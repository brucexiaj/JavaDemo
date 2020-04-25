package com.alg.tree;

import java.util.Stack;

/**
 * 二叉树中两个节点最近的公共祖先节点
 * 限制条件：链表中所有节点的值唯一，两个节点都不是根节点
 * @author brucexia
 *
 */

public class NearestRootNode {
private static boolean endFlag = false;//递归求路径是否结束
	
	static class BinaryTree{
		private int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 求根节点到一个节点的路径
	 * @param tree 树的根节点
	 * @param target 所求节点的值
	 * @param path 根到所求节点的路径
	 */
	public static void getPathToNode(BinaryTree tree, int target, Stack<Integer> path) {
			if(tree.left != null && !endFlag) {
				path.push(tree.left.value);
				getPathToNode(tree.left, target, path);
			}

			if(tree.value == target) {
				endFlag = true;
			}	
			
			if(tree.right != null && !endFlag) {
				path.push(tree.right.value);
				getPathToNode(tree.right, target, path);
			}
			
			if(!endFlag) {
				path.pop();
			}							
	}
	
	public static void main(String args[]) {
		BinaryTree root = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);
		
		root.left = two;
		
		two.left = three;
		two.right = four;
		
		three.right = five;
		four.right = six;
		
		five.left = seven;
		five.right = eight;
		
		int value1 = 6;
		int value2 = 8;
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		getPathToNode(root, value1, stack1);
		endFlag = false;
		getPathToNode(root, value2, stack2);
		
		while (stack1.size() > stack2.size()) {
			stack1.pop();		
		}
		
		while (stack2.size() > stack1.size()) {
			stack2.pop();		
		}
		
		int commonRoot = root.value;
		while((commonRoot = stack1.pop()) != stack2.pop());
		
		
		System.out.println("common root is:" + commonRoot);
		
	}

}
