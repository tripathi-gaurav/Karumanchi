package org.tripathi.karumanchi.linkedlist;

//find if loop exists by Floyd's algorithm and then find the node at which loop exists
//we use the same fastPtr and slowPtr logic as in Problem9
//once loop is found then we re-initialize the slowPtr to head
//and from there on, increment both fastPtr and slowPtr by one till they are equal

//https://leetcode.com/problems/linked-list-cycle-ii/description/
public class Problem11 {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = Problem6.getLinkedListWithLoop(sll);
		Problem11 solution = new Problem11();
		ListNode nodeAtWhichLoopExists =  solution.findNodeAtWhichLoopExists(headNode);
		if(nodeAtWhichLoopExists == headNode) {
			System.out.println("No loop");
		}else {
			System.out.println(nodeAtWhichLoopExists.getData());
		}
	}

	ListNode findNodeAtWhichLoopExists(ListNode headNode) {

		ListNode fastPtr = headNode, slowPtr = headNode;
		Boolean loopExists = false;
		while(fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(fastPtr==slowPtr) {
				loopExists = true;
				break;
			}
		}
		
		if(loopExists) {
			slowPtr = headNode;
			while(fastPtr != slowPtr) {
				fastPtr = fastPtr.getNext();
				slowPtr = slowPtr.getNext();
			}
			return fastPtr;
		}
		
		return headNode;
	}
}
