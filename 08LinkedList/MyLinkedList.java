public class MyLinkedList{
    
    private Node start, end;
    private int size;
    
    private Node getNode(int index){
	int counter = 0;
	Node currentNode = start;
	//No exceptions because it is a private class.
	
	while (currentNode != null){
	    if (counter == index){
		return currentNode;
	    }
	    counter++;
	    currentNode = currentNode.getNext();
	}
	//So that it compiles
	return null;
    }

    public MyLinkedList(){
	clear();
    }

    public String toString(){
	String ans = new String("[");
	int counter = 0;
	Node currentNode = start;
	while (counter < size && current != null){
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
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
	}
        Node x = getNode(index);
	return x.getValue();
    }

    public Integer set(int index, Integer value){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
	}
	Integer capablanca = getNode(index).getValue();
	getNode(index).setValue(data);
	return capablanca;
    }

    public int indexOf(Integer value){
	int counter = 0;
	Node currentNode = start;
	while (!data.getValue().equals(value)){
	    data = data.getNext();
	    counter++;
	}
	if (size == counter){
	    return -1;
	}
	return counter;
    }

    //Adds to end 
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
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
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
	    //prev.setNext(newData) (Maybe?)
    }

    public boolean remove(Integer value){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
	}
	

    }

    public Integer remove(int index){
	//EXCEPTIONS!
	if (index < 0){
	    throw new IndexOutOfBoundsException("too small.");
	}
	if (index >= size){
	    throw new IndexOutOfBoundsException("TOO BIG!");
	}
	
	
    }

    //Node class:

    private class Node{
	private Integer data;
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
	public Node getnext(){
	    return next;
	}
	public Integer getData(){
	    return data;
	}
	public void setPrev(Node prev){
	    this.prev = prev;
	}
	public void setNext(Node next){
	    this.next = next;
	}
	public void setValue(Node value){
	    this.value = value;
	}
	//Helper function
	public boolean hasNext(){
	    return (getNext() != null);
	}
	public String toString(){
	    String ans = new String("" + value);
	}
	    
    }

}
