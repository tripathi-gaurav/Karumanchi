package org.tripathi.karumanchi.trees;

import org.tripathi.karumanchi.stacks.LLStack;
//problem-20 in book
//http://practice.geeksforgeeks.org/problems/root-to-leaf-paths/
//https://leetcode.com/problems/binary-tree-paths/description/

public class PrintPaths {

	public void printPathsIterative(BinaryTreeNode root) {
		//Time complexity : O(n)
		//Space complexity : O(n) for the stack
		if(root == null) {
			return ;
		}
		
		LLStack stack = new LLStack();
		stack.push(root);
		String path = root.getData() + " ";
		BinaryTreeNode temp = null;
		
		while(!stack.isEmpty()) {
			path = (String) stack.pop();
			root = (BinaryTreeNode) stack.pop();
			
			if(temp.getLeft() == null && temp.getRight() == null) {
				System.out.print(path + "#");
			}
			
			if(root.getRight() != null) {
				temp = root.getRight();
				path += temp.getData() + " ";
				stack.push(temp);
				stack.push(path);
			}
			//change the order of check left and right node to match the book's output.
			//current order match the problem on GfG
			if(root.getLeft() != null) {
				temp = root.getLeft();
				path += temp.getData() + " ";
				stack.push(temp);
				stack.push(path);
			}
			
		}
		
	}
}
