package org.tripathi.karumanchi.queues;

public class StackUsingTwoQueues {

	LLQueue queue1;
	LLQueue queue2;
	
	public StackUsingTwoQueues() {
		queue1 = new LLQueue();
		queue2 = new LLQueue();
	}
	
	//Push operations:
	//check whether queue1 is empty or not. if empty, enqueue into queue2
	//otherwise enqueue the element into queue1
	//goal is to always have one queue empty
	public void push(Integer data) {
		if(queue1.isEmpty()) {
			queue2.enQueue(data);
		}else {
			queue1.enQueue(data);
		}
	}
	
	//Pop operations: 
	//Queue is FIFO whereas Stack is LIFO.
	//last element is always at the rear pointer of Queue.
	//Transfer n-1 elements into the other vacant queue and then delete this last element
	public Integer pop() {
		Integer data = null;
		while(!queue1.isEmpty()) {
			queue2.enQueue(queue1.deQueue());
			if(queue1.getQueueSize(queue1) == 1) {
				data = (Integer) queue1.deQueue();
				break;
			}
		}
		
		while(!queue2.isEmpty()) {
			queue1.enQueue(queue2.deQueue());
			if(queue2.getQueueSize(queue2) == 1) {
				data = (Integer) queue2.deQueue();
				break;
			}
		}
		return data;
	}
	
}
