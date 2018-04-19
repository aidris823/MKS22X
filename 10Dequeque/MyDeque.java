import java.util.*;
public class MyDeque<E>{
    private ArrayList<E> data;
    private int size;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = new ArrayList<>[10];
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = new ArrayList<>[10];
    }
    public int size(){
	return size;
    }
    public void addFirst(E data){
	
