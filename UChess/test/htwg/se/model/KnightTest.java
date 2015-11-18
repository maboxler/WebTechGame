package htwg.se.model;

import static org.junit.Assert.*;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
	
	Knight knight;
	Knight knight2;

	@Before
	public void setUp() throws Exception {
		knight = new Knight(1,1,'w');
	}
	
	@Test
	public void outRangeTest() {	
		assertNull(knight.validMove(-1, 3));
		assertNull(knight.validMove(10, 3));
		assertNull(knight.validMove(3, -1));
		assertNull(knight.validMove(3, 10));
	}
		
	@Test
	public void equalPositionTest() {
		knight = new Knight(2,3,'w');
		assertNull(knight.validMove(2, 3));
		assertNull(knight.validMove(2, 3));
		assertNull(knight.validMove(1, 3));
		assertNull(knight.validMove(2, 4));
		Point[] array = knight.validMove(3, 5);
		System.out.println(array[0].getX());
		System.out.println(array[0].getY());
		assertTrue(array[0].equals(new Point(3,5)));
		assertEquals(array.length, 1);
		array = knight.validMove(0, 4);
		assertTrue(array[0].equals(new Point(0,4)));
		
		
		knight = new Knight(1,7,'w');
		assertNotNull(knight.validMove(0, 5));
		knight = new Knight(0,5,'w');
		array = knight.validMove(1, 7);
		assertEquals(array.length, 1);
		assertTrue(array[0].equals(new Point(1,7)));

	}
	
	@Test
	public void validMoveTest() {
		knight = new Knight(2,3,'w');
		assertNotNull(knight.validMove(3, 5));
		assertNotNull(knight.validMove(4, 4));
		assertNotNull(knight.validMove(4, 2));
		assertNotNull(knight.validMove(3, 1));
		assertNotNull(knight.validMove(1, 5));
		assertNotNull(knight.validMove(1, 1));
		assertNotNull(knight.validMove(0, 2));
		assertNotNull(knight.validMove(0, 4));
		assertNull(knight.validMove(3, 3));
		assertNull(knight.validMove(1, 3));
	}
	
	
	
	@Test
	public void moveTest() {
		knight2 = new Knight(2,3,'w');
		//assertNull(knight2.validMove(3, 3));	
		assertNotNull(knight2.validMove(3, 5));	
		//assertNotNull(knight2.validMove(3, 5));	
		
		
		
		
	}
    	
	@Test
	public void test() {
		assertEquals(knight.toChar(), 'H');
		assertNull(knight.validMove(1, 1));
	}

}
