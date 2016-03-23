/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Chesspiece;
import htwg.util.Point;
import java.util.ArrayList;
import java.util.List;

public class Knight
extends Chesspiece {
    private List<Point> validMovesList = new ArrayList<Point>();

    public Knight(int x, int y, char color) {
        super(x, y, color);
    }

    @Override
    public Point[] validMove(int x, int y) {
        if (this.equalPosition(x, y) || this.outRange(x, y) || this.tMove(x, y)) {
            return null;
        }
        return this.listToArray();
    }

    private boolean tMove(int x, int y) {
        ArrayList<Point> allMoveList = new ArrayList<Point>();
        Point move = new Point(x, y);
        allMoveList.add(new Point(this.x + 1, this.y + 2));
        allMoveList.add(new Point(this.x - 1, this.y + 2));
        allMoveList.add(new Point(this.x + 1, this.y - 2));
        allMoveList.add(new Point(this.x - 1, this.y - 2));
        allMoveList.add(new Point(this.x + 2, this.y + 1));
        allMoveList.add(new Point(this.x + 2, this.y - 1));
        allMoveList.add(new Point(this.x - 2, this.y + 1));
        allMoveList.add(new Point(this.x - 2, this.y - 1));
        for (Point point : allMoveList) {
            if (!move.equals(point)) continue;
            this.validMovesList.add(move);
            return false;
        }
        return true;
    }

    private boolean outRange(int x, int y) {
        if (x >= 8 || x < 0) {
            return true;
        }
        if (y >= 8 || y < 0) {
            return true;
        }
        return false;
    }

    private boolean equalPosition(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        return false;
    }

    private Point[] listToArray() {
        Point[] pointField = new Point[this.validMovesList.size()];
        int i = 0;
        pointField[i] = this.validMovesList.get(i);
        this.validMovesList.clear();
        return pointField;
    }

    @Override
    public char toChar() {
        return 'H';
    }
}

