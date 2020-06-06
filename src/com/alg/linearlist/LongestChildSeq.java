package com.alg.linearlist;

import java.util.HashMap;
/**
 * 寻找无序数组中最长的连续数字（这些数字不要求排在一起）
 * 动态规划+hash
 * LeetCode - 128：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author brucexia
 * @date 25th, April, 2020
 *
 */
public class LongestChildSeq {
	public static int longestConsecutive(int[] nums) {
		if (0 == nums.length) {
			return 0;
		}
		HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length, (float)1.0);
		hashMap.put(nums[0], 0);
		//最大长度，最左侧数字具体值，最右侧数字具体的值
		int maxLen = 1, start = nums[0], end=nums[0];
		for(int num : nums) {
			//如果这个数字在之前已经出现过，那么不用计算了
			if(null != hashMap.get(Integer.valueOf(num))) {
				continue;
			} else if (num == start - 1) { //在左侧延长了最长子序列
				start--;
				maxLen++;
				while(null != hashMap.get(Integer.valueOf(start-1))) {
					start--;
					maxLen++;
				}
			} else if (num == end + 1) { //在右侧延长了最长子序列
				end++;
				maxLen++;
				while(null != hashMap.get(Integer.valueOf(end+1))) {
					end++;
					maxLen++;
				}
			} else { //没有延长原来的子序列
				int newMaxLen = 1,newStart=num, newEnd = num;
				//以这个数字为基准，左右两侧查找
				while(null != hashMap.get(Integer.valueOf(newStart-1))) {
					newStart--;
					newMaxLen++;
				}
				while(null != hashMap.get(Integer.valueOf(newEnd+1))) {
					newEnd++;
					newMaxLen++;
				}
				if (newMaxLen > maxLen) {
					maxLen = newMaxLen;
					start = newStart;
					end = newEnd;
				}
			}
			hashMap.put(num, 0);
		}
		return maxLen;
		
    }
	
	 public static void main(String as[]) {
	    	int array[] = {100, 4, 200, 1, 3, 2};
	    	System.out.println(longestConsecutive(array));
	    	
	    }
}
