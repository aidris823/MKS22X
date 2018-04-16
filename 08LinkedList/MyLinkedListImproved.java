import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    
    private Node start, end;
    private int size;
    
    //c+p'ed superarray (mostly)
    private class LLIterator implements Iterator<T>{
	//Where next is: (Bad naming)
	Node current;
	
	public LLIterator(Node start){
	    current = start;
	}

	public boolean hasNext(){
	    return current != null;
	}

	public T next(){
	    if (hasNext()){
		current = current.getNext();
	    }
	    else{
		throw new UnsupportedOperationException();
	    }
	    //AKA current
	    return current.getPrev();
	}	
    }
    public int max(){
	if (size == 0){
	    return -1;
	}
	Node current = start;
	Node max = current;
	while (current != null){
	    //CompareTo bc. Integer class
	    int val = current.getValue();
	    if (val.compareTo(max.getValue()) >= 0){
		max = current;
	    }
	    current = current.getNext();
	}
	return this.indexOf(max.getValue());
    }
       
    public int min(){
	if (size == 0){
	    return -1;
	}
	Node current = start;
	Node min = current;
	while (current != null){
	    //CompareTo bc. Integer class
	    int val = current.getValue();
	    if (val.compareTo(max.getValue()) <= 0){
		min = current;
	    }
	    current = current.getNext();
	}
	return this.indexOf(min.getValue());
    }

    public void extend(MyLinkedListImproved<T> other){
	end.setNext(other.start);
	other.start.setPrev(end);
	end = other.end;
	size = size + other.size();
	other.clear();
    }
		
    
    private Node getNode(int index){
	int counter = 0;
	Node currentNode = start;
	while (currentNode != null){
	    if (counter == index){
		return currentNode;
	    }
	    counter++;
	    currentNode = currentNode.getNext();
	}
	return null;
    }

    public MyLinkedListImproved(){
	clear();
    }

    public String toString(){
	String ans = new String("[");
	int counter = 0;
	Node currentNode = start;
	while (counter < size && currentNode != null){
	    ans += currentNode.getValue();
	    if (currentNode.hasNext()){
		ans += ", ";
	    }
	    else{
		ans += "]";
	    }
	    currentNode = currentNode.getNext();
	    counter++;
	}
	return ans;	
    }

    public void clear(){
	start = null;
	end = null;
	size = 0;
    }

    public int size(){
	return size;
    }

    public T get(int index){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("Too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("Too big!");
	}
        Node x = getNode(index);
	return x.getValue();
    }

    public T set(int index, T value){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("Too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("Too big!");
	}
	T oldVal = new T(getNode(index).getValue());
	Node currentNode = start;
	for (int i = 0; i < index; i++){
	    currentNode = currentNode.getNext();
	}
	currentNode.setValue(value);
	return oldVal;
    }

    public int indexOf(T value){
	int counter = 0;
	Node currentNode = start;
	while (!currentNode.getValue().equals(value)){
	    currentNode = currentNode.getNext();
	    counter++;
	}
	//Not there
	if (size - 1 == counter){
	    return -1;
	}
	//Is there
	return counter;
    }

    //Adds to end pretty sure, from documentation
    public boolean add(T newData){
	Node x = new Node(newData);
	if (size == 0){
	    start = x;
	    end = x;
	}
	else{
	    end.setNext(x);
	    x.setPrev(end);
	    end = x;
	}
	size++;
	return true;
    }

    public void add(int index, T value){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("Too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("Too big!");
	}
	Node newData = new Node(value);
	//Add to beginning
	if (index == 0){
	    start.setPrev(newData);
	    newData.setNext(start);
	    start = newData;
	}
	//Add to end
	if (index == size()-1){
	    end.setNext(newData);
	    newData.setPrev(end);
	    end = newData;
	}
	//Neither:
	else{
	    Node prev = getNode(index - 1);
	    Node next = getNode(index + 1);
	    newData.setPrev(prev);
	    newData.setNext(next);
	    prev.setNext(newData); //(Maybe?)
	    //Not maybe, definite yes
	}
    }

    //Goes through entire data structure
    public boolean remove(T value){

	if (indexOf(value) == -1){
	    return false;
	}
	remove(indexOf(value));
	return true;
	
    }

    public Integer remove(int index){
	//SHould always be able to remove if the exceptions don't catch it, , so always returns true I think.
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
	}
	//	Integer oldValue = new Integer(getNode(index).getValue());
	Node currentNode = getNode(index);
	
	/*We forget about the element at this index faster than...
	  someone giving the silent treatment? */
	if (index == 0){
	    T oldValue = new T(start.getValue());
	    start = start.getNext();
	    start.setPrev(null);
	    return oldValue;
	}
	if (index == size - 1){
	    T oldValue = new T(end.getValue());
	    end = end.getPrev();
	    end.setNext(null);
	    
	}
	else{
	    //CurrentNode: "Doooon't forget me, I beeeeeeeeg"
	    currentNode.getPrev().setNext(currentNode.getNext());
	    currentNode.getNext().setPrev(currentNode.getPrev());
	}
	size--;
	return currentNode.getValue();
    }
	

    //Node class:

    private class Node{
	private Integer value;
	private Node prev, next;
	
	public Node(){
	    prev = null;
	    next = null;
	}
	
	public Node(Integer val){
	    value = val;
	    prev = null;
	    next = null;
	}
	
	public Node getPrev(){
	    return prev;
	}
	public Node getNext(){
	    return next;
	}
	public Integer getValue(){
	    return value;
	}
	public void setPrev(Node prev){
	    this.prev = prev;
	}
	public void setNext(Node next){
	    this.next = next;
	}
	public void setValue(Integer value){
	    this.value = value;
	}
	public String toString(){
	    String ans = new String("" + getValue());
	    return ans;
	}
	
	//Helper function that is very necessary but I don't think was mentioned
	public boolean hasNext(){
	    return (getNext() != null);
	}	

    }
}
