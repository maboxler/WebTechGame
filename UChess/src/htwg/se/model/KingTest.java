/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.King;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KingTest {
    King king;

    @Before
    public void setUp() throws Exception {
        this.king = new King(1, 1, 'w');
    }

    @Test
    public void equalPositionTest() {
        this.king = new King(2, 3, 'w');
        Assert.assertNull((Object)this.king.validMove(0, 4));
        Assert.assertNull((Object)this.king.validMove(2, 3));
        Assert.assertNull((Object)this.king.validMove(-1, 4));
        Assert.assertNull((Object)this.king.validMove(1, -4));
        Assert.assertNull((Object)this.king.validMove(1, 9));
        Assert.assertNull((Object)this.king.validMove(9, 1));
        Assert.assertNotNull((Object)this.king.validMove(2, 4));
        Assert.assertNotNull((Object)this.king.validMove(2, 2));
        Assert.assertNull((Object)this.king.validMove(2, 5));
        Assert.assertNotNull((Object)this.king.validMove(1, 4));
        Assert.assertNotNull((Object)this.king.validMove(2, 4));
        Assert.assertNotNull((Object)this.king.validMove(3, 4));
        Assert.assertNotNull((Object)this.king.validMove(1, 2));
        Assert.assertNotNull((Object)this.king.validMove(2, 2));
        Assert.assertNotNull((Object)this.king.validMove(3, 2));
        Assert.assertNotNull((Object)this.king.validMove(1, 3));
        this.king = new King(0, 0, 'w');
        Assert.assertNotNull((Object)this.king.validMove(1, 1));
    }

    @Test
    public void horizontalTest() {
        this.king = new King(2, 3, 'w');
        Assert.assertNotNull((Object)this.king.validMove(1, 3));
        Assert.assertNotNull((Object)this.king.validMove(3, 3));
    }

    @Test
    public void test() {
        this.king = new King(1, 1, 'w');
        Assert.assertEquals((long)this.king.toChar(), (long)75);
    }
}

