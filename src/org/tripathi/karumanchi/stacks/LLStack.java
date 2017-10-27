package org.tripathi.karumanchi.stacks;

import java.util.EmptyStackException;

import org.tripathi.karumanchi.linkedlist.ListNode;

public class LLStack {

	private ListNode headNode;
	
	public LLStack() {
		this.headNode = new ListNode();
	}
	
	public void push(Object data) {
		if(headNode == null) {
			headNode = new ListNode(data);
		}else if(headNode.getData() == null) {
			this.headNode.setData(data);
		}else {
			ListNode newNode = new ListNode(data);
			newNode.setNext(headNode);
			headNode = newNode;
		}
	}
	
	public Object top() {
		if(this.headNode == null) {
			return null;
		}else {
			return this.headNode.getData();
		}
	}
	
	public Object pop() {
		Object data = null;
		if(this.headNode == null) {
			throw new EmptyStackException();
		}else {
			data = this.headNode.getData();
			this.headNode = headNode.getNext();
		}
		return data;
	}
	
	public Boolean isEmpty() {
		if(this.headNode == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void deleteStack() {
		this.headNode = null;
	}
}
