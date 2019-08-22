package org.tripathi.karumanchi.heaps;

public class HeapSort {

	public void heapSort(int[] array) {
	
		//swap the first and last element in the heap, reduce the count of the heap and percolate down?
		//book says this will achieve heap sort in-place.
		
		if( array == null ) {
			return ;
		}
		int n = array.length;
		Heap h = new Heap(n);
		h.buildHeap(h, array);
		int oldCount = h.count;
		for( int i=n-1; i>0; i-- ) {
			int temp = h.array[0];
			h.array[0] = h.array[h.count-1];
			h.array[h.count-1] = temp;
			h.count--;
			h.PercolateDown(i);
		}
		h.count = oldCount;
		array = h.array;
	}
	
	public void heapSort1(int[] array) {
		if(array == null ) {
			return ;
		}
		int n = array.length;
		Heap h = new Heap(n);
		h.buildHeap(h, array);
		int i=0;
		while( h.count > 0 ) {
			array[i] = h.poll();
		}
	}
}
