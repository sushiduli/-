package com.my.thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadCallable implements Callable<String>{

	public int num = 0;
	
	public ThreadCallable(int num) {
		this.num = num;
	}
	@Override
	public String call() throws Exception {
		if(num%2 == 0)
			Thread.sleep(2000);
		System.out.println(num+"===="+System.currentTimeMillis()/1000);
		return ""+num;
	}
	
	public static void main(String[] args) throws Exception {
	
  		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			//Future<String> future = service.submit(new ThreadCallable(i));
			//future.get();
		}
		service.shutdown();

		FutureTask<String> task = new FutureTask<>(new ThreadCallable(0));
		new Thread(task).start();
		task = new FutureTask<>(new ThreadCallable(1));
		new Thread(task).start();
		task = new FutureTask<>(new ThreadCallable(2));
		new Thread(task).start();
		task = new FutureTask<>(new ThreadCallable(3));
		new Thread(task).start();
	}

}
