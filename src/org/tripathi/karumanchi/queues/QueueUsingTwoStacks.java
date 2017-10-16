package org.tripathi.karumanchi.queues;

import java.util.Stack;

import org.tripathi.karumanchi.stacks.LLStack;

public class QueueUsingTwoStacks {

	LLStack stack1;
	LLStack stack2;
	
	public QueueUsingTwoStacks() {
		stack1 = new LLStack();
		stack2 = new LLStack();
	}
	
	public boolean isEmpty() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.isEmpty();
	}
	
	public void enQueue(Integer data) {
		stack1.push(data);
	}
	
	public Integer deQueue() {
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}else {
			while(!stack1.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return stack2.pop();
		}
	}
}
