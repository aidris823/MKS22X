import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackCalc{
    public static double eval(String s){
	double ans = 0;
	String[] tokens = s.split(" ");
	System.out.println(Arrays.toString(tokens));
	Stack stack = new Stack();
	for (int i = 0; i < tokens.length; i++){
	    stack.push(tokens[i]);
	}
	for (int i = 0; i < tokens.length; i++){
	    if (tokens[i].equals("+")){
		stack.push("" + (stack.pop() + stack.pop()));
	    }
	    if (tokens[i].equals("-")){
		stack.push("" + (stack.pop() - stack.pop()));
	    }
	    if (tokens[i].equals("*")){
		stack.push("" + (stack.pop() * stack.pop()));
	    }
	    if (tokens[i].equals("/")){
		stack.push("" + (stack.pop() / stack.pop()));
	    }
	    if (tokens[i].equals("%")){
		stack.push("" + (stack.pop() % stack.pop()));
	    }
	}
	return Double.parseDouble(stack.peek(0));
    }

    private static class Stack{
	private ArrayList<String> stack = new ArrayList<>();
	public void push(String x){
	    stack.add(x);
	}
	public Double pop(){
	    String val = stack.get(stack.size()-1);
	    stack.remove(stack.size()-1);
	    return Double.parseDouble(val);
	}
	public String peek(int x){
	    return stack.get(x);
	}
    }
	
    public static void main(String[] arguments){
	System.out.println(Calculator.eval("10 2.0 +"));
	//	System.out.println(Double.parseDouble("348904.3122389"));
	//System.out.println(Calculator.eval("299.792458 666 +"));
	//System.out.println(Calculator.eval("10 2.0 +"));
	//	System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
	//System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
	
}
