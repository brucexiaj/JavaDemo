package com.alg.linkcode;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 获取链表的中间节点
 * 输出：
 * 第一行为原来的数组（随机产生）
 * 第二行为排序后的数组
 * 
 * @author brucexia
 * @date 2020.03.28
 */


public class LinkMiddleItem {
	static class LinkNode{
		int value;
		LinkNode next;
		LinkNode(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}
	}
	
	
	public static int getMiddleLinkNode(LinkNode linkNode) {
		LinkNode middleNode = linkNode;
		LinkNode currentNode = linkNode;
		while(currentNode != null) {
			currentNode = currentNode.next;
			currentNode = currentNode.next;
			middleNode = middleNode.next;
		}
		return middleNode.value;
	}
	
	public static void main(String args[]) {
		LinkNode linkNode = new LinkNode(0);
		LinkNode head = linkNode;
		LinkNode prevNode = linkNode;
		for(int i = 1;i < 100;i++) {
			LinkNode node = new LinkNode(i);
			prevNode.next = node;
			prevNode = node;
		}
		System.out.println(getMiddleLinkNode(head));
		
	}
}
