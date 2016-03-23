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
import htwg.se.model.Pawn;
import htwg.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {
    Field testfield;

    @Before
    public void setUp() throws Exception {
        this.testfield = new Field(new Point(1, 1));
    }

    @Test
    public void test() {
        Assert.assertEquals((Object)this.testfield.getChessPiece(), (Object)null);
        Assert.assertNull((Object)this.testfield.getChessPiece());
        this.testfield = new Field(new Point(1, 1), null);
        Assert.assertEquals((Object)this.testfield.getChessPiece(), (Object)null);
        Assert.assertEquals((Object)this.testfield.getFieldCoordinates().equals(new Point(1, 1)), (Object)true);
        Pawn pawn = new Pawn(1, 1, 'w');
        this.testfield.setChessPiece(pawn);
        Assert.assertEquals((Object)this.testfield.getChessPiece(), (Object)pawn);
    }
}

