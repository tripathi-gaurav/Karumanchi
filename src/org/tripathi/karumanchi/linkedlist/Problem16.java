package org.tripathi.karumanchi.linkedlist;

//Reverse a Singly Linked List
//https://leetcode.com/problems/reverse-linked-list/description/
public class Problem16 {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		Problem16 solution = new Problem16();
		head = solution.reverseList(head);
		sll.PrintList(head);
	}
	
	ListNode reverseList(ListNode head) {
		ListNode temp = null, nextNode = null;
		while(head != null) {
			nextNode = head.getNext();
			head.setNext(temp);
			temp = head;
			head = nextNode;
		}
		return temp;
	}
}
