package consumable;
import java.util.*;
import Maze.*;
import character.Character;
public abstract class Crystal implements Consumable {
	
	protected String description;
	protected Boolean used;
	protected Character hero;
	protected Maze maze;
	protected Cell cell;
	
	
	protected String  id;	
	/**
	  * Create a crystal
	  * @param description the description
	  * @param m the maze where the crystal should exist.
	  **/
	public Crystal(String description,Maze m) {
		this.description = description;
		this.used = false;
		this.hero=null;
		this.maze=m;

		this.initId();
	}
	
	public Character getHero() {
		// TODO Auto-generated method stub
		return this.hero;
	}
	
	protected abstract void initId();
	
	/**
	  * A function that will change depending of the crystal color,
	  * it delete the crystal from the player's inventory and activate the effect.
	  * @return crystal consumption confirmation message
	  **/
	@Override
	public abstract String  consume();

	
	/**
	  * destroy the crystal
	  * @return return message after the destruction of the crystal
	  **/
	@Override
	public String destroy() {
		this.used = true; 
		return "Destroyed";
	}
	
	
	
	public String getId() {
		return this.id;
	}
	/**
	 * set the hero who's owning the cyrstal.
	 */
	public void setHero(Character h) {
		this.hero=h;
	}
	/**
	 * set a cell where a crystal spawn at the start of the game,
	 * for the player to loot.
	 */
	public void setCell(Cell c) {
		c.setTresor(this);
		this.cell=c;
		
	}
	/**
	 * return the crystal id.
	 * @return the crystal id.
	 */
	public String toString() {
		return this.id;
	} 
	
	public boolean isUsed() {
		
		return this.used;
	}
	
}
