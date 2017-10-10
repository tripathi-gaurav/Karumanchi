package org.tripathi.karumanchi.linkedlist;

/*
 * Here, we go through various operations of SinglyLinkedList
 * The list contains of nodes which will have a next pointer/reference
 * The last node is identified by checked the the next pointer pointing to NULL
 */
public class SinglyLinkedList {
	
	ListNode sll;
	
	//Traversing the Linked List
	int ListLength(ListNode headNode) {
		//we start by traversing from the first node
		//we stop our counter when the last node points to NULL
		int length = 0;
		ListNode currentNode = headNode; //we will use this as our marker
		while(currentNode != null ) { //when marker points to NULL, we are done
			length++;
			currentNode = currentNode.getNext(); //move to the next node
		}
		return length;
	}
	//since we are traversing the entire list of size n
	//therefore, the time complexity is O(n)
	//space complexity will be O(1) for creating a temp variable
	
	
	//Inserting a node at the beginning of the linked list
	ListNode InsertNodeAtBeginning(ListNode headNode, int data) {
		ListNode newHeadNode = new ListNode(data);
		newHeadNode.setNext(headNode);
		return newHeadNode;
	}
	

}
