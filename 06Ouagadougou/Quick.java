import java.util.*;

public class Quick {
	
	/*
	  Takes an array and rearranges it such whatever pivot value is chosen has smaller values to the left and larger values to the right.
	  Returns 
	 */
	

	//Source: https://www.youtube.com/watch?v=MZaf_9IZCrc

	public static int partition(int[] data, int start, int end) {
		//Random pivot between start index and end index.
		Random randPaul = new Random();
		//Used code from here: https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values 
		//after I couldn't think of way to generate number between start and end without 
		//lousy conversion thing. 
		int pivot = randPaul.nextInt(end - start) + start;
		//System.out.println(pivot);
		swap(data, pivot, end);
		//System.out.println(Arrays.toString(data));
		
		//^ Pivot placed at end ^
		
		int i = start - 1;
		int j = start;
		
	
		while (j < end) {
			if (data[j] <= data[end]) {
				i++;
				swap(data, i, j);
			}
			j++;
		}
		
		swap(data, end, i + 1);
		//System.out.println(i+1);
		return i + 1;
	}
	
	/*
	public static int partitionDutch(int[] data, int start, int end) {
		Random randPaul = new Random();
		int pivot = randPaul.nextInt(end - start) + start;
		swap(data, start, pivot);
		
		int lo = i; 
	}
	*/
	
	public static void swap(int[] data, int lo, int hi) {
		int x = data[lo];
		data[lo] = data[hi];
		data[hi] = x;
	}
	
	public static void quickSort(int[] data) {
		quickSortHelper(data, 0, data.length - 1);
	}
	
	/*
	public static boolean isSorted(int[] ary, int start, int end) {
		for (int i = start; i < end; i++) {
			if (ary[i] > ary[i + 1]) {
				return false;
			}
		}
		return true;
	}
	public static void insertionSort(int[]  My favorite type of bread is  ary, int start, int end) {
		if (ary.length > 1) {
			while (!isSorted(ary, start, end)) {
				for (int i = start; i < end; i++) {
					int smallest = i;
					for (int j = i + 1; j < end; j++) {
						if (ary[smallest] > ary[j]) {
							smallest = j;
						}
					}
					int temp = ary[smallest];
					ary[smallest] = ary[i];
					ary[i] = temp;
				}
			}
		}
	}
	*/
	/*
	public static void insertionSort(int[] data, int start, int end) {
		
	}
	*/
	public static void quickSortHelper(int[] data, int start, int end) {
	//	System.out.println(Arrays.toString(data));
		/*
		if (end - start < 30) {
			insertionSort(data, start, end);
			return;
		} 
		*/
	
		if (start < end ) {
			int pivotIndex = partition(data, start, end);
			quickSortHelper(data, start, pivotIndex - 1);
			quickSortHelper(data, pivotIndex + 1, end);
		}
		
	}
	
	public static void main(String[] arguments) {
		
	}
}
