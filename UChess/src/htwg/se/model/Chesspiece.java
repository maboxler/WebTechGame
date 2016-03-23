/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Piece;
import htwg.util.Point;

public abstract class Chesspiece
implements Piece {
    protected int x;
    protected int y;
    protected char color;
    protected boolean moved;
    protected boolean alive;

    @Override
    public Point getPosition() {
        return new Point(this.x, this.y);
    }

    @Override
    public boolean getMoved() {
        return this.moved;
    }

    @Override
    public char getcolor() {
        return this.color;
    }

    public void setmovedTrue() {
        this.moved = true;
    }

    @Override
    public void setPosition(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public void kill() {
        this.alive = false;
        this.setPosition(new Point(-1, -1));
    }

    public Chesspiece(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.moved = false;
        this.alive = true;
    }

    @Override
    public abstract Point[] validMove(int var1, int var2);

    @Override
    public abstract char toChar();
}

