/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Pawn;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {
    Pawn testpawn;

    @Before
    public void setUp() throws Exception {
        this.testpawn = new Pawn(1, 1, 'w');
    }

    @Test
    public void euqalPositionTest() {
        Assert.assertNull((Object)this.testpawn.validMove(1, 1));
        Assert.assertNull((Object)this.testpawn.validMove(2, 1));
    }

    @Test
    public void outRangeTest() {
        Assert.assertNull((Object)this.testpawn.validMove(-1, 1));
        Assert.assertNull((Object)this.testpawn.validMove(10, 1));
        Assert.assertNull((Object)this.testpawn.validMove(1, -1));
        Assert.assertNull((Object)this.testpawn.validMove(2, 10));
    }

    @Test
    public void whichDirectionTest() {
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 2));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 3));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(1, 2));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 2));
        Assert.assertNull((Object)this.testpawn.validMove(2, 8));
    }

    @Test
    public void twoUpTest() {
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 3));
        Assert.assertNull((Object)this.testpawn.validMove(2, 5));
    }

    @Test
    public void oneUpTest() {
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 2));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(2, 3));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(3, 2));
        this.testpawn = new Pawn(2, 1, 'w');
        Assert.assertNotNull((Object)this.testpawn.validMove(1, 2));
    }

    @Test
    public void test() {
        Assert.assertEquals((Object)this.testpawn.moved, (Object)false);
        Assert.assertEquals((long)this.testpawn.toChar(), (long)80);
        Assert.assertNull((Object)this.testpawn.validMove(1, 1));
    }
}

