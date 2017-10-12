package org.tripathi.karumanchi.linkedlist;

import java.util.Random;

public class CircularLinkedList {

	Integer ListLength(CLLNode headNode){
		Integer count = 0;
		CLLNode current = headNode;
		while(current != null) {
			count++;
			current = current.getNext();
			if( current == headNode ) {
				break;
			}
		}
		return count;
	}
	
	void PrintList(CLLNode headNode) {
		CLLNode currentNode = headNode;
		while(currentNode != null) {
			System.out.print(currentNode.getData() + " ->");
			currentNode = currentNode.getNext();
			if(currentNode == headNode) {
				break;
			}
		}System.out.println(headNode.getData() + "(headNode)");
	}
	
	CLLNode InsertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert) {
		if(headNode == null) {
			return nodeToInsert;
		}
		
		CLLNode currentNode = headNode;
		while(currentNode.getNext() != null) {
			if(currentNode.getNext() == headNode) {
				break;
			}
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(nodeToInsert);
		nodeToInsert.setNext(headNode);
		return headNode;
	}
	
	CLLNode InsertAtBegenningInCLL(CLLNode headNode, CLLNode nodeToInsert) {
		//differing from the book here in code style.
		//pretty much the same thing though
		if(headNode == null) {
			return nodeToInsert;
		}
		
		
		CLLNode currentNode = headNode;		
		while(currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(nodeToInsert);
		nodeToInsert.setNext(headNode);
		headNode = nodeToInsert;		
		
		return headNode;
	}
	
	CLLNode DeleteFirstNodeInCLL(CLLNode headNode) {
		
		if(headNode == null) {
			return headNode;
		}
		
		CLLNode currentNode = headNode;
		while(currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(headNode.getNext());
		headNode = headNode.getNext();
		return headNode;
	}
	
	CLLNode DeleteLastNodeInCLL(CLLNode headNode) {
		if(headNode == null) {
			return headNode;
		}
		
		CLLNode currentNode = headNode;
		CLLNode secondLastNode = currentNode;
		while(currentNode.getNext() != headNode) {
			secondLastNode = currentNode;
			currentNode = currentNode.getNext();
		}
		currentNode = null;
		secondLastNode.setNext(headNode);
		return headNode;
	}
	
	CLLNode DeleteNodeInCLLAtPosition(CLLNode headNode, Integer position) {
		if(headNode == null) {
			return headNode;
		}
		Integer size = ListLength(headNode);
		if(position > size+1 || position < 1) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + (size));
			return headNode;
		}
		
		if(position == 1) {
			headNode = DeleteFirstNodeInCLL(headNode);
		}else if(position == size) {
			headNode = DeleteLastNodeInCLL(headNode);
		}else {
			CLLNode nodeBeforeDeletionNode = headNode;
			for(int i=1;i<position-1;i++) {
				nodeBeforeDeletionNode = nodeBeforeDeletionNode.getNext();
			}
			CLLNode nodeToDelete = nodeBeforeDeletionNode.getNext();
			CLLNode nodeAfterDeletionNode = nodeToDelete.getNext();
			nodeBeforeDeletionNode.setNext(nodeAfterDeletionNode);
			//nodeToDelete is now orphaned. gc will collect it from the dumpster
			nodeToDelete = null;
			
		}
		return headNode;
	}
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		CLLNode headNode = new CLLNode(1);
		for(int i = 2; i<10; i++) {
			cll.InsertAtEndInCLL(headNode, new CLLNode(i));
			cll.PrintList(headNode);
		}
		
		Random rand = new Random();
		Integer size = cll.ListLength(headNode);
		Integer numberOfDeletions = rand.nextInt(size);
		System.out.println("Performing " + numberOfDeletions + " deletion(s).");
		Integer position = null;
		
		for(int i=1;i<=numberOfDeletions;i++) {
			position = rand.nextInt(cll.ListLength(headNode)) + 1;
			System.out.println("Deleting node at position: " + position);
			headNode = cll.DeleteNodeInCLLAtPosition(headNode, position);
			cll.PrintList(headNode);
		}
	}
	
	
}
