public class USACO{

    private int r, c, e, n;
    private int[][] lake;
    private int[][] stompy;

    /* My understanding:

       Take input, set up lake, have cows stomp with specific instructions, 
       return the area.  No recursion or anything, just stompy stompy?
    */
    
    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    String line = in.nextLine();
	    String[] vals = line.split(" ");
	    r = vals[0];
	    c = vals[1];
	    e = vals[2];
	    n = vals[3];
	    
	    int counter = 0;
	    while (counter < r){
		line = in.nextLine();
		for (int i = 0; i < line.length(); i++){
		    lake[counter][i] = Integer.parseInt(line.charAt(i));
		}
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
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
