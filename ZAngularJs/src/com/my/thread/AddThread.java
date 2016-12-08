package com.my.thread;

public class AddThread extends Thread{
	
	public NumFactory factory;
	
	public AddThread(NumFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public void run() {
		synchronized (factory) {
				while (factory.num > 20) {
					try {
						factory.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				factory.notify();
				factory.add();
				System.out.println("生产了两个，还剩下：==="+factory.num);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
