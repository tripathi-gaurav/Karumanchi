package org.tripathi.karumanchi.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//Find the nth node from last in Linked List
public class Problem3 {
	public static void main(String[] args)throws IOException {
		SinglyLinkedList sll = new SinglyLinkedList();
		Problem3 solution = new Problem3();
		ListNode headNode = solution.PopulateList(sll);
		HashMap<Integer, ListNode> hashOfListWithKeyAndData = new HashMap<>();
		ListNode currentNode = headNode;
		Integer nthPosition, index = 0;
		System.out.println("enter nth position");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nthPosition = Integer.parseInt(br.readLine().trim());
		sll.PrintList(headNode);
		while(currentNode != null) {
			hashOfListWithKeyAndData.put(index++, currentNode);
			currentNode = currentNode.getNext();
		}
		
		System.out.println(hashOfListWithKeyAndData.get(index-nthPosition).getData());
	}
	
	static ListNode PopulateList(SinglyLinkedList sll) {
		ListNode headNode = new ListNode(1); 
		ListNode nodeToInsert = null;
		for(int i=1; i<=9;i++) {
			nodeToInsert = new ListNode(i);
			sll.InsertInLinkedList(headNode, nodeToInsert, i);
		}
		return headNode;
	}
	
	static ListNode PopulateList2(SinglyLinkedList sll) {
		ListNode headNode = new ListNode(11);
		ListNode nodeToInsert = null;
		for(int i=11;i<=20;i++) {
			nodeToInsert = new ListNode(i);
			sll.InsertInLinkedList(headNode, nodeToInsert, i-10);
		}
		return headNode;
	}
	

}
