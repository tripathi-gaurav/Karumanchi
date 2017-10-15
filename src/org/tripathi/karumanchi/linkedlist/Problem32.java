package org.tripathi.karumanchi.linkedlist;

//Reverse a linked list in pairs
//1->2->3->4->X
//2->1->4->3->X

public class Problem32 {

	public static void main(String[] args) {
		Problem32 solution = new Problem32();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		sll.PrintList(head);
		head = solution.mySolution(head);
		sll.PrintList(head);
	}
	
	ListNode mySolution(ListNode head) {
		//Time complexity: O(n) for traversing the elements
		//Space COmplexity: O(1)
		ListNode temp=null,temp2=null;
		ListNode current = head;
		ListNode previous = null;
		Boolean isHeadUpdated = false;
		
		while(current != null && current.getNext() != null) {
			temp = current.getNext();
			temp2 = temp.getNext();
			temp.setNext(current);
			current.setNext(temp2);
			
			if(!isHeadUpdated) {
				head = temp;
				isHeadUpdated = true;
			}else {
				previous.setNext(temp);
			}
			previous = current;
			current = current.getNext();
		}
		
		return head;
	}
}
