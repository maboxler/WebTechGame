/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Bishop;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BishopTest {
    Bishop bishop;

    @Before
    public void setUp() throws Exception {
        this.bishop = new Bishop(1, 1, 'w');
    }

    @Test
    public void outRangeTest() {
        Assert.assertNull((Object)this.bishop.validMove(-1, 1));
        Assert.assertNull((Object)this.bishop.validMove(8, 1));
        Assert.assertNull((Object)this.bishop.validMove(1, -1));
        Assert.assertNull((Object)this.bishop.validMove(1, 8));
        Assert.assertNotNull((Object)this.bishop.validMove(1, 4));
    }

    @Test
    public void equalPositionTest() {
        this.bishop = new Bishop(2, 3, 'w');
        Assert.assertNotNull((Object)this.bishop.validMove(4, 5));
    }

    @Test
    public void validMoveTest() {
        Assert.assertNull((Object)this.bishop.validMove(1, 1));
    }

    @Test
    public void diagonalTest() {
        this.bishop = new Bishop(2, 3, 'w');
        Assert.assertNotNull((Object)this.bishop.validMove(0, 5));
        Assert.assertNotNull((Object)this.bishop.validMove(3, 4));
        Assert.assertNotNull((Object)this.bishop.validMove(1, 2));
        Assert.assertNotNull((Object)this.bishop.validMove(3, 2));
        Assert.assertNotNull((Object)this.bishop.validMove(0, 5));
        this.bishop = new Bishop(2, 3, 'w');
        Assert.assertNotNull((Object)this.bishop.validMove(0, 7));
    }

    @Test
    public void horizontalTest() {
        this.bishop = new Bishop(2, 3, 'w');
        Assert.assertNotNull((Object)this.bishop.validMove(4, 3));
        Assert.assertNotNull((Object)this.bishop.validMove(1, 3));
    }

    @Test
    public void verticalTest() {
        this.bishop = new Bishop(2, 3, 'w');
        Assert.assertNotNull((Object)this.bishop.validMove(2, 4));
        Assert.assertNotNull((Object)this.bishop.validMove(2, 1));
    }

    @Test
    public void test() {
        this.bishop = new Bishop(1, 1, 'w');
        Assert.assertEquals((long)this.bishop.toChar(), (long)66);
        Assert.assertNull((Object)this.bishop.validMove(1, 1));
    }
}

