package org.tripathi.karumanchi.trees;

//problem 34
//http://www.geeksforgeeks.org/connect-nodes-at-same-level/

public class ConnectNodesAtSameLevel {

	/*
	 * Please note that it's Function problem i.e. you need to write your solution
	 * in the form of Function(s) only. Driver Code to call/invoke your function
	 * would be added by GfG's Online Judge.
	 */

	// A Binary Tree node
	class Node {
		int data;
		Node left, right, nextRight;

		Node(int item) {
			data = item;
			left = right = nextRight = null;

		}
	}

	class GfG {
		void connect(Node root) {
			// Your code here
			if (root == null) {
				return;
			}
			java.util.Queue<Node> queue = new java.util.LinkedList<Node>();
			queue.add(root);
			queue.add(null);

			while (!queue.isEmpty()) {
				root = queue.poll();
				if (root == null) {
					if (!queue.isEmpty()) {
						queue.add(null);
					}
				} else {
					root.nextRight = queue.peek();
					if (root.left != null) {
						queue.add(root.left);
					}
					if (root.right != null) {
						queue.add(root.right);
					}
				}
			}
		}
	}
	
	
}
