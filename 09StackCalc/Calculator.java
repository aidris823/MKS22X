import java.util.ArrayList;
public class Calculator{
    public static double eval(String s){
	double ans = 0;
	String[] tokens = s.split(" ");
	Stack stack = new Stack();
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
		stack.push("" + (stack.pop() + stack.pop()));
	    }
	}
	return Double.parseDouble(stack.getFirstVal());
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
	public String getFirstVal(){
	    return stack.get(0);
	}
    }
	
    public static void main(String[] arguments){
	System.out.println(Calculator.eval("299.792458 6666 +"));
	System.out.println(Calculator.eval("10 2.0 +"));
	System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
	System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
    }
	
}
