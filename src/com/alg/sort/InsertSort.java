package com.alg.sort;

import java.util.Random;

/**
 * 归并排序算法，采用递归实现
 * 输出：
 * 第一行为原来的数组（随机产生）
 * 第二行为排序后的数组
 * 
 * @author brucexia
 * @date 2020.03.28
 */
public class InsertSort {
	/**
	 * 插入排序
	 * @param array 待排序数组
	 * @param m 数组起点索引
	 * @param n 数组终点索引
	 */
	public static void insertSort(int array[], int m, int n) {
		if(m < n) {
			for(int i = m + 1;i <= n;i++) {
				if(array[i] < array[i - 1]) {
					int cur = array[i];
					int j = i - 1;
					for(;j >= m && array[j] > cur;j--) { //移动位置
						array[j + 1] = array[j];
					}
					array[j + 1] = cur;
				}
			}
		}		
	}

	public static void main(String args[]) {
		int array[] = new int[20];
		for(int i = 0;i < 20;i++) {
			array[i] = new Random().nextInt(100);
		}
		for(int i = 0;i < 20;i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		insertSort(array, 0, 19);
		for(int i = 0;i < 20;i++) {
			System.out.print(array[i] + "\t");
		}
		
		
	}
}
