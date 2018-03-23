import java.util.*;
public class Quick{
    public static int partition(int[] data, int start, int end){
	/*Used code from here: https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values 
after I couldn't think of way to generate number between start and end without 
lousy conversion thing. */
	Random random = new Random();
	int pivot = random.nextInt(end - start) + start;
	// System.out.println("Pivot: " + pivot);
	int i = pivot + 1;
	int j = end;
	while (i <= j){
	    if (data[i] < data[start]){
		i++;
	    }
	    else{
		swap(data,i,j);
		j--;
	    }
	}
	swap(data,start,j);
	return j;				
    }	
    public static void swap(int[] data, int lo, int hi){
	int x = data[lo];
	data[lo] = data[hi];
	data[hi] = x;
    }

    public static void quickSort(int[] data){
	
    }
    /*Looked at what QuickSort is according to Wikipedia and Khan Academy.
1. Find pivot.
2. Partition.
3. Partition again until the base case is reached (length = 1 or 0)

    
    //Finds kth smallest element.
    */
    public static int quickSelect(int[] data, int k){
	return 3;
    }
    
    public static void main(String[] arguments){

	int[] mbwe = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(Arrays.toString(mbwe));
	System.out.println(Quick.partition(mbwe, 0, 10));
	System.out.println(Arrays.toString(mbwe));
    }
	    
}	
		
		
