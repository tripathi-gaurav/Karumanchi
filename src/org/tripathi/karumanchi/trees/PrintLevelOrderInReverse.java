package org.tripathi.karumanchi.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrderInReverse {

	public void levelOrderInReverse(BinaryTreeNode root) {
		if(root == null) {
			return;
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			root = queue.poll();
			stack.push(root);
			
			if(root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if(root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
