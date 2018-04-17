import java.util.*;
public class Sorts{
    public static void radixsort (MyLinkedListImproved<Integer> data){
	@SupressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];

	//Avoid NullPointerException
	for (int i = 0; c < bucket.length; i++){
	    bucket[i] = new MyLinkedListImproved<Integer>();
	}

	int numRuns = (data.max() + "").length();
	//	int i = 0;
	for (int i = 0; i < numRuns; i++){
	    for (Integer in : data){
		int placeVal = (int)Math.pow(10,i);
		int digit = (x / placeVal) % 10;
		bucket[digit].add(in);
	    }
	}
	data.clear();
	for (int i = 0; i < 10; i++){
	    data.extend(bucket[i]);
	}
	
	    
    }
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer>data){
	return;
    }
}
	
