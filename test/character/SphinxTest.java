package character;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.*;
import consumable.*;
import game.goals.*;

public class SphinxTest {
	private Maze maze;
	private NPC sphinx;
	private Hero hero;
	private Cell c ;
	private Goals quest;
	
	@Before
	public void before() {
		this.maze=new BinaryMaze(3,3);
		this.c=this.maze.getCell(0, 0);
		this.hero=new Hero("player", this.c, 10);
		this.quest=new OneCellGoal(this.c);
		String[] q = {
				"Quel est le nom de la plus grande pyramide d'Egypte ?",
				"Quel est le nom du monstre du labyrinthe ?",
				"Dans la mythologie Grecque, où est construit le labyrinthe de Dédale pour y enfermer un monstre ?",
				"Comment ai-je perdu mon nez ?"
				};
		String[] r = {
				"Khéops",
				"Minotaur",
				"Crète",
				"Obelix"
				,};
		this.sphinx=new Sphinx("kurt",c,q,r);
		this.sphinx.setQuest(this.quest);
		
	}
	
	@Test
	public void clueTest() {
		assertEquals(this.sphinx.clue(),this.quest.getGoalDescription());
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(SphinxTest.class);
    }

}
