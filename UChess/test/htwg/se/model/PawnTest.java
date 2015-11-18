package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PawnTest {
	
	Pawn testpawn;

	@Before
	public void setUp() throws Exception {
		testpawn = new Pawn(1,1,'w');
	}
	
	
	@Test
	public void euqalPositionTest() {
		assertNull(testpawn.validMove(1, 1));
		assertNull(testpawn.validMove(2, 1));

	}
	
	@Test
	public void outRangeTest() {
		assertNull(testpawn.validMove(-1, 1));
		assertNull(testpawn.validMove(10, 1));
		assertNull(testpawn.validMove(1, -1));
		assertNull(testpawn.validMove(2, 10));
	}
	
	@Test
	public void whichDirectionTest() {
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 2));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 3));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(1, 2));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 2));
		//assertNotNull(testpawn.validMove(2, 3));
		//assertNotNull(testpawn.validMove(2, 6));
		assertNull(testpawn.validMove(2, 8));
		
	}
	
	@Test
	public void twoUpTest() {
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 3));
		assertNull(testpawn.validMove(2, 5));
				
	}
	
	@Test
	public void oneUpTest() {
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 2));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(2, 3));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(3, 2));
		testpawn = new Pawn(2,1,'w');
		assertNotNull(testpawn.validMove(1, 2));
//		testpawn = new Pawn(2,1,'w');
//		assertNotNull(testpawn.validMove(2, 3));
//		assertNotNull(testpawn.validMove(2, 4));
		//assertNotNull(testpawn.validMove(2, 5));
//		assertNotNull(testpawn.validMove(2, 2));
//		testpawn = new Pawn(2,1,'w');
//		assertNotNull(testpawn.validMove(2, 3));
//		testpawn = new Pawn(2,1,'w');
//		assertNotNull(testpawn.validMove(1, 2));
//		testpawn = new Pawn(2,1,'w');
//		assertNotNull(testpawn.validMove(3, 2));
//		
//		testpawn = new Pawn(2,1,'w');
//		assertNotNull(testpawn.validMove(2, 2));
	}
	
	
	@Test
	public void test() {
		assertEquals(testpawn.moved, false);
		assertEquals(testpawn.toChar(), 'P');
		assertNull(testpawn.validMove(1, 1));
	}

}
