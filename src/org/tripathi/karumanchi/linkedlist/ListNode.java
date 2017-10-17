package org.tripathi.karumanchi.linkedlist;

/*
 * This is a ListNode POJO
 * 
 */
public class ListNode {
	private Object data;
	private ListNode next;
	
	public ListNode() {}
	
	public ListNode(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	
	

}
