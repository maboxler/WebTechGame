/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Assert
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.view;

import htwg.se.controller.ChessController;
import htwg.se.controller.Icontroller;
import htwg.se.model.GameField;
import htwg.se.view.TUI;
import htwg.util.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TUITest {
    TUI tui;

    @Before
    public void setUp() throws Exception {
        GameField gf = new GameField();
        ChessController cs = new ChessController(gf);
        this.tui = new TUI(cs);
    }

    @Test
    public void test() {
        this.tui.update(null);
        this.tui.restart();
        this.tui.message("start");
        Assert.assertTrue((boolean)this.tui.processInputLine("00 01"));
        Assert.assertFalse((boolean)this.tui.processInputLine(" "));
        Assert.assertFalse((boolean)this.tui.processInputLine("kshdfkjbfhjbfjd"));
    }
}

