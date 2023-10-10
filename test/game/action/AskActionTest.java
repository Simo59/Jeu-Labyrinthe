package game.action;

import static org.junit.Assert.*;

import org.junit.*;

import Maze.*;
import character.Hero;
import character.Insane;
import character.MerchantTest;
import character.NPC;


public class AskActionTest {
	private Maze maze;
	private Hero hero;
	private Action askAction;
	private Cell c1;
	private NPC  np;
	@Before
	public void before() {
		this.maze=new BinaryMaze(2,2);
		this.c1=this.maze.getCellByNumber(0);
		this.hero=new Hero("clovis",this.c1,0);
		this.askAction=new AskAction();
		
	}
	
	@Test
	public void isPossibleTest() {
		this.c1.setCharacter(hero);
		assertTrue(this.hero.getCurrentCell().equals(c1));
		//System.out.println(this.c1.getCharcters());
		
		assertTrue(this.c1.getCharcters().size()==1);
		assertFalse(this.askAction.isPossible(this.hero));
		this.np=new Insane("sim", this.c1);
		this.c1.setCharacter(np);
		assertTrue(this.c1.getCharcters().size()==2);
		assertTrue(this.hero.getCurrentCell().equals(c1));
		assertTrue(this.np.getCurrentCell().equals(this.c1));
		assertTrue(this.askAction.isPossible(this.hero));
	}
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(AskActionTest.class);
    }
}
