/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.view;

import htwg.se.controller.Icontroller;
import htwg.se.model.Chesspiece;
import htwg.se.model.Field;
import htwg.se.view.UI;
import htwg.util.Event;
import htwg.util.IObserver;
import htwg.util.Point;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class TUI
implements UI,
IObserver {
    static final Logger log = Logger.getLogger(TUI.class.getName());
    Icontroller controller;
    boolean firstpressed;
    Point first;
    ArrayList<String> figures = new ArrayList();
    String bgColor = "w";
    Map<String, String> m1 = new LinkedHashMap<String, String>();
    List<LinkedHashMap> l1 = new LinkedList<LinkedHashMap>();

    public TUI(Icontroller controller) {
        this.controller = controller;
        this.firstpressed = false;
        this.first = null;
        controller.addObserver(this);
    }

    public Icontroller getTuiController() {
        return this.controller;
    }

    public String printUI() {
        Field[][] field = this.controller.getField();
        String testAusgabe = "";
        String feld = "";
        int count1 = 0;
        int count2 = 0;
        testAusgabe = this.createXCoordinates(testAusgabe);
        this.figures.clear();
        int y = 7;
        while (y >= 0) {
            testAusgabe = this.createYCoordinates(testAusgabe, y);
            testAusgabe = String.valueOf(testAusgabe) + "|";
            int x = 0;
            while (x <= 7) {
                if (field[x][y].getChessPiece() != null) {
                    testAusgabe = String.valueOf(testAusgabe) + field[x][y].getChessPiece().getcolor();
                    testAusgabe = String.valueOf(testAusgabe) + field[x][y].getChessPiece().toChar();
                    this.jsonArrayBuilder(field, y, x, false);
                    ++count1;
                    if (x != 7) {
                        this.changeColor();
                    }
                } else {
                    testAusgabe = String.valueOf(testAusgabe) + "  ";
                    this.jsonArrayBuilder(field, y, x, true);
                    ++count2;
                    if (x != 7) {
                        this.changeColor();
                    }
                }
                testAusgabe = String.valueOf(testAusgabe) + "|";
                ++x;
            }
            feld = String.valueOf(feld) + testAusgabe + "\n";
            testAusgabe = "";
            --y;
        }
        System.out.println("count1: " + count1);
        System.out.println("count2: " + count2);
        this.message(feld);
        this.message(this.controller.getStatusMessage());
        feld = feld.replaceAll("\n", "<br>");
        return feld;
    }

    private void changeColor() {
        this.bgColor = this.bgColor == "w" ? "b" : "w";
    }

    public String getFigures() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"type\":\"field\",\"figures\" : [");
        int i = 0;
        while (i < this.figures.size()) {
            sb.append(this.figures.get(i));
            if (i < this.figures.size() - 1) {
                sb.append(",");
            }
            ++i;
        }
        sb.append("]}");
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void jsonArrayBuilder(Field[][] field, int y, int x, boolean leer) {
        if (!leer) {
            this.figures.add("{\"figure\":\"" + field[x][y].getChessPiece().toChar() + "\", \"color\":\"" + field[x][y].getChessPiece().getcolor() + "\", \"bg\":\"" + this.bgColor + "\"," + "\"pos\":\"" + x + y + "\"}");
        } else {
            this.figures.add("{\"figure\":\"x\", \"color\":\"x\", \"bg\":\"" + this.bgColor + "\"," + "\"pos\":\"" + x + y + "\"}");
        }
    }

    private String createYCoordinates(String testAusgabe, int y) {
        testAusgabe = String.valueOf(testAusgabe) + y;
        return testAusgabe;
    }

    private String createXCoordinates(String field) {
        int xx = 0;
        while (xx <= 7) {
            field = String.valueOf(field) + "  " + xx;
            ++xx;
        }
        field = String.valueOf(field) + "\n";
        return field;
    }

    @Override
    public void restart() {
        this.controller.reset();
    }

    public boolean processInputLine(String line) {
        if (line.matches("[0-7][0-7] [0-7][0-7]")) {
            this.pressed(line.charAt(0) - 48, line.charAt(1) - 48);
            this.pressed(line.charAt(3) - 48, line.charAt(4) - 48);
            return true;
        }
        return false;
    }

    @Override
    public void pressed(int x, int y) {
        if (this.firstpressed) {
            this.controller.move(this.first, new Point(x, y));
            this.firstpressed = false;
            return;
        }
        this.first = new Point(x, y);
        this.firstpressed = true;
    }

    public void message(String text) {
        log.info("\n" + text);
    }

    @Override
    public void update(Event e) {
        this.printUI();
        if (this.controller.checkWin()) {
            this.message("GAME OVER");
        }
    }

    public String getWtui() {
        Field[][] field = this.controller.getField();
        String testAusgabe = "";
        String feld = "";
        testAusgabe = this.createXCoordinates(testAusgabe);
        int y = 7;
        while (y >= 0) {
            testAusgabe = this.createYCoordinates(testAusgabe, y);
            testAusgabe = String.valueOf(testAusgabe) + "|";
            int x = 0;
            while (x <= 7) {
                if (field[x][y].getChessPiece() != null) {
                    testAusgabe = String.valueOf(testAusgabe) + field[x][y].getChessPiece().getcolor();
                    testAusgabe = String.valueOf(testAusgabe) + field[x][y].getChessPiece().toChar();
                } else {
                    testAusgabe = String.valueOf(testAusgabe) + "  ";
                }
                testAusgabe = String.valueOf(testAusgabe) + "|";
                ++x;
            }
            feld = String.valueOf(feld) + testAusgabe + "\n";
            testAusgabe = "";
            --y;
        }
        feld = feld.replaceAll("\n", "<br>");
        return feld;
    }
}

