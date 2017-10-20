package org.tripathi.karumanchi.trees;

public class AreStructurallyIdentical {

	public Boolean areStructurallyIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		return ( root1.getData() == root2.getData() && (
				( areStructurallyIdentical(root1.getLeft(), root2.getLeft()) ) &&
				( areStructurallyIdentical(root1.getRight(), root2.getRight()) )
														)
				);
	}
}
