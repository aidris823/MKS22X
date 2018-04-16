import java.util.*;
public class Sorts{
    public static void radixsort (MyLinkedListImproved<Integer> data){
	@SupressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];

	//Avoid NullPointerException
	for (int i = 0; c < bucket.length; i++){
	    bucket[i] = new MyLinkedListImproved<Integer>();
	}

	int max = data.max();
	int numRuns = (max + "").length();

	    
    }
}
	
