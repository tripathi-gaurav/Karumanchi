package org.tripathi.karumanchi.linkedlist;

import java.util.Random;

public class DoublyLinkedList {
	
	Integer ListLength(DLLNode headNode) {
		Integer count = 0;
		DLLNode currentNode = headNode;
		while(currentNode != null) {
			currentNode = currentNode.getNext();
			count++;
		}
		return count;
	}

	DLLNode InsertInDLL(DLLNode headNode, DLLNode nodeToInsert, Integer position) {
		if(headNode == null) {
			return nodeToInsert;
		}
		
		Integer size = ListLength(headNode);
		if(position > size+1 || position < 1) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + (size));
			return headNode;
		}
		
		if(position == 1) {
			headNode.setPrevious(nodeToInsert);
			nodeToInsert.setNext(headNode);
			nodeToInsert.setPrevious(null);
		}else {
			DLLNode currentNode = headNode;
			for(int i=1;i<position-1;i++) {
				currentNode = currentNode.getNext();
			}
			DLLNode nextNode = currentNode.getNext();
			currentNode.setNext(nodeToInsert);
			nodeToInsert.setPrevious(currentNode);
			nodeToInsert.setNext(nextNode);
		}
		
		return headNode;
	}
	
	DLLNode DeleteNodeInDLL(DLLNode headNode, Integer position) {
		if(headNode == null) {
			return headNode;
		}
		
		Integer size = ListLength(headNode);
		if(position >size+1 || position < 1) {
			System.out.println("Invalid position specified. Valid positions are between 1 and " + (size));
			return headNode;
		}
		
		if(position == 1) {
			DLLNode newHeadNode = headNode.getNext();
			headNode = null;
			newHeadNode.setPrevious(null);
		}else {
			DLLNode previousNode = headNode;
			for(int i =1; i<position-1; i++) {
				previousNode = previousNode.getNext();
			}
			DLLNode nodeToDelete = previousNode.getNext();
			DLLNode nextNode = nodeToDelete.getNext();
			if(nextNode != null) {
				previousNode.setNext(nextNode);
				nextNode.setPrevious(previousNode);
			}
			nodeToDelete = null;
		}
		return headNode;
		//Time Complexity: O(n)
		//Space Complexity: O(1)
	}
	
	void PrintList(DLLNode headNode) {
		DLLNode currentNode = headNode;
		System.out.print("X ");
		while(currentNode != null) {
			System.out.print("<- " + currentNode.getData() + " -> ");
			currentNode = currentNode.getNext();
		}System.out.println(" X");
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		DLLNode headNode = null;
		for(int i=1;i<10;i++) {
			DLLNode t = new DLLNode(i);
			headNode = dll.InsertInDLL(headNode, t, i);
			dll.PrintList(headNode);
		}
		Random rand = new Random();
		Integer noOfTimeToDelete = rand.nextInt(8);
		System.out.println("deleting random " + noOfTimeToDelete + " nodes");
		for(int i=0; i<noOfTimeToDelete; i++) {
			Integer position = rand.nextInt(dll.ListLength(headNode));
			System.out.println("Deleting node at position: " + position);
			dll.DeleteNodeInDLL(headNode, position);
			dll.PrintList(headNode);
		}
	}
}
