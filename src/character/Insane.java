package character;

import Maze.Cell;

public class Insane extends Mobile_NPC {

	public Insane(String name, Cell cell) {
		super(name,cell,"insane");
	}
	
	@Override
	public String clue( ) {
		
		return this.quest.getFalseClue();
	}
	
	@Override
	public String respond(Hero h) {
		return this.clue();
	}
	
	/*public String toString() {
		return "insane";
	}
*/
}
