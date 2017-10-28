package org.tripathi.karumanchi.trees;

public class MirrorOrNot {

	//problem number 25
	public boolean MirrorOrNot(BinaryTreeNode root1, BinaryTreeNode root2) {
		//Time Complexity: O(n)
		//Space Complexity: O(n)
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		if(root1.getData() == root2.getData()) {
			return true;
		}
		boolean isMirror = MirrorOrNot(root1.getLeft(), root2.getLeft()) && MirrorOrNot(root1.getRight(), root2.getRight());
		return isMirror;
		
	}
	
}
