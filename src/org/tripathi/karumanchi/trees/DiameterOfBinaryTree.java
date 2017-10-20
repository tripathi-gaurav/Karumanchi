package org.tripathi.karumanchi.trees;

//https://leetcode.com/problems/diameter-of-binary-tree/description/
//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/

public class DiameterOfBinaryTree {

	public Integer diameterOfBinaryTree(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		int rootDiameter = height(root.getLeft()) + height(root.getRight()); // +1 if you are counting nodes to compute dia
		int leftDiameter = diameterOfBinaryTree(root.getLeft());
		int rightDiameter = diameterOfBinaryTree(root.getRight());
		
		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}
	
	public Integer height(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
		
	}
}
