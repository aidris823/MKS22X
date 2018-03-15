public class Quick{
    public static int partition(int[] data, int start, int end){
	int pivot = (int) end - ( Math.random() * start);
	i = start - 1;
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
	swap(data,i,j);
	return j;
		
		
	}
	
    }
    public static void swap(int[] data, int lo, int hi){
    }
    
	    
}	
		
		
