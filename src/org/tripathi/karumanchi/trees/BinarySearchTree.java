package org.tripathi.karumanchi.trees;

import java.util.Stack;

import org.tripathi.karumanchi.queues.LLQueue;

public class BinarySearchTree {

	void PreOrder(BinaryTreeNode root) {
		//DLR : Root, Left, Right
		//Time Complexity: O(n)
		//Space Complexity: O(n)
		if(root!=null) {
			System.out.print(root.getData() + " ");
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	void PreOrderIterative(BinaryTreeNode root) {
		if(root == null) {
			return ;
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		while(true) {

			while(root != null) {
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			root = stack.pop();
			root = root.getRight();
		}
	}
	
	void InOrder(BinaryTreeNode root) {
		//LDR: Left, Root, Right
		//Time Complexity: O(n)
		//Space Complexity: O(n)
		if(root == null) {
			return ;
		}
		
		InOrder(root.getLeft());
		System.out.println(root.getData() + " " );
		InOrder(root.getRight());
	}
	
	void PostOrder(BinaryTreeNode root) {
		//LRD: Left, Right, Root
		//Time Complexity: O(n)
		//Space Complexity: O(n)
		if (root == null) {
			return ;
		}
		
		PostOrder(root.getLeft());
		PostOrder(root.getRight());
		System.out.println(root.getData());
	}
	
	void InOrderIterative(BinaryTreeNode root) {
		
		if(root == null) {
			return ;
		}
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		while(true) {

			while(root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			root = stack.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
	}
	
	void PostOrderIterative(BinaryTreeNode root) {
		//LRD: Left, Right, Root 
		Stack<BinaryTreeNode> stack = new Stack<>();
		if(root == null) {
			return;
		}
		
		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()) {
				break;
			}
			
			while(!stack.isEmpty()) {
				if(stack.peek().getRight() == root) {
					System.out.println(stack.peek());
					root = stack.pop();
				}else {
					break;
				}
			}
			
			if(!stack.isEmpty()) {
				root = stack.peek().getRight();
			}
		}
	}
	
	void LevelOrder(BinaryTreeNode root) {
		
		if(root == null) {
			return;
		}
		LLQueue queue = new LLQueue();
		BinaryTreeNode temp;
		
		queue.enQueue( root );
		while(!queue.isEmpty()) {
			
			temp = (BinaryTreeNode) queue.deQueue();
			System.out.println(temp.getData());
			
			if(temp.getLeft() != null) {
				queue.enQueue(temp.getLeft());
			}
			
			if(temp.getRight() != null) {
				queue.enQueue(temp.getRight());
			}
			
		}
	}
	
	BinaryTreeNode findInBST(BinaryTreeNode root, Integer target) {
		
		if(root == null) {
			return root;
		}
		
		while(root != null) {
			if(root.getData() == target) {
				break;
			}
			
			if(target < root.getData()) {
				root = root.getLeft();
			}
			if(target > root.getData()) {
				root = root.getRight();
			}
		}
		
		return root;
	}
	
	BinaryTreeNode findMinInBST(BinaryTreeNode root) {
		if(root == null) {
			return root;
		}
		while(root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}
	
	BinaryTreeNode findMinInBSTRecursive(BinaryTreeNode root) {
		if(root == null) {
			return root;
		}
		if(root.getLeft() == null) {
			return root;
		}
		return findMinInBSTRecursive(root.getLeft());
	}
	
	BinaryTreeNode findMaxInBST(BinaryTreeNode root) {
		if(root == null) {
			return root;
		}
		while(root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}
	
	BinaryTreeNode insertInBST(BinaryTreeNode root, int data) {
		//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
		//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
		
		if(root == null) {
			root = new BinaryTreeNode();
			root.setData(data);
		}else {
			if(data < root.getData()) {
				root = insertInBST(root.getLeft(), data);
			}else if(data > root.getData()) {
				root = insertInBST(root.getRight(), data);
			}
		}
		return root;
	}
	
	BinaryTreeNode deleteNode(BinaryTreeNode root, int data) {
		//https://leetcode.com/problems/delete-node-in-a-bst/description/
		//http://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/
		if(root == null) {
			return root;
		}
		
		if(root.getData() > data) {
			root.setRight(deleteNode(root.getRight(), data));
		}else if(root.getData() < data) {
			root.setLeft(deleteNode(root.getLeft(), data));
		}else {
			//we have found the element
			if(root.getRight() != null && root.getLeft() != null) {
				BinaryTreeNode maxInLeftSubTree = findMaxInBST(root.getLeft());
				root = maxInLeftSubTree;
				root.setLeft(deleteNode(root.getLeft(), maxInLeftSubTree.getData()));
			}else if(root.getRight() != null || root.getLeft() != null) {
				//has only one child
				BinaryTreeNode temp = ( root.getLeft() == null ? root.getRight() : root.getLeft() );
				root = temp;
				temp = null;
			}else {
				//leaf node...no child
				root = null;
			}
		}
		
		return root;
	}
	
	
}
