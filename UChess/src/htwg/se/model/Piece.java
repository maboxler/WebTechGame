/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.util.Point;

public interface Piece {
    public Point getPosition();

    public char getcolor();

    public void setPosition(Point var1);

    public Point[] validMove(int var1, int var2);

    public char toChar();

    public boolean getMoved();
}

