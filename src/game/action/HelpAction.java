package game.action;

import java.util.*;

import character.Hero;

public class HelpAction implements Action {

	@Override
	/**
	 * @see  action.Action 
	 * describe the available action n the curren turn
	 */
	public void now(Hero h) {
		List<Action>avalaible=new ArrayList<>(); 
		List<Action>all= h.getAllActions();
		for (Action a: all) {
			if(a.isPossible(h) ) {
				System.out.println(a.getDescription());
			}
		}	

	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public boolean isPossible(Hero h) {
		
		return true;
	}
	
	public String toString() {
		return "Help";
		}

	@Override
	/**
	 * @see action.Action
	 */
	public String getDescription() {
		
		return "Help ; Show the Menu of help";
	}

}
