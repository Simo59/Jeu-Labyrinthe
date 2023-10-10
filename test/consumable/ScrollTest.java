package consumable;
import Maze.Cell;
import Maze.*;
import character.Hero;
import character.MerchantTest;
import game.goals.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Maze.Cell;

public class ScrollTest {

	private Scroll s1;
	private Scroll s2;
	private Hero hero;
	private Cell c1;
	private Cell c2;
	private Goals cg;
	private Maze m;
	
	@Before 
	public void before() {
		this.c1=new Cell(0,0,1);
		this.c2=new Cell(0,1,2);
		this.hero=new Hero("hero", c1, 0);
		this.cg=new OneCellGoal(c1);
		this.m=new BinaryMaze(10,1);
		this.s1=new Scroll(this.m,cg);
		this.s2=new Scroll(this.m,cg);
		
	}
	
	@Test 
	public void setCellAndSetHeroTest() {
		this.s1.setCell(c1);
		this.s2.setCell(c2);
		assertEquals(this.s1.getSource(),this.c1);
		assertEquals(this.s2.getSource(),this.c2);
		
		this.s1.setHero(hero);
		this.s2.setHero(hero);
		 
		assertEquals(this.s1.getHero(),this.hero);
		assertEquals(this.s2.getHero(),this.hero);
	}
	
	@Test 
	public void consumeTest() {
		String tmp1=this.s1.consume();
		assertTrue(this.s1.isUsed());
		assertFalse(this.s2.isUsed());
		String tmp2=this.s2.consume();
		assertTrue(this.s2.isUsed());
		assertEquals(tmp1,this.cg.getGoalDescription());
		assertEquals(tmp2,this.cg.getGoalDescription());
	}
		
	@Test
	public void destroyTest() {
		assertFalse(this.s1.isUsed());
		assertFalse(this.s2.isUsed());
		
		this.s1.destroy();
		this.s2.destroy();
		
		assertTrue(this.s1.isUsed());
		assertTrue(this.s2.isUsed());
	}
		
		
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ScrollTest.class);
    }

}
