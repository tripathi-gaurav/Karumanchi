package org.tripathi.karumanchi.trees;

//http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
//problem 28 in the book
public class PrintAncestors {
	
	//Time Complexity : O(n)
	//Space Complexity: O(n) for the recursive stack
	public boolean printAllAncestors(BinaryTreeNode root, int target) {
		if(root == null) {
			return false;
		}
		if(root.getData() == target) {
			return true;
		}
		boolean targetHit = printAllAncestors(root.getLeft(), target) || printAllAncestors(root.getRight(), target);
		if(targetHit) {
			System.out.println(root.getData() + " ");
		}
		return targetHit;
		
	}

}
