package character;
import Maze.*;
import java.util.*;

public abstract class Mobile_NPC extends NPC {
	
	protected Random alea = new Random();
	
	public Mobile_NPC(String name,Cell cell,String id) {
		super(name,cell,id);
	}
	
	/**
	 * Move NPC to a direction
	 * 
	 * @param c Cote : Direction to move
	 */
	
	public void move(Cote c){
		this.currentCell.unsetCharacter(this);
    	this.currentCell = this.currentCell.getPaths().get(c);
    	this.currentCell.setCharacter(this);
    }
	
	/**
	 * Move an NPC in a random direction
	 */
	public void randomMove() {
		//Cote [] tab = (Cote[]) this.currentCell.getPaths().keySet().toArray();
		Cote [] tab=new Cote[this.currentCell.getPaths().keySet().size()];
		int i=0; 
		for(Cote c :this.currentCell.getPaths().keySet()) {
			tab[i]=c;
			i++;
		}
		
		
		int chosenOne = alea.nextInt(tab.length);
		this.move(tab[chosenOne]);
	}

	/**
	 * Abstract function witch will be different for all NPC
	 * allows interaction between player and NPCs.
	 *@param h : the hero interacting with the NPC.
	 */
	 public abstract String respond(Hero h) ;
	

}
