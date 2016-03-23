/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Knight;
import htwg.util.Point;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnightTest {
    Knight knight;
    Knight knight2;

    @Before
    public void setUp() throws Exception {
        this.knight = new Knight(1, 1, 'w');
    }

    @Test
    public void outRangeTest() {
        Assert.assertNull((Object)this.knight.validMove(-1, 3));
        Assert.assertNull((Object)this.knight.validMove(10, 3));
        Assert.assertNull((Object)this.knight.validMove(3, -1));
        Assert.assertNull((Object)this.knight.validMove(3, 10));
    }

    @Test
    public void equalPositionTest() {
        this.knight = new Knight(2, 3, 'w');
        Assert.assertNull((Object)this.knight.validMove(2, 3));
        Assert.assertNull((Object)this.knight.validMove(2, 3));
        Assert.assertNull((Object)this.knight.validMove(1, 3));
        Assert.assertNull((Object)this.knight.validMove(2, 4));
        Point[] array = this.knight.validMove(3, 5);
        System.out.println(array[0].getX());
        System.out.println(array[0].getY());
        Assert.assertTrue((boolean)array[0].equals(new Point(3, 5)));
        Assert.assertEquals((long)array.length, (long)1);
        array = this.knight.validMove(0, 4);
        Assert.assertTrue((boolean)array[0].equals(new Point(0, 4)));
        this.knight = new Knight(1, 7, 'w');
        Assert.assertNotNull((Object)this.knight.validMove(0, 5));
        this.knight = new Knight(0, 5, 'w');
        array = this.knight.validMove(1, 7);
        Assert.assertEquals((long)array.length, (long)1);
        Assert.assertTrue((boolean)array[0].equals(new Point(1, 7)));
    }

    @Test
    public void validMoveTest() {
        this.knight = new Knight(2, 3, 'w');
        Assert.assertNotNull((Object)this.knight.validMove(3, 5));
        Assert.assertNotNull((Object)this.knight.validMove(4, 4));
        Assert.assertNotNull((Object)this.knight.validMove(4, 2));
        Assert.assertNotNull((Object)this.knight.validMove(3, 1));
        Assert.assertNotNull((Object)this.knight.validMove(1, 5));
        Assert.assertNotNull((Object)this.knight.validMove(1, 1));
        Assert.assertNotNull((Object)this.knight.validMove(0, 2));
        Assert.assertNotNull((Object)this.knight.validMove(0, 4));
        Assert.assertNull((Object)this.knight.validMove(3, 3));
        Assert.assertNull((Object)this.knight.validMove(1, 3));
    }

    @Test
    public void moveTest() {
        this.knight2 = new Knight(2, 3, 'w');
        Assert.assertNotNull((Object)this.knight2.validMove(3, 5));
    }

    @Test
    public void test() {
        Assert.assertEquals((long)this.knight.toChar(), (long)72);
        Assert.assertNull((Object)this.knight.validMove(1, 1));
    }
}

