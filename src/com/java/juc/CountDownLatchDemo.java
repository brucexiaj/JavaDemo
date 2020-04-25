package com.java.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch的例子
 * @author 
 *
 */

public class CountDownLatchDemo {
	public static CountDownLatch countDownLatch = new CountDownLatch(10);
	static class Thread1 extends Thread{
		private String name;
		public  Thread1(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(name + "启动！");
				countDownLatch.await();
				System.out.println(name + "已经结束！");
			} catch (InterruptedException e) {
				
			}
		}		
	}
	
	static class Thread2 extends Thread{
		private String name;
		public  Thread2(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			countDownLatch.countDown();
			System.out.println(name + "已经结束！");
		}		
	}
	
	
	
	public static void main(String args[]) throws InterruptedException {
		for(int i = 0;i < 10;i++) {
			new Thread1("线程" + i).start();
		}
		Thread.sleep(3000);
		for(int i = 10;i < 20;i++) {
			new Thread2("线程" + i).start();
		}
		
	}
}
