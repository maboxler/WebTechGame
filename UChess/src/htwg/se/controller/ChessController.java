/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.google.inject.Inject
 */
package htwg.se.controller;

import com.google.inject.Inject;
import htwg.se.controller.Icontroller;
import htwg.se.model.Chesspiece;
import htwg.se.model.Field;
import htwg.se.model.GameField;
import htwg.util.Observable;
import htwg.util.Point;

public class ChessController
extends Observable
implements Icontroller {
    private GameField gamefield;
    private boolean blackturn;

    @Inject
    public ChessController(GameField gamefield) {
        this.gamefield = gamefield;
        this.blackturn = true;
    }

    @Override
    public Field[][] getField() {
        return this.gamefield.getField();
    }

    @Override
    public String getStatusMessage() {
        if (this.blackturn) {
            return "black";
        }
        return "white";
    }

    @Override
    public void move(Point start, Point goal) {
        if (this.checkTurn(start) && this.gamefield.moveCheck(start, goal)) {
            this.gamefield.moveAfterCheck(start, goal);
            this.blackturn = !this.blackturn;
        }
        this.notifyObservers();
    }

    private boolean checkTurn(Point start) {
        Field[][] field = this.gamefield.getField();
        Chesspiece piece = field[start.getX()][start.getY()].getChessPiece();
        if (piece == null) {
            return false;
        }
        return this.colorCheck(piece);
    }

    @Override
    public void reset() {
        this.gamefield = new GameField();
        this.blackturn = true;
        this.notifyObservers();
    }

    private boolean colorCheck(Chesspiece piece) {
        if (this.blackturn) {
            if (piece.getcolor() == 'b') {
                return true;
            }
            return false;
        }
        if (piece.getcolor() == 'w') {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWin() {
        if (!this.gamefield.blackWon() && !this.gamefield.whiteWon()) {
            return false;
        }
        return true;
    }

    @Override
    public String getWinner() {
        if (this.checkWin()) {
            if (this.gamefield.blackWon()) {
                return "black";
            }
            if (this.gamefield.whiteWon()) {
                return "white";
            }
        }
        return "NONE";
    }
}

