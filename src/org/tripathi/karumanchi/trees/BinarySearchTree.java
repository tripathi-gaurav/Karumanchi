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
}
