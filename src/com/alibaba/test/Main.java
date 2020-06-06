package com.alibaba.test;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author 夏军
 *
 */
public class Main {
	
	public static void main(String args[]) {
		//初始化车位类型
		ParkingSpace carSpace = new ParkingSpace(ParkingSpaceType.ORDIN_CAR, 5.0, 60.0, 3);
		ParkingSpace freightSpace = new ParkingSpace(ParkingSpaceType.ORDIN_FREIGHT, 10.0, 120.0, 4);
		ParkingSpace contractSpace = new ParkingSpace(ParkingSpaceType.CONTRACT, 150.0, 5);
		//初始化停车场
		ParkLot parkLot = new ParkLot();
		parkLot.addParkSpaceType(carSpace.getSpaceType(), carSpace);
		parkLot.addParkSpaceType(freightSpace.getSpaceType(), freightSpace);
		parkLot.addParkSpaceType(contractSpace.getSpaceType(), contractSpace);
		
		//初始化汽车阻塞队列
		BlockingQueue<Car> carQueue = new ArrayBlockingQueue<>(3);
		BlockingQueue<Car> freightQueue = new ArrayBlockingQueue<>(4);
		BlockingQueue<Car> contractQueue = new ArrayBlockingQueue<>(5);
		
		//开启入口和出口两个线程
		Thread entrance = new Entrance(carQueue, freightQueue, contractQueue);
		Thread exit = new Exit(parkLot, carQueue, freightQueue, contractQueue);
		entrance.start();
		exit.start();
		
		
		
	}
}
