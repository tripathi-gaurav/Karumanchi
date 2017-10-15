package org.tripathi.karumanchi.linkedlist;

//Check whether a LinkedList has even or odd number of elements 
//traverse the list with a pointer stepping two nodes at a time
//if, in the end the node is null, then we have even number of nodes

public class Problem29 {

	public static void main(String[] args) {
		Problem29 solution = new Problem29();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		if(solution.isListEven(head)) {
			System.out.println("List has even number of elements");
		}else {
			System.out.println("List has odd number of elements");
		}
		ListNode nodeToInsert = new ListNode(10);
		sll.InsertInLinkedList(head, nodeToInsert, 10);
		System.out.println("Is list even?: " + solution.isListEven(head));
		
	}
	
	private Boolean isListEven(ListNode head) {
		//Time complexity: O(n/2) = O(n)
		//Space complexity: O(1)
		Boolean isListEven = false;
		while(head != null && head.getNext() != null) {
			head = head.getNext().getNext();
		}
		if( head == null) {
			isListEven = true;
		}else {
			isListEven = false;
		}
		return isListEven;
	}
}
