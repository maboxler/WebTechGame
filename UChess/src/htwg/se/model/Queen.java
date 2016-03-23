/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Chesspiece;
import htwg.util.Point;
import java.util.ArrayList;
import java.util.List;

public class Queen
extends Chesspiece {
    private List<Point> validMovesList = new ArrayList<Point>();

    public Queen(int x, int y, char color) {
        super(x, y, color);
    }

    @Override
    public Point[] validMove(int x, int y) {
        if (this.equalPosition(x, y) || this.outRange(x, y)) {
            return null;
        }
        this.whichDirection(x, y);
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
        if (x != this.x && y == this.y) {
            this.horizontal(x, y);
        } else if (x == this.x) {
            this.vertical(x, y);
        } else {
            this.diagonal(x, y);
        }
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

    private void horizontal(int x, int y) {
        if (this.x < x) {
            this.rightHorizontal(x, y);
        } else {
            this.leftHorizontal(x, y);
        }
    }

    private void leftHorizontal(int x, int y) {
        int i = this.x;
        while (i >= x) {
            this.validMovesList.add(new Point(i, y));
            --i;
        }
    }

    private void rightHorizontal(int x, int y) {
        int i = this.x;
        while (i <= x) {
            this.validMovesList.add(new Point(i, y));
            ++i;
        }
    }

    private void vertical(int x, int y) {
        if (this.y < y) {
            this.upVertical(x, y);
        } else {
            this.downVertical(x, y);
        }
    }

    private void upVertical(int x, int y) {
        int i = this.y;
        while (i <= y) {
            this.validMovesList.add(new Point(x, i));
            ++i;
        }
    }

    private void downVertical(int x, int y) {
        int i = this.y;
        while (i >= y) {
            this.validMovesList.add(new Point(x, i));
            --i;
        }
    }

    private void diagonal(int x, int y) {
        if (this.y < y) {
            this.upDiagonal(x, y);
        } else {
            this.downDiagonal(x, y);
        }
    }

    private void upDiagonal(int x, int y) {
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

    private void downDiagonal(int x, int y) {
        if (x < this.x) {
            this.leftDownDiagonal(y);
        } else {
            this.rightDownDiagonal(x);
        }
    }

    private void leftDownDiagonal(int x) {
        int n = 0;
        int i = this.x;
        while (i >= x) {
            this.validMovesList.add(new Point(this.x - n, this.y - n));
            ++n;
            --i;
        }
    }

    private void rightDownDiagonal(int x) {
        int n = 0;
        int i = this.x;
        while (i <= x) {
            this.validMovesList.add(new Point(this.x + n, this.y - n));
            ++n;
            ++i;
        }
    }

    @Override
    public char toChar() {
        return 'Q';
    }
}

