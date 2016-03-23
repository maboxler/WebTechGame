/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Chesspiece;
import htwg.util.Point;
import java.util.ArrayList;
import java.util.List;

public class Pawn
extends Chesspiece {
    boolean moved = false;
    private List<Point> validMovesList = new ArrayList<Point>();

    public Pawn(int x, int y, char color) {
        super(x, y, color);
    }

    @Override
    public Point[] validMove(int x, int y) {
        if (this.equalPosition(x, y) || this.outRange(x, y) || this.possibleMove(x, y)) {
            return null;
        }
        this.whichDirection(x, y);
        this.moved = true;
        return this.listToArray();
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

    private void whichDirection(int x, int y) {
        if (x == this.x) {
            this.vertical(x, y);
        } else {
            this.diagonal(x, y);
        }
    }

    private void diagonal(int x, int y) {
        if (x < this.x) {
            this.leftUpDiagonal(x);
        } else {
            this.rightUpDiagonal(x);
        }
    }

    private void leftUpDiagonal(int x) {
        int n = 0;
        int i = x;
        while (i >= x) {
            this.validMovesList.add(new Point(this.x - n, this.y + n));
            ++n;
            --i;
        }
    }

    private void rightUpDiagonal(int x) {
        int n = 0;
        int i = this.x;
        while (i <= x) {
            this.validMovesList.add(new Point(this.x + n, this.y + n));
            ++n;
            ++i;
        }
    }

    private boolean equalPosition(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        return false;
    }

    private boolean possibleMove(int x, int y) {
        ArrayList<Point> allMoveList = new ArrayList<Point>();
        Point move = new Point(x, y);
        allMoveList.add(new Point(this.x, this.y + 1));
        allMoveList.add(new Point(this.x + 1, this.y + 1));
        allMoveList.add(new Point(this.x - 1, this.y + 1));
        if (!this.moved) {
            allMoveList.add(new Point(this.x, this.y + 2));
        }
        for (Point point : allMoveList) {
            if (!move.equals(point)) continue;
            return false;
        }
        return true;
    }

    private Point[] listToArray() {
        Point[] pointField = new Point[this.validMovesList.size()];
        int i = 0;
        for (Point point : this.validMovesList) {
            if (i == 0) {
                ++i;
                continue;
            }
            pointField[i - 1] = point;
            ++i;
        }
        this.validMovesList.clear();
        return pointField;
    }

    private void vertical(int x, int y) {
        int i = this.y;
        while (i <= y) {
            this.validMovesList.add(new Point(x, i));
            ++i;
        }
    }

    @Override
    public char toChar() {
        return 'P';
    }
}

