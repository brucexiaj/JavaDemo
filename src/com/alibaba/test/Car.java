package com.alibaba.test;

import java.util.Date;

/**
 * 汽车类
 * @author xiajun
 *
 */

public class Car {
	private ParkingSpaceType type;//汽车对应的车位类型
	private Date date;//汽车进入时间
	private int carCode;//汽车编号，防止合约车重复计费
	public Car(ParkingSpaceType type, Date date) {
		super();
		this.type = type;
		this.date = date;
	}
	
	public Car(ParkingSpaceType type, Date date, int carCode ) {
		super();
		this.type = type;
		this.date = date;
		this.carCode = carCode;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ParkingSpaceType getType() {
		return type;
	}
	public void setType(ParkingSpaceType type) {
		this.type = type;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}
	
	
	

}
