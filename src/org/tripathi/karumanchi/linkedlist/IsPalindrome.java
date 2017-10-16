package org.tripathi.karumanchi.linkedlist;

//Problem 37 in book
//https://leetcode.com/problems/palindrome-linked-list/description/

public class IsPalindrome {
	
	public boolean isPalindrome(ListNode head) {
        ListNode fastPtr = head, slowPtr = head;
        Boolean isPalindrome = true;
        if(head == null)
            return isPalindrome;
        
        while(fastPtr != null && fastPtr.getNext()!= null){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        
        
        ListNode temp = null ,next = null,tempHead = slowPtr;
        
        while(tempHead != null){
            next = tempHead.getNext();
            tempHead.setNext(temp);
            temp = tempHead;
            tempHead = next;
        }
        slowPtr = temp;
        
        fastPtr = head;
        while(slowPtr != null){
            if(fastPtr.getData() != slowPtr.getData()){
                //System.out.println(fastPtr.val + " " + slowPtr.val);
                isPalindrome = false;
            }
            fastPtr = fastPtr.getNext();
            slowPtr = slowPtr.getNext();
        }
        
        return isPalindrome;
    }

}
