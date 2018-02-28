public class KnightBoard{
    private int[][] board;
    private int rowSize;
    private int colSize;
    private int[] pR = new int[]{-2, -2, 2, 2, -1, -1, 1, 1};
    private int[] pC = new int[]{ 1, -1, 1, -1, 2, -2, 2, -2};
    
    //Constructor:
    public KnightBoard(int startingRows,int startingCols){
	//If sRows/sCols is negative, then throw IllegalArgumentException.
	if (startingRows <  0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	rowSize = startingRows;
	colSize = startingCols;
	board = new int[rowSize][colSize];
	resetBoard();
    }

    //Sets all values of the board to zero.
    private void resetBoard(){
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		board[i][j] = 0;
	    }	}
    }
    
    //Solves Knight tour?
    
    public boolean solve(int startingRow, int startingCol){
	
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if (!isWithinBounds(startingRow,startingCol)){
	    throw new IllegalArgumentException();
	}

	return solveHelper(startingRow, startingCol, 1);
    }
    //Solve gets by with a little help from its friends (or just one friend in
    //this case)
    public boolean solveHelper(int row, int col, int level){
	if (board[row][col] != 0){
	    return false;
	}   
	
	if (level == rowSize * colSize/* && board[row][col] == 0*/ ){
	    board[row][col] = level;
	    return true;
	}
	int[][] legalMoves = getLegalMoves(row,col);
	if (legalMoves.length == 0){
	    return false;
	}
	
	for (int i = 0; i < legalMoves.length; i++){
	    if (legalMoves[i][0] != row && legalMoves[i][1] != col && 
		board[legalMoves[i][0]][legalMoves[i][1]] == 0){
		board[row][col] = level;
		if(solveHelper(legalMoves[i][0],legalMoves[i][1], level + 1)){
		    return true;
		}
		else{
		    board[row][col] = 0;
		}
	    }
	}
	return false;
    }
		
		
		
			    
    
       
    //Helper functions that determines if a move is within bounds 
    private boolean isWithinBounds(int r, int c){
	return (r >= 0 && c >= 0 && r < rowSize && c < colSize);
    }
    /*
    //Sees if Knight currently has a legal square.
    private boolean hasLegalSquare(int r, int c){

    for (int i = 0; i < 8; i++){
    if (isWithinBounds(r+pR[i],c+pC[i]) && (board[r+pR[i]][c+pC[i]] == 0)){
    return true;
    }
    }
    return false;
    }
    */
    //Returns an array of legal moves for the Knight.
    private int[][] getLegalMoves(int r, int c){
	/*
	  Having eight legal moves is
	  only possible if it's the first move for the
	  Knight and it's not near a corner, 
	  but it's just to be safe.
	*/
	
	int[][] ans = new int[8][2];
       
	for (int i = 0; i < 8; i++){
	    if (isWithinBounds(r+pR[i],c+pC[i])
		&& (board[r+pR[i]][c+pC[i]] == 0)){
		ans[i][0] = r + pR[i];
		ans[i][1] = c + pC[i];
		//	System.out.println("Legal Directions: \n" + pR[i] + ", " + pC[i] + "\n Legal Moves \n " + ans[i][0] + ", " + 
		//			   ans[i][1]);
	    }
       
	}
	return ans;
    }
    
    public boolean isSolvable(){
	return !((rowSize < 3 && rowSize < 3) || (rowSize == 3 && colSize == 3));
    }

    public int countSolutions(int startingRow, int startingCol){
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if (!isWithinBounds(startingRow,startingCol)){
	    throw new IllegalArgumentException();
	}
	if (!isSolvable()){
	    return 0;
	}
	return countSolutionsHelper(startingRow, startingCol, 1, 1);
    }
    public int countSolutionsHelper(int r, int c, int level, int counter){
	if (level > rowSize * colSize){
	    return counter + 1;
	}
	// ??????
	return counter;
    }
	
	
        
    public String toString(){
	String ans = "";
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		
		if (board[i][j] == 0 || !isSolvable()){
		    ans += "_ ";
		}
		
		else if (board[i][j] > 0 && board[i][j] < 10){
		    ans += " " + board[i][j] + " ";
		}
		else{
		    ans += board[i][j] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] arguments){
	//I'm trying a 5 x 5 first and starting on [2,2]...because Wikipedia has an animation for that Knight tour.
	KnightBoard kasparov = new KnightBoard(5,5);
	kasparov.solve(2,2);
	System.out.println(kasparov.toString());
    }
}

   
	       
		
		
