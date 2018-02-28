public class KnightBoard{
    private int[][] board;
    private int rowSize;
    private int colSize;
    private int[] pR = new int[]{-2, -2, 1, 1, 2, 2, -1,-1};
    private int[] pC = new int[]{ 1, -1, 2,-2, 1,-1, -2, 2};

    private int[] prevCoordinates = new int[]{-1,1};
    
    //Constructor:
    public KnightBoard(int startingRows,int startingCols){
	//If sRows/sCols is negative, then throw IllegalArgumentException.
	if (startingRows <  0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	rowSize = startingRows;
	colSize = startingCols;
	board = new int[rowSize][colSize];
	resetBoard(rowSize,colSize);
    }

    //Sets all values of the board to zero.
    private void resetBoard(int r, int c){
	for (int i = 0; i < r; i++){
	    for (int j = 0; j < c; j++){
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
    public boolean solveHelper(int row, int col, int level){
	int[][] legalMoves = getLegalMoves(row,col);
	//Base cases
	if (level == row * col){
	    return true;
	}
	/*
	if (!hasLegalSquare(row,col)){
	    return false;
	}
	*/
	if (board[row][col] == 0){
	    board[row][col] = level;
	    for (int i = 0; i < 8; i++){
		if (solveHelper(legalMoves[i][0],legalMoves[i][1],level+1)){
		    return true;
		}
	    }
	}
	return false;	    
    }
       
	

    //Helper functions that determines if a move is within bounds:
    private boolean isWithinBounds(int r, int c){
	return (r > 0 && c > 0 && r < rowSize && c < colSize);
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
	but it's just to be safe.d
	*/
	
	int[][] ans = new int[8][2];
       
	for (int i = 0; i < 8; i++){
	    if (isWithinBounds(r+pR[i],c+pC[i])
		&& (board[r+pR[i]][c+pC[i]] == 0)){
		ans[i][0] = r + pR[i];
		ans[i][1] = c + pC[i];
	    }
	}
	return ans;
    }
    
    public boolean isSolvable(){
	return !(rowSize == 2 || colSize == 2 || (rowSize == 3 && colSize == 3) || rowSize == 1 || colSize == 1);
	}
	
	
        
    public String toString(){
	String ans = "";
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		
		if (board[i][j] == 0 || !isSolvable()){
		    ans += "_ ";
		}
		else if (board[i][j] > 0 && board[i][j] < 10){
		    ans += " " + board[i][j];
		}
		else{
		    ans += board[i][j];
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
	       
		
		
