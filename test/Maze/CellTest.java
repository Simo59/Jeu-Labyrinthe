package Maze;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell c1; 
	private Cell c2;
	private Cell c3;
	@Before
	public void before() {
		this.c1=new Cell(0,0,1);
		this.c2=new Cell(0,1,3);
		this.c3=new Cell(1,0,4);
		
	}
	
	/*
	 * Vérifie la fonction getCoordX
	 */
	@Test
	public void getCoordXTest() {
		assertTrue(c1.getCoordX()==0);
		assertTrue(c2.getCoordX()==0);
		assertTrue(c3.getCoordX()==1);
	}
	
	/*
	 * Vérifie la fonction getCoordY
	 */
	@Test
	public void getCoordYTest() {
		assertTrue(c1.getCoordY()==0);
		assertTrue(c2.getCoordY()==1);
		assertTrue(c3.getCoordY()==0);
	}
	
	/*
	 * Vérifie la fonction openCote
	 */
	@Test
	public void openCoteTest() {
		assertFalse(this.c1.getPaths().containsKey(Cote.NORD));
		assertFalse(this.c1.getPaths().containsKey(Cote.SUD));
		assertFalse(this.c1.getPaths().containsKey(Cote.EST));
		assertFalse(this.c1.getPaths().containsKey(Cote.OUEST));
		assertTrue(this.c1.getPaths().keySet().size()==0);
		
		assertFalse(this.c2.getPaths().containsKey(Cote.NORD));
		assertFalse(this.c2.getPaths().containsKey(Cote.SUD));
		assertFalse(this.c2.getPaths().containsKey(Cote.EST));
		assertFalse(this.c2.getPaths().containsKey(Cote.OUEST));
		assertTrue(this.c2.getPaths().keySet().size()==0);
		
		this.c1.openCote(Cote.NORD, this.c2);
		this.c1.openCote(Cote.SUD, this.c2);
		this.c1.openCote(Cote.EST, this.c2);
		this.c1.openCote(Cote.OUEST, this.c2);
		
		assertSame(this.c1.getPaths().get(Cote.NORD),c2);
		assertSame(this.c1.getPaths().get(Cote.SUD),c2);
		assertSame(this.c1.getPaths().get(Cote.EST),c2);
		assertSame(this.c1.getPaths().get(Cote.OUEST),c2);
		assertTrue(this.c1.getPaths().keySet().size()==4);
		
		assertSame(this.c2.getPaths().get(Cote.NORD),c1);
		assertSame(this.c2.getPaths().get(Cote.SUD),c1);
		assertSame(this.c2.getPaths().get(Cote.EST),c1);
		assertSame(this.c2.getPaths().get(Cote.OUEST),c1);
		assertTrue(this.c2.getPaths().keySet().size()==4);
		
		}
	
	/*
	 * Vérifie la fonction closeCote
	 */
	@Test
	public void closeCoteTest() {
		this.c1.openCote(Cote.NORD, this.c2);
		this.c1.openCote(Cote.SUD, this.c2);
		this.c1.openCote(Cote.EST, this.c2);
		this.c1.openCote(Cote.OUEST, this.c2);
		
		assertSame(this.c1.getPaths().get(Cote.NORD),c2);
		assertSame(this.c1.getPaths().get(Cote.SUD),c2);
		assertSame(this.c1.getPaths().get(Cote.EST),c2);
		assertSame(this.c1.getPaths().get(Cote.OUEST),c2);
		assertTrue(this.c1.getPaths().keySet().size()==4);
		
		assertSame(this.c2.getPaths().get(Cote.NORD),c1);
		assertSame(this.c2.getPaths().get(Cote.SUD),c1);
		assertSame(this.c2.getPaths().get(Cote.EST),c1);
		assertSame(this.c2.getPaths().get(Cote.OUEST),c1);
		assertTrue(this.c2.getPaths().keySet().size()==4);
		
		this.c1.closeCote(Cote.NORD, this.c2);
		this.c1.closeCote(Cote.SUD, this.c2);
		this.c1.closeCote(Cote.EST, this.c2);
		this.c1.closeCote(Cote.OUEST, this.c2);
		
		assertFalse(this.c1.getPaths().containsKey(Cote.NORD));
		assertFalse(this.c1.getPaths().containsKey(Cote.SUD));
		assertFalse(this.c1.getPaths().containsKey(Cote.EST));
		assertFalse(this.c1.getPaths().containsKey(Cote.OUEST));
		assertTrue(this.c1.getPaths().keySet().size()==0);
		
		assertFalse(this.c2.getPaths().containsKey(Cote.NORD));
		assertFalse(this.c2.getPaths().containsKey(Cote.SUD));
		assertFalse(this.c2.getPaths().containsKey(Cote.EST));
		assertFalse(this.c2.getPaths().containsKey(Cote.OUEST));
		assertTrue(this.c2.getPaths().keySet().size()==0);
		}
	
	/*
	 * Vérifie la fonction getPaths
	 */
	@Test
	public void getPathTest() {
		this.c1.openCote(Cote.NORD, this.c2);
		this.c1.openCote(Cote.OUEST, this.c2);
		
		this.c2.openCote(Cote.EST, this.c1);
		this.c2.openCote(Cote.SUD, this.c1);
		
		assertTrue(this.c1.getPaths().containsKey(Cote.NORD));
		assertTrue(this.c1.getPaths().containsKey(Cote.OUEST));
		assertFalse(this.c1.getPaths().containsKey(Cote.EST));
		assertFalse(this.c1.getPaths().containsKey(Cote.SUD));
		
		assertTrue(this.c2.getPaths().containsKey(Cote.EST));
		assertTrue(this.c2.getPaths().containsKey(Cote.SUD));
		assertFalse(this.c2.getPaths().containsKey(Cote.NORD));
		assertFalse(this.c2.getPaths().containsKey(Cote.OUEST));
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CellTest.class);
    }
}
