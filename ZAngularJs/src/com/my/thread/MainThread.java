package com.my.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
	
	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(consumer).start();
		new Thread(producer).start();
		
	}
}
