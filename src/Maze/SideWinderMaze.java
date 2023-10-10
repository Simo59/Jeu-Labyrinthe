package Maze;
import java.util.*;

public class SideWinderMaze extends Maze {

	 private  final int casser=1;
	 
	 /**
	  * create the maze using sidewinder algorithm
	  * @param w the width of the maze
	  * @param h the height of the maze
	  */
	    public SideWinderMaze(int w,int h){
	        super(w,h);
	        this.initMaze();
	    }
	    
	    /**
	     * the method implementing the sidewinder algorithm
	     */
	    public void initMaze(){
	        for (int x=0; x<width-1;x++ ){
	            this.theCells[x][0].openCote(Cote.EST,this.theCells[x+1][0] );
	        }

	        for (int y =1;y<this.height;y++){
	            
	                 List <Cell> memoire= new ArrayList<>();
	                 for (int x = 0;x<this.width;x++){
	                    memoire.add(this.theCells[x][y]);
	                    int decide = this.randomPath();
	                    if (decide ==this.casser && (x + 1) < width){
	                        openEastWall(y, x);
	                    }
	                    else{
	                       int rand=ALEA.nextInt(memoire.size());
	                       Cell c = memoire.get(rand);
	                       c.openCote(Cote.NORD, theCells[c.getCoordX()][c.getCoordY()-1]);
	                       memoire.clear();
	                    }
	               

	            }
	    
	              
	        }

	        




	    }

	    /**
	     * Open the east wall of the cell with coordinate x and y 
	     * @param y coordinate y
	     * @param x coordinate x
	     */
		private void openEastWall(int y, int x) {
			this.theCells[x][y].openCote(Cote.EST,this.theCells[x+1][y] );
		}
	    
	    /*
	     * a method that returns a random number between 0 and one
	     * @return 0 or 1 randomly
	     */
	    private int randomPath() {
			return ALEA.nextInt(2);
		}    
    

}
        
  
