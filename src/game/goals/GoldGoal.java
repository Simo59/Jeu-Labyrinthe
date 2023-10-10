package game.goals;

import character.Hero;

public class GoldGoal extends Goals {
	private int goldToWin;
	public GoldGoal(int g ) {
	this.goldToWin=g;
	}
	/**
	 * checks if the hero has enough gold to achieve the gold goal. set the achieve boolean to true if that's the case.
	 * @param h Hero : the hero.
	 */
	public void verify(Hero h) {
		if(h.getGold()>=this.goldToWin) {
			this.achieve();
		}
	}
	@Override
	public String getGoalDescription() {
		return "In order to get out of the maze, you must have in your bank account : ("+this.goldToWin+")" ;
	}
	/**
	 * returns a false clue of the gold goal to achieve.
	 * @return String : an incorrect clue referring the gold needed to escape the maze.
	 */
	public String getFalseClue() {
		return "In order to get out of the maze, you must have in your bank account : ("+this.goldToWin/2+")" ;
	}

}
