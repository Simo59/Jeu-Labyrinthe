package Maze;

import java.util.*;
import character.*;

public abstract class Maze {
 protected Cell[][] theCells;
 protected int width;
 protected int height;
 protected static final Random ALEA = new Random();
 
 /**
  * create a maze of closed cells
  * @param w the width of the maze
  * @param h the height of the maze
  **/
 public Maze(int w,int h) {
	 // i : x
	 // j : y
	 this.width=w;
	 this.height=h;
	 this.theCells=new Cell[w][h];
	 int n =1;
	 for (int j=0;j<this.height;j++) {
		 for(int i=0;i<this.width;i++) {
			 this.theCells[i][j]=new Cell(i,j,n);
			 n++;
		 }
	 }
 }
 /**
  * get the width of the maze
  * @return the width of the maze
  **/
 
 public int getWidth() {
	 return this.width;
 }
 
 /**
  * get the height of the maze
  * @return the height of the maze
  **/
 public int getHeight() {
	 return this.height;
 }
 
 /**
  * get the cell situated in coordinate x and y 
  * @param x the coordinate x 
  * @param y the coordinate y
  * @return the cell in coordinate x and y 
  **/
 public Cell getCell(int x,int y){
	 return this.theCells[x][y];
 }
 
public void openAllCells() {
		for (int j=1 ; j<this.height-1 ; j++) {
			for(int i=1 ; i<this.width-1 ; i++) {
				Cote[] tabCote = Cote.values();
					
				Cell cell = this.getCell(i, j);
				Cell cellN = this.getCell(i, j-1);
				Cell cellS = this.getCell(i, j+1);
				Cell cellE = this.getCell(i+1, j);
				Cell cellO = this.getCell(i-1, j);
					
				Cell[] tabCell = {cellN,cellS,cellE,cellO};
					
				for(int d=0 ; d<tabCote.length ; d++) {
					cell.openCote(tabCote[d],tabCell[d]);
				}
				
				
				
			}
		}
		int j=0;
		int i=0;
		while(j<2) {
			for (int k = 0;k<this.width-1;k++) {
				
				Cell cell = this.getCell(k , i);
				Cell cellE = this.getCell(k+1 , i);
				cell.openCote(Cote.EST,cellE);
			
			}
			i=this.height-1;
			j +=1 ;
		}
		
		j=0;
		i=0;
		while(j<2) {
			for (int k = 0;k<this.height-1;k++) {
				
				Cell cell = this.getCell(i , k);
				Cell cellS = this.getCell(i , k+1);
				cell.openCote(Cote.SUD,cellS);
			
			}
			i=this.width-1;
			j +=1 ;
		}
	}
	
	/**
	 * the method creating the maze
	 **/
 
	public abstract void initMaze() ;
 
	
	/**
	 * Get all mobile NPCs that are on the maze
	 * @return all mobile NPCs that are on the maze
	 */
	public List<Mobile_NPC> getAllmobileNpc(){
		List<Mobile_NPC> res=new ArrayList<>();
		for (int j=0;j<this.height;j++) {
			 for(int i=0;i<this.width;i++) {
				 if(this.theCells[i][j].getMobileNPCs().size()>0) {
					 List<Mobile_NPC> tmp =this.theCells[i][j].getMobileNPCs();
					 for(Mobile_NPC n :tmp) {
						 res.add(n);
					 }
				 }
			 }
		 }
		return res;
		
	}
	
 
	public String toString() {
		String res ="";
		for(int y =0; y<this.height;y++) {
			for(int x=0;x<this.width;x++) {
				res+= this.theCells[x][y].toString()+" | ";
			}
			res+="\n";	
		}
		return res;
	}
	
	/**
	 * display the Maze with special characters
	 * */
	public void display() {
        String southWalls = null;
        for (int h = 0; h < this.height; h++) {//Regarde tout les
            String northWalls = ""; /**pour recuperer les murs nord*/
            southWalls = ""; /*pour recuperer les murs sud */
            String pathArea = ""; /**reucuperer lest et l'ouest*/
            for (int w = 0; w < this.width; w++) {
                //Verifying the existence of north wall
                if (!(this.theCells[w][h].getPaths().containsKey(Cote.NORD))) {
                    northWalls += "╬════";
                } else {
                    northWalls += "╬    ";
                }
                //Verifying the existence of west wall
                if(this.theCells[w][h].getNumber()<10) {
                if (!(this.theCells[w][h].getPaths().containsKey(Cote.OUEST))) {
                	if(this.theCells[w][h].isHeroOnTheCell()) {
                    pathArea += "║ +"+this.theCells[w][h].getNumber()+" ";
                	}else {
                		pathArea += "║ "+this.theCells[w][h].getNumber()+"  ";
                	}
                } else {
                	if(this.theCells[w][h].isHeroOnTheCell()) {
                    pathArea += " + "+this.theCells[w][h].getNumber()+" ";
                	}
                	else {
                		pathArea += "  "+this.theCells[w][h].getNumber()+"  ";	
                	}
                }}
                else if (this.theCells[w][h].getNumber()<100) {
                	if (!(this.theCells[w][h].getPaths().containsKey(Cote.OUEST))) {
                		if(this.theCells[w][h].isHeroOnTheCell()) {
                        pathArea += "║+ "+this.theCells[w][h].getNumber();
                        }
                		else {
                			pathArea += "║  "+this.theCells[w][h].getNumber();
                		}
                    } else {
                    	if(this.theCells[w][h].isHeroOnTheCell()) {
                        pathArea += " + "+this.theCells[w][h].getNumber();}
                    	else {
                    		pathArea += "   "+this.theCells[w][h].getNumber();
                    	}
                    }
                }
                else {
                	if (!(this.theCells[w][h].getPaths().containsKey(Cote.OUEST))) {
                		if(this.theCells[w][h].isHeroOnTheCell()) { 
                        pathArea += "║+"+this.theCells[w][h].getNumber();}
                		else {
                			pathArea += "║ "+this.theCells[w][h].getNumber();
                		}
                    } else {
                    	if(this.theCells[w][h].isHeroOnTheCell()) {
                        pathArea += " +"+this.theCells[w][h].getNumber();
                        }
                    	else {
                    		pathArea += "  "+this.theCells[w][h].getNumber();	
                    	}
                    }
                }
                
                
                //Last row
                if (w == this.width - 1) {
                    northWalls += "╬";
                    if (!(this.theCells[w][h].getPaths().containsKey(Cote.EST))) {
                        pathArea += "║  ";
                    } else {
                        pathArea += "   ";
                    }
                }
                if (h == this.height - 1) {
                    if (!(this.theCells[w][h].getPaths().containsKey(Cote.SUD))) {
                        southWalls += "╬════";
                    } else {
                        southWalls += "╬    ";
                    }
                    if (w == this.width - 1) {
                        southWalls += "╬";
                    }
                }
            }
            System.out.println(northWalls);
            System.out.println(pathArea);
            if (southWalls != "") {
                System.out.println(southWalls);
            }
        }
    }
	
	/**
	 * Return the cell with the number x if the cell doesn't exist it returns the cell 1
	 * @param x the number of the cell to get 
	 * @return the cell with the number x or the cell 1 if cell with the number x does not exist
	 */
	public Cell getCellByNumber(int x) {
		if(x<=this.width*this.height) {
			for (int j=0;j<this.height;j++) {
				 for(int i=0;i<this.width;i++) {
					 if(this.theCells[i][j].getNumber()==x) {
						 return this.theCells[i][j];
					 }
				}
			}
		}
		return this.theCells[0][0];
	}

	

 
 
}
