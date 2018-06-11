
public class ExpressionTree {

	//Fields:
	private ExpressionTree left, right;
	private double value;
	private char op;
	
	//Is a final branch
	public ExpressionTree(double value) {
		this.value = value;
		op = '~';
	}
	
	//Ne estas fina brancxo
	public ExpressionTree(char op, ExpressionTree l, ExpressionTree r) {
		this.op = op;
		left = l;
		right = r;
	}
	//isValue() must be true.
	public double getValue() {
		return value;
	}
	
	//isOp() is true.
	public char getOp() {
		return op;
	}
	
	//isOp() is true.
	private ExpressionTree getLeft() {
		return left;
	}
	
	//isOp() is true.
	private ExpressionTree getRight() {
		return right;
	}
	
	private boolean isOp() {
		return ((left != null) && (right != null));
	}
	
	private boolean isValue() {
		return ((left == null) || (right == null));
	}
	
	//Actual operation
	private double perform(char op, double a, double b) {
		//I could case-switch this too and be lazy but that was never taught
		double ans;
		
		if (op == '+') {
			ans = a + b;
		}
		if(op == '-') {
			ans = a - b;
		}
		if (op == '*') {
			ans = a * b;
		}
		if (op == '/') {
			ans = a / b;
		}
		else {
			ans = a % b;
		}
		return ans;
	}
	
	public double evaluate() {
		if (isValue()) {
			return getValue();
		}
		else {
			return perform(this.getOp(),
					this.getLeft().evaluate(),
					this.getRight().evaluate());
		}
		
	}
	
	public String toStringPostfix() {
		String ans = "";
		//Base Case/Root thingy
		if (isValue()) {
			ans += getValue();
		}
		//PostFix: "2 2 +"
		else {
			ans += getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp();
		}
		return ans;
	}
	
	//Say we have +, 2, 2...
	public String toString() {
		String ans = "";
		if (isValue()) {
			ans += getValue();
		}
		//Infix: "(2 + 2)"
		else {
			ans += "(" + getLeft().toString() + " " + getOp() + " " + getRight().toString() + ")";
 		}
		return ans;
	}
	
	public String toStringPrefix() {
		String ans = "";
		if (isValue()) {
			ans += getValue();
		}
		//Prefix: "+ 2 2"
		else {
			ans += getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
		}
		return ans;
	}
	//Teacher's main:
	 public static void main(String[] args){
	/*
		 //ugly main sorry!
		    ExpressionTree a = new ExpressionTree(4.0);
		    ExpressionTree b = new ExpressionTree(2.0);

		    ExpressionTree c = new ExpressionTree('+',a,b);
		    System.out.println(c);
		    System.out.println(c.toStringPostfix());
		    System.out.println(c.toStringPrefix());
		    System.out.println(c.evaluate());


		    ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
		    System.out.println(d);
		    System.out.println(d.toStringPostfix());
		    System.out.println(d.toStringPrefix());
		    System.out.println(d.evaluate());

		    ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
		    System.out.println(ex);
		    System.out.println(ex.toStringPostfix());
		    System.out.println(ex.toStringPrefix());
		    System.out.println(ex.evaluate());

		    ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
		    System.out.println(ex);
		    System.out.println(ex.toStringPostfix());
		    System.out.println(ex.toStringPrefix());
		    System.out.println(ex.evaluate());

		    ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
		    System.out.println(ex);
		    System.out.println(ex.toStringPostfix());
		    System.out.println(ex.toStringPrefix());
		    System.out.println(ex.evaluate());   
		  }
		 */
	 }
}
