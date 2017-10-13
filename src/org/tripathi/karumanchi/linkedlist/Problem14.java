package org.tripathi.karumanchi.linkedlist;


//find if there is cycle(loop) in the linked list
//if there is a cycle, find the length of the cycle

//Time Complexity: O(N)
//Space Complexity: O(1)
public class Problem14 {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = Problem6.getLinkedListWithLoop(sll);
		Problem14 solution = new Problem14();
		ListNode fastPtr = headNode, slowPtr = headNode;
		Integer count = 1;
		
		Boolean loopExists = false;
		while(fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(slowPtr == fastPtr) {
				loopExists = true;
				//break;
			}
			
			if(loopExists) {
				fastPtr = fastPtr.getNext(); //since count is already initialized to 0, so no problem.
				while(fastPtr != slowPtr) {
					count++;
					fastPtr = fastPtr.getNext();
				}
				break;
				/* 
				 //re-initialized slowPtr to headNode and then found the start of the cycle/loop
				 //once at start, then ran a loop while incrementing a counter till the slowPtr reach back
				 //to the start of the loop
				 //better method was in the book. instead of finding the start ofthe loop
				 //leave the slowPtr where it is, increment the fastPtr till it equals the slowPtr 
				slowPtr = headNode;
				while(slowPtr != fastPtr) {
					slowPtr = slowPtr.getNext();
					fastPtr = fastPtr.getNext();
				}
				
				ListNode nodeAtStartOfCycle = fastPtr;
				slowPtr = slowPtr.getNext();
				
				while(slowPtr != nodeAtStartOfCycle) {
					count++;
					slowPtr = slowPtr.getNext();
				}
				break;*/
			}
		}
		if(loopExists) {
			System.out.println("Length of looop: " + count);
		}
		
	}
}
