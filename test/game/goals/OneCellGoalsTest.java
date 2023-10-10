package game.goals;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.Cell;
import character.Hero;

public class OneCellGoalsTest {


		
		private Cell c1=new Cell(0,0,1);
		private Cell c2=new Cell (0,1,1);
		private Goals ocg;
		private Hero  hero;
		
		@Before
		public void before(){
		this.c1=new Cell(0,0,1);
		this.c2=new Cell(0,0,1);
		this.hero=new Hero("clovis",this.c1,0);
		this.ocg=new OneCellGoal(this.c2);
		}
		
		@Test
		public void verifyTest() {
			assertEquals(this.hero.getCurrentCell(),this.c1);
			assertFalse(this.ocg.isAchieved());
			this.ocg.verify(hero);
			assertFalse(this.ocg.isAchieved());
			this.hero.setCell(c2);
			assertEquals(this.hero.getCurrentCell(),this.c2);
			this.ocg.verify(hero);
			assertTrue(this.ocg.isAchieved());
		}
		
	

}
