package org.tripathi.karumanchi.linkedlist;

//Print a LinkedList in reverse order

public class Problem28 {

	public static void main(String[] args) {
		Problem28 solution = new Problem28();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		solution.PrintListInReverse(head);
		
	}
	
	private void PrintListInReverse(ListNode head) {
		if(head == null) {
			return;
		}
		PrintListInReverse(head.getNext());
		System.out.print(head.getData());
		
		//Time Complexity: O(n)
		//Space Complexity: O(n) for the stack of this method's recursive call
	}
}
