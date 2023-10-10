package game.action;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.*;
import character.Hero;
import character.MerchantTest;
public class AddGoldActionTest {

	private Maze maze;
	private Hero hero;
	private Action addAction;
	private Cell c1;
	
	@Before
	public void before() {
		this.maze=new BinaryMaze(2,2);
		this.c1=this.maze.getCellByNumber(0);
		this.hero=new Hero("clovis",this.c1,0);
		this.addAction=new AddGoldAction();
	}
	
	@Test
	public void isPossibleTest() {
		assertTrue(this.c1.getGold()==0);
		assertFalse(this.addAction.isPossible(this.hero));
		this.c1.setGold(2);
		assertTrue(this.c1.getGold()==2);
		assertTrue(this.addAction.isPossible(this.hero));
		
	}
	
	@Test
	public void nowTest() {
		this.c1.setGold(2);
		assertTrue(this.c1.getGold()==2);
		assertTrue(this.hero.getGold()==0);
		assertTrue(this.addAction.isPossible(this.hero));
		this.addAction.now(this.hero);
		assertTrue(this.c1.getGold()==0);
		assertTrue(this.hero.getGold()==2);
		assertFalse(this.addAction.isPossible(this.hero));
	
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(AddGoldActionTest.class);
    }
}
