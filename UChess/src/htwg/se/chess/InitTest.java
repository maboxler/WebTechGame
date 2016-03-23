/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.junit.Before
 *  org.junit.Test
 */
package htwg.se.chess;

import htwg.se.chess.Init;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class InitTest {
    Init init;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        System.out.println(new Init().getWTui());
    }
}

