package htwg.util;

import static org.junit.Assert.*;
import htwg.util.Point;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
	
	Point testpoint;

	@Before
	public void setUp() throws Exception {
		testpoint = new Point(1,2);
	}

	@Test
	public void test() {
		assertEquals(testpoint.getX(), 1);
		assertEquals(testpoint.getY(), 2);
		Point refpoint = new Point(1,2);
		assertEquals(testpoint.equals(refpoint), true);
		refpoint = new Point(1,1);
		assertEquals(testpoint.equals(refpoint), false);
		refpoint = new Point(3,1);
		assertEquals(testpoint.equals(refpoint), false);
		refpoint = new Point(3,4);
		assertEquals(testpoint.equals(refpoint), false);
		refpoint = new Point(1,1);
		assertEquals(testpoint.equals(refpoint), false);
	}

}
