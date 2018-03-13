import java.util.*;
import java.io.*;

//Code was debugged w/help from Shaina Peters and Taseen Ali

public class Maze{

    private char[][] maze;
    private int[][] dirs = {
	{0,-1},
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
	    int counter = 0;
	    while (in.hasNextLine()){
		String line = in.nextLine();
		for (int i = 0; i < line.length(); i++){
		    maze[counter][i] = line.charAt(i);
		}
		counter++;
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
    //Prints out the board.
    public String toString(){
	String ans = "";
	for (int i = 0; i < rowCount; i++){
	    for (int j = 0; j < colCount; j++){
		ans += maze[i][j];
	    }
	    ans += "\n";
	}
	return ans;
    }

    //Precondition: It is a legal board.
  
    public int solve(){
	//Find location of S."
	int[] sLocation = new int[2];
	
	for (int i = 0; i < rowCount; i++){
	    for (int j = 0; j < colCount; j++){
		if (maze[i][j] == 'S'){
		    maze[i][j] = '@';
		    sLocation[0] = i;
		    sLocation[1] = j;
		}
	    }
	}

	return solve(sLocation[0],sLocation[1],0);
    }
    //  int numRecursions = 0;
    //Helper
    private int solve(int row, int col, int atCounter){

	//	numRecursions++;
	/*	System.out.println(numRecursions);
	System.out.println("Current coordinates: [" + row + ", " + col + "]");
	System.out.println("Am I currently on a legal square?: " + isLegal(row,col));
	System.out.println(toString());*/
	if (animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	/*
	if (maze[row][col] == 'E'){
	    //System.out.println(toString());
	    return atCounter;
	}
	*/
	//	maze[row][col] = '@';

	//	maze[row][col] = '@';
      
	for (int i = 0; i < 4; i++){
	    if (isLegal(row+dirs[i][0],col+dirs[i][1])){
		if (maze[row+dirs[i][0]][col+dirs[i][1]] == 'E'){
		    return atCounter + 1;
		}
		maze[row+dirs[i][0]][col+dirs[i][1]] = '@';
		int x = (solve(row+dirs[i][0],col+dirs[i][1],atCounter+1));
		if (x != -1){
		    return x;
		}
		maze[row+dirs[i][0]][col+dirs[i][1]] = '.';	
	    }	       
	}
	return -1;
    }

    //Checks to see if that move does not crash into a wall
    private boolean isLegal(int row, int col){
	return (row > 0
		&& row < rowCount - 1 &&
		col > 0 && col < colCount - 1 && maze[row][col] != '#'
		&& maze[row][col] != '.' && maze[row][col] != '@');
    }

    public static void main(String[] arguments){
	Maze hazy = new Maze("data1.dat");
	System.out.println(hazy.toString());
	hazy.setAnimate(true);
	//	hazy.solve();
	System.out.println(hazy.solve());
	//	System.out.println(hazy.toString());
		
	
    }

	

}
