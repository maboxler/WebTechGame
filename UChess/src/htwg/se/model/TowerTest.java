/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Tower;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TowerTest {
    Tower testtower;

    @Before
    public void setUp() throws Exception {
        this.testtower = new Tower(1, 1, 'w');
    }

    @Test
    public void outRangeTest() {
        Assert.assertNull((Object)this.testtower.validMove(-1, 1));
        Assert.assertNull((Object)this.testtower.validMove(8, 1));
        Assert.assertNull((Object)this.testtower.validMove(1, -1));
        Assert.assertNull((Object)this.testtower.validMove(1, 8));
        Assert.assertNotNull((Object)this.testtower.validMove(1, 4));
    }

    @Test
    public void equalPositionTest() {
        Assert.assertNull((Object)this.testtower.validMove(1, 1));
    }

    @Test
    public void verticalTest() {
        Assert.assertNotNull((Object)this.testtower.validMove(1, 0));
        this.testtower = new Tower(4, 4, 'w');
        Assert.assertNull((Object)this.testtower.validMove(2, 5));
        Assert.assertNotNull((Object)this.testtower.validMove(2, 4));
        Assert.assertNull((Object)this.testtower.validMove(4, 4));
        Assert.assertNotNull((Object)this.testtower.validMove(4, 5));
        Assert.assertNotNull((Object)this.testtower.validMove(4, 3));
        Assert.assertNull((Object)this.testtower.validMove(5, 5));
        Assert.assertNull((Object)this.testtower.validMove(3, 5));
        Assert.assertNotNull((Object)this.testtower.validMove(3, 4));
        Assert.assertNull((Object)this.testtower.validMove(3, 5));
        Assert.assertNotNull((Object)this.testtower.validMove(3, 4));
        Assert.assertNotNull((Object)this.testtower.validMove(3, 4));
    }

    @Test
    public void horizontalTest() {
        this.testtower = new Tower(4, 4, 'w');
        Assert.assertNotNull((Object)this.testtower.validMove(5, 4));
        Assert.assertNotNull((Object)this.testtower.validMove(3, 4));
        Assert.assertNotNull((Object)this.testtower.validMove(4, 5));
        Assert.assertNotNull((Object)this.testtower.validMove(4, 3));
        Assert.assertNull((Object)this.testtower.validMove(5, 5));
        Assert.assertNull((Object)this.testtower.validMove(3, 3));
    }

    @Test
    public void testtoChar() {
        Assert.assertEquals((long)this.testtower.toChar(), (long)84);
    }
}

