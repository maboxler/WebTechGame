package htwg.se.model;

import static org.junit.Assert.*;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field testfield;

	@Before
	public void setUp() throws Exception {
		testfield = new Field(new Point(1,1));
	}

	@Test
	public void test() {
		assertEquals(testfield.getChessPiece(), null);
		assertNull(testfield.getChessPiece());
		testfield = new Field(new Point(1,1),null);
		assertEquals(testfield.getChessPiece(), null);
		assertEquals(testfield.getFieldCoordinates().equals(new Point(1,1)), true);
		Pawn pawn = new Pawn(1,1,'w');
		testfield.setChessPiece(pawn);
		assertEquals(testfield.getChessPiece(), pawn);
	}

}
