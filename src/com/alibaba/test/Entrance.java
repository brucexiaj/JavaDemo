package com.alibaba.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 入口类
 * @author 夏军
 *
 */

public class Entrance extends Thread{
	private BlockingQueue<Car> carQueue;//控制小汽车数量的队列
	private BlockingQueue<Car> freightQueue;//控制货车数量的队列
	private BlockingQueue<Car> contractQueue;//控制合约车数量的队列
			
	public Entrance(BlockingQueue<Car> carQueue, BlockingQueue<Car> freightQueue, BlockingQueue<Car> contractQueue) {		
		this.carQueue = carQueue;
		this.freightQueue = freightQueue;
		this.contractQueue = contractQueue;
	}
	 @Override
     public void run() {
		 int carCode = 0;
         while (true) {   
         	
             try { 
            	 int index = new Random().nextInt(3);
            	 //int index = 2;
            	 switch (index) { //随机进入一种汽车
				case 0:
					Car car = new Car(ParkingSpaceType.ORDIN_CAR, new Date());
	                if(carQueue.offer(car, 2333, TimeUnit.MILLISECONDS))
	                	System.out.println("进入一辆小汽车");
					break;
				case 1:
					Car freight = new Car(ParkingSpaceType.ORDIN_FREIGHT, new Date());
	                if(freightQueue.offer(freight, 2333, TimeUnit.MILLISECONDS))
	                	System.out.println("进入一辆货车");
					break;
				case 2:
					
					Car contract = new Car(ParkingSpaceType.CONTRACT, new Date(), carCode);
	                if(contractQueue.offer(contract, 2333, TimeUnit.MILLISECONDS))
	                	System.out.println("进入一辆合约车，编号是："+carCode);
	                	carCode++;
					break;

				default:
					break;
				}
            	 
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             
             try {
                 Thread.sleep(1000);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }
}
