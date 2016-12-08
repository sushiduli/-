package com.my.thread;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable{

	BlockingQueue<String> block;
	
	public Producer(BlockingQueue<String> block){
		this.block = block;
	}
	
	@Override
	public void run() {
		try {
			block.put(Thread.currentThread().getName());
			System.out.println("放入到队列中：==="+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
