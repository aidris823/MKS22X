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

		//Is the Queen safe there?
		if (!isQueenSafe(r,c)) {
			return isQueenSafe(r,c);
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
				board[r-i][c+i]++;
			}
		catch(ArrayIndexOutOfBoundsException e) {
				//Do nothing
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
				board[r-i][c+i]--;
			}
		catch(ArrayIndexOutOfBoundsException e) {
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
	
	public static void main(String[] arguments) {
		QueenBoard daBoard = new QueenBoard(8);
		daBoard.addQueen(2, 3);
		System.out.println(daBoard.toString());
		System.out.println(daBoard.threatCheck());
		daBoard.addQueen(0,4);
		System.out.println(daBoard.toString());
		System.out.println(daBoard.threatCheck());
	}
}
