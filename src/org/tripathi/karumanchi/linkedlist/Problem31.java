package org.tripathi.karumanchi.linkedlist;

//given two sorted lists, merge them into a third sorted list

public class Problem31 {

	public static void main(String[] args) {
		Problem31 solution = new Problem31();
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head1 = Problem3.PopulateList(sll);
		ListNode head2 = Problem3.PopulateList2(sll);
		ListNode resultHead = solution.MergeSortedList(head1, head2);
		sll.PrintList(resultHead);
		
		
	}
	
	ListNode MergeSortedList(ListNode head1, ListNode head2) {
		//Time Complexity : O(n)
		
		ListNode head = null;
		
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		
		if(head1.getData() < head2.getData()) {
			head = head1;
			head.setNext(MergeSortedList(head1.getNext(), head2));
		}else if(head2.getData() < head1.getData()) {
			head = head2;
			head.setNext(MergeSortedList(head1, head2.getNext()));		}
		
		
		return head;
		
	}
}
