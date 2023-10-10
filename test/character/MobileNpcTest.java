package character;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Maze.*;
import consumable.*;

public class MobileNpcTest {
	
	
	private Maze m;
	private Mobile_NPC merchant ;
	private Mobile_NPC insane;
	private Cell c1;
	private Cell c2;
	@Before
	// initialisation 
	public void before() {
		Consumable[] Items=new Consumable[5];
		int[] q=new int[5];
		int[] p=new int[5];
		this.m=new BinaryMaze(5,5);
		this.c1= this.m.getCell(3,2);
		this.c2= this.m.getCell(0, 0);
		this.merchant=new Merchant("merchant",this.c1,Items,q,p);
		this.insane=new Insane("insane",c2);
	}
	
	@Test 
	public void moveEtRandomMoveTest() {
		Cell cm =this.merchant.getCurrentCell();
		Cell ci=this.insane.getCurrentCell();
		assertTrue(cm.equals(c1));
		assertTrue(ci.equals(c2));
		this.insane.randomMove();
		
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MobileNpcTest.class);
    }

}
