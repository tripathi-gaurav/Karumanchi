package org.tripathi.karumanchi.linkedlist;

//Split a Circular Linked List in two equal halves;

public class Problem36 {
	public static void main(String[] args) {
		
	CircularLinkedList cll = new CircularLinkedList();
	CLLNode head = cll.getCircularLinkedList();
	cll.PrintList(head);
	
	CLLNode slowPtr = head, fastPtr = head;
	do {
		fastPtr = fastPtr.getNext().getNext();
		slowPtr = slowPtr.getNext();
	}while(fastPtr != head && fastPtr.getNext() != head);

	fastPtr.setNext(slowPtr.getNext());
	slowPtr.setNext(head);
	
	cll.PrintList(head);
	cll.PrintList(fastPtr);
	
	}
}
