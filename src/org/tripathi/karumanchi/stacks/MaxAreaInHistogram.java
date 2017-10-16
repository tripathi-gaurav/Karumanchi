package org.tripathi.karumanchi.stacks;


//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

public class MaxAreaInHistogram {
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		MaxAreaInHistogram solution = new MaxAreaInHistogram();
		System.out.println( solution.MaxRechtangleArea(heights) );
	}

	public Integer MaxRechtangleArea(int[] A) {
		Stack<Integer> stack = new Stack<>();
		if(A==null || A.length==0) {
			return 0;
		}
		//2 1 5 6 2 3
		//0 1 2 3 4 5 
		Integer maxArea = 0;
		int i=0;
		for(i=0;i<A.length;) {
			
			if(stack.isEmpty() || A[stack.peek()] <= A[i]) {
				stack.push(i);
				i++;
			}else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			maxArea = Math.max(maxArea, A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		}
		
		
		return maxArea;
		
	}
	
}
