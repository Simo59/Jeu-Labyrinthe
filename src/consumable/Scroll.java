package consumable;


import Maze.Cell;
import Maze.Maze;
import character.Character;
import game.goals.Goals;

public class Scroll implements Consumable {
	private Cell source;
	private boolean used ;
	private Character hero;
	protected Maze maze;
	public   final String  id="scroll";
	private Goals goalFinal;
	
	/**
	 * create a new scroll 
	 * @param g the final quest 
	 * @param m source of the scroll
	 */
	public Scroll(Maze m, Goals g) {
		this.used=false;
		this.hero=null;
		this.goalFinal = g;
	}
	
	/**
	 * affects a cell to the scroll.
	 * param c : the Cell where the scroll should be added.
	 */
	public void setCell(Cell c) {
		this.source = c;
		c.setTresor(this);
	}
	/**
	 * get the hero that's owning the scroll.
	 * @return Character : the hero.
	 */
	public Character getHero() {
		return this.hero;
	}
	
	/**
	 * get the source of the scroll 
	 * @return  the source of the scroll
	 */
	public Cell getSource() {
		return this.source;
	}
// la methode consume doit etre dans l hero
	@Override
	
	/**
	 * Consume the scroll
	 * @return the hint on the scroll
	 */
	public String consume() {
		this.used=true;

		return this.goalFinal.getGoalDescription();
	}

	@Override
	/**
	 * destroy the scroll
	 * @return a message  confirming the destruction
	 */
	public String destroy() {
		this.used=true;
		return "destroyed";
	}
	/**
	 * assign a hero to the scroll.
	 * @param h : the hero that must be assigned to the scroll.
	 */
	public void setHero(Character h) {
		this.hero=h;
	}
	/**
	 * return the scroll's id
	 * @return String : the scroll's id.
	 */
	public String getId() {
		return this.id;
	}
	
	public String toString() {
		return this.id;
	}
	/**
	 * ask the class if the scroll status is 'used'.
	 * @return boolean : true if scroll has been used, false otherwise.
	 */
	public boolean isUsed() {
		
		return this.used;
	}

	
	

}
