package consumable;
import Maze.Cell;
import character.Character;
public interface Consumable {

	public String consume();
	
	public String destroy();
	
	public void setHero(Character h);
	public Character getHero();
	
	public boolean isUsed();
	
	public String getId();
	
	public void setCell(Cell c);
}
