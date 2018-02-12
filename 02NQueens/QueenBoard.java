public class QueenBoard{
    private int[][] board;
    private int size;

    public QueenBoard(int size){
	this.size = size;
	board = new int[size][size];
	resetBoard();
    }

    //Suggested Private Methods:
    private boolean addQueen(int r, int c){
	board[r][c] = -1;
	for (int i = 1; i < (size-r); i++){
	    board[r+i][c] += 1;
	}
	for (int i = 1; i < (size-c); i++){
	    board[r][c+i] += 1;
	}
	return true;
    }
    private boolean removeQueen(int r, int c){
	return true;
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
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		if (board[i][j] != -1){
		    ans += "_ ";
		}
		if (board[i][j] == -1){
		    ans += "Q ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    private void resetBoard(){
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }
		

    /* Returns false if board is not solvable and fills board with 0's.
       Returns true if board is solvable and solves the board.
    */
    public boolean solve(){
	if (countSolutions() == 0){
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
	QueenBoard daBoard1 = new QueenBoard(1);
	QueenBoard daBoard2 = new QueenBoard(2);
	QueenBoard daBoard3 = new QueenBoard(3);
	QueenBoard daBoard4 = new QueenBoard(4);
	System.out.println(daBoard1.toString());
	System.out.println(daBoard2.toString());
	System.out.println(daBoard3.toString());
	System.out.println(daBoard4.toString());
		
	
	
	
    }
}
