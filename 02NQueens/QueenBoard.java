public class QueenBoard {
	
    private int[][] board;
    private int size; 
	
    //Constructor:
    public QueenBoard(int size) {
	board = new int[size][size];
	this.size = size;
	resetBoard();
    }
	
    //Sets all squares in the board to equal 0. (Hard reset)
    private void resetBoard() {
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		board[i][j] = 0;
	    }
	}
    }
	
    /* Adds a Queen to a specific square.  
       OUTLINE:
	 
       First check if the Queen would be threatened at that square (horizontally
       right-up and horizontally right-down.
	 
       If it is, then immediately return false.
       If not, then carry on:
	 
       Square that gets the Queen gets -1.
       All horizontal right squares get += 1.
       All diagonal up squares get += 1.
       All diagonal down squares get += 1.
	 
    */
	
    private boolean addQueen(int r, int c){
	
	if (board[r][c] != 0){
	    return false;
	}
	
	//Is the Queen safe there?
	if (!isQueenSafe(r,c)) {
	    return false;
	}
		
	board[r][c] = -1;
	//Just return true if you're in the last column.
	if (c == size - 1) {
	    return true;
	}
	//Horizontal:
	for (int i = c + 1; i < size; i++) {
	    board[r][i]++;
	}
	//Diagonal up AND down:
	for (int i = 1; i < size; i++) {
	    try {
		board[r+i][c+i]++;
	    }
	    catch(ArrayIndexOutOfBoundsException e) {
		//Do nothing
	    }
	    try{
		board[r-i][c+i]++;
	    }
	    catch(ArrayIndexOutOfBoundsException e){
		//Don't do anythng
	    }
	   
	}
	return true;
    }
	
    /*Helper function that sees if two -1's face each other.
      (Precondition: board[r][c] == -1)
	
      Only checks horizontal right, diagonal right-up, and diagonal-right down.
    */
    private boolean isQueenSafe(int r, int c) {
	//Horizontal
	for (int i = c; i < size; i++) {
	    if (board[r][i] == -1) {
		return false;
	    }
	}
	for (int i = 1; i < size; i++) {
	    try {
		if (/* Diagonal down */ board[r+i][c+i] == -1 
		    || /*Diagonal up */ board[r-i][c+i] == -1) {
		    return false;
		}
	    }
	    catch(ArrayIndexOutOfBoundsException e) {
		//Do nothing
	    }
	}
	return true;
    }
	
    private boolean removeQueen(int r, int c) {
	if (board[r][c] != -1){
	    return false;
	}
	board[r][c] = 0;
	//Just return true if you're in the last column.
	//Horizontal:
	for (int i = c + 1; i < size; i++) {
	    board[r][i]--;
	}
	//Diagonal up AND down:
	for (int i = 1; i < size; i++) {
	    try {
		board[r+i][c+i]--;
	    }
	    catch(ArrayIndexOutOfBoundsException e) {
		//Do nothing
	    }
	    try{
		board[r-i][c+i]--;
	    }
	    catch(ArrayIndexOutOfBoundsException e){
		//Do nothing
	    }
	}
	return true;
    }
	
    public String toString() {
	String ans = "";
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		if (board[i][j] == -1) {
		    ans += "Q ";
		}
		else {
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public String threatCheck() {
	String ans = "";
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		ans += board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    public boolean solve(){
	//Impossible if it's a 2x2 or 3x3 board
	if (size == 2 || size == 3){
	    resetBoard();
	    return false;
	}
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelper(0);
    }
    public boolean solveHelper(int col){
	//Source: Mr. K, AP Computer Science (The answer was basically spoon
	//fed to me and I'd like to acknowledge that.)
	if (col == size){
	    return true;
	}

	for (int row = 0; row < size; row++){
	    if (addQueen(row,col)){
		if (solveHelper(col+1)){
		    return true;
		}
	    removeQueen(row,col);
	    }
	}
	return false;
    }

    //What is the premise of this problem?
    public int countSolutions(){
	if (size == 2 || size == 3){
	    return 0;
	}
	resetBoard();
	return size;
    }
	
    public static void main(String[] arguments){
	/*
	QueenBoard daBoard = new QueenBoard(8);
	daBoard.addQueen(2, 3);
	System.out.println(daBoard.toString());
	System.out.println(daBoard.threatCheck());
	daBoard.addQueen(0,4);
	System.out.println(daBoard.toString());
	System.out.println(daBoard.threatCheck());
	QueenBoard b = new QueenBoard(4);

	QueenBoard board = new QueenBoard(8);
	board.solve();
	System.out.println(board.toString());
	System.out.println(board.threatCheck());
	*/
	QueenBoard mamedyarov = new QueenBoard(8);
	mamedyarov.addQueen(4,5);
	System.out.println(mamedyarov.toString());
	System.out.println(mamedyarov.threatCheck());
	mamedyarov.removeQueen(4,5);
	System.out.println(mamedyarov.toString());
	System.out.println(mamedyarov.threatCheck());
	System.out.println(mamedyarov.solve());
	System.out.println(mamedyarov.toString());
	System.out.println(mamedyarov.threatCheck());
	QueenBoard carlsen = new QueenBoard(10);
	System.out.println(carlsen.toString());
	System.out.println(carlsen.threatCheck());
	System.out.println(carlsen.solve());
	System.out.println(carlsen.toString());
	System.out.println(carlsen.threatCheck());
    }
}
