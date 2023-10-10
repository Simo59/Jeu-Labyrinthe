package Maze;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MazeTest {
	private Maze l1; 
	private RecursiveMaze l2;
	private Maze l3;
	
	@Before
	public void before() {
		this.l1=new BinaryMaze(15,12);
		this.l2=new RecursiveMaze(10,12);
		this.l3=new SideWinderMaze(9,9);
	}
	
	/*
	 * Verifie la largeur du labyrinthe
	 */
	@Test
	public void widthTest() {
		assertSame(this.l1.getWidth(),15);
		assertSame(this.l2.getWidth(),10);
		assertSame(this.l3.getWidth(),9);
		
	}
	
	/*
	 * Verifie la hauteur du labyrinthe
	 */
	@Test
	public void heightTest() {
		assertSame(this.l1.getHeight(),12);
		assertSame(this.l2.getHeight(),12);
		assertSame(this.l3.getHeight(),9);
	}
	
	/*
	 * Verifie la fonction getCell
	 */
	@Test
	public void getCellTest() {
		Maze[] laby = {this.l1,this.l2,this.l3};
		for (Maze lab : laby) {
			for (int x=0 ; x<lab.getWidth() ; x++) {
				for (int y=0 ; y<lab.getHeight() ; y++) {
					assertSame(lab.getCell(x, y).getCoordX(),x);
					assertSame(lab.getCell(x, y).getCoordY(),y);
				}
			}
		}
	}
	
	/*
	 * Verifie la fonction openAllCell
	 */
	@Test
	public void openAllCellTest() {
		Maze[] laby = {this.l1,this.l2,this.l3};
		for (Maze lab : laby) {
			lab.openAllCells();
			for (int x=1 ; x<lab.getWidth()-1 ; x++) {
				for (int y=1 ; y<lab.getHeight()-1 ; y++) {
					for (Cote cote : Cote.values()) {
						assertTrue(lab.getCell(x, y).getPaths().containsKey(cote));
					}
				}
			}
			/*
			int j=0;
			int i=0;
			while(j<2) {
				for (int k = 0;k<lab.getWidth()-1;k++) {
					if (k==0) {
						if (i==0) {
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.NORD));
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.SUD));
						}
						else {
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.SUD));
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.NORD));
						}
					}
					else {
						if (i==0) {
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.NORD));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.SUD));
						}
						else {
							assertFalse(lab.getCell(k, i).getPaths().containsKey(Cote.SUD));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(k, i).getPaths().containsKey(Cote.NORD));
						}
					}
				}
				i=lab.getHeight()-1;
				j +=1 ;
			}*/
			int j=0;
			int i=0;
			while(j<2) {
				for (int k = 0;k<lab.getHeight()-1;k++) {
					if (k==0) {
						if (i==0) {
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.NORD));
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.SUD));
						}
						else {
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.NORD));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.OUEST));
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.SUD));
						}
					}
					else {
						if (i==0) {
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.NORD));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.SUD));
						}
						else {
							assertFalse(lab.getCell(i, k).getPaths().containsKey(Cote.EST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.SUD));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.OUEST));
							assertTrue(lab.getCell(i, k).getPaths().containsKey(Cote.NORD));
						}
					}
				}
				i=lab.getWidth()-1;
				j +=1 ;
			}
		}
		
	}
	
	/*
	 * Verifie la fcontion addWallsX
	 */
	@Test
	public void addWallsXTest() {
		this.l2.openAllCells();
		this.l2.addWallsX(5,0,this.l2.getWidth());
		for (int x = 0 ; x<this.l2.getWidth() ; x++) {
			assertFalse(this.l2.getCell(x,5).getPaths().containsKey(Cote.SUD));
			assertFalse(this.l2.getCell(x,6).getPaths().containsKey(Cote.NORD));
		}
	}
	
	/*
	 * Verifie la fonction addWallsY
	 */
	@Test
	public void addWallsYTest() {
		this.l2.openAllCells();
		this.l2.addWallsY(5,0,this.l2.getHeight());
		for (int x = 0 ; x<this.l2.getHeight() ; x++) {
			assertFalse(this.l2.getCell(5,x).getPaths().containsKey(Cote.EST));
			assertFalse(this.l2.getCell(6,x).getPaths().containsKey(Cote.OUEST));
		}
	}
	
	/*
	 * Verifie la fonction orientation
	 */
	@Test
	public void orientationTest() {
		assertSame(this.l2.orientation(3, 4),0);
		assertSame(this.l2.orientation(4, 3),1);
		
	}
	
	
	public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MazeTest.class);
    }
}
