package com.alg.sort;

import java.awt.event.ItemEvent;
import java.util.Random;
import java.util.Scanner;

/**
 * 快速排序算法，采用递归实现
 * 输入如下：
 * 10（元素个数）
 * 12 34 2 6 23 7 9 10 100 55（具体内容）
 * 输出：
 * 第一行为原来的数组
 * 第二行为排序后的数组
 * @author brucexia
 * @date 2020.03.28
 */
public class QuickSort {
	public static void swap(int array[], int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	public static void partition(int array[], int m, int n) {
		int flag = m; //哨兵索引
		int start = m;
		for(int i = m + 1;i <= n;i++) {
			if(array[i]< array[m]) { //把小的元素都放在左边
				swap(array, i, start++);
			}
		}
		if(start - 1 >= m){
			swap(array, start - 1, m); //将哨兵放在最终的位置上（一般为中间）
			flag = start - 1;
		}
		
		if(flag - 1 > m) { //对左半部分快排
			partition(array, m, flag - 1);
		}
		if(flag + 1 < n) { //对右半部分快排
			partition(array, flag + 1, n);
		}
	
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int originArray[] = new int[length];
		for(int i = 0;i < length;i++) {
			originArray[i] = scanner.nextInt();
		}
		for(int i = 0;i < length;i++) {
			System.out.print(originArray[i] + "\t");
		}
		System.out.println();
		
		partition(originArray, 0, length - 1);
		
		for(int i = 0;i < length;i++) {
			System.out.print(originArray[i] + "\t");
		}

		
		
	}
}
