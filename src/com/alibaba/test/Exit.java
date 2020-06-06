package com.alibaba.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 出口类
 * @author 夏军
 *
 */
public class Exit extends Thread{
	private BlockingQueue<Car> carQueue;
	private BlockingQueue<Car> freightQueue;
	private BlockingQueue<Car> contractQueue;
	private ParkLot parkLot;
	private double totalFee = 0.0;
	private HashMap<Integer, Integer> contractCarMap = new HashMap<Integer, Integer>(); //防止合约车被反复计费
			
	public Exit(ParkLot parkLot, BlockingQueue<Car> carQueue, BlockingQueue<Car> freightQueue, BlockingQueue<Car> contractQueue) {		
		this.parkLot = parkLot;
		this.carQueue = carQueue;
		this.freightQueue = freightQueue;
		this.contractQueue = contractQueue;
	}
	
	
	//计算汽车的停车费
	public static double calFee(Car car, ParkLot parkLot) {
		if (car.getType() == ParkingSpaceType.CONTRACT) {            
	        ParkingSpace parkingSpace = parkLot.getParkingSpaceInfo().get(car.getType());
	        double monthFee = parkingSpace.getMouthFee();
	        return monthFee / 30; //这里还需要考虑同一辆合约车一天多次停车的计费为题
		} else {
			Date enterDate = car.getDate();
	        Date now = new Date();
	        long diff = now.getTime() - enterDate.getTime();	                
	        int hour = (int)(diff / 1000 / 3600) + 1;	            
	        ParkingSpace parkingSpace = parkLot.getParkingSpaceInfo().get(car.getType());
	        double hourFee = parkingSpace.getHourFee();
	        double dailyMaxFee = parkingSpace.getDailyMaxFee();
	        if (hourFee * hour >= dailyMaxFee) {
	       	 return dailyMaxFee;
	        } else {
	       	 return  hourFee * hour;
	        }
		}
        
	}
	
	 @Override
     public void run() {
         while (true) {   
         	
             try {    
            	//随机出去一辆车
            	 int index = new Random().nextInt(3);
            	 switch (index) { //随机产生车辆
				case 0:
					 Car car = carQueue.poll(3333, TimeUnit.MILLISECONDS);
					 if(null != car) {
						 System.out.println("出去一辆小汽车");
		                 totalFee += calFee(car, parkLot); 
					 }
					 
	                 
					break;
				case 1:
					Car freight = freightQueue.poll(3333, TimeUnit.MILLISECONDS);
					if(null != freight) {
						 totalFee += calFee(freight, parkLot);
		                 System.out.println("出去一辆货车");
					}
	                
	                 
					break;
				case 2:
					Car contractCar = contractQueue.poll(3333, TimeUnit.MILLISECONDS);
					if(null!=contractCar) {
						int carCode = contractCar.getCarCode();
						if (null != contractCarMap.get(carCode)) {//判断这个车是否来过
							System.out.println("出去一辆已经计费过的合约车,编号是："+carCode);
						}else {
							System.out.println("出去一辆合约车,编号是："+carCode);
							contractCarMap.put(carCode, 0);
							totalFee += calFee(contractCar, parkLot);
							
						}
					}
					
	                 
	                 
					break;
				default:
					break;
            	 }
                
                 System.out.println("已经收费"+Double.toString(totalFee));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             
             try {
            	 
                 Thread.sleep(6578);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }
}
