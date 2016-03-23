/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.controller;

import htwg.se.controller.ChessController;
import htwg.se.model.Chesspiece;
import htwg.se.model.Field;
import htwg.se.model.GameField;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChessControllerTest {
    ChessController cs;

    @Before
    public void setUp() throws Exception {
        this.cs = new ChessController(new GameField());
    }

    @Test
    public void test() {
        this.cs.move(new Point(0, 0), new Point(0, 0));
        Assert.assertNotNull((Object)this.cs.getField());
        this.cs.reset();
    }

    @Test
    public void moveTest() {
        this.cs.move(new Point(1, 0), new Point(1, 0));
        this.cs.move(new Point(1, 3), new Point(1, 0));
        this.cs.move(new Point(1, 0), new Point(3, 0));
        this.cs.move(new Point(3, 3), new Point(3, 4));
        Assert.assertEquals((Object)"It's blacks turn", (Object)this.cs.getStatusMessage());
        Assert.assertEquals((long)this.cs.getField()[0][0].getChessPiece().toChar(), (long)84);
        this.cs.move(new Point(0, 0), new Point(0, 1));
        Assert.assertEquals((long)this.cs.getField()[0][0].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)this.cs.getField()[0][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)this.cs.getField()[1][7].getChessPiece().toChar(), (long)72);
        this.cs.move(new Point(1, 7), new Point(0, 5));
        Assert.assertEquals((Object)"It's whites turn", (Object)this.cs.getStatusMessage());
        Assert.assertEquals((long)this.cs.getField()[0][7].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)this.cs.getField()[0][6].getChessPiece().toChar(), (long)80);
        this.cs.move(new Point(0, 7), new Point(0, 6));
        Assert.assertEquals((long)this.cs.getField()[0][7].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)this.cs.getField()[0][6].getChessPiece().toChar(), (long)80);
        Assert.assertNull((Object)this.cs.getField()[1][7].getChessPiece());
        Assert.assertEquals((long)this.cs.getField()[0][5].getChessPiece().toChar(), (long)72);
        this.cs.move(new Point(1, 0), new Point(0, 2));
        Assert.assertNull((Object)this.cs.getField()[1][0].getChessPiece());
        Assert.assertEquals((long)this.cs.getField()[0][2].getChessPiece().toChar(), (long)72);
    }

    @Test
    public void moveTest2() {
        Assert.assertEquals((Object)"It's blacks turn", (Object)this.cs.getStatusMessage());
        Assert.assertEquals((long)this.cs.getField()[1][7].getChessPiece().toChar(), (long)72);
        Assert.assertNull((Object)this.cs.getField()[7][4].getChessPiece());
        this.cs.move(new Point(1, 7), new Point(7, 4));
        Assert.assertEquals((long)this.cs.getField()[1][7].getChessPiece().toChar(), (long)72);
        Assert.assertNull((Object)this.cs.getField()[7][4].getChessPiece());
    }

    @Test
    public void KnightTest() {
        Assert.assertEquals((long)this.cs.getField()[1][7].getChessPiece().toChar(), (long)72);
        Assert.assertNull((Object)this.cs.getField()[0][5].getChessPiece());
        this.cs.move(new Point(1, 7), new Point(0, 5));
        Assert.assertEquals((long)this.cs.getField()[0][5].getChessPiece().toChar(), (long)72);
        Assert.assertNull((Object)this.cs.getField()[1][7].getChessPiece());
        this.cs.move(new Point(1, 0), new Point(0, 2));
        Assert.assertTrue((boolean)this.cs.getField()[0][5].getChessPiece().getPosition().equals(new Point(0, 5)));
        this.cs.move(new Point(0, 5), new Point(1, 7));
        Assert.assertEquals((long)this.cs.getField()[1][7].getChessPiece().toChar(), (long)72);
        Assert.assertNull((Object)this.cs.getField()[0][5].getChessPiece());
    }

    @Test
    public void winTest() {
        Assert.assertFalse((boolean)this.cs.checkWin());
        this.cs.getField()[4][0].getChessPiece().kill();
        Assert.assertTrue((boolean)this.cs.checkWin());
        this.cs.getField()[4][7].getChessPiece().kill();
        Assert.assertTrue((boolean)this.cs.checkWin());
    }

    @Test
    public void winTest2() {
        Assert.assertFalse((boolean)this.cs.checkWin());
        this.cs.getField()[4][7].getChessPiece().kill();
        Assert.assertTrue((boolean)this.cs.checkWin());
    }
}

