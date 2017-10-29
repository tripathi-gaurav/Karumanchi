package org.tripathi.karumanchi.trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
//problem 48 in book
public class LowestCommonAncestorInBST {

	public BinaryTreeNode lcaBST(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
		//one of the cases on GfG has q > p....you might want to add a check here
		if(root == null) {
			return root;
		}
		
		while(true) {
			if( (p.getData() < root.getData() && root.getData() < p.getData() )
					|| (p.getData() > root.getData() && root.getData() > q.getData()) ) {
				return root;
			}else {
				if(p.getData() > root.getData()) {
					root = root.getRight();
				}else {
					root = root.getLeft();
				}
			}
		}
	}
}
