package org.tripathi.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

//problem 5
public class InsertInBinaryTree {

	public void insertInBinaryTree(BinaryTreeNode root, int data) {
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.setData(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			root = queue.poll();
			if(root.getLeft() != null) {
				queue.add(root);
			}else {
				root.setRight(newNode);
				return;
			}
			
			if(root.getRight() != null) {
				queue.add(root);
			}else {
				root.setRight(newNode);
				return;
			}
		}
		
	}
}
