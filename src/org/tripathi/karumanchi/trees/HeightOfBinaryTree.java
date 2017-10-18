package org.tripathi.karumanchi.trees;

import org.tripathi.karumanchi.queues.LLQueue;

public class HeightOfBinaryTree {

	public Integer heightOfBinaryTreeIterative(BinaryTreeNode root) {
		Integer count = -1;
		LLQueue queue = new LLQueue();
		queue.enQueue(root);
		queue.enQueue(null);
		while(!queue.isEmpty()) {
			
			root = (BinaryTreeNode) queue.deQueue();
			if( root == null ) {
				count++;
			}else {
				if( root.getLeft() != null ) {
					queue.enQueue(root.getLeft());
				}
				if( root.getRight() != null ) {
					queue.enQueue(root.getRight());
				}
				
				if( root.getRight() != null || root.getLeft() != null ) {
					queue.enQueue(null);
				}
			}
			
		}
		return count;
	}
}
