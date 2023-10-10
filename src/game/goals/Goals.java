package game.goals;

import character.Hero;

public abstract class Goals {
	protected boolean achieved;
	
	public Goals(){
		this.achieved=false;
	}
	/**
	 * returns whats goals must be achieved in order to escape the maze.
	 * @return a String with the goals needed.
	 */
	public String getGoals() {
		return  "You must :";
	}
	/**
	 * Verify the state of boolean achieved.
	 * @return achieved boolean : true if the goal is achieved, false otherwise.
	 */
	public boolean isAchieved() {
		return this.achieved;
	}
	/**
	 * change the state of the boolean achieved to true.
	 */
	public void achieve() {
		this.achieved=true;
	}
	
	
	public abstract String getFalseClue();

	public abstract void verify(Hero h);
	public abstract String getGoalDescription();
}
