package com.alg.linearlist;

/**
 * 最大的连续子数组的乘积
 * LeetCode - 152 - https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author brucexia
 * @date 25th, April, 2020
 *
 */
public class MaxMultiResChildSeq {
	//以当前位置为终点的自数组的最大乘积
	public static int[] endHereMax(int array[]) {
		int res[] = new int[array.length];
		int posMax = 1, negMax = 1;
		for(int i=0;i< array.length;i++) {
			if(array[i]>=0) {
				posMax = posMax > 0 ? posMax * array[i] : array[i];
				negMax = negMax < 0 ? negMax * array[i] : array[i];
			} else {
				int temp = posMax;//这里一定不能漏掉
				posMax = negMax < 0 ? negMax * array[i] : array[i];
				negMax = temp > 0 ? temp * array[i] : array[i];
			}
			res[i] = posMax;
			
		}
		return res;
	}
	
	public static int maxProduct(int nums[]) {
		int res[] = endHereMax(nums);
		int max=nums[0];
		for(int i=0;i< nums.length;i++) {
			max = max > res[i] ? max : res[i];
		}
		return max;
	}
	
	public static void main(String args[]) {
		int array[] = {-2,3,-4};
		System.out.print(maxProduct(array));
	}
}
