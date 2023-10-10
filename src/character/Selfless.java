package character;
import Maze.Cell;

public class Selfless extends Mobile_NPC {
	
	public Selfless(String name, Cell cell ) {
		super(name,cell,"selfless");
	}

	@Override
	public String respond(Hero h) {
		return "Hi, "+h.name+" I think I have infomations : "+this.clue();
	}
	
	@Override
	public String clue() {	
		return this.quest.getGoalDescription();
	}

	/*public String toString() {
		return "selfless";
	}*/
	
}
