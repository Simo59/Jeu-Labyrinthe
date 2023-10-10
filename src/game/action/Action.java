package game.action;

import character.Hero;

public interface Action {
/**
 *start the action in the current turn  
 * @param h the hero who,is going to do the aaction
 */
	public void now(Hero h);
/**
 * verify if the action is possible in the current turn or not	
 * @param h the hero who is playing the turn 
 * @return true if the action is possible else false
 */
  public boolean isPossible(Hero h);
  
/**
 * get the description of the action 
 * @return the description of the action 
 */
 public String getDescription();
}
