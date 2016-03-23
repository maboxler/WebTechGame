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
import htwg.se.model.Field;
import htwg.se.model.GameField;
import htwg.se.model.Pawn;
import htwg.se.model.Piece;
import htwg.se.model.Queen;
import htwg.se.model.Tower;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GamefieldTest {
    GameField gamefield;

    @Before
    public void setUp() throws Exception {
        this.gamefield = new GameField();
    }

    @Test
    public void inittest() {
        Field[][] field = this.gamefield.getField();
        Assert.assertEquals((long)field[0][0].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)field[0][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[1][0].getChessPiece().toChar(), (long)72);
        Assert.assertEquals((long)field[1][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[2][0].getChessPiece().toChar(), (long)66);
        Assert.assertEquals((long)field[2][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[3][0].getChessPiece().toChar(), (long)81);
        Assert.assertEquals((long)field[3][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[4][0].getChessPiece().toChar(), (long)75);
        Assert.assertEquals((long)field[4][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[5][0].getChessPiece().toChar(), (long)66);
        Assert.assertEquals((long)field[5][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[6][0].getChessPiece().toChar(), (long)72);
        Assert.assertEquals((long)field[6][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[7][0].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)field[7][0].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[7][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[7][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[6][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[6][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[5][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[5][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[4][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[4][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[3][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[3][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[2][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[2][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[1][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[1][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[0][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[0][1].getChessPiece().getcolor(), (long)119);
        Assert.assertEquals((long)field[0][7].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)field[0][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[1][7].getChessPiece().toChar(), (long)72);
        Assert.assertEquals((long)field[1][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[2][7].getChessPiece().toChar(), (long)66);
        Assert.assertEquals((long)field[2][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[3][7].getChessPiece().toChar(), (long)81);
        Assert.assertEquals((long)field[3][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[4][7].getChessPiece().toChar(), (long)75);
        Assert.assertEquals((long)field[4][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[5][7].getChessPiece().toChar(), (long)66);
        Assert.assertEquals((long)field[5][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[6][7].getChessPiece().toChar(), (long)72);
        Assert.assertEquals((long)field[6][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[7][7].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)field[7][7].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[7][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[7][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[6][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[6][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[5][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[5][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[4][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[4][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[3][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[3][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[2][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[2][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[1][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[1][6].getChessPiece().getcolor(), (long)98);
        Assert.assertEquals((long)field[0][6].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[0][6].getChessPiece().getcolor(), (long)98);
    }

    @Test
    public void killtest() {
        Assert.assertFalse((boolean)this.gamefield.beatable(new Queen(1, 1, 'w'), new Pawn(1, 1, 'w')));
        Assert.assertTrue((boolean)this.gamefield.beatable(new Queen(1, 1, 'w'), new Pawn(1, 1, 'b')));
        Field[][] field = this.gamefield.getField();
        Assert.assertEquals((long)field[0][0].getChessPiece().toChar(), (long)84);
        Assert.assertEquals((long)field[0][1].getChessPiece().toChar(), (long)80);
        this.gamefield.moveAfterCheck(new Point(0, 0), new Point(0, 1));
        Assert.assertNull((Object)field[0][0].getChessPiece());
        Assert.assertEquals((long)field[0][1].getChessPiece().toChar(), (long)84);
        this.gamefield.moveAfterCheck(new Point(0, 1), new Point(0, 0));
        Assert.assertNull((Object)field[0][1].getChessPiece());
        Assert.assertEquals((long)field[0][0].getChessPiece().toChar(), (long)84);
    }

    @Test
    public void wintest() {
        Assert.assertFalse((boolean)this.gamefield.whiteWon());
        this.gamefield.getField()[4][7].getChessPiece().kill();
        Assert.assertTrue((boolean)this.gamefield.whiteWon());
        this.gamefield = new GameField();
        Assert.assertFalse((boolean)this.gamefield.blackWon());
        this.gamefield.getField()[4][0].getChessPiece().kill();
        Assert.assertTrue((boolean)this.gamefield.blackWon());
    }

    @Test
    public void movetest() {
        this.gamefield = new GameField();
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 0), new Point(1, 0)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 3), new Point(1, 0)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 0), new Point(3, 0)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(3, 3), new Point(3, 4)));
    }

    @Test
    public void pathtest() {
        Field[][] field = this.gamefield.getField();
        field[0][4].setChessPiece(new Tower(0, 4, 'w'));
        field[7][4].setChessPiece(new Tower(7, 4, 'b'));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(0, 4), new Point(7, 4)));
        field[4][4].setChessPiece(new Tower(4, 4, 'w'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(0, 4), new Point(7, 4)));
        field[7][4].setChessPiece(new Tower(7, 4, 'w'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(4, 4), new Point(7, 4)));
    }

    @Test
    public void pawntest1() {
        Field[][] field = this.gamefield.getField();
        Assert.assertEquals((long)field[1][6].getChessPiece().toChar(), (long)80);
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(0, 4)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(2, 4)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(0, 5)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(2, 5)));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 5)));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 4)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(4, 6)));
        Assert.assertEquals((long)field[1][1].getChessPiece().toChar(), (long)80);
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(0, 2)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(2, 2)));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 2)));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(4, 6)));
        field[0][5].setChessPiece(new Pawn(0, 5, 'b'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(0, 5)));
        field[0][5].setChessPiece(new Pawn(0, 5, 'w'));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(0, 5)));
        field[1][5].setChessPiece(new Pawn(1, 5, 'w'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 5)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 4)));
        field[1][4].setChessPiece(new Pawn(1, 4, 'w'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 4)));
        field[1][5].setChessPiece(null);
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 4)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 7)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 0)));
    }

    @Test
    public void pawntest2() {
        Field[][] field = this.gamefield.getField();
        Assert.assertEquals((long)field[1][6].getChessPiece().toChar(), (long)80);
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(0, 3)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(2, 3)));
        field[1][6].getChessPiece().setmovedTrue();
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 6), new Point(1, 4)));
        field[0][2].setChessPiece(new Pawn(0, 2, 'w'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(0, 2)));
        field[0][2].setChessPiece(new Pawn(0, 2, 'b'));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(0, 2)));
    }

    @Test
    public void whitePawnTest() {
        Field[][] field = this.gamefield.getField();
        Assert.assertEquals((long)field[1][1].getChessPiece().toChar(), (long)80);
        Assert.assertEquals((long)field[1][1].getChessPiece().getcolor(), (long)119);
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 0)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 7)));
        Assert.assertTrue((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 2)));
        field[1][2].setChessPiece(new Pawn(1, 2, 'b'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 2)));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
        field[1][3].setChessPiece(new Pawn(1, 3, 'b'));
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
        field[1][2].setChessPiece(null);
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
        field[1][1].getChessPiece().setmovedTrue();
        Assert.assertFalse((boolean)this.gamefield.moveCheck(new Point(1, 1), new Point(1, 3)));
    }
}

