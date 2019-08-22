package org.tripathi.karumanchi.heaps;

public class Heap {

	int array[];
	int count;
	int capacity;
	
	
	public Heap(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		this.array = new int[ capacity ];
		
	}
	
	public int Parent(int i) {
		//returns the index at which the parent of current node is located at in the array
		if( i<=0 || i > this.capacity ) {
			return -1;
		}
		return (i-1)/2; //this.array[ (i-1)/2 ];
	}
	
	public int leftChild(int position) {
		//returns the index at which left child is located in the array
		int left = position*2 + 1;
		if( left > this.count ) {
			return -1;
		}
		return left; //this.array[left];
	}
	
	public int rightChild(int position) {
		//return the index at which right child is located in the array
		int right = position*2 + 2;
		if( right > this.count ) {
			return -1;
		}
		return right; //this.array[right];
	}
	
	public int peek() {
		//return the MAX element. [ min element for a min-heap ]
		if( this.count == 0 ) {
			return Integer.MIN_VALUE;
		}
		return this.array[0];
	}
	
	public void PercolateDown(int position) {
		//heapify from the given position to leaf
		//In max-heap we find the maximum of current node and it's children and swap them all the way down to leaf nodes
		int left, right, max=position, temp;
		left = this.leftChild(position);
		if( left != -1  && this.array[left] > this.array[max] ) {
			max = left;
		}
		
		right = this.rightChild(position);
		if( right != -1 && this.array[right] > this.array[max] ) {
			max = right;
		}
		
		if( max != position ) {
			//means that we have found an element greater than current node
			temp = this.array[position];
			this.array[position] = this.array[max];
			this.array[max] = temp;
			PercolateDown( max );
		}
	}
	
	public int poll() {
		//remove and return the MAX element [ or MIN element ]
		if( this.count == 0 ) {
			return Integer.MIN_VALUE;
		}
		int result = this.array[0];
		this.array[0] = this.array[count-1];
		this.count--;
		PercolateDown(0);
		return result;
	}
	
	public void insert(int data) {
		//insert the element as the last leaf
		//compare with parent to find and fix heap property of subtree being less than the current node
		if( this.count == this.capacity ) {
			resizeHeap();
		}
		int i = this.count;
		while( i>=0 && data > this.array[this.Parent(i)] ) {
			this.array[i] = this.array[this.Parent(i)];
			i = this.Parent(i);
			
		}
		this.array[i] = data;
	}
	
	private void resizeHeap() {
		//double up the heap array
		int[] oldArrayCopy = new int[ this.capacity ];
		System.arraycopy( this.array, 0, oldArrayCopy, 0, this.capacity-1 );
		this.array = new int[ this.capacity*2 ];
		System.arraycopy( oldArrayCopy, 0, this.array, 0, this.capacity-1 );
		this.capacity *= 2;
	}
	
	public void buildHeap(Heap heap, int[] A) {
		/* The leaf nodes of a heap satisfy the magic property of heap and do not need to fixed.
		 * The leaf elements are at the end.
		 * So, to heapify a the array, we need to heapify all non-leaf nodes.
		 * i.e. call PercolateDown() on all non-leaf nodes
		 * the first non-leaf node is the Parent() of the last element in the Heap
		 */
		if( heap == null ) {
			return ;
		}
		while( A.length > heap.capacity ) {
			heap.resizeHeap();
		}
		for(int i=0; i<A.length; i++) {
			heap.array[i] = A[i];
			heap.count++;
		}
		
		for( int i= heap.Parent(heap.count-1); i>0; i-- ) {
			heap.PercolateDown(i);
		}
	}
}
