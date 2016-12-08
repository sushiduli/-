package com.my.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	BlockingQueue<String> block;
	
	public Consumer(BlockingQueue<String> block){
		this.block = block;
	}
	
	@Override
	public void run() {

		try {
			String take = block.take();
			System.out.println("取出队列中的：==="+take);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
