package org.tripathi.karumanchi.trees;

public class MirrorABinaryTree {
	
	BinaryTreeNode MirrorABinaryTree(BinaryTreeNode root) {
		if(root == null) {
			return root;
		}
		
		MirrorABinaryTree(root.getLeft());
		MirrorABinaryTree(root.getRight());
		BinaryTreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
		return root;
	}
}
