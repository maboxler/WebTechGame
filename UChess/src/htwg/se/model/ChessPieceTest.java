/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.model;

import htwg.se.model.Chesspiece;
import htwg.se.model.Pawn;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessPieceTest {
    Chesspiece piece;

    @Before
    public void setUp() throws Exception {
        this.piece = new Pawn(1, 2, 'w');
    }

    @Test
    public void test() {
        Assert.assertEquals((long)this.piece.getcolor(), (long)119);
        Point point = this.piece.getPosition();
        Assert.assertEquals((long)point.getX(), (long)1);
        Assert.assertEquals((long)point.getY(), (long)2);
        int x = 6;
        int y = 7;
        this.piece.setPosition(new Point(x, y));
        point = this.piece.getPosition();
        Assert.assertEquals((long)point.getX(), (long)6);
        Assert.assertEquals((long)point.getY(), (long)7);
        Assert.assertTrue((boolean)this.piece.alive);
        this.piece.kill();
        Assert.assertFalse((boolean)this.piece.alive);
    }
}

