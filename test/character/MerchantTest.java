package character;

import static org.junit.Assert.*;
import org.junit.Test;

import Maze.Cell;
import Maze.RecursiveMaze;
import consumable.Consumable;
import consumable.PurpleCrystal;

public class MerchantTest {
	
	@Test
	public void setShopAndSellTest() {
		Cell c = new Cell(1,1,0);
		RecursiveMaze m = new RecursiveMaze(10,10);
		PurpleCrystal pc = new PurpleCrystal(m);
		int [] Q = {1};
		int [] P = {10};
		Consumable [] C = {pc};
		Merchant M = new Merchant("Red hot chili pepper", c ,C,Q,P);
		Hero h = new Hero("AC/DC", c ,100);
		
		Integer I = (Integer) M.Shop.get(pc).keySet().toArray()[0];
		Integer O = (Integer) M.Shop.get(pc).values().toArray()[0];
		assertTrue(I==Q[0]);
		assertTrue(O==P[0]);
		M.sell(pc, 1, h);
		I = (Integer) M.Shop.get(pc).keySet().toArray()[0];
		O = (Integer) M.Shop.get(pc).values().toArray()[0];
		assertTrue(I==0);
		assertTrue(O==P[0]);
		
		
	}
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MerchantTest.class);
    }
}
