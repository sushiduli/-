package com.my.thread;

public class NumFactory {

	public int num = 10;
	
	public int total = 20;
	
	//非同步方法
	public void add(){
		num = num+2;
	}
	
	public void scale(){
		num--;
	}

	
	//同步方法
	public synchronized void addSync(){
		while(num > 20){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		num = num + 2;
		System.out.println("生产了两个。当前数量：==="+num);
		
	}
	
	public synchronized void scaleSync(){
		while(num < 10){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		num--;
		System.out.println("消费了一个。当前数量：==="+num);
	}
	
}
