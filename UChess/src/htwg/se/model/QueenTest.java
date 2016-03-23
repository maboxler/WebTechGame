/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Queen;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueenTest {
    Queen queen;

    @Before
    public void setUp() throws Exception {
        this.queen = new Queen(1, 1, 'w');
    }

    @Test
    public void outRangeTest() {
        Assert.assertNull((Object)this.queen.validMove(-1, 1));
        Assert.assertNull((Object)this.queen.validMove(8, 1));
        Assert.assertNull((Object)this.queen.validMove(1, -1));
        Assert.assertNull((Object)this.queen.validMove(1, 8));
        Assert.assertNotNull((Object)this.queen.validMove(1, 4));
    }

    @Test
    public void equalPositionTest() {
        this.queen = new Queen(2, 3, 'w');
        Assert.assertNotNull((Object)this.queen.validMove(2, 4));
        Assert.assertNull((Object)this.queen.validMove(2, 3));
        Assert.assertNotNull((Object)this.queen.validMove(3, 4));
        Assert.assertNotNull((Object)this.queen.validMove(3, 3));
    }

    @Test
    public void validMoveTest() {
        Assert.assertNull((Object)this.queen.validMove(1, 1));
    }

    @Test
    public void diagonalTest() {
        this.queen = new Queen(2, 3, 'w');
        Assert.assertNotNull((Object)this.queen.validMove(0, 5));
        Assert.assertNotNull((Object)this.queen.validMove(3, 4));
        Assert.assertNotNull((Object)this.queen.validMove(1, 2));
        Assert.assertNotNull((Object)this.queen.validMove(3, 2));
        Assert.assertNotNull((Object)this.queen.validMove(0, 5));
        this.queen = new Queen(2, 3, 'w');
        Assert.assertNotNull((Object)this.queen.validMove(0, 7));
    }

    @Test
    public void horizontalTest() {
        this.queen = new Queen(2, 3, 'w');
        Assert.assertNotNull((Object)this.queen.validMove(4, 3));
        Assert.assertNotNull((Object)this.queen.validMove(1, 3));
    }

    @Test
    public void verticalTest() {
        this.queen = new Queen(2, 3, 'w');
        Assert.assertNotNull((Object)this.queen.validMove(2, 4));
        Assert.assertNotNull((Object)this.queen.validMove(2, 1));
        Assert.assertNotNull((Object)this.queen.validMove(2, 7));
    }

    @Test
    public void test() {
        Assert.assertEquals((long)this.queen.toChar(), (long)81);
        Assert.assertNull((Object)this.queen.validMove(1, 1));
    }
}

