package org.tripathi.karumanchi.linkedlist;

//find if a list has a ciruclar loop in it or ends with null
//brute force method
public class Problem6 {

	static ListNode getLinkedListWithLoop(SinglyLinkedList sll) {
		ListNode headNode = new ListNode(1);
		ListNode loopToNode = null;
		for(int i=2;i<10;i++) {
			ListNode nodeToInsert = new ListNode(i);
			headNode = sll.InsertInLinkedList(headNode, nodeToInsert, i);
			if(i==6) {
				loopToNode = nodeToInsert;
				//comment the above line and uncomment the below line to see the working scenario
				//loopToNode = headNode;
			}
		}
		sll.PrintList(headNode);
		ListNode lastNode = headNode;
		while(lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		lastNode.setNext(loopToNode);
		return headNode;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode headNode = getLinkedListWithLoop(sll);
		ListNode tempNode = headNode;
		//we compare each node with all the other nodes
		//if we find any two nodes having the same values, then loop exists
		//this method will only work when the loop is at the first node
		while(tempNode.getNext() != null) {
			
			ListNode tempNode2 = tempNode.getNext();
			while(tempNode2.getNext() != null) {
				if(tempNode2 == tempNode) {
					System.out.println("Loop exists at node with data: " + tempNode.getData());
					return;
				}else {
					System.out.println(tempNode.getData() + "!=" + tempNode2.getData());
					tempNode2 = tempNode2.getNext();
				}
			}
			tempNode = tempNode.getNext();
		}
	}
}
