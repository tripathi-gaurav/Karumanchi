package org.tripathi.karumanchi.linkedlist;

//find if a list has a ciruclar loop in it or ends with null
//in this we make use of Flyod's algorithm
//we make use a fast pointer and slow pointer
//the fast pointer will increment with two steps
//whereas, the slow pointer will increment by one
//if there exists a loop, the hare will collide with the tortoise at one point in time!

//https://leetcode.com/problems/linked-list-cycle/description/

public class Problem9 {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = Problem6.getLinkedListWithLoop(sll);
		ListNode fastPtr = headNode, slowPtr = headNode;
		while(fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(fastPtr == slowPtr) {
				System.out.println("List contains a loop!");
				return;
			}
		}
		System.out.println("No loop found in the list!");
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}
