package org.tripathi.karumanchi.trees;

/*
 * find if a tree is symmetric in nature. for example, the below is symmetric
    1
   / \
  2   2
 / \ / \
3  4 4  3

https://leetcode.com/problems/symmetric-tree/description/
*/
public class MirrorTree {

	public boolean isSymmetric(BinaryTreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.getLeft(), root.getRight());
        
    }
    
    public boolean isSymmetric(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.getData() != root2.getData()){
            return false;
        }else{
            return isSymmetric(root1.getLeft(), root2.getRight()) && isSymmetric(root1.getRight(), root2.getLeft());
        }
    }
	
}
