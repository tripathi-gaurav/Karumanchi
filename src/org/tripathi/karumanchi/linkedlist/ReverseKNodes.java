package org.tripathi.karumanchi.linkedlist;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
//Problem 37 in book

public class ReverseKNodes {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode head = Problem3.PopulateList(sll);
		ReverseKNodes solution = new ReverseKNodes();
		sll.PrintList(head);
		head = solution.reverseKNodes(head, 4);
		sll.PrintList(head);
	}
	
	ListNode reverseKNodes(ListNode head, Integer k) {
		if(head == null) {
			return head;
		}
		
		int count = 1;
		ListNode temp = null, next, tempHead = head;
		ListNode nodeToConnectFrom = head, nodeToConnectTo;
		Boolean isHeadUpdated = false;
		ListNode previousEnd = null;
		
		while(nodeToConnectFrom != null && hasKNodes(nodeToConnectFrom, k)) {
			nodeToConnectTo = getNodeToConnectTo(nodeToConnectFrom, k);
			tempHead = nodeToConnectFrom;
			System.out.println("node to connect from: " + nodeToConnectFrom.getData());
			System.out.println("nodeTo Connect to: " + ( nodeToConnectTo == null ? "null" : nodeToConnectTo.getData() ) );
			temp = null;
			count=1;
			while(tempHead != null && count <=k) {
				next = tempHead.getNext();
				tempHead.setNext(temp);
				temp = tempHead;
				tempHead = next;
				count++;
			}
			

			if(!isHeadUpdated) {
				head = temp;
				isHeadUpdated = true;
				previousEnd = nodeToConnectFrom;
			}else {
				previousEnd.setNext(temp);
				previousEnd = nodeToConnectFrom;
			}
			
			nodeToConnectFrom.setNext(nodeToConnectTo);
			nodeToConnectFrom = nodeToConnectTo;
			
		}
		
		return head;
	}
	
	private Boolean hasKNodes(ListNode head, Integer k) {
		Boolean hasKNodes = true;
		for(int i=0;i<k;i++) {
			if(head == null) {
				hasKNodes = false;
				break;
			}
			head = head.getNext();
		}
		return hasKNodes;
	}
	
	private ListNode getNodeToConnectTo(ListNode head, Integer k) {
		for(int i=0;i<k;i++) {
			head = head.getNext();
		}
		return head;
	}
}
