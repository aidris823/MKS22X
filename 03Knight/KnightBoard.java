public class KnightBoard{
    private int[][] board;
    private int rowSize;
    private int colSize;
    private boolean didICallSolve = false;
    
    public KnightBoard(int startingRows, int startingCols){
	
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	
	rowSize = startingRows;
	colSize = startingCols;

	board = new int[rowSize][colSize];
	resetBoard();
    }
    
    public void resetBoard(){
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		board[i][j] = 0;
	    }
	}
    }

    public String toString(){
	String ans = "";
	if (!didICallSolve || !solve(rowSize,colSize)){
	    for (int i = 0; i < rowSize; i++){
		for (int j = 0; j < colSize; j++){
		    ans += "_ ";
		}
		ans += "\n";
	    }
	}
	for (int i = 0; i < rowSize; i++){
	    for (int j = 0; j < colSize; j++){
		if (board[i][j] < 10){
		    ans += " " + board[i][j];
		}
		else{
		    ans += "" +  board[i][j];
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    public boolean solve(int startingRow, int startingCol){
	didICallSolve = true;
	return true;
    }
}
