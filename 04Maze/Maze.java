import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private int[][] dirs = {{0,-1},
	        		   {0,1},
				   {-1,0},
				   {1,0}};
    private int rowCount;
    private int colCount;
    private boolean animate;

    //Constructor:  Loads maze text; sets animate to false by default.
    public Maze(String filename){
	animate = false;
	rowCount = 0;
	colCount = 0;
	//Source: WordSearch code
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNextLine()){
		String line = in.nextLine();
		colCount = line.length();
		rowCount++;
	    }
	    maze = new char[rowCount][colCount];
	    in = new Scanner(f);
	    while (in.hasNextLine()){
		String line = in.nextLine();
		for (int i = 0; i < line.length(); i++){
		    maze[rowCount-i][i] = line.charAt(i);
		}
	    }	    
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	if (!hasStartAndEnd()){
	    throw new IllegalStateException();
	}
    }
    
    private void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    //Checks if S appears *only* once and E appears *only* once.
    public boolean hasStartAndEnd(){
	int startCount = 0;
	int endCount = 0;
	for (int i = 0; i < rowCount; i++){
	    for (int j = 0; j < colCount; j++){
		if (maze[i][j] == 'S'){
		    startCount++;
		}
		if (maze[i][j] == 'E'){
		    endCount++;
		}
	    }
	}
	return (startCount == 1 && endCount == 1);
    }

    //Precondition: It is a legal board.
    public int solve(){
	//Find location of S."
	int[] sLocation = new int[2];
	int numAts = 0;
	
	for (int i = 0; i < rowCount; i++){
	    for (int j = 0; j < colCount; j++){
		if (maze[i][j] == 'S'){
		    maze[i][j] = ' ';
		    sLocation[0] = i;
		    sLocation[1] = j;
		}
	    }
	}

	return solve(sLocation[0],sLocation[1],0);
    }
    //Helper
    private int solve(int row, int col, int atCounter){
	if (animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	if (maze[row][col] == 'E'){
	    return atCounter;
	}
	maze[row][col] = '@';	
	for (int i = 0; i < 4; i++){
	    if (isLegal(row+dirs[i][0],col+dirs[i][1])){
		return (solve(row+dirs[i][0],col+dirs[i][1],atCounter+1));
	    }
	}
	maze[row][col] = '.';
	return -1;
    }

    //Checks to see if that move does not crash into a wall
    private boolean isLegal(int row, int col){
	return (maze[row][col] != '#');
    }

    public static void main(String[] arguments){
	Maze hazy = new Maze("data3.dat");
	hazy.setAnimate(true);
	
    }

	

}
