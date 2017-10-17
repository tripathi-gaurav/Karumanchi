package org.tripathi.karumanchi.queues;

import org.tripathi.karumanchi.linkedlist.ListNode;

public class LLQueue {
	private ListNode frontNode;
	private ListNode rearNode;
	
	public LLQueue() {
		this.frontNode = null;
		this.rearNode = null;
	}
	
	public Boolean isEmpty() {
		return (frontNode == null);
	}
	
	public void enQueue(Object data) {
		ListNode newNode = new ListNode(data);
		if(rearNode != null) {
			rearNode.setNext(newNode);
		}
		this.rearNode = newNode;
		if(frontNode == null) {
			frontNode = rearNode;
		}
	}
	
	public Object deQueue() {
		Object data;
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}else {
			data = frontNode.getData();
			frontNode = frontNode.getNext();
		}
		return data;
	}
	
	@Override
	public String toString() {
		ListNode current = this.frontNode;
		StringBuffer sb = new StringBuffer();
		while(current != null) {
			sb.append(current.getData() + " -> ");
			current = current.getNext();
		}sb.append(" X");
		return sb.toString();
	}
	
	public void populateQueue(LLQueue queue) {
		for(int i=1;i<=10;i++) {
			queue.enQueue(i);
		}
	}
	
	public Integer getQueueSize(LLQueue queue) {
		Integer length = 0;
		ListNode current = queue.frontNode;
		while(current!= null) {
			length++;
			current = current.getNext();
		}
		return length;
	}
	
}
