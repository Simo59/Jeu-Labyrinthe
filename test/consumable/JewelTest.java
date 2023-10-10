package consumable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.Cell;
import character.Hero;
import character.MerchantTest;
public class JewelTest {
	
	private Jewel jw1;
	private Jewel jw2;
	private Hero hero;
	private Cell c1;
	@Before
	public void before() {
		this.c1=new Cell(0,0,1);
		this.hero=new Hero("hero", c1, 0);
		this.jw1=new Jewel(2);
		this.jw2=new Jewel(3);
	}
	
	@Test
	public void jewelConsumeTest() {
		this.jw1.setHero(this.hero);
		this.jw2.setHero(this.hero);
		
		assertEquals((Hero) this.jw1.getHero(),this.hero);
		assertEquals((Hero) this.jw2.getHero(),this.hero);
		
		assertSame(this.jw1.getGold(),2);
		assertSame(this.jw2.getGold(),3);
		
		assertSame(this.hero.getGold(),0);
		
		this.jw1.consume();
		assertSame(this.hero.getGold(),2);
		assertTrue(this.jw1.isUsed());
		
		this.jw2.consume();
		assertSame(this.hero.getGold(),5);
		assertTrue(this.jw2.isUsed());
	}
	
	
	@Test
	public void destroyTest() {
		assertFalse(this.jw1.isUsed());
		assertFalse(this.jw2.isUsed());
		
		this.jw1.destroy();
		this.jw2.destroy();
		
		assertTrue(this.jw1.isUsed());
		assertTrue(this.jw2.isUsed());
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(JewelTest.class);
    }
	
	
	

}
