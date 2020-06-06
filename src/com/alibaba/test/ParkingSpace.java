package com.alibaba.test;

/**
 * 车位类
 * @author 夏军
 *
 */
public class ParkingSpace {
	private ParkingSpaceType type;
	private int spaceNum;//车位数量
	private double hourFee;//小时收费
	private double dailyMaxFee;//每天最大费用
	private double mouthFee;//月租费
	public ParkingSpace(ParkingSpaceType type, double hourFee, double dailyMaxFee, int spaceNum) {
		this.type = type;
		this.hourFee = hourFee;
		this.dailyMaxFee = dailyMaxFee;
		this.spaceNum = spaceNum;
	}
	
	public ParkingSpace(ParkingSpaceType type, double mouthFee, int spaceNum) {
		this.type = type;
		this.mouthFee = mouthFee;
		this.spaceNum = spaceNum;
	}
	
	public ParkingSpaceType getSpaceType() {
		return type;
	}

	public double getHourFee() {
		return hourFee;
	}

	public void setHourFee(double hourFee) {
		this.hourFee = hourFee;
	}

	public double getDailyMaxFee() {
		return dailyMaxFee;
	}

	public void setDailyMaxFee(double dailyMaxFee) {
		this.dailyMaxFee = dailyMaxFee;
	}

	public double getMouthFee() {
		return mouthFee;
	}

	public void setMouthFee(double mouthFee) {
		this.mouthFee = mouthFee;
	}
	
	
	
}
