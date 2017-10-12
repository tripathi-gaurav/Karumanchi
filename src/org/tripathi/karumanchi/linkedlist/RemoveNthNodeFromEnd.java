package org.tripathi.karumanchi.linkedlist;

//remove nth node from the end of list
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromEnd {
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		ListNode nodeToInsert = new ListNode(1);
		ListNode headNode = null;
		headNode = sll.InsertInLinkedList(headNode, nodeToInsert, 1);
		RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
		sll.PrintList(headNode);
		headNode = r.removeNthFromEnd(headNode, 1);
		sll.PrintList(headNode);
		
		headNode = Problem3.PopulateList(sll);
		sll.PrintList(headNode);
		headNode = r.removeNthFromEnd(headNode,2);
		sll.PrintList(headNode);
	}
	
	public ListNode removeNthFromEnd(ListNode headNode, int n) {
        ListNode pN1Node = headNode, pNthNode = headNode, pTemp = headNode;
        pTemp = headNode;
        Integer count = 1;
        /*for(int i=1; pTemp.getNext() != null; i++) {
        	pTemp = pTemp.getNext();
        	if(i >= n) {
        		pN1Node = pNthNode;
        		pNthNode = pNthNode.getNext();
        		
        	}
        }*/
        
        while(pTemp.getNext() != null){
            pTemp = pTemp.getNext();
            count++;
            if(count > n){
                pN1Node = pNthNode;
                if(pNthNode.getNext() != null)
                pNthNode = pNthNode.getNext();
            }
        }
        System.out.println(count + " " + n);
        if(n == count) {
        	return headNode.getNext();
        }
        pN1Node.setNext(pNthNode.getNext());
        pNthNode = null;
        return headNode;
    }

}
