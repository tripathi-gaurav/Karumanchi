package org.tripathi.karumanchi.linkedlist;

/*
 * Here, we go through various operations of SinglyLinkedList
 * The list contains of nodes which will have a next pointer/reference
 * The last node is identified by checked the the next pointer pointing to NULL
 */
public class SinglyLinkedList {
	
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
	
	ListNode InsertNodeAtEndOfLinkedList(ListNode headNode, int data) {
		ListNode newNode = new ListNode(data);
		newNode.setNext(null);
		ListNode currentNode = headNode;
		/*traverse the list till you reach the last element
		 * the first implementation that i came up with. 
		 * one should delete the dead code below.
		 * while(true) {
			if(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}else {
				break;
			}
		}*/
		// i feel the below implementation is more readable
		while( currentNode.getNext() != null ) {
			currentNode = currentNode.getNext();
		}
		//now that currentNode is the last node, set its next pointer to the new node
		currentNode.setNext(newNode);
		return headNode;
		//Time Complexity: O(n)
		
	}
	
	
	//Now we insert a node in between the linked list at a specified position
	//the node to be inserted is provided by user now
	ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
		if( headNode==null ) {
			//if the headNode itself is null, let us set the newNode as the headNode and be sorted
			return nodeToInsert;
		}
		Integer size = ListLength(headNode);
		if( position > size+1 || position < 1 ) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + size+1);
			return headNode;
		}
		// if position is 1, that means insertion is happening before the headnode
		// (I) to insert before the headnode, we will have to use set the nodeToInsert's next pointer 
		// (II) also we return the nodeToInsert in order to change the headNode to point to the new one
		// for everything else, we can traverse from the headNode to the desired position.
		if( position == 1 ) {
			nodeToInsert.setNext(headNode); //(I)
			return nodeToInsert; //(II)
		}else {
			//all other cases, traverse
			ListNode previousNode = headNode;
			// we start with 1 as in head position, go up to position - 1 
			// pos - 1 will be the node AFTER which insertion is done. 
			// if we go up to position, then we can't do anything with that node as that node should actually 
			//						...be the next node after the nodeToInsert
			for(int i=1;i<position-1;i++) {
				previousNode = headNode.getNext(); 
			}
			ListNode nextNode = previousNode.getNext(); 
			previousNode.setNext(nodeToInsert);
			nodeToInsert.setNext(nextNode);
		}
		return headNode;
		//Time Complexity: O(n) for insertion at worst
		//Space Complexity: O(1) for the temp variable
	}
	
	ListNode deleteFirstNodeInSLL(ListNode headNode) {
		/*ListNode tempNode = headNode.getNext();
		headNode = null;
		return tempNode;*/
		//since we are returning and effectively updating the headNode
		//therefore, if we just return headNode.getNext(), it should work just fine.
		return headNode.getNext();
	}
	
	ListNode deleteLastNodeInSLL(ListNode headNode) {
		ListNode currentNode = headNode;
		//traverse to the second last node and setNext to NULL
		while(currentNode.getNext().getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(null);
		return headNode;
	}
	
	ListNode deleteLastNodeInSLL2(ListNode headNode) {
		//this is the implementation that the book explains
		ListNode currentNode = headNode;
		ListNode previousNode = currentNode;
		//traverse to the second last node and setNext to NULL
		while(currentNode.getNext() != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		currentNode = null; //not really required here, gc can handle this
		previousNode.setNext(null);
		return headNode;
	}
	
	ListNode DeleteFromLinkedList(ListNode headNode, Integer position) {
		//multiple returns in this method. don't think multiple returns are good for implementation/maintainability
		int size = ListLength(headNode);
		if(position > size + 1 || position < 1) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + size+1);
			return headNode;
		}
		
		if(position == 1) {
			//return deleteFirstNodeInSLL(headNode);
			ListNode currentNode = headNode.getNext();
			headNode = null; //not required here, let gc take care
			return currentNode; //ideally, simply do return headNode.getNext();
		}else {
			ListNode currentNode = headNode.getNext();
			for(int i=1;i<position-1;i++) { //book uses while(count < position)
				currentNode = currentNode.getNext();
			}
			//changed the names and method to do the same thing as in book and make it easier to understand.
			ListNode nodeToDelete = currentNode.getNext();
			currentNode.setNext(nodeToDelete.getNext());
			nodeToDelete = null; //mark for gc
		}
		
		return headNode;
	}
	ListNode DeleteFromLinkedListSingleReturn(ListNode headNode, Integer position) {
		//multiple returns in this method. don't think multiple returns are good for implementation/maintainability
		int size = ListLength(headNode);
		Boolean alert = false;
		if(position > size + 1 || position < 1) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + size+1);
			alert = true;
		}
		if(!alert) {
			if(position == 1) {
				//return deleteFirstNodeInSLL(headNode);
				ListNode currentNode = headNode.getNext();
				headNode = null; //not required here, let gc take care
				headNode = currentNode; //ideally, simply do return headNode.getNext();
			}else {
				ListNode currentNode = headNode.getNext();
				for(int i=1;i<position-1;i++) { //book uses while(count < position)
					currentNode = currentNode.getNext();
				}
				//changed the names and method to do the same thing as in book and make it easier to understand.
				ListNode nodeToDelete = currentNode.getNext();
				currentNode.setNext(nodeToDelete.getNext());
				nodeToDelete = null; //mark for gc
			}
		}
		return headNode;
	}

}
