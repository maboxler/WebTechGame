package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {
	
	Bishop bishop;

	@Before
	public void setUp() throws Exception {
		bishop = new Bishop(1, 1, 'w');
	}

	@Test
	public void outRangeTest() {	
		
		assertNull(bishop.validMove(-1, 1));
		assertNull(bishop.validMove(8, 1));
		assertNull(bishop.validMove(1, -1));
		assertNull(bishop.validMove(1, 8));
		assertNotNull(bishop.validMove(1, 4));
	
	}
		
	@Test
	public void equalPositionTest() {
//		bishop = new Bishop(2,3,'w');
//		assertNotNull(bishop.validMove(2, 4));
//		assertNull(bishop.validMove(2, 3));
//		assertNotNull(bishop.validMove(3, 4));
//		assertNotNull(bishop.validMove(3, 3));
		
		bishop = new Bishop(2,3,'w');
		assertNotNull(bishop.validMove(4, 5));
	}
	
	@Test
	public void validMoveTest() {
		assertNull(bishop.validMove(1, 1));
	}
    	
	
	@Test
	public void diagonalTest() {			    	
		bishop = new Bishop(2,3,'w');
    	//assertNull(queen.validMove(2,3));
    	
    	assertNotNull(bishop.validMove(0,5));
    	assertNotNull(bishop.validMove(3,4));
    	assertNotNull(bishop.validMove(1,2));
    	assertNotNull(bishop.validMove(3,2));
    	assertNotNull(bishop.validMove(0,5));
    	
    	bishop = new Bishop(2,3,'w');
    	assertNotNull(bishop.validMove(0,7));
    	
    	
    	
	}
	
	@Test
	public void horizontalTest() {
		bishop = new Bishop(2,3,'w');
		assertNotNull(bishop.validMove(4,3));
		assertNotNull(bishop.validMove(1,3));
	}
	
	@Test
	public void verticalTest() {
		bishop = new Bishop(2,3,'w');
		assertNotNull(bishop.validMove(2,4));
		assertNotNull(bishop.validMove(2,1));
	}


	@Test
	public void test() {
		bishop = new Bishop(1,1,'w');
		assertEquals(bishop.toChar(), 'B');
		assertNull(bishop.validMove(1, 1));
	}

}
