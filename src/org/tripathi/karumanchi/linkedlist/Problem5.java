package org.tripathi.karumanchi.linkedlist;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Problem5 {
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = Problem3.PopulateList(sll);
		ListNode pNthNode = headNode, pTemp = headNode;
		sll.PrintList(headNode);
		System.out.println("Enter nth node: ");
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		Integer nthPosition = sc.nextInt();
		for(int i=1; pTemp.getNext()!= null ; i++) {
			pTemp = pTemp.getNext();
			if(i>=nthPosition) { //since we are starting the loop from 1 therefore its >=
				pNthNode = pNthNode.getNext();
			}
		}
		sc.close();
		System.out.println(pNthNode.getData());
	}
	

}
