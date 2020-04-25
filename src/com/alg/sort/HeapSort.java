package com.alg.sort;

import java.util.Random;

/**
 * 堆排序算法，采用递归实现
 * 输出：
 * 第一行为原来的数组（随机产生）
 * 第二行为排序后的数组
 * 
 * @author brucexia
 * @date 2020.03.28
 */

public class HeapSort {
	public static void swap(int array[], int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	//返回参与了交换的子节点的索引，便于后面调整子节点
	//比较x,y,z索引处的元素，把最大的元素放在x的位置
	public static int setMaxParent(int array[], int x, int y, int z, int length) {
		if(x > length || y > length) {
			return -1;
		}
		if(z > length) {
			if(array[x] < array[y]) {
				swap(array, x, y);
				return y;
			}
		} else {
			int maxValue = array[y] > array[z] ? array[y] : array[z];
			int maxIndex = array[y] > array[z] ? y : z;
			if(array[x] < maxValue) {
				swap(array, x, maxIndex);
				return maxIndex;
			}
		}
		return -1;
	}
	
	public static void heapSort(int array[], int length) {
		//构造初始的大顶堆，即父节点大于子节点，堆顶部元素最大
		int lastPNode = length / 2; //数组的0位置不存储元素
		for(int i = lastPNode;i >= 1;i--) {
			int cNode = setMaxParent(array, i, i << 1, (i << 1) + 1, length);
			while(-1 != cNode) { //调整收到影响的子节点
				cNode = setMaxParent(array, cNode, cNode << 1, (cNode << 1) + 1, length);
			}
		}
		//将第一个元素与最后一个元素交换
		swap(array, 1, length);
		length--; //交换之后，最后一个元素就不用考虑了，相当于“删除”了它
		//继续调整剩下的元素，直到所有元素有序
		while(length > 1) {
			//继续调整
			int cNode = setMaxParent(array, 1, 2, 3, length);
			while(-1 != cNode) {
				cNode = setMaxParent(array, cNode, cNode << 1, (cNode << 1) + 1, length);
			}
			swap(array, 1, length); //将最大元素移动末尾
			length--; //下一次调整的时候，最后一个元素相当于“删除”了
		}
		
	}
	
	public static void main(String args[]) {
		int array[] = new int[21];
		for(int i = 1;i <= 20;i++) {
			array[i] = new Random().nextInt(200);
		}
		for(int i = 1;i <= 20;i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		heapSort(array, 20);
		for(int i = 1;i <= 20;i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
