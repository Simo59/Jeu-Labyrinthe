package game.action;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import Maze.BinaryMaze;
import Maze.Cell;
import Maze.Maze;
import character.Hero;
import character.MerchantTest;
import consumable.Consumable;
import consumable.Jewel;

public class AddingItemTest {
	
	private Maze maze;
	private Hero hero;
	private Action addAction;
	private Cell c1;
	private Consumable jw;
	
	@Before
	public void before() {
		this.maze=new BinaryMaze(2,2);
		this.c1=this.maze.getCellByNumber(0);
		this.hero=new Hero("clovis",this.c1,0);
		this.addAction=new AddingItemAction();
		this.jw=new Jewel(2);
	}
	
	@Test
	public void isPossibleTest() {
		assertTrue(this.c1.getTresor()==null);
		assertEquals(this.hero.getCurrentCell(),this.c1);
		assertFalse(this.addAction.isPossible(this.hero));
		this.c1.setTresor(this.jw);
		assertEquals(this.c1.getTresor(),this.jw);
		assertEquals(this.hero.getCurrentCell(),this.c1);
		assertTrue(this.addAction.isPossible(this.hero));
		
	}
	
	@Test
	public void nowTest() {
		this.c1.setTresor(jw);
		assertTrue(this.hero.getBag().keySet().size()==0);
		assertTrue(this.addAction.isPossible(this.hero));
		this.addAction.now(this.hero);
		assertTrue(this.hero.getBag().keySet().size()==1);
		assertTrue(this.hero.getBag().get(this.jw)==1);
		assertFalse(this.addAction.isPossible(this.hero));
		assertTrue(this.c1.getTresor()==null);
	}
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(AddingItemTest.class);
    }
	
}
