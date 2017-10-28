package org.tripathi.karumanchi.trees;

//book has different definition of isomorphic while GfG has a different definition
//according to GfG, isomorphic will be what the book defines as quasiIsomorphic PLUS making sure data is same
/*
 * as per GfG:
 * Two trees are called isomorphic if one of them can be obtained from other by a series of flips,
 * i.e. by swapping left and right children of a number of nodes. 
 * Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
 */
//The above will be implemented in the method quasiIsomorphic
//isIsomorphic will be as per the book's definition
//problem  41 and 42
public class Isomorphic {

	public boolean isIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return isIsomorphic(root1.getLeft(), root2.getRight()) && isIsomorphic(root1.getRight(), root2.getRight());
	}

	public boolean quasiIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2) {
		// this will have all the above condition PLUS check if swapping makes it equal
		// PLUS check if data are equal
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return ( root1.getData() == root2.getData() ) && (
				( quasiIsomorphic(root1.getLeft(), root2.getLeft()) && quasiIsomorphic(root1.getRight(), root2.getRight()) )
				|| ( quasiIsomorphic(root1.getLeft(), root2.getRight())	&& quasiIsomorphic(root1.getRight(), root2.getLeft()) )
				);
	}
}
