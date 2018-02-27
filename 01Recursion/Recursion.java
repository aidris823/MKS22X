public class Recursion{
    //Factorial function:
    public int fact (int n){
	//Base case:
	if (n == 0){
	    return 1;
	}
	//Stops people from entering negative numbers: 
	if (n < 0){
	    throw new IllegalArgumentException("Only enter numbers zero or greater.");
	}
	//Recursive case:
	return n * (fact(n-1));
    }
    
    //Fibonacci function:
    public int fib(int n){
	//Apparently, element 0 of the Fibonacci sequence is zero.
	if (n == 0){
	    return 0;
	}
	//Do not accept negative numbers:
	if (n < 0){
	    throw new IllegalArgumentException("Only enter numbers zero or greater.");
	}
	return fibHelper(0,n,1,0);
    }
    //Helper function that actually does the Fibonacci sequence:
    public int fibHelper(int numLoop, int n, int prev, int morePrev){
	if (numLoop == n){
	    return morePrev;
	}
	//The num loop (what current num youre on in the Fibonacci sequence) increases.
	numLoop++;
	//Redo but with the next number of the sequence.
	return fibHelper(numLoop, n, (prev + morePrev),prev );
    }
    //Square Root function:
    public double sqrt(double n){
	if (n < 0.0){
	    throw new IllegalArgumentException("I don't think we're supposed to deal with complex numbers.");
	}
	if (n == 0.0){
	    return 0.0;
	}
	//Any number smaller than n and greater than 0 could work, I think. 
	return sqrtHelper(n,n/2,0.00001);
    }
    //Helper function:
    public double sqrtHelper(double n, double myGuess, double tolerance){
	//If it's within 0.0000000000001, the function says it's good enough.
	if ((Math.abs(n-(myGuess*myGuess))) <= tolerance){
	    return myGuess;
	}
	//Better guess:
	return sqrtHelper(n, (n / myGuess + myGuess) / 2, tolerance);
    }
    
    public static void main(String[] arguments){
	Recursion x = new Recursion();

	System.out.println(x.fact(0)); //Should return 1.
	System.out.println(x.fact(1)); //Should return 1.
	System.out.println(x.fact(2)); //Should return 2.
	System.out.println(x.fact(5)); //Should return 120.
	System.out.println(x.fib(0)); //Should return 0.
	System.out.println(x.fib(1)); //Should return 1.
	System.out.println(x.fib(8)); //Should return 34.
	System.out.println(x.fib(9)); //Should return 55.
	System.out.println(x.fib(15)); //Should return 987...I think
	System.out.println(x.fib(1000)); //I don't know what it should return, but let's hope it doesn't take too long to calculate.
	System.out.println(x.sqrt(0.0)); //Returns 0.0.
	System.out.println(x.sqrt(1.0)); //Returns ~1.
	System.out.println(x.sqrt(100.0)); //Returns ~10.
	System.out.println(x.sqrt(0.25)); //Returns ~0.5.
	System.out.println(x.sqrt(Math.PI)); //Returns ~1.77245.
	System.out.println(x.sqrt(20904.6838)); //Returns...I don't know.  It's my OSIS, okay?
		
	//Post calculations: Apparently fib(1000) is 1318412525.
	//Also, my OSIS^0.5 is ~144.584
	//Who knew?
    }
}
