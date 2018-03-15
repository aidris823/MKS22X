import java.util.Arrays;
public class Quick{
    public static int partition(int[] data, int start, int end){
	/*Used code from here: https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values 
after I couldn't think of way to generate number between start and end without 
lousy conversion thing. */	
	int pivot = (int) Math.random() * (end-start) + start;
	// System.out.println("Pivot: " + pivot);
	int i = start + 1;
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
    public static void main(String[] arguments){

	int[] mbwe = {999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(Arrays.toString(mbwe));
	System.out.println(Quick.partition(mbwe, 0, 10));
	System.out.println(Arrays.toString(mbwe));
    }
	    
}	
		
		
