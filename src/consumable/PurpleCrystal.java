package consumable;

import java.util.*;


import character.Character;
import scan.Scan;
import Maze.*;

public class PurpleCrystal extends Crystal {
	
	private static final String  localid="purplecrystal";  
	
	/**
	 * create a purple crystal
	 * @param m Maze : the maze where the PurpleCrystal exist.
	 */
	public PurpleCrystal(Maze m) {
		super("destroy a wall of the current cell",m);
	}

	/**
	 * @see consumable.Crystal
	 * break a choosed wall around the player.
	 */
	public String consume() {
		// un try catch ici pour unbreakable wall
		System.out.println(" Quel est le mur a casser ? chisissez un!");
			System.out.println(" nord ");
			System.out.println(" sud");
			System.out.println(" est ");
			System.out.println(" Ouest ");
		String wall=Scan.scanStr();
		Cote res;
		Cell c;
		boolean diff=true;
		// Les coordonnées de le cell courante 
		int x = this.hero.getCurrentCell().getCoordX();
		int y = this.hero.getCurrentCell().getCoordY();
		Cote [] tab= Cote.values();
		while(diff) {
			for(int i =0;i<tab.length;i++) {
				if (wall.toLowerCase().equals(tab[i].toString().toLowerCase())) {
					diff=false;
				}
			}
			if (diff) {
				System.out.println("write a valid wall");
				wall=Scan.scanStr();
			}
		}
		
		try {
		switch (wall.toLowerCase()) {
		case "sud":
			res=Cote.SUD;
			c=this.maze.getCell(x,y+1 );
			break;
		case "est":
			res=Cote.EST;
			c=this.maze.getCell(x+1,y );
			break;
		case "ouest":
			res=Cote.OUEST;
			c=this.maze.getCell(x-1,y);
			break;
		 default:
			c=this.maze.getCell(x,y-1);
			res=Cote.NORD;
			break;
		}
		this.hero.getCurrentCell().openCote(res,c);
		this.used=true;
		return "the wall has been destroyed" ;
		}
		catch(IndexOutOfBoundsException e) {
			return "unbrekable Wall";  
		}
	}
	

	@Override
	protected void initId() {	
		this.id=PurpleCrystal.localid;
	}

}
