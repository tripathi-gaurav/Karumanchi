package org.tripathi.karumanchi.stacks;

public class ArrayWithTwoStacks {
	private Integer[] dataArray;
	private int size;
	private int topOne;
	private int topTwo;
	
	public ArrayWithTwoStacks(int size) {
		if(size<2) {
			throw new IllegalStateException("size < 2 is not permissible");
		}
		this.size = size;
		dataArray = new Integer[size];
		topOne = -1;
		topTwo = size;
	}
	
	public void push(int data, int stackId) {
		if(topTwo == topOne+1) {
			System.out.println("Stack overflow");
			return;
		}
		if(stackId == 1) {
			this.dataArray[++topOne] = data;
		}else {
			this.dataArray[--topTwo] = data;
		}
	}
	
	public Integer pop(int stackId) {
		Integer toPop = null;
		if(stackId == 1) {
			if(this.topOne == -1) {
				System.out.println("Stack underflow");
				toPop = this.dataArray[topOne];
				this.dataArray[topOne--] = null;
			}
		}else {
			if(this.topTwo == this.size) {
				System.out.println("Stack underflow");
				toPop = this.dataArray[topTwo];
				this.dataArray[topTwo++] = null;
			}
		}
		
		return toPop;
	}
	
	public Boolean isEmpty(Integer stackId) {
		Boolean isEmpty = false;
		if(stackId == 1 && this.topOne == -1) {
			isEmpty = true;
		}else if(stackId == 2 && this.topTwo == this.size) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	public Integer top(Integer stackId) {
		Integer top = null;
		if(!this.isEmpty(stackId)) {
			if(stackId == 1) {
				top = this.dataArray[topOne];
			}else if(stackId == 2) {
				top = this.dataArray[topTwo];
			}
		}
		
		return top;
	}
	//1 2 3 4 5 6 
	
	// 1, 2, 3, 4, 5, 
	//3,2,5,6,4,1 //1,5,4,6,2,3
	//SSS XX SS X S XXX
	//SX SSSS XX SX

}
