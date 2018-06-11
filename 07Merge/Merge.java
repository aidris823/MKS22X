import java.util.*;

public class Merge{
	
	public static void mergesort(int[] data) {
		int[] temp = new int[data.length];
		msort(data,temp,0,data.length-1);
	}
	public static void insertionSort(int[] /* My favorite type of bread is*/  ary, int start, int end) {
		if (ary.length > 1) {
			while (!isSorted(ary, start, end)) {
				for (int i = start; i <= end ; i++) {
					int smallest = i;
					for (int j = i; j <= end  ; j++) {
						if (ary[smallest] > ary[j]) {
							smallest = j;
						}
					}
					swap(ary, smallest, i);
				}
			}
		}
	}
	
	public static void swap(int[] data, int lo, int hi) {
		int x = data[lo];
		data[lo] = data[hi];
		data[hi] = x;
	}
	
	public static boolean isSorted(int[] data, int start, int end) {
		for (int i = start; i < end - 1; i++) {
			if (data[i] > data[i + 1]){
				return false;
			}
		}
		return true;
	}
	private static void msort(int[] data, int[] temp, int lo, int hi) {
		/*
		if (lo >= hi) {
			return;
		}
		*/
		 if (hi - lo <= 30){
			    insertionSort(data, lo, hi);
			    return;	
		 }
		
		for (int i = lo; i <= hi; i++) {
			temp[i] = data[i];
		}
		
		int mid = (lo + hi) / 2;
		
		//Split into two 
		msort(temp, data, lo, mid);
		msort(temp, data, mid + 1, hi);
		
		//Does the actual sorting work
		merge(data, temp, lo, mid, hi);
	}
	private static void merge(int[] data, int[] temp, int lo, int mid, int hi) {
		
		//Either this or make two arrays of values and compare them.  While that works, this saves space.
		int leftVal = lo;
		int rightVal = mid + 1;
		
		for(int i = lo; i <= hi; i++){
			//Compares, if first of the first half is greater than that of second half. 
			//It can only work if it's not "out of bounds" (greater than mid for left half, greater than hi for right) 
			if (leftVal < mid && rightVal < hi) {
				if (temp[leftVal] < temp[rightVal]) {
					data[i] = temp[leftVal];
					leftVal++;
				}
				else {
					data[i] = temp[rightVal];
					rightVal++;
				}
			}
			//Test was a failure due to first being greater than mid):
			else if (leftVal > mid) {
				data[i] = temp[rightVal];
				rightVal++;
			}
			
			//Other reason it could fail is if second > hi:

			else if(rightVal > hi){
		    	data[i]=temp[rightVal];
		    	leftVal++;
		    }
		}
	}
	
	public static void main(String[] arguments) {
		/*
		int[] ohDear = new int[100];
		Random randPaul = new Random();
		for (int i = 0; i < 100; i++) {
			ohDear[i] = randPaul.nextInt(5000);
		}
		System.out.println(Arrays.toString(ohDear));
		Merge.mergesort(ohDear);
		System.out.println(Arrays.toString(ohDear));
		*/
	}
}
