package com.java.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import com.java.juc.ThreadTurnPrint.Thread1;
import com.java.juc.ThreadTurnPrint.Thread2;

/**
 * CyclicBarrier的例子
 * @author brucexia
 *
 */
public class CyclicBarrierDemo {

	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
	static class Thread1 extends Thread{
		private String name;
		public  Thread1(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(name + "启动！");
				cyclicBarrier.await();
				System.out.println(name + "已经结束！");
			} catch (InterruptedException | BrokenBarrierException e) {
				
			}
		}		
	}
	
	
	
	public static void main(String args[]) throws InterruptedException {
		for(int i = 0;i < 9;i++) {
			new Thread1("线程" + i).start();
		}
		Thread.sleep(1000);
		for(int i = 9;i < 10;i++) {
			new Thread1("线程" + i).start();
		}
		
	}
}
