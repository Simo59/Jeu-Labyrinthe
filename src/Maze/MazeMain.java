package Maze;

public class MazeMain {
	/**
	 * a methos created in the first part of the project to test the algorithms of maze generating 
	 * @param args
	 */

	public static void main(String[] args) {

	int x = 10;
	int y = 13;
	RecursiveMaze testmaze= new RecursiveMaze(x,y);
	BinaryMaze testmaze2 = new BinaryMaze(x,y);
	Maze testmaze3=new SideWinderMaze(x,y);
	
	System.out.println("RecursiveMaze");
	testmaze.display();
	System.out.println("\n");
	System.out.println("BinaryMaze");
	testmaze2.display();
	System.out.println("\n");
	System.out.println("SideMaze");
	testmaze3.display();
	System.out.println(Cote.SUD);
	
	
	
	}
	
	
}
