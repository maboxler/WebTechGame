package htwg.se.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KingTest {
	
	King king;

	@Before
	public void setUp() throws Exception {
		king = new King(1,1,'w');
	}
	
		
	@Test
	public void equalPositionTest() {
		king = new King(2,3,'w');
		
		
		assertNull(king.validMove(0, 4));
		assertNull(king.validMove(2, 3));
		assertNull(king.validMove(-1, 4));
		assertNull(king.validMove(1, -4));
		assertNull(king.validMove(1, 9));
		assertNull(king.validMove(9, 1));

		assertNotNull(king.validMove(2, 4));
		assertNotNull(king.validMove(2, 2));
		assertNull(king.validMove(2, 5));
		assertNotNull(king.validMove(1, 4));
		assertNotNull(king.validMove(2, 4));
		assertNotNull(king.validMove(3, 4));
		assertNotNull(king.validMove(1, 2));
		assertNotNull(king.validMove(2, 2));
		assertNotNull(king.validMove(3, 2));
		assertNotNull(king.validMove(1, 3));
		
		king = new King(0,0,'w');
		assertNotNull(king.validMove(1,1));
		
	}
	
	@Test
	public void horizontalTest() {
		king = new King(2,3,'w');
		assertNotNull(king.validMove(1,3));
		assertNotNull(king.validMove(3,3));
	}



	@Test
	public void test() {
		king = new King(1,1,'w');
		assertEquals(king.toChar(), 'K');
	}

}
