package com.alg.sort;

/**
 * 归并排序算法，采用递归实现
 * 输出：
 * 第一行为原来的数组（随机产生）
 * 第二行为排序后的数组
 * @author brucexia
 * @date 2020.03.28
 */
import java.util.Random;

public class MergeSort {
	public static void mergeSort(int array[], int m, int n) {
		if (m < n) {
			int middle = (m + n) / 2;
			mergeSort(array, m, middle);
			mergeSort(array, middle + 1, n);
			//将左右两部分归并的结果合并
			int res[] = new int[n - m + 1];
			int i = m, j = middle + 1, index = 0;
			while(i <= middle && j <= n) { //取小的元素放在新数组里面
				res[index++] = array[i] < array[j] ? array[i++] : array[j++];
			}
			while(j <= n)
				res[index++] = array[j++];
			while(i <= middle)
				res[index++] = array[i++];
			
			index = 0;
			for(i = m;i <= n;i++) {
				array[i] =  res[index++];
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
		mergeSort(array, 0, 19);
		for(int i = 0;i < 20;i++) {
			System.out.print(array[i] + "\t");
		}
		
		
	}
}
