public class KnightBoard{
    private int[][] board;
    private int rowSize;
    private int colSize;
    private boolean solveCalled;
    private int[] prevCoordinates = new int[]{-1,1};
    
    //Constructor:
    public KnightBoard(int startingRows,int startingCols){
	//If sRows/sCols is negative, then throw IllegalArgumentException.
	if (startingRows <  0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	rowSize = startingRows;
	colSize = startingCols;
	solveCalled = false;
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

    public boolean solve(int startingRow, int startingCol){
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	if (!isInsideBounds(startingRow) || !isInsideBounds(startingCols)){
	    throw new IllegalArgumentException();
	}
	return solveHelper(startingRow, startingCol, 1);
    }
    public boolean solveHelper(int row, int col, int level){
	
    }

    //Helper functions that determines if a move is within bounds:
    private boolean isWithinBounds(int r, int c){
	return (r > 0 && c > 0 && r < rowSize && c < colSize);
    }

        

    public String toString(){}

       

    
}
	       
		
		
