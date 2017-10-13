package org.tripathi.karumanchi.linkedlist;

import java.util.Stack;

//find if a list has a ciruclar loop in it or ends with null
//hash table method
//in this approach we maintain a hash table of all the nodes
//if a node already exists in the hash table, then ta-da! we have spotted a loop
//i chose to use a stack instead of hash map
public class Problem7 {
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = Problem6.getLinkedListWithLoop(sll);
		Problem7 solution = new Problem7();
		solution.findIfLoopExists(headNode);
	}

	void findIfLoopExists(ListNode headNode) {
		Stack<ListNode> nodeStack = new Stack<ListNode>();
		ListNode currentNode = headNode;
		while(currentNode.getNext() != null) {
			if(!nodeStack.contains(currentNode)) {
				nodeStack.add(currentNode);
				currentNode = currentNode.getNext();
			}else {
				System.out.println("List contains a loop at node with data: " + currentNode.getData());
				break;
			}
		}		
	}
	//Time Complexity: O(n) for scanning the list
	//Space Complexity: O(n) for hash table or stack
}
