package htwg.se.model;

import static org.junit.Assert.*;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class GamefieldTest {
	
	GameField gamefield;

	@Before
	public void setUp() throws Exception {
		gamefield = new GameField();
	}

	@Test
	public void inittest() {
		Field field[][] = gamefield.getField();
		assertEquals(field[0][0].getChessPiece().toChar(), 'T');
		assertEquals(field[0][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[1][0].getChessPiece().toChar(), 'H');
		assertEquals(field[1][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[2][0].getChessPiece().toChar(), 'B');
		assertEquals(field[2][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[3][0].getChessPiece().toChar(), 'Q');
		assertEquals(field[3][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[4][0].getChessPiece().toChar(), 'K');
		assertEquals(field[4][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[5][0].getChessPiece().toChar(), 'B');
		assertEquals(field[5][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[6][0].getChessPiece().toChar(), 'H');
		assertEquals(field[6][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[7][0].getChessPiece().toChar(), 'T');
		assertEquals(field[7][0].getChessPiece().getcolor(), 'w');
		assertEquals(field[7][1].getChessPiece().toChar(), 'P');
		assertEquals(field[7][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[6][1].getChessPiece().toChar(), 'P');
		assertEquals(field[6][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[5][1].getChessPiece().toChar(), 'P');
		assertEquals(field[5][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[4][1].getChessPiece().toChar(), 'P');
		assertEquals(field[4][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[3][1].getChessPiece().toChar(), 'P');
		assertEquals(field[3][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[2][1].getChessPiece().toChar(), 'P');
		assertEquals(field[2][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[1][1].getChessPiece().toChar(), 'P');
		assertEquals(field[1][1].getChessPiece().getcolor(), 'w');
		assertEquals(field[0][1].getChessPiece().toChar(), 'P');
		assertEquals(field[0][1].getChessPiece().getcolor(), 'w');
		
		
		assertEquals(field[0][7].getChessPiece().toChar(), 'T');
		assertEquals(field[0][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[1][7].getChessPiece().toChar(), 'H');
		assertEquals(field[1][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[2][7].getChessPiece().toChar(), 'B');
		assertEquals(field[2][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[3][7].getChessPiece().toChar(), 'Q');
		assertEquals(field[3][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[4][7].getChessPiece().toChar(), 'K');
		assertEquals(field[4][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[5][7].getChessPiece().toChar(), 'B');
		assertEquals(field[5][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[6][7].getChessPiece().toChar(), 'H');
		assertEquals(field[6][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[7][7].getChessPiece().toChar(), 'T');
		assertEquals(field[7][7].getChessPiece().getcolor(), 'b');
		assertEquals(field[7][6].getChessPiece().toChar(), 'P');
		assertEquals(field[7][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[6][6].getChessPiece().toChar(), 'P');
		assertEquals(field[6][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[5][6].getChessPiece().toChar(), 'P');
		assertEquals(field[5][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[4][6].getChessPiece().toChar(), 'P');
		assertEquals(field[4][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[3][6].getChessPiece().toChar(), 'P');
		assertEquals(field[3][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[2][6].getChessPiece().toChar(), 'P');
		assertEquals(field[2][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[1][6].getChessPiece().toChar(), 'P');
		assertEquals(field[1][6].getChessPiece().getcolor(), 'b');
		assertEquals(field[0][6].getChessPiece().toChar(), 'P');
		assertEquals(field[0][6].getChessPiece().getcolor(), 'b');		
	}
	
	@Test
	public void killtest() {
		assertFalse(gamefield.beatable(new Queen(1,1,'w'), new Pawn(1,1,'w')));
		assertTrue(gamefield.beatable(new Queen(1,1,'w'), new Pawn(1,1,'b')));
		Field field[][] = gamefield.getField();
		assertEquals(field[0][0].getChessPiece().toChar(),'T');
		assertEquals(field[0][1].getChessPiece().toChar(),'P');
		gamefield.moveAfterCheck(new Point(0,0), new Point(0,1));
		assertNull(field[0][0].getChessPiece());
		assertEquals(field[0][1].getChessPiece().toChar(),'T');
		gamefield.moveAfterCheck(new Point(0,1), new Point(0,0));
		assertNull(field[0][1].getChessPiece());
		assertEquals(field[0][0].getChessPiece().toChar(),'T');
	}
	
	@Test
	public void wintest() {
		assertFalse(gamefield.whiteWon());
		gamefield.getField()[4][7].getChessPiece().kill();
		assertTrue(gamefield.whiteWon());
		gamefield = new GameField();
		assertFalse(gamefield.blackWon());
		gamefield.getField()[4][0].getChessPiece().kill();
		assertTrue(gamefield.blackWon());
	}
	
	@Test
	public void movetest() {
		gamefield = new GameField();
		assertFalse(gamefield.moveCheck(new Point(1, 0),new Point(1,0)));
		assertFalse(gamefield.moveCheck(new Point(1, 3),new Point(1,0)));
		assertFalse(gamefield.moveCheck(new Point(1, 0),new Point(3,0)));
		assertFalse(gamefield.moveCheck(new Point(3, 3),new Point(3,4)));
		
	}
	
	@Test
	public void pathtest() {
		Field[][] field = gamefield.getField();
		field[0][4].setChessPiece(new Tower(0, 4, 'w'));
		field[7][4].setChessPiece(new Tower(7, 4, 'b'));
		assertTrue(gamefield.moveCheck(new Point(0, 4),new Point(7,4)));
		field[4][4].setChessPiece(new Tower(4, 4, 'w'));
		assertFalse(gamefield.moveCheck(new Point(0, 4),new Point(7,4)));
		field[7][4].setChessPiece(new Tower(7, 4, 'w'));
		assertFalse(gamefield.moveCheck(new Point(4, 4),new Point(7,4)));
	}
	
	@Test
	public void pawntest1() {
		Field[][] field = gamefield.getField();
		assertEquals(field[1][6].getChessPiece().toChar(),'P');
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(0,4)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(2,4)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(0,5)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(2,5)));
		assertTrue(gamefield.moveCheck(new Point(1,6), new Point(1,5)));
		assertTrue(gamefield.moveCheck(new Point(1,6), new Point(1,4)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(4,6)));
		assertEquals(field[1][1].getChessPiece().toChar(),'P');
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(0,2)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(2,2)));
		assertTrue(gamefield.moveCheck(new Point(1,1), new Point(1,2)));
		assertTrue(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(4,6)));
		field[0][5].setChessPiece(new Pawn(0, 5, 'b'));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(0,5)));
		field[0][5].setChessPiece(new Pawn(0, 5, 'w'));
		assertTrue(gamefield.moveCheck(new Point(1,6), new Point(0,5)));
		field[1][5].setChessPiece(new Pawn(1, 5, 'w'));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,5)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,4)));
		field[1][4].setChessPiece(new Pawn(1, 4, 'w'));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,4)));
		field[1][5].setChessPiece(null);
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,4)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,7)));
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,0)));
	}
	
	@Test
	public void pawntest2() {
		Field[][] field = gamefield.getField();
		assertEquals(field[1][6].getChessPiece().toChar(),'P');
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(0,3)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(2,3)));
		field[1][6].getChessPiece().setmovedTrue();
		assertFalse(gamefield.moveCheck(new Point(1,6), new Point(1,4)));
		field[0][2].setChessPiece(new Pawn(0,2,'w'));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(0,2)));
		field[0][2].setChessPiece(new Pawn(0,2,'b'));
		assertTrue(gamefield.moveCheck(new Point(1,1), new Point(0,2)));
		
	}
	
	@Test
	public void whitePawnTest() {
		Field[][] field = gamefield.getField();
		assertEquals(field[1][1].getChessPiece().toChar(),'P');
		assertEquals(field[1][1].getChessPiece().getcolor(),'w');
		assertTrue(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,0)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,7)));
		assertTrue(gamefield.moveCheck(new Point(1,1), new Point(1,2)));
		field[1][2].setChessPiece(new Pawn(1, 2, 'b'));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,2)));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
		field[1][3].setChessPiece(new Pawn(1, 3, 'b'));
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
		field[1][2].setChessPiece(null);
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
		field[1][1].getChessPiece().setmovedTrue();
		assertFalse(gamefield.moveCheck(new Point(1,1), new Point(1,3)));
	}

}
