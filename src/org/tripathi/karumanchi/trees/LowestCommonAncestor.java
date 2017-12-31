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
		
		BinaryTreeNode leftTemp = lca(root.getLeft(), p, q);
		BinaryTreeNode rightTemp = lca(root.getRight(), p, q);
		
		if(leftTemp != null && rightTemp != null){
            return root;
        }
		
		if(leftTemp == null) {
			return leftTemp;
		}
		
		if(rightTemp == null) {
			return rightTemp;
		}
		
		return null;
	}
}
