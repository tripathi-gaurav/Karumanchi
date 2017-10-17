package org.tripathi.karumanchi.linkedlist;

//insert a node in a sorted LinkedList

public class Problem15 {
	
	public static void main(String[] args) {
		Problem15 solution = new Problem15();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		sll.PrintList(head);
		ListNode nodeToInsert = new ListNode(22);
		head = solution.insertIntSortedList(head, nodeToInsert);
		sll.PrintList(head);
		nodeToInsert = new ListNode(2);
		head = solution.insertIntSortedList(head, nodeToInsert);
		sll.PrintList(head);
		nodeToInsert = new ListNode(11);
		head = solution.insertIntSortedList(head, nodeToInsert);
		sll.PrintList(head);
		nodeToInsert = new ListNode(100);
		head = solution.insertIntSortedList(head, nodeToInsert);
		sll.PrintList(head);
	}

	ListNode insertIntSortedList(ListNode head, ListNode nodeToInsert) {
		//Time complexity: O(n)
		//Space complexity: O(1)
		ListNode currentNode = head;
		ListNode previousNode = head;
		//book's cleaner version
		while(currentNode != null && (Integer) nodeToInsert.getData() > (Integer) currentNode.getData()) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		nodeToInsert.setNext(currentNode);
		previousNode.setNext(nodeToInsert);
		/* my first attempt
		
		while(nodeToInsert.getData() > currentNode.getData() && currentNode.getNext() != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		if(nodeToInsert.getData() > currentNode.getData()) {
			nodeToInsert.setNext(currentNode.getNext());
			currentNode.setNext(nodeToInsert);
		}else if(nodeToInsert.getData() < currentNode.getData() && nodeToInsert.getData() > previousNode.getData()) {
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
		}*/
		
		return head;
	}
}
