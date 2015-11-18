package htwg.se.controller;

import static org.junit.Assert.*;
import htwg.se.model.GameField;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class ChessControllerTest {

	ChessController cs;
	
	@Before
	public void setUp() throws Exception {
		cs = new ChessController(new GameField());
	}

	@Test
	public void test() {
		cs.move(new Point(0,0), new Point(0,0));
		assertNotNull(cs.getField());
		cs.reset();
	}
	
	@Test
	public void moveTest() {
		cs.move(new Point(1, 0),new Point(1,0));
		cs.move(new Point(1, 3),new Point(1,0));
		cs.move(new Point(1, 0),new Point(3,0));
		cs.move(new Point(3, 3),new Point(3,4));
		assertEquals("It's blacks turn", cs.getStatusMessage());
		assertEquals(cs.getField()[0][0].getChessPiece().toChar(), 'T');
		cs.move(new Point(0,0), new Point(0,1));
		assertEquals(cs.getField()[0][0].getChessPiece().toChar(), 'T');
		assertEquals(cs.getField()[0][1].getChessPiece().toChar(),'P');
		assertEquals(cs.getField()[1][7].getChessPiece().toChar(), 'H');
		cs.move(new Point(1, 7),new Point(0,5));
		assertEquals("It's whites turn", cs.getStatusMessage());
		assertEquals(cs.getField()[0][7].getChessPiece().toChar(), 'T');
		assertEquals(cs.getField()[0][6].getChessPiece().toChar(), 'P');
		cs.move(new Point(0,7),new Point(0,6));
		assertEquals(cs.getField()[0][7].getChessPiece().toChar(), 'T');
		assertEquals(cs.getField()[0][6].getChessPiece().toChar(), 'P');
		assertNull(cs.getField()[1][7].getChessPiece());
		assertEquals(cs.getField()[0][5].getChessPiece().toChar(),'H');
		cs.move(new Point(1,0), new Point(0,2));
		assertNull(cs.getField()[1][0].getChessPiece());
		assertEquals(cs.getField()[0][2].getChessPiece().toChar(),'H');
	}
	
	@Test
	public void moveTest2() {
		assertEquals("It's blacks turn", cs.getStatusMessage());
		assertEquals(cs.getField()[1][7].getChessPiece().toChar(),'H');
		assertNull(cs.getField()[7][4].getChessPiece());
		cs.move(new Point(1,7), new Point(7,4));
		assertEquals(cs.getField()[1][7].getChessPiece().toChar(),'H');
		assertNull(cs.getField()[7][4].getChessPiece());
	}
	
	@Test
	public void KnightTest() {
		assertEquals(cs.getField()[1][7].getChessPiece().toChar(), 'H');
		assertNull(cs.getField()[0][5].getChessPiece());
		cs.move(new Point(1,7),new Point(0,5));
		assertEquals(cs.getField()[0][5].getChessPiece().toChar(), 'H');
		assertNull(cs.getField()[1][7].getChessPiece());
		cs.move(new Point(1,0), new Point(0,2));
		assertTrue(cs.getField()[0][5].getChessPiece().getPosition().equals(new Point(0,5)));
		cs.move(new Point(0,5),new Point(1,7));
		
		assertEquals(cs.getField()[1][7].getChessPiece().toChar(), 'H');
		assertNull(cs.getField()[0][5].getChessPiece());
	}
	
	@Test
	public void winTest() {
		assertFalse(cs.checkWin());
		cs.getField()[4][0].getChessPiece().kill();
		assertTrue(cs.checkWin());
		cs.getField()[4][7].getChessPiece().kill();
		assertTrue(cs.checkWin());
	}
	
	@Test
	public void winTest2() {
		assertFalse(cs.checkWin());
		cs.getField()[4][7].getChessPiece().kill();
		assertTrue(cs.checkWin());
	}

}
