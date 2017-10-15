package org.tripathi.karumanchi.linkedlist;

import java.util.HashMap;
import java.util.Map;

//find the middle node in a linked list
//not implementing the brute force method in problem24. never will.


public class Problem25Through27 {

	public static void main(String[] args) {
		Problem25Through27 solution = new Problem25Through27();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		sll.PrintList(head);
		solution.problem25(head);
		solution.problem26(head);
		solution.problem27(head);
	}

	private void problem25(ListNode head) {
		// here we solve by first getting the length of the list and then traversing till n/2
		Integer length = Problem19.listLength(head);
		ListNode current = head;
		for(int i=0;i<length/2;i++) {
			current = current.getNext();
		}
		System.out.println("middle node by list length: " + current.getData());
		//Time Complexity: O(n) + O(n)
		//Space Complexity: O(1)
	}
	
	private void problem26(ListNode head) {
		// here we will use a HashMap<Index, Node> and get the Node at index n/2
		ListNode current = head;
		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		Integer index = 1;
		while(current != null) {
			map.put(index++, current);
			current = current.getNext();
		}
		System.out.println("middle node by list length: " + map.get(index/2).getData());
		//Time Complexity: O(n)
		//Space Complexity: O(n)
	}
	
	private void problem27(ListNode head) {
		//Efficient solution
		//do it in a single scan. use two pointers:
		//fastPtr increasing at 2x and slowPtr moving at x
		//when fastPtr reaches the end, slowPtr will be at the middle
		ListNode fastPtr = head, slowPtr = head;
		while(fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}
		System.out.println("middle node by list length: " + slowPtr.getData());
	}
	
}
