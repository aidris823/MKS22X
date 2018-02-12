public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	resetBoard();
    }

    //Suggested Private Methods:
    private boolean addQueen(int r, int c){
    }
    private boolean removeQueen(int r, int c){
    }

    /* Returns in format:

       All numbers that are Queens is replaced with "Q".
       All others are displayed as underscores "_".
       There are spaces in between each symbol:

       _ _ Q _ 
       Q _ _ _ 
       _ _ _ Q
       _ Q _ _
    */
    public String toString(){
	String ans = "";
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		if (board[i][j] == 0){
		    ans += "_ ";
		}
		if (board[i][j] == -1){
		    ans += "Q ";
		}
		ans += "\n";
	    }
	}
	return ans;
    }

    private void resetBoard(){
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		board[i][j] = 0;
	    }
	}
    }
		

    /* Returns false if board is not solvable and fills board with 0's.
       Returns true if board is solvable and solves the board.
    */
    public boolean solve(){
	if (board.length == 2 || board.length == 1){
	    resetBoard();
	    return false;
	}
	return true;
    }

    // Returns number of solutions and fills board with zeros.
    public int countSolutions(){
	resetBoard();
	if (board.length == 2 || board.length == 1){
	    return 0;
	}
	return board.length;
    }

    public static void main(String[] arguments){
	QueenBoard daBoard0 = new QueenBoard(0);
	QueenBoard daBoard1 = new QueenBoard(1);
	QueenBoard daBoard2 = new QueenBoard(2);
	QueenBoard daBoard3 = new QueenBoard(3);
	QueenBoard daBoard4 = new QueenBoard(4);
    }
}
