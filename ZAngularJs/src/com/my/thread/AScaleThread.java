package com.my.thread;

public class AScaleThread implements Runnable{

	public NumFactory factory;
	
	public AScaleThread(NumFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void run() {
		synchronized (factory) {
			while (factory.num < 15) {
				try {
					factory.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				factory.notify();
				factory.scale();
				System.out.println("消费了一个，还剩下：==="+factory.num);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
