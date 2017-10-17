package org.tripathi.karumanchi.trees;

import org.tripathi.karumanchi.queues.LLQueue;

//problem 1 and 2 in chapter 2
//Time Complexity: O(n)
//Space Complexity: O(n)

public class MaxInBinaryTree {
	public Integer maxInBinaryTreeRecursive(BinaryTreeNode root) {
		Integer maxValue = Integer.MIN_VALUE;
		 if (root != null){
		        int leftMax = maxInBinaryTreeRecursive(root.getLeft());
		        int rightMax = maxInBinaryTreeRecursive(root.getRight());
		         
		        if (leftMax > rightMax)
		        	maxValue = leftMax;
		        else
		        	maxValue = rightMax;
		             
		        if (root.getData() > maxValue)
		        	maxValue = root.getData();
	}
		return maxValue;
	}
	
	public Integer maxInBinaryTreeIterative(BinaryTreeNode root) {
		//basically just a Level Order Traversal
		if(root == null) {
			return null;
		}
		Integer maxValue = Integer.MIN_VALUE;
		LLQueue queue = new LLQueue();
		
		queue.enQueue(root);
		while(!queue.isEmpty()) {
			root = (BinaryTreeNode) queue.deQueue();
			if(root.getData() > maxValue) {
				maxValue = root.getData();
			}
			
			if(root.getLeft() != null) {
				queue.enQueue(root.getLeft());
			}
			
			if(root.getRight() != null) {
				queue.enQueue(root.getRight());
			}
		}
		
		return maxValue;
	}
}
