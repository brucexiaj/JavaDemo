package com.alg.sort;

import java.util.Random;

import javax.swing.JLabel;
/**
 * 全排列的递归实现
 * @author brucexiajun
 *
 */
public class FullArrange {
	
	public static void swap(int array[], int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	public static int getStep(int n) {
		return 1==n ? 1 : getStep(n-1)*n;
	}
	
	public static int[][] fullArrangement(int array[], int end){
		
		if(0==end) {
			int res[][] = new int[1][1];
			res[0][0] = array[0];
			return res;
		}
		
		
		int res[][] = new int[getStep(end+1)][end+1];
		

		for(int i=0;i<=end;i++) {//每次取一个数不参与全排列
			swap(array, i, end);
			int curRes[][] = fullArrangement(array, end-1);		
			for(int j=0;j<curRes.length;j++) {
				int k = 0;
				for(;k<curRes[0].length;k++) {
					
					res[j+i*getStep(end)][k] = curRes[j][k];
				}
				res[j+i*getStep(end)][k] = array[end];//不参与排列的数放在尾部
			}
			swap(array, end, i);
		}
		return res;
	}
	
	
	public static void main(String args[]) {
		int array[] = new int[4];
		for(int i = 0;i < 4;i++) {
			array[i] = i + 1;
		}
		int res[][] = fullArrangement(array, array.length-1);
		for(int j=0;j<res.length;j++) {
			for(int k = 0;k<res[0].length;k++) {
				System.out.print(res[j][k] + "\t");
			}
			System.out.println();
		}
	}
}
