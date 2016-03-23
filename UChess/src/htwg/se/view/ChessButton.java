/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.view;

import javax.swing.JButton;

public class ChessButton
extends JButton {
    private static final long serialVersionUID = 1;
    int cx;
    int cy;
    String fieldColor;
    String chessPiece;

    public String getChessPiece() {
        return this.chessPiece;
    }

    public void setChessPiece(String chessPiece) {
        this.chessPiece = chessPiece;
    }

    public int getFieldX() {
        return this.cx;
    }

    public void setFieldX(int x) {
        this.cx = x;
    }

    public int getFieldY() {
        return this.cy;
    }

    public void setFieldY(int y) {
        this.cy = y;
    }

    public void setFieldColor(String color) {
        this.fieldColor = color;
    }

    public String getFieldColor() {
        return this.fieldColor;
    }
}

