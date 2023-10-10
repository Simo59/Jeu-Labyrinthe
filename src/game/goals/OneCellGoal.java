 package game.goals;

import Maze.Cell;
import character.Hero;

public class OneCellGoal extends Goals {

	private Cell cellToWin;
	
	public OneCellGoal(Cell c) {
		this.cellToWin=c;
	}
	/**
	 * check if the cell where the hero is standing is the "cellToWin".
	 * if it is, the function change achieve boolean to true.
	 */
	public void verify(Hero h) {
	
		if(h.getCurrentCell().equals(cellToWin)) {
			this.achieve();
		}
		
	}
	@Override
	/**
	 * get a clue from this goal
	 * @return a clue
	 */
	public String getGoalDescription() {
		return "In order to get out of the maze, you have to pass by the Cell : ("+this.cellToWin.getNumber()+")" ;
	}
	
	/**
	 * get a false clue from this goal
	 * @return a false clue
	 */
	public String getFalseClue() {
		return "In order to get out of the maze, you have to pass by the Cell : ("+this.cellToWin.getNumber()/2+")" ;
	}
}
