package com.java.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JInternalFrame;


public class AlibabaFirst {
	public static int getMax(int array[],int length) {
		int maxIndex=-1;
		int maxValue=-1;
		
		for(int i = 0;i < length;i++) {
			if(array[i]>maxValue) {
				maxValue=array[i];
				maxIndex=i;
			}				
		}
		return maxIndex;
	}
	
	public static void addJi(int array[],int length,int addNum) {
		for(int i = 0;i < length;i++) {
			array[i]	 += addNum;			
		}
	}
	
	public static int sum(int array[],int length) {
		int res=0;
		for(int i = 0;i < length;i++) {
			res	 += array[i];			
		}
		return res;
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int jiPlantNum = scanner.nextInt();
		int dayNum = scanner.nextInt();
		int addNum = scanner.nextInt();//增加的小鸡数量
		
		
		int jiNum[] = new int[jiPlantNum];
		for(int i = 0;i < jiPlantNum;i++) {
			jiNum[i] = scanner.nextInt();
		}

		int maxIndex = getMax(jiNum, jiPlantNum);		
		addJi(jiNum, jiPlantNum, addNum);
		jiNum[maxIndex] = jiNum[maxIndex] / 2;

		for(int day=2;day <= dayNum;day++) {
			addJi(jiNum, jiPlantNum, addNum);
			maxIndex=getMax(jiNum, jiPlantNum);
			jiNum[maxIndex] = jiNum[maxIndex] / 2;
//			for(int i = 0;i < jiPlantNum;i++) {
//				System.out.print(jiNum[i] + "\t");
//			}
//			System.out.println();
//			if(jiNum[max[1]] > jiNum[max[3]]) {//haishiduo
//				jiNum[max[1]] = jiNum[max[1]] >> 1;
//			}else {
//				jiNum[max[3]] = jiNum[max[3]] >> 1;
//				
//			}
			
//			for(int i = 0;i < jiPlantNum;i++) {
//				System.out.print(jiNum[i] + "\t");
//			}
//			System.out.println();
			
		}

	
	}
	
}
