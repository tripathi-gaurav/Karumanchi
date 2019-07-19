package org.tripathi.karumanchi.sorting;

public class MergeSort {
	// TODO: implement in-place merging
	public static void main(String[] args) {
		
	}
	
	public void mergeSort(int[] array) {
		mergeSort(array, new int[array.length], 0, array.length-1);
	}
	
	public void mergeSort(int[] array, int[] aux, int leftStart, int rightEnd) {
		if( leftStart > rightEnd ) {
			return;
		}
		
		int middle = (rightEnd - leftStart) / 2 + leftStart ;
		mergeSort(array, aux, leftStart, middle);
		mergeSort(array, aux, middle+1, rightEnd);
		mergeHalves(array, aux, leftStart, rightEnd);
	}
	
	public void mergeHalves(int[] array, int[] aux, int leftStart, int rightEnd) {
		
		int left = leftStart;
		int leftEnd = (rightEnd - leftStart) / 2 + leftStart;
		int rightStart = leftEnd + 1;
		
		int right = rightStart;
		int auxInd = left;
		
		while( left<= leftEnd && right <= rightEnd ) {
			if( array[left] <= array[right] ) {
				aux[auxInd++] = array[left++];
			}else {
				aux[auxInd++] = array[right++];
			}
		}
		
		System.arraycopy(array, left, aux, auxInd, leftEnd - left + 1);
		System.arraycopy(array, right, aux, auxInd, rightEnd - right + 1);
		System.arraycopy(aux, leftStart, array, leftStart, rightEnd-leftStart+1);
	}
}
