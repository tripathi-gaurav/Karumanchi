package org.tripathi.karumanchi.heaps;

import java.util.Collections;
import java.util.PriorityQueue;


/*
 * Problem-27 : Dynamic median finding. Design a heap data structure that supports finding the median.
 * AKA:Find Median from Data Stream ( https://leetcode.com/problems/find-median-from-data-stream/ )
 */

public class MedianHeap {
	PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;
    
    /** initialize your data structure here. */
    public MedianHeap() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>( Collections.reverseOrder() );
    }
    
    public void addNum(int num) {
        if( minPQ.isEmpty() ){
            minPQ.add( num );
        }else{
            if( num < minPQ.peek() ){
                maxPQ.add( num );
            }else{
                minPQ.add( num );
            }
        }
        rebalance();
    }
    
    private void rebalance(){
        if( Math.abs( minPQ.size() - maxPQ.size() ) < 2 ){
            return ;
        }
        
        PriorityQueue<Integer> biggerQ = maxPQ.size() > minPQ.size() ? maxPQ : minPQ;
        PriorityQueue<Integer> smallerQ = maxPQ.size() < minPQ.size() ? maxPQ : minPQ;
        
        smallerQ.add( biggerQ.poll() );
    }
    
    public double findMedian() {
        if( Math.abs( minPQ.size() - maxPQ.size() ) == 0 ){
            return (double) (minPQ.peek() + maxPQ.peek()) / 2D;
        }
        
        PriorityQueue<Integer> biggerQ = maxPQ.size() > minPQ.size() ? maxPQ : minPQ;
        PriorityQueue<Integer>  smallerQ = maxPQ.size() < minPQ.size() ? maxPQ : minPQ;
        
        return (double) biggerQ.peek();
    }
    
    public static void main(String[] args) {
    	MedianHeap solution = new MedianHeap();
		solution.addNum(1);
		solution.addNum(2);
		System.out.println( solution.findMedian() );
		solution.addNum(3);
		System.out.println( solution.findMedian() );
	}
}
