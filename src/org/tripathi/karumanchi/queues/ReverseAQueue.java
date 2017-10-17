package org.tripathi.karumanchi.queues;

import java.util.Stack;

//reverse a queue by using only the default ADT operations 

public class ReverseAQueue {

	public static void main(String[] args) {
		LLQueue queue = new LLQueue();
		queue.populateQueue(queue);
		System.out.println(queue);
		
		ReverseAQueue solution = new ReverseAQueue();
		solution.reverseQueue(queue);
		System.out.println(queue);
	}
	
	public void reverseQueue(LLQueue queue) {
		Stack<Integer> stack = new Stack<>();
		
		while(!queue.isEmpty()) {
			stack.push( (Integer) queue.deQueue());
		}
		
		while(!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}
	}
}
