package com.java.juc;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 使用AtomicInteger+synchronized实现的线程轮流打印
 * @author brucexia
 *
 */
public class ThreadTurnPrint {
	public static Object object1 = new Object();
	public static Object object2 = new Object();
	public static volatile AtomicInteger atomicInteger = new AtomicInteger(0);
	static class Thread1 extends Thread{
		@Override
		public void run() {
			while(true) {
				synchronized (this) {
					if(0 == atomicInteger.get()) {
						System.out.println("a");
						atomicInteger.getAndIncrement();
					}
				}				
			}			
		}		
	}
	
	static class Thread2 extends Thread{
		@Override
		public void run() {
			while(true) {
				synchronized (this) {
					if(1 == atomicInteger.get()) {
						System.out.println("b");
						atomicInteger.decrementAndGet();						
					}
				}
			}		
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		Thread.sleep(50);
		t2.start();
		Thread.sleep(100);
//		System.out.println("main thread still running!");
	}
}
