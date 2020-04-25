package com.alg.linearlist;
/**
 * 对于数组中的每一个数字，计算除了它之外的数字的乘积
 * 不用除法，只用线性的空间
 * LeetCode - 238 - https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author brucexia
 * @date 25th, April, 2020
 */
public class ArrayMultiExceptSelf {
	//递归的计算右侧数字相乘的结果
	public static int getRight(int array[], int index) {
		if (index ==  array.length - 1) { //递归结束的条件
			return array[array.length - 1];
		} else {
			return array[index]	* getRight(array, index + 1);
		}
	}
	
	public static int[] multiArray(int []array) {
		int len = array.length;
		int result[] = new int[len];
		int start = 1; //start表示左侧数字相乘的结果
		for(int i = 0;i < len;i++) {
			start = i==0 ? start : start*array[i-1];
			
			result[i] = (i==len-1) ? start : (start * getRight(array, i+1));
		}
		return result;
	}
	
	public static void main(String args[]) {
		int arrary[] = {9, 3, 6, 1, 2};
		int result[] = multiArray(arrary);
		for(int a : result) {
			System.out.println(a);
		}
	}
}
