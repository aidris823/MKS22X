public class USACO{
    public static int bronze(String filename){
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
