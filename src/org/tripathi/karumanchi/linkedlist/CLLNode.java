package org.tripathi.karumanchi.linkedlist;

/*
 * Adding this class only for readability purpose
 * it is nothing but the ListNode class
 */
public class CLLNode
{
	private int data;
	private CLLNode next;
	
	public CLLNode() { super(); }
	
	public CLLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}

}
