/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.model;

import htwg.se.model.Bishop;
import htwg.se.model.Chesspiece;
import htwg.se.model.Field;
import htwg.se.model.King;
import htwg.se.model.Knight;
import htwg.se.model.Pawn;
import htwg.se.model.Piece;
import htwg.se.model.Queen;
import htwg.se.model.Tower;
import htwg.util.Point;

public class GameField {
    private Pawn[] blackPawns;
    private Pawn[] whitePawns;
    private Tower[] blackTowers;
    private Tower[] whiteTowers;
    private Knight[] blackKnights;
    private Knight[] whiteKnights;
    private Bishop[] blackBishops;
    private Bishop[] whiteBishops;
    private Queen blackQueen;
    private Queen whiteQueen;
    private King blackKing;
    private King whiteKing;
    private Field[][] field = new Field[8][8];

    public GameField() {
        this.initField();
        this.blackPawns = new Pawn[8];
        this.whitePawns = new Pawn[8];
        this.blackTowers = new Tower[2];
        this.whiteTowers = new Tower[2];
        this.blackKnights = new Knight[2];
        this.whiteKnights = new Knight[2];
        this.blackBishops = new Bishop[2];
        this.whiteBishops = new Bishop[2];
        this.initWhitePawns();
        this.initBlackPawns();
        this.initTowers();
        this.initKnights();
        this.initBishops();
        this.intiKings();
        this.initQueens();
    }

    private void initField() {
        int x = 0;
        while (x < 8) {
            int y = 0;
            while (y < 8) {
                this.field[x][y] = new Field(new Point(x, y));
                ++y;
            }
            ++x;
        }
    }

    private void initWhitePawns() {
        int x = 0;
        int y = 1;
        Pawn[] arrpawn = this.whitePawns;
        int n = arrpawn.length;
        int n2 = 0;
        while (n2 < n) {
            Pawn pawn = arrpawn[n2];
            pawn = new Pawn(x, y, 'w');
            this.field[x][y] = new Field(new Point(x, y), pawn);
            ++x;
            ++n2;
        }
    }

    private void initBlackPawns() {
        int x = 0;
        int y = 6;
        Pawn[] arrpawn = this.blackPawns;
        int n = arrpawn.length;
        int n2 = 0;
        while (n2 < n) {
            Pawn pawn = arrpawn[n2];
            pawn = new Pawn(x, y, 'b');
            this.field[x][y] = new Field(new Point(x, y), pawn);
            ++x;
            ++n2;
        }
    }

    private void initTowers() {
        this.whiteTowers[0] = new Tower(0, 0, 'w');
        this.field[0][0] = new Field(new Point(0, 0), this.whiteTowers[0]);
        this.whiteTowers[1] = new Tower(7, 0, 'w');
        this.field[7][0] = new Field(new Point(7, 0), this.whiteTowers[1]);
        this.blackTowers[0] = new Tower(0, 7, 'b');
        this.field[0][7] = new Field(new Point(0, 7), this.blackTowers[0]);
        this.blackTowers[1] = new Tower(7, 7, 'b');
        this.field[7][7] = new Field(new Point(7, 7), this.blackTowers[1]);
    }

    private void initKnights() {
        this.whiteKnights[0] = new Knight(1, 0, 'w');
        this.field[1][0] = new Field(new Point(1, 0), this.whiteKnights[0]);
        this.whiteKnights[1] = new Knight(6, 0, 'w');
        this.field[6][0] = new Field(new Point(6, 0), this.whiteKnights[1]);
        this.blackKnights[0] = new Knight(1, 7, 'b');
        this.field[1][7] = new Field(new Point(1, 7), this.blackKnights[0]);
        this.blackKnights[1] = new Knight(6, 7, 'b');
        this.field[6][7] = new Field(new Point(6, 7), this.blackKnights[1]);
    }

    private void initBishops() {
        this.whiteBishops[0] = new Bishop(2, 0, 'w');
        this.field[2][0] = new Field(new Point(2, 0), this.whiteBishops[0]);
        this.whiteBishops[1] = new Bishop(5, 0, 'w');
        this.field[5][0] = new Field(new Point(5, 0), this.whiteBishops[1]);
        this.blackBishops[0] = new Bishop(2, 7, 'b');
        this.field[2][7] = new Field(new Point(2, 7), this.blackBishops[0]);
        this.blackBishops[1] = new Bishop(5, 7, 'b');
        this.field[5][7] = new Field(new Point(5, 7), this.blackBishops[1]);
    }

    private void initQueens() {
        this.whiteQueen = new Queen(3, 0, 'w');
        this.field[3][0] = new Field(new Point(3, 0), this.whiteQueen);
        this.blackQueen = new Queen(3, 7, 'b');
        this.field[3][7] = new Field(new Point(3, 7), this.blackQueen);
    }

    private void intiKings() {
        this.whiteKing = new King(4, 0, 'w');
        this.field[4][0] = new Field(new Point(4, 0), this.whiteKing);
        this.blackKing = new King(4, 7, 'b');
        this.field[4][7] = new Field(new Point(4, 7), this.blackKing);
    }

    public Field[][] getField() {
        return this.field;
    }

    public boolean moveCheck(Point from, Point to) {
        Chesspiece figure = this.field[from.getX()][from.getY()].getChessPiece();
        if (figure == null) {
            return false;
        }
        return this.checkPawn(figure, to);
    }

    private boolean checkPawn(Piece figure, Point to) {
        if (figure.toChar() == 'P') {
            return this.pawnColorRoutine(figure, to);
        }
        return this.checkValid(figure, to);
    }

    private boolean pawnColorRoutine(Piece p, Point to) {
        if (p.getcolor() == 'w') {
            return this.whitepawnRoutine(p, to);
        }
        return this.blackpawnRoutine(p, to);
    }

    private boolean blackpawnRoutine(Piece p, Point to) {
        if (to.getX() + 1 == p.getPosition().getX() && to.getY() == p.getPosition().getY() - 1) {
            return this.pawnDiagonal(p, to);
        }
        if (to.getX() - 1 == p.getPosition().getX() && to.getY() == p.getPosition().getY() - 1) {
            return this.pawnDiagonal(p, to);
        }
        if (to.getX() == p.getPosition().getX()) {
            return this.blackPawnMoveFront(p, to);
        }
        return false;
    }

    private boolean blackPawnMoveFront(Piece p, Point to) {
        if (to.getY() >= p.getPosition().getY() - 2 && to.getY() < p.getPosition().getY()) {
            return this.blackPawnOneOrTwo(p, to);
        }
        return false;
    }

    private boolean blackPawnOneOrTwo(Piece p, Point to) {
        if (p.getPosition().getY() - 2 == to.getY()) {
            return this.blackPawnTwo(p, to);
        }
        return this.blackPawnOne(p, to);
    }

    private boolean blackPawnOne(Piece p, Point to) {
        if (this.field[to.getX()][to.getY()].getChessPiece() == null) {
            return true;
        }
        return false;
    }

    private boolean blackPawnTwo(Piece p, Point to) {
        if (p.getMoved()) {
            return false;
        }
        return this.blackPawnPathTwo(p, to);
    }

    private boolean blackPawnPathTwo(Piece p, Point to) {
        Field stepOne = this.field[to.getX()][to.getY() + 1];
        Field stepTwo = this.field[to.getX()][to.getY()];
        if (stepTwo.getChessPiece() == null && stepOne.getChessPiece() == null) {
            return true;
        }
        return false;
    }

    private boolean whitepawnRoutine(Piece p, Point to) {
        if (to.getX() + 1 == p.getPosition().getX() && to.getY() == p.getPosition().getY() + 1) {
            return this.pawnDiagonal(p, to);
        }
        if (to.getX() - 1 == p.getPosition().getX() && to.getY() == p.getPosition().getY() + 1) {
            return this.pawnDiagonal(p, to);
        }
        if (to.getX() == p.getPosition().getX()) {
            return this.pawnMoveFront(p, to);
        }
        return false;
    }

    private boolean pawnDiagonal(Piece p, Point to) {
        if (this.field[to.getX()][to.getY()].getChessPiece() != null) {
            return this.pawnColorCheck(p.getcolor(), this.field[to.getX()][to.getY()].getChessPiece().getcolor());
        }
        return false;
    }

    private boolean pawnMoveFront(Piece p, Point to) {
        if (to.getY() <= p.getPosition().getY() + 2 && to.getY() > p.getPosition().getY()) {
            return this.pawnOneOrTwoSteps(p, to);
        }
        return false;
    }

    private boolean pawnOneOrTwoSteps(Piece p, Point to) {
        if (p.getPosition().getY() + 1 == to.getY()) {
            return this.pawnOneStep(p, to);
        }
        return this.pawnTwoStep(p, to);
    }

    private boolean pawnOneStep(Piece p, Point to) {
        if (this.field[to.getX()][to.getY()].getChessPiece() == null) {
            return true;
        }
        return false;
    }

    private boolean pawnTwoStep(Piece p, Point to) {
        if (p.getMoved()) {
            return false;
        }
        return this.pawnClearPath(p, to);
    }

    private boolean pawnClearPath(Piece p, Point to) {
        Field stepOne = this.field[p.getPosition().getX()][p.getPosition().getY() + 1];
        Field stepTwo = this.field[p.getPosition().getX()][p.getPosition().getY() + 2];
        if (stepOne.getChessPiece() == null && stepTwo.getChessPiece() == null) {
            return true;
        }
        return false;
    }

    private boolean pawnColorCheck(char piece, char target) {
        if (piece != target) {
            return true;
        }
        return false;
    }

    private boolean checkValid(Piece figure, Point to) {
        Point[] path = figure.validMove(to.getX(), to.getY());
        if (path == null) {
            return false;
        }
        return this.checkPath(figure, path);
    }

    private boolean checkPath(Piece figure, Point[] path) {
        int index = -1;
        int i = 0;
        while (i < path.length - 2) {
            index = i;
            if (this.field[path[i].getX()][path[i].getY()].getChessPiece() != null) {
                return false;
            }
            ++i;
        }
        return this.checkGoal(path[index + 1], figure);
    }

    private boolean checkGoal(Point goal, Piece figure) {
        Field goalfield = this.field[goal.getX()][goal.getY()];
        if (goalfield.getChessPiece() == null) {
            return true;
        }
        return this.beatable(goalfield.getChessPiece(), figure);
    }

    public boolean beatable(Piece target, Piece figure) {
        if (target.getcolor() != figure.getcolor()) {
            return true;
        }
        return false;
    }

    public boolean whiteWon() {
        if (this.blackKing.alive) {
            return false;
        }
        return true;
    }

    public boolean blackWon() {
        if (this.whiteKing.alive) {
            return false;
        }
        return true;
    }

    public void moveAfterCheck(Point from, Point to) {
        Field targetField = this.field[to.getX()][to.getY()];
        Field fromField = this.field[from.getX()][from.getY()];
        Chesspiece cp = fromField.getChessPiece();
        if (targetField.getChessPiece() != null) {
            targetField.getChessPiece().kill();
        }
        cp.setPosition(to);
        cp.setmovedTrue();
        targetField.setChessPiece(cp);
        fromField.setChessPiece(null);
    }
}

