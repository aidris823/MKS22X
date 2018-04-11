public class MyLinkedList{
    
    private Node start, end;
    private int size;

    
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

    public MyLinkedList(){
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

    public Integer get(int index){
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

    public Integer set(int index, Integer value){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("Too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("Too big!");
	}
	Integer oldVal = new Integer(getNode(index).getValue());
	Node currentNode = start;
	for (int i = 0; i < index; i++){
	    currentNode = currentNode.getNext();
	}
	currentNode.setValue(value);
	return oldVal;
    }

    public int indexOf(Integer value){
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
    public boolean add(Integer newData){
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

    public void add(int index, Integer value){
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
    public boolean remove(Integer value){

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
	    Integer oldValue = new Integer(start.getValue());
	    start = start.getNext();
	    start.setPrev(null);
	    return oldValue;
	}
	if (index == size - 1){
	    Integer oldValue = new Integer(end.getValue());
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
    /*
    //Not my work, but rather Crystal Wang's.
    public static void main(String[] arguments){
	MyLinkedList a = new MyLinkedList();
     
	System.out.println("Testing add(Integer value)");
	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	    System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
	} //adds the integers from 0 to 9 inclusive and prints out the LinkedList

	System.out.println("\nTesting get(int index)");
	for (int i = 0; i < 10; i++){
	    System.out.println("index: " + i + " data: " + a.get(i));
	} //prints the integers from 0 to 9 inclusive

	System.out.println("\nTesting exception for get(int index)");
	try{
	    System.out.println(a.get(10));
	    System.out.println(a.size());
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.get(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	for (int i = 0; i < 10; i++){
	    a.add(new Integer(i));
	}

	System.out.println("\nTesting indexOf(Integer value)");
	for (int i = 0; i < 10; i++){
	    System.out.println("Value: " + i + " Index: " + a.indexOf(i));
	} //prints 0 to 9 inclusive

	System.out.println("\nTesting remove(Integer value)");
	for(int i = 0; i < 10; i++){
	    a.remove(new Integer(i));
	    System.out.println(a);
	} //removes first half of the LinkedList

	System.out.println("\nTesting set(int index, Integer value)");
	for (int i = 0; i < 10; i++){
	    a.set(i, new Integer(i * 10));
	    System.out.println(a);
	} //sets the data of each node to 10 * index

	System.out.println("\nTesting exceptions for set(int index, Integer value)");
	try{
	    System.out.println(a.set(-1, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.set(10, new Integer(1)));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesing add(int index, Integer value)");
	for (int i = 0; i < 9; i++){
	    a.add(i, new Integer(i * 3));
	    System.out.println("index added: " + i + " LinkedList: " + a.toString());
	} //adds multiples of 3 up to 24 to the LinkedList at the beginning
	a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
	System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for add(int index, Integer value)");
	try{
	    a.add(-1, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    a.add(21, new Integer(5));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting remove(int index)");
	System.out.println("Original LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
	System.out.println("LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
	System.out.println("LinkedList: " + a.toString());
	System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
	System.out.println("LinkedList: " + a.toString());

	System.out.println("\nTesting exceptions for remove(int index)");
	try{
	    System.out.println(a.remove(-1));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"
	try{
	    System.out.println(a.remove(17));
	}catch(IndexOutOfBoundsException e){
	    System.out.println("This size is out of bounds");
	} //prints "This size is out of bounds"

	System.out.println("\nTesting clear()");
	a.clear();
	System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
    }
    */
}
