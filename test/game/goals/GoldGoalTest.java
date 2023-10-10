package game.goals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Maze.Cell;
import character.Hero;

public class GoldGoalTest {

	private Cell c1=new Cell(0,0,1);
	private Goals gg;
	private Hero  hero;
	
	@Before
	public void before(){
	this.c1=new Cell(0,0,1);
	this.hero=new Hero("clovis",this.c1,0);
	this.gg=new GoldGoal(2);
	}
	
	@Test 
	public void verifyTest() {
		assertSame(this.hero.getGold(),0);
		assertFalse(this.gg.isAchieved());
		this.gg.verify(hero);
		assertFalse(this.gg.isAchieved());
		this.hero.addGold(3);
		this.gg.verify(hero);
		assertSame(this.hero.getGold(),3);
		assertTrue(this.gg.isAchieved());
	}
	

}
