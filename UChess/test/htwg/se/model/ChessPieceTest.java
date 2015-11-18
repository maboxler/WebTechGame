package htwg.se.model;

import static org.junit.Assert.*;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class ChessPieceTest {
	
	Chesspiece piece;

	@Before
	public void setUp() throws Exception {
		piece = new Pawn(1,2,'w');
	}

	@Test
	public void test() {
		assertEquals(piece.getcolor(), 'w');
		Point point = piece.getPosition();
		assertEquals(point.getX(), 1);
		assertEquals(point.getY(), 2);
		int x = 6;
		int y = 7;
		piece.setPosition(new Point(x,y));
		point = piece.getPosition();
		assertEquals(point.getX(), 6);
		assertEquals(point.getY(), 7);
		assertTrue(piece.alive);
		piece.kill();
		assertFalse(piece.alive);
	}

}
