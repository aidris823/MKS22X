import java.util.ArrayList;
public class Stack<T>{

    private ArrayList<T> data;
    private int size;

    public Stack(){
	data = new ArrayList<>[10];
	size = 0;
    }
    public Stack(int size){
	data = new ArrayList<>[size];
	size = 0;
    }

    public T pop(){
	T ans = data.get(data.size() - 1);
	data.remove(data.size() - 1);
	size--;
	return ans;
    }

    public T peek(){
	return data.get(data.size() - 1);
    }

    public T push(T safwt){
	data.add(safwt);
	size++;
    }
	

    

    
