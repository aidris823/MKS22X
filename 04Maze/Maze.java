import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private int rowCount;
    private int colCount;
    private boolean animate;

    //Constructor
    public Maze(String filename){
	rowCount = 0;
	try{
	    File f = new File(filename);
	    Scanner in;
	    while (in.hasNext()){
		String line = in.nextLine);
		colCount = line.length();
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.out.exit(1);
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

    public boolean hasStartAndEnd(){
	int startCount = 0;
	int endCount = 0;
	for (int i = 0; i < 

    public int solve(){
	//Find location of S."
	int[] sLocation = new int[2];
	int numAts = 0;
	
	for (int i = 0; i < rowCount; i++){
	    for (int j = 0; j < colCount; j++){
		if (maze[i][j] == 'S'){
		    sLocation[0] = i;
		    sLocation[1] = j;
		}
	    }
	}

	

}
