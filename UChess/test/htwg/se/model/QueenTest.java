package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueenTest {
	
	Queen queen;

	@Before
	public void setUp() throws Exception {
		queen = new Queen(1,1,'w');
	}
	
	@Test
	public void outRangeTest() {	
		
		assertNull(queen.validMove(-1, 1));
		assertNull(queen.validMove(8, 1));
		assertNull(queen.validMove(1, -1));
		assertNull(queen.validMove(1, 8));
		assertNotNull(queen.validMove(1, 4));
	
	}
		
	@Test
	public void equalPositionTest() {
		queen = new Queen(2,3,'w');
		assertNotNull(queen.validMove(2, 4));
		assertNull(queen.validMove(2, 3));
		assertNotNull(queen.validMove(3, 4));
		assertNotNull(queen.validMove(3, 3));
	}
	
	@Test
	public void validMoveTest() {
		assertNull(queen.validMove(1, 1));
	}
    	
	
	@Test
	public void diagonalTest() {			    	
    	queen = new Queen(2,3,'w');
    	//assertNull(queen.validMove(2,3));
    	
    	assertNotNull(queen.validMove(0,5));
    	assertNotNull(queen.validMove(3,4));
    	assertNotNull(queen.validMove(1,2));
    	assertNotNull(queen.validMove(3,2));
    	assertNotNull(queen.validMove(0,5));
    	
    	queen = new Queen(2,3,'w');
    	assertNotNull(queen.validMove(0,7));
    	
    	
    	
	}
	
	@Test
	public void horizontalTest() {
		queen = new Queen(2,3,'w');
		assertNotNull(queen.validMove(4,3));
		assertNotNull(queen.validMove(1,3));
	}
	
	@Test
	public void verticalTest() {
		queen = new Queen(2,3,'w');
		assertNotNull(queen.validMove(2,4));
		assertNotNull(queen.validMove(2,1));
		assertNotNull(queen.validMove(2,7));
		
	}


	@Test
	public void test() {
		assertEquals(queen.toChar(), 'Q');
		assertNull(queen.validMove(1, 1));
	}

}
