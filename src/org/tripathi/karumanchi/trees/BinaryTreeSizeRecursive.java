package org.tripathi.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

//problem 6 and problem 7
public class BinaryTreeSizeRecursive {

	public Integer SizeOfBinaryTree(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}else {
			return SizeOfBinaryTree(root.getLeft()) + 1 + SizeOfBinaryTree(root.getRight());
		}
	}
	
	public Integer SizeOfBinaryTreeRecursive(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		Integer size = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			root = queue.poll();
			size++;
			if(root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if(root.getRight()!=null) {
				queue.add(root.getRight());
			}
		}
		
		return size;
	}
}
