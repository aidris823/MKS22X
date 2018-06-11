
public class MyHeap<T extends Comparable<T>> {
	
	private T[] data;
	private int size; //True size, just like SuperArray
	private boolean isMax;
	
	
	//Default to max
	@SuppressWarnings("unchecked")
	public MyHeap() {
		isMax = true;
		data = (T[]) new Comparable[10];
	}
	
	//Depends on whether it's max or not, otherwise the same
	@SuppressWarnings("unchecked")
	public MyHeap(boolean isMax) {
		this.isMax = isMax;
		data = (T[]) new Comparable[10];
	}

		
	public void add(T s) {
		
		if (size() == data.length - 1) {
			resize();
		}
		data[size] = s;
		size++;
		//Pushing up is needed when it's added in order to preserve Heap structure
		pushup(size);
	}
	private void pushup(int index) {
		//Base case 
		if (index == 0) {
			return;
		}
		//Up:
		int upIndex = (index - 1) / 2;
		T prevVal = data[upIndex];
		
		if (isMax) {
			if (prevVal.compareTo(data[index]) < 0) {
				swap(data,upIndex,index);
				index = upIndex;
				pushup(index);
			}
		}
		if (!isMax) {
			if (prevVal.compareTo(data[index]) > 0) {
				swap(data, upIndex, index);
				index = upIndex;
				pushup(index);
			}
			
		}
	}
	public T remove() {
		T ans = data[0];
		if (size != 0) {
			data[0] = data[size - 1];
			data[size - 1] = null;
			size--;
		}
		//Pushing down is needed when you remove.
		pushdown(0);
		return ans;
	}
	private void pushdown(int index) {
		int downIndex = index * 2 + 1;
		T nextVal = data[downIndex];
		
		if (isMax) {
			//Base case: downIndex < size <- Inc. element
			if ((downIndex < size) && ((data[index].compareTo(nextVal) < 0))){
					if (downIndex + 1 >= size() || (nextVal.compareTo(data[downIndex + 1]) <= 0)){
						swap(data,downIndex,index);
						pushdown(downIndex + 1);
					}
			}
		}
		if (!isMax) {
			if ((downIndex < size) && ((data[index].compareTo(nextVal) > 0))){
				if (downIndex + 1 >= size() || (nextVal.compareTo(data[downIndex + 1]) >= 0)){
					swap(data,downIndex,index);
					pushdown(downIndex + 1);
				}
			}
		}
	}
	private void swap(T[] data, int a, int b) {
		T temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	public T peek() {
		return data[0];
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		//Double it
		//SuppressWarnings does NOT go here according to class today =(
		T[] data = (T[]) new Comparable[this.data.length * 2];
		//Transfer it
		for (int i = 0; i < size(); i++) {
			data[i] = this.data[i];
		}
		this.data = data;
		//Bop it, Twist it, Turn it
	}
	
	public String toString() {
		String ans = "[";
		for (int i = 0; i < size() - 1; i++) {
			ans += data[i] + ", ";
		}
		ans += data[size - 1];
		ans += "]";
		return ans;
	}
	
	//Several removes

	public void heapify(int[] data) {
		/*
		boolean tempMax = isMax;
		isMax = true;
		*/
		for (int i = data.length - 1; i >= 0; i--) {
			if ((i * 2 + 1) < size) {
				pushdown(i);
			}
		}
	}
}
