package com.jboss.rest.service.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.LogManager;


public class Initializer {

	public void init() throws IOException {
		String homeDir = Initializer.getHomeDir();
		// Load Properties
		loadProperties();
		// 重置jre默认Log的config
		LogManager.getLogManager().reset();
		if (!org.slf4j.bridge.SLF4JBridgeHandler.isInstalled()) {
			org.slf4j.bridge.SLF4JBridgeHandler.install();
		}
		LoggerConfigurator.config(homeDir + "/config/logback.xml");
	}

	public static void loadProperties() throws IOException {
		File cnf = new File(Initializer.getHomeDir() + "/config/");
		for (File file : cnf.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".properties")) {
				Properties ppt = new Properties();
				try (FileInputStream fi = new FileInputStream(file)) {
					ppt.load(fi);
					System.getProperties().putAll(ppt);
				}
			}
		}
	}

	public static String getHomeDir() {
		String homeDir = System.getProperty("app.home");
		if (homeDir == null || !Files.isDirectory(Paths.get(homeDir))) {
			homeDir = System.getenv("app_home");
		}
		if (homeDir == null || !Files.isDirectory(Paths.get(homeDir))) {
			homeDir = System.getProperty("boot.home");
		}
		if (homeDir == null || !Files.isDirectory(Paths.get(homeDir))) {
			homeDir = System.getProperty("user.dir");
		}
		System.setProperty("app.home", homeDir);// 固定
		return homeDir;
	}

}
