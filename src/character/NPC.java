package character;
import Maze.Cell;
import game.goals.Goals;

public abstract class NPC extends Character {
	protected boolean status;
	protected Goals quest;
	
	public NPC(String name,Cell cell,String id) {
		super(name,cell,id);
		status=true;
		
	}
	
	/**
	 * Abstract function which will be different for all NPC.
	 * the function dictate how the NPC will interact with the hero, and the player.
	 */
	 public abstract String respond(Hero h) ;
	 /**
	  * it determines how the NPC will give out a clue to finish the maze.
	  */
	 public abstract String clue();
	 /**
	  * get the NPC status, used for knowing if the NPC is available for interaction with the player.
	  * @return boolean : True if the NPC is available, False if not.
	  */
	 public boolean getStatus() {
		 return this.status;
	 }
	 /**
	  * set the clue that will be assigned to NPC, and given to the player, if the interaction is successful.
	  * @param g Goals : the goal that will be given.
	  */
	 public void setQuest(Goals g) {
		 this.quest=g;
	 }
	 /**
	  * function called when a NPC has already been interacted with, and thus switching his status (availability) to false.
	  */
	 public void alreadyAsked() {
		 this.status=false;
	 }
}
