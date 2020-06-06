package com.alibaba.test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 停车场
 * @author 夏军
 *
 */
public class ParkLot {
	private String name;
	private HashMap<ParkingSpaceType, ParkingSpace> parkSpaceInfo = new HashMap<>();//车位类型map
	
	public ParkLot() {
		
	}
//	public ParkLot(HashMap<ParkingSpaceType, Integer> parkingSpaceInfo) {
//		this.parkingSpaceInfo = parkingSpaceInfo;
//	}
	public void addParkSpaceType(ParkingSpaceType parkingSpaceType, ParkingSpace parkingSpace) {
		parkSpaceInfo.put(parkingSpaceType, parkingSpace);
	}
//	
	public HashMap<ParkingSpaceType, ParkingSpace> getParkingSpaceInfo() {
		return this.parkSpaceInfo;
	}
//	
	
}
