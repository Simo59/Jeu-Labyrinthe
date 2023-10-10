package game.action;

import Maze.Cell;
import character.Hero;
import consumable.Consumable;

public class AddingItemAction implements Action {

	@Override
	/**
	 * add the item available on the cell to the bag of hero 
	 * @see  action.Action 
	 * 
	*/
	public void now(Hero h) {
		Cell c=h.getCurrentCell();
		Consumable t =c.getTresor();
		h.addBag(t, 1);	
		c.removeFromTresor(t);
	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public boolean isPossible(Hero h) {
		Cell c = h.getCurrentCell();
		if(c.containsTresor()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "addingItem";
	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public String getDescription() {
		
		return " AddingItem: add  an item from the cell to the bag ro use it anytime" ;
	}

}
