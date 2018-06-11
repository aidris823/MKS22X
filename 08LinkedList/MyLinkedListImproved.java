import java.util.*;


//Actual Linked List:
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
	
	public Iterator<T> iterator(){
		return new LLIterator(start);
	}
	//c + p'ed superarray mostly
	public class LLIterator implements Iterator<T>{
		Node current;
		public LLIterator(Node start) {
			current = start;
		}
		public boolean hasNext() {
			return current != null;
		}
		public T next() {
			if (hasNext()) {
				current = current.getNext();
			}
			else {
				throw new UnsupportedOperationException();
			}
			return current.getPrev().getValue();
		}
	}
	private class Node{
		private T value;
		private Node prev, next;
		
		//Constructors
		public Node() {
			prev = null;
			next = null;
		}
		public Node(T val) {
			value = val;
			prev = null;
			next = null;
		}
		
		//Getters/Setters
		public Node getPrev() {
			return prev;
		}
		public Node getNext() {
			return next;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public T getValue() {
			return value;
		}
		
		public String toString() {
			String ans = "" + getValue();
			return ans;
		}
		
		public boolean hasNext() {
			return (getNext() != null);
		}
		public boolean hasPrev() {
			return (getPrev() != null);
		}
		
	}
	private Node start, end;
	private int size;
	
	public MyLinkedListImproved() {
		clear();
	}
	
	public void clear() {
		start = null;
		end = null;
		size = 0;
	}
	
	public String toString() {
		Node currentNode = start;
		String ans = "[";
		while (currentNode != null) {
			ans += currentNode.toString() + " ";
			currentNode = currentNode.getNext();
		}
		ans += "]";
		return ans;
	}
	
	private Node getNode(int index) {
		int counter = 0;
		Node currentNode = start;
		while (currentNode != null) {
			if (counter == index) {
				return currentNode;
			}
			counter++;
			currentNode = currentNode.getNext();
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Too small.");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("Too big.");
		}
		Node x = getNode(index);
		return x.getValue();
	}
	
	public T set(int index, T value) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Too small.");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("Too big.");
		}
		getNode(index).setValue(value);
		return value;
	}
	
	public int indexOf(T value) {
		Node currentNode = start;
		int counter = 0;
		
		while (currentNode != null) {
			if (currentNode.getValue().equals(value)) {
				return counter;
			}
			counter++;
			currentNode = currentNode.getNext();
		}
		return -1;
	}
	
	//Adds to end of LinkedList
	public boolean add(T newData) {
		Node x = new Node(newData);
		if (size == 0) {
			start = x;
			end = x;
		}
		else {
			end.setNext(x);
			x.setPrev(end);
			end = x;
		}
		size++;
		return true;
	}
	//Adds at specific area
	public boolean add(int index, T value) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Too small.");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("Too big.");
		}
		
		Node n = new Node(value);
		
		if (index == 0) {
			start.setPrev(n);
			n.setNext(start);
			start.setValue(value);
		}
		if (index == size - 1) {
			return add(value);
		}
		
		else {
			Node prev = getNode(index - 1);
			Node next = getNode(index );
			n.setPrev(prev);
			n.setNext(next);
			prev.setNext(n);
			next.setPrev(n);
		}
		size++;
		return true;
	}
	
	public boolean remove(T value) {
		if (indexOf(value) == -1) {
			return false;
		}
		remove(indexOf(value));
		return true;
	}
	//Mafia-esque "forgetting"
	public T remove(int index) {
		T oldValue;
		//Start and end:
		if (index == 0) {
			oldValue = start.getValue();
			start = start.getNext();
			start.setPrev(null);
			return oldValue;
		}
		if (index == size - 1) {
			oldValue = end.getValue();
			end = end.getPrev();
			end.setNext(null);
			return oldValue;
		}
		else {
			oldValue = get(index);
			Node currentNodePrev = getNode(index - 1);
			Node currentNodeNext = getNode(index + 1);
			currentNodePrev.setNext(currentNodeNext);
			currentNodeNext.setPrev(currentNodePrev);
		}
		size--;
		return oldValue;
	}
	public int max() {
		if (size == 1) {
			return 0;
		}
		T val = start.getValue();
		int max = 0;
		int index = 0;
		for (T iter : this) {
			if (iter.compareTo(val) > 0) {
				val = iter;
				max = index;
			}
			index++;
		}
		return index;
	}
	public void extend(MyLinkedListImproved<T> other) {
		if (size() == 0) {
			start = other.start;
			return;
		}
		if (other.size() == 0) {
			return;
		}
		end.setNext(other.start);
		other.start.setPrev(end);
		end = other.end;
		size += other.size();
		other.clear();
	}
}
