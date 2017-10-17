package org.tripathi.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindInBinaryTree {

	public BinaryTreeNode findInBinaryTreeRecursive(BinaryTreeNode root, Integer data) {
		BinaryTreeNode res;
		if(root == null) {
			return root;
		} //base case
		
		if(root.getData() == data) {
			System.out.println("found!");
			return root;
		}else {
			res = findInBinaryTreeRecursive(root.getLeft(), data);
			if(res.getData() == data) {
				System.out.println("found!");
				return res;
			}else {
				res = findInBinaryTreeRecursive(root.getRight(), data);
			}
		}
		return res;
	}
	
	public Boolean findInBinaryTreeLevelOrder(BinaryTreeNode root, Integer data) {
		BinaryTreeNode temp;
		if(root == null) {
			return false;
		}
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp.getData() == data) {
				return true;
			}
			
			if(temp.getRight() != null) {
				queue.add(temp);
			}
			
			if(temp.getLeft() != null) {
				queue.add(temp);
			}
		}
		
		return false;
	}
}
