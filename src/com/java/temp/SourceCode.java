

package com.java.temp;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;



import java.util.concurrent.CountDownLatch;


public class SourceCode {
	public ReentrantLock reentrantLock = new ReentrantLock();
	public Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
	public HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	public static void main(String args[]) {
		AlibabaFirst asAlibabaFirst = new AlibabaFirst();
		SourceCode sc = new SourceCode();
		//sc.hashtable.put(null, null); //Hashtable不支持null
		sc.hashMap.put(null, null); //HashMap支持null
		String aString = "sdf";
		StringBuffer sBuffer = new StringBuffer();
		SoftReference<Integer> sReference = new SoftReference<Integer>(1);
		ThreadLocal<Integer> tLocal = new ThreadLocal<Integer>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.DAYS, null);
		AtomicInteger atomicInteger = new AtomicInteger(3);
		HashSet<Integer> aHashSet = new HashSet<>();
	}
	
}
