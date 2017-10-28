package org.tripathi.karumanchi.trees;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
//problem 29
public class LowestCommonAncestor {

	public BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		if(root == null) {
			return root;
		}
		
		//use the first condition for leet code
		//if(root == p || root == q)
		if(root.getData() == p.getData() || root.getData() == q.getData()) {
			return root;
		}
		
		
		return null;
	}
}
