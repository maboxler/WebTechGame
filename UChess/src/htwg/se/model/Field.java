/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Chesspiece;
import htwg.util.Point;

public class Field {
    private Point position;
    private Chesspiece c;

    public Field(Point p) {
        this.position = p;
        this.c = null;
    }

    public Field(Point p, Chesspiece c) {
        this.position = p;
        this.c = c;
    }

    public Point getFieldCoordinates() {
        return this.position;
    }

    public Chesspiece getChessPiece() {
        return this.c;
    }

    public void setChessPiece(Chesspiece c) {
        this.c = c;
    }
}

