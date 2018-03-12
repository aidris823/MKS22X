import java.util.*;
import java.io.*;

public class USACO{

    private int r, c, e, n;
    private int[][] lake;
    private int[][] stompy;

    /* My understanding:

       Take input, set up lake, have cows stomp with specific instructions, 
       return the area.  No recursion or anything, just stompy stompy?

     RowCount, ColCount, End Depth, 
    */
    
    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    r = in.nextInt();
	    c = in.nextInt();
	    e = in.nextInt();
	    n = in.nextInt();

	    lake = new int[r][c];

	    for (int i = 0; i < r; i++){
		lake[i] = in.nextLine();
	    }
	    
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
		
	    
	    
	    
    }
    public static void stomp(int r, int c, int d){
	int max = 0;
	for (int i = r - 1; i < r + 3; i++){
	}
    }
    public static int silver(String filename){
	int[] start;
	int[] end;
	char[][] map;
	int[][] currentNumofPaths;
	int[][] oldNumOfPaths;
	int rowCount = 0;
	int colCount = 0;

	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNextLine()){
		String line = in.nextLine();
		colCount = line.length();
		rowCount++;
	    }
	    map = new char[rowCount][colCount];
	    in = new Scanner(f);
	    int counter = 0;
	    while (in.hasNextLine()){
		String line = in.nextLine();
		for (int i = 0; i < line.length(); i++){
		    map[counter][i] = line.charAt(i);
		}
		counter++;
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	
    }
}
