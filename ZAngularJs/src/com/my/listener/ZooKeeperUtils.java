package com.my.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperUtils {
	private static final String ZooKeeper_Hosts = "zookeeper.zkHost";
	private static final int Connection_Timeout = 30000;// millisecond
	private static Watcher watcher = null;
	private static ZooKeeper zk = null;

	private static final String ZooKeeper_RootPath = "root";
	public static final String Service_ZooKeeper_IsUsed = "service.zookeeper.isused";
	private static final String Service_ZooKeeper_HostName = "service.zookeeper.hostname";
	private static final String Service_ZooKeeper_UsedFor = "service.zookeeper.usedfor";
	private static CountDownLatch block = new CountDownLatch(1);

	public static boolean IsLeader = true;

	public static void init() throws IOException, KeeperException,
			InterruptedException {
		if (!Boolean.valueOf(System
				.getProperty(ZooKeeperUtils.Service_ZooKeeper_IsUsed)))
			return;

		watcher = new Watcher() {
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					block.countDown();
				}
				try {
					IsLeader = isLeader();
				} catch (Exception e) {
				}
			}
		};
		zk = new ZooKeeper(System.getProperty(ZooKeeper_Hosts),
				Connection_Timeout, watcher);
		block.await();

		connect();
	}

	private static void connect() throws KeeperException, InterruptedException,
			IOException {
		if (zk.exists("/" + ZooKeeper_RootPath, true) == null)
			zk.create("/" + ZooKeeper_RootPath, ZooKeeper_RootPath.getBytes(),
					Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zk.getChildren("/" + ZooKeeper_RootPath, true);

		zk.create(
				"/" + ZooKeeper_RootPath + "/"
						+ System.getProperty(Service_ZooKeeper_HostName),
				System.getProperty(Service_ZooKeeper_UsedFor).getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		zk.getChildren("/" + ZooKeeper_RootPath, true);
	}

	private static boolean isLeader() throws KeeperException,
			InterruptedException {
		if (!Boolean.valueOf(System
				.getProperty(ZooKeeperUtils.Service_ZooKeeper_IsUsed)))
			return true;

		int myIndex = Integer.MAX_VALUE;
		int minIndex = Integer.MAX_VALUE;
		List<Integer> lstAllServiceIndex = new ArrayList<Integer>();
		for (String path : zk.getChildren("/" + ZooKeeper_RootPath, true)) {
			String data = new String(zk.getData("/" + ZooKeeper_RootPath + "/"
					+ path, false, null));
			if (data.equals(System.getProperty(Service_ZooKeeper_UsedFor))) {
				if (path.indexOf(System.getProperty(Service_ZooKeeper_HostName)) >= 0) {
					myIndex = Integer
							.valueOf(path.substring(path.length() - 9));
				} else {
					lstAllServiceIndex.add(Integer.valueOf(path.substring(path
							.length() - 9)));
				}
			}
		}

		for (int index : lstAllServiceIndex) {
			minIndex = index < minIndex ? index : minIndex;
		}

		return myIndex < minIndex;
	}

	public static void close() throws InterruptedException {
		if (Boolean.valueOf(System
				.getProperty(ZooKeeperUtils.Service_ZooKeeper_IsUsed)))
			zk.close();
	}
	
}
