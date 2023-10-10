package character;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.*;
import consumable.*;


public class HeroTest {
	// creation des objets necessaire pour les tests
	private Cell c1;
	private Maze m;
	private Hero hero  ;
	private Consumable d1;
	private Consumable d2;
	private Consumable d3;
	
	@Before
	// initialisation 
	public void before() {
		this.m=new BinaryMaze(5,5);
		this.c1= m.getCell(3,2);
		this.hero= new Hero("clovis",c1,150);
		this.d1=new PurpleCrystal(m);
		this.d2=new RedCrystal(m);
		this.d3=new PurpleCrystal(m);
	}
	
	@Test 
	public void addBagTest() {
		// tester que bag est vide lors de la creation 
		assertTrue(this.hero.getBag().keySet().size()==0);
		this.hero.addBag(this.d1, 1);
		//tester l'ajout d un element a bag vide
		assertTrue(this.hero.getBag().keySet().size()==1);
		assertTrue(this.hero.getBag().containsKey(this.d1));
		assertTrue(this.hero.getBag().get(this.d1)==1);
		
		// ajout d un objet existant dans bag
		this.hero.addBag(this.d1, 1);
		assertTrue(this.hero.getBag().keySet().size()==1);
		assertTrue(this.hero.getBag().containsKey(this.d1));
		assertTrue(this.hero.getBag().get(this.d1)==2);
		// ajout d un nouvel objet inexistant dans bag
		this.hero.addBag(d2, 3);
		assertTrue(this.hero.getBag().keySet().size()==2);
		assertTrue(this.hero.getBag().containsKey(d2));
		assertTrue(this.hero.getBag().get(d2)==3);	
		
	}
	
	@Test
	public void setGoldTest() {
		assertTrue(this.hero.getGold()==150);
		this.hero.addGold(20);
		assertTrue(this.hero.getGold()==150+20);
	}

	@Test
	public void bagIsEmptyTest() {
		assertTrue(this.hero.getBag().keySet().size()==0);
		assertTrue(this.hero.bagIsEmpty());
		this.hero.addBag(this.d1, 1);
		assertFalse(this.hero.bagIsEmpty());
		this.hero.removeFromBag(this.d1.getId());
		assertTrue(this.hero.bagIsEmpty());
	}
	
	@Test
	public void removeFromBagTest() {
		assertTrue(this.hero.getBag().keySet().size()==0);
		this.hero.addBag(this.d1, 2);
		this.hero.addBag(this.d2, 1);
		this.hero.removeFromBag(this.d1.getId());
		assertTrue(this.hero.getBag().get(this.d1)==1);
		this.hero.removeFromBag(this.d1.getId());
		assertTrue(this.hero.getBag().get(this.d1)==0);
		assertTrue(this.hero.getBag().get(this.d2)==1);
		this.hero.removeFromBag(this.d2.getId());
		assertTrue(this.hero.getBag().get(this.d2)==0);
		assertTrue(this.hero.bagIsEmpty());
	}
	
	@Test
	public void getStrFromBagTest() {
		
		
	}
	
	
	
	
	@Test
	public void bagTest(){
		Cell c = new Cell(1,1,0);
		Hero h = new Hero("L'imperatrice", c ,100);
		RecursiveMaze m = new RecursiveMaze(10,10);
		PurpleCrystal pc = new PurpleCrystal(m);
		
		h.addBag(pc, 1);
		Object[] A = h.bag.keySet().toArray();
		
		assertTrue(A[0]==pc);
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(HeroTest.class);
    }
	
	
	
	
	

}
