//Je suis un pomme de terre.
public class MyLinkedList implements List{
    private Node start, end;
    private int size;

    public MyLinkedList(){
	size = 0;
	
    }

    public boolean add(int val){
	
	size += 1;
    }
    public boolean remove(int val){
	size -= 1;
    }
    private Node getNode(int i){
    }
    public void add(int i, int val){
    }
    
    
    
}

private class Node{
    private int data;
    private Node next, prev;

    Node(int data, Node next, Node prev){
	this.data = data;
	this.next = next;
	this.prev = prev;
    }
	
    void setData(int x){
    }
    int getData(){
    }
    void setPrev(int x){
    }
    int getPrev(){
    }
    void setNext(int x){
    }
    int getNext(){
    }
}
