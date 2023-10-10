package consumable;

import Maze.Cell;
import character.Character;
import character.Hero;

public class Jewel implements Consumable {
	private int gold;
	private Cell currentCell;
	private Hero hero;
	private boolean used ;
	private String id = "jewel";
	
	public Jewel(int g) {
		this.gold=g;
		this.used=false;
		
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public String consume() {
		this.hero.addGold(this.gold);
		
		
		this.used=true;
		String res =this.gold+" has been added to your account";
		return res;
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public String destroy() {
		this.used=true;
		return "has been destroyed";
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public void setHero(Character h) {
		this.hero=(Hero) h;

	}

	@Override
	public String getId() {
		
		return this.id;
	}
	
	public String toString() {
		return this.id;
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public void setCell(Cell c) {
		c.setTresor(this);
		this.currentCell=c;
		
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public Character getHero() {
		// TODO Auto-generated method stub
		return this.hero;
	}
	/**
	 * returns the gold amount that the jewel will give to the player one used.
	 * @return	the amount of gold
	 * 
	 */

	public int getGold() {
			return this.gold;
	}
	/**
	 * @see consumable.Consumable
	 */
	@Override
	public boolean isUsed() {
		
		return this.used;
	}
	

}
