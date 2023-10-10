package game.action;

import Maze.Cell;
import character.Hero;

public class AddGoldAction implements Action {

	@Override
	/**
	 * @see action.Action
	 * add the gold available on the current cell to the hero
	 */
	public void now(Hero h) {
		Cell cel = h.getCurrentCell();
		h.addGold(cel.getGold());
		cel.setGold(0);
	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public boolean isPossible(Hero h) {
		if(h.getCurrentCell().getGold()>0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "add Gold";
	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public String getDescription() {
		// TODO Auto-generated method stub
		return "AddGold : Add the gold available on the cell to your bag to use it later ";
	}
}


