package org.tripathi.karumanchi.linkedlist;

import java.util.Stack;

//find intersection or merge point of two lists
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
//problem 19 through 23

public class Problem19 {

	public static void main(String[] args) {
		Problem19 solution = new Problem19();
		ListNode head1 = null, head2 = null;
		solution.getIntersectionNode(head1, head2);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackOfNodes = new Stack<>();
        if(headA == null || headB == null)
            return null;
        
        while(headA != null){
            stackOfNodes.add(headA);
            headA = headA.getNext();
        }
        while(headB != null){
            if(!stackOfNodes.contains(headB)){
                stackOfNodes.add(headB);
                headB = headB.getNext();
            }else{
                return headB;
            }
        }
        return null;
    }
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		//Time Complexity = O(max(m,n))
		//Space Complexity = O(1)
        if(headA == null || headB == null)
            return null;
       
        Integer sizeA = listLength(headA);
        Integer sizeB = listLength(headB);
        ListNode list1, list2;
        Integer diff;
        
        if(sizeA > sizeB){
            list1 = headA;
            list2 = headB;
            diff = sizeA-sizeB;
        }else{
            list1 = headB;
            list2 = headA;
            diff=sizeB-sizeA;
        }
        
        for(int i=0;i<diff;i++){
            list1 = list1.getNext();
        }
        
        while(list1 != null && list2 != null){
            if(list1 == list2){
                return list1;
            }else{
                list1 = list1.getNext();
                list2 = list2.getNext();
            }
        }
       
        return null;
    }
    
    public static Integer listLength(ListNode head){
        Integer length = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getNext();
            length++;
        }
        return length;
    }
}
