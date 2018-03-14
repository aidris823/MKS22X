public class Quick{
    public int partition(int[] data, int start, int end){
	int pivot = Math.random()*((start+end) / 2) / 10 * 10;
	int x = start + 1;
	int[] data = new int[end-start];
	data[0] = pivot;
	
	for (int i = start; i < end; i++){
	    if (data[i] < pivot){
		x++;
	        data[x] = pivot;
		data[x-1] = data[i];
	    }
	    if (data[i] > pivot){
		x--;
		data[x] = pivot;
		data[x+1] = data[i];
	    }
	}
	return x;
    }
}	
		
		
