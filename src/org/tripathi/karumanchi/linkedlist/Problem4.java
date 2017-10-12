package org.tripathi.karumanchi.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Find the nth node from last in Linked List
public class Problem4 {

	public static void main(String[] args)throws IOException {
		SinglyLinkedList sll = new SinglyLinkedList();
		Problem4 solution = new Problem4();
		ListNode headNode = solution.PopulateList(sll);
		Integer size = sll.ListLength(headNode);
		sll.PrintList(headNode);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer nthPosition = Integer.parseInt(br.readLine().trim());
		if(nthPosition > size -1) {
			System.out.println("Fewer nodes in the list");
		}
		ListNode currentNode = headNode;
		for(int i=1;i<=size-nthPosition;i++) {
			currentNode = currentNode.getNext();
		}
		System.out.println(currentNode.getData());
		//Time Complexity: O(n);
	}
	
	ListNode PopulateList(SinglyLinkedList sll) {
		ListNode headNode = new ListNode(1); 
		ListNode nodeToInsert = null;
		for(int i=1; i<=10;i++) {
			nodeToInsert = new ListNode(i);
			sll.InsertInLinkedList(headNode, nodeToInsert, i);
		}
		return headNode;
	}
}
