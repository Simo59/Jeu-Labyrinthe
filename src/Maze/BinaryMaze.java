package Maze;


public class BinaryMaze extends Maze {
	 protected  final int  INDEST=1;
	 protected  final int  INDSUD=0;
	
	
	/**
	 * create a perfect maze using binary trees algorithm
	 * @param w : the width of the  maze
	 * @param h : the height of the maze
	 */
	public BinaryMaze(int w,int h) {
		super(w,h);
		this.initMaze();
	}
	
	/**
	 * a method in which we implement the algorithm of the binary tree to create the maze 
	 */
	public void initMaze() {
		// j : x
		// i : y
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width;j++) {
				try {
					int path=this.randomPath();
					Cell c1 = this.getCell(j,i);
					
					if (path==this.INDEST) {
						Cell cEst = this.getCell(j+1,i);
						c1.openCote(Cote.EST,cEst);
					}
					else {
						Cell cSud = this.getCell(j,i+1);
						c1.openCote(Cote.SUD,cSud);
					}
				}
				catch(IndexOutOfBoundsException e) {
				
					if(!(j==width-1 && i==height-1)) {
						Cell c1 = this.getCell(j,i);
						if(j==width-1) {
							Cell cSud = this.getCell(j,i+1);
							c1.openCote(Cote.SUD,cSud);	
						}
						else if(i==height-1){
							Cell cEst = this.getCell(j+1,i);
							c1.openCote(Cote.EST,cEst);
						
						}
					}		
				}	
			}
		}
	}
	/**
	 * returns 1 or 0 in a random way
	 * @return 1 or 0 
	 */
	private int randomPath() {
		return ALEA.nextInt(2);
	}

}
