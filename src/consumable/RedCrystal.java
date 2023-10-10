package consumable;
import Maze.Cell;
import Maze.Maze;
import character.Character;
import scan.Scan;

public class RedCrystal extends Crystal {
	
	private static final String localid="redcrystal";

	/**
	  * Create a red crystal
	  * @param m Maze : the maze where the red Crystal should exist.
	  **/
	public RedCrystal(Maze m) {
		super("teleportation to another cell",m);
	}
	
	/**
	 * @see consumable.Crystal
	 */
	public String consume() {
		 // recuperer les cordonnées x et y  
		 System.out.println("which cell do you want to to teleport \n");
		 int number =Scan.scanInt();
		 this.hero.getCurrentCell().unsetCharacter(this.hero);
		 this.hero.setCell(this.maze.getCellByNumber(number));
		 this.maze.getCellByNumber(number).setCharacter(this.hero);
		
		
		this.used = true; 
		return "you are on a new cell";
	}
	/**
	 * returns this crystal id.
	 * @return String : the Crystal id.
	 */
	public String getId() {
		return this.id;
	}

	@Override
	protected void initId() {	
		this.id=RedCrystal.localid;
	}

	
}
