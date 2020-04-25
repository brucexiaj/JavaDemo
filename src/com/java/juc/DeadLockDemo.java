package com.java.juc;

/**
 * 用synchronized实现的死锁的例子
 * @author brucexia
 *
 */
public class DeadLockDemo {
	public static Object object1 = new Object();
	public static Object object2 = new Object();
	static class Thread1 extends Thread{
		@Override
		public void run() {
			System.out.println("Thread1 start!");
			synchronized (object1) { //获取object1的锁才能进入这个代码块
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
				}
				synchronized (object2) {
					System.out.println("Thread1 !");
				}
				
				
			}
			
		}
		
	}
	
	static class Thread2 extends Thread{
		@Override
		public void run() {
			System.out.println("Thread2 start!");
			synchronized (object2) { //获取object2的锁才能进入这个代码块
				
				//加上下面这部分代码就能解决死锁
//				try {
//					object2.wait(); //释放了object2的锁
//				} catch (InterruptedException e) {
//				}
				
				synchronized (object1) {
					System.out.println("Thread2 !");
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
		System.out.println("main thread still running!");
	}
}
