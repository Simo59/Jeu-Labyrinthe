package Maze;

public class RecursiveMaze extends Maze {
	
	/**
	 * create a maze using the algorithm of recursive division
	 * @param w the width of the maze
	 * @param h the height of the maze
	 */
	public RecursiveMaze(int w,int h) {
		super(w,h);
		
		this.openAllCells();
		initMaze();
		
	}
	 
	
	@Override
	/**
	 * the method creating the maze
	 */
	public void initMaze() {
		
		this.divide(0,0,this.width,this.height,orientation(this.width,this.height));

	}
	
	/**
	 * The method implementing the recursive division algorithm to generate the maze
	 * @param x the coordinate x of the origin of the current maze to divide 
	 * @param y the coordinate x of the origin of the current maze to divide
	 * @param width the width of the current maze to divide
	 * @param height the height of the current maze to divide
	 * @param orient the orientation of the wall which divide the current maze
	 */
	protected void divide (int x, int y, int width, int height,int orient ) {
		
		if (width>=2 && height>=2) {
			boolean horizontal = (orient == 0);
			
			int wx;
			int wy;
			int px;
			int py;
			int dx;
			int dy;
			int length;
			Cote dir;
			int nx;
			int ny;
			int w;
			int h;
			
			//Choix position mur,porte,direction
			if (horizontal) {
				//Position début du mur
				wx = x ;
				wy = y + ALEA.nextInt(height-1);
				
				
				//Position de la porte
				px = wx + ALEA.nextInt(width);
				py = wy + 0;
				
				//Choix de la direction
				dx = 1;
				dy = 0;
				
				//Longueur du mur
				length = width;
				
				//direction perpendiculaire au mur
				dir = Cote.SUD;
				
				//Ajout du mur et de la porte
				addWallsX(wy,wx,length);
				Cell cel = this.getCell(px,py);
				Cell celS = this.getCell(px,py+1);
				cel.openCote(dir,celS);
				
				wx += dx;
				wy += dy;
				
				
			}
			else {
				//Choix position mur,porte,direction
				wx = x + ALEA.nextInt(width-1);
				wy = y;
				
				//Position de la porte
				px = wx;
				py = wy + ALEA.nextInt(height);
				
				//Choix de la direction
				dx = 0;
				dy = 1;
				
				//Longueur du mur
				length = height;
				
				//direction perpendiculaire au mur
				dir = Cote.EST;
				
				//Ajout du mur et de la porte
				addWallsY(wx,wy,length);
				Cell cel = this.getCell(px,py);
				Cell celE = this.getCell(px+1,py);
				cel.openCote(dir,celE);
				
				wx += dx;
				wy += dy;
				
			}
			
			//recursivité
			nx = x;
			ny = y;
			if (horizontal) {
				w = width;
				h = wy-y+1;
			}
			else {
				w = wx-x+1;
				h = height;
			}
			
			divide(nx, ny, w, h, orientation(w, h));
			
			if (horizontal){
				nx = x;
				ny = wy+1;
				w = width;
				h =  y+height-wy-1;
			} 
			else {
				nx = wx+1;
				ny = y;
				w = x+width-wx-1;
				h =  height;
			}
			
			divide(nx, ny, w, h,orientation(w, h));
			
		}
	}
	/**
	 * add an horizontal wall in the maze from a given point to another given point
	 * @param ligne the line where to add the wall
	 * @param debut the point of the beginning of the wall
	 * @param fin the point of the end of the wall
	 */
	protected void addWallsX(int ligne,int debut, int fin){	
	  for (int i=debut ;i<debut+fin;i++) {
		this.theCells[i][ligne].closeCote(Cote.SUD,this.theCells[i][ligne+1]);
	  }
	}
	
	/**
	 * add a vertical wall in the maze from a given point to another given point
	 * @param colonne the line where to add the wall
	 * @param debut the point of the beginning of the wall
	 * @param fin the point of the end of the wall
	 */
	protected void addWallsY(int colonne,int debut,int fin) {
		for (int i=debut; i<debut+fin; i++) {
			this.theCells[colonne][i].closeCote(Cote.EST,this.theCells[colonne+1][i]);
		}
		
	}
	
	/**
	 * choose the orientation of a new wall in function of the width and the 
	 * the width and the height of the current maze
	 * @param width the width of the current maze
	 * @param height the height of the current maze
	 * @return 0 for an horizontal wall ,1 for a vertical wall
	 */
	protected int orientation(int width,int height){
		/*
		 * 0 : horizontal
		 * 1 : vertical
		 */
        if (width < height){
            return 0;
        }
        else if (height < width){
            return 1;
        }
        else{
            if (this.randomOrientation()==0){
                return 0;
            }
            else{
                return 1;
            }
        }

    

    }

	/**
	 * Chose randomly a number between 0 and 1
	 * @return 0 or 1
	 */
	protected int randomOrientation() {
		return ALEA.nextInt(2);
	}

}
