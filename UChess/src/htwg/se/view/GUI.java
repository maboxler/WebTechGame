/*
 * Decompiled with CFR 0_114.
 */
package htwg.se.view;

import htwg.se.controller.Icontroller;
import htwg.se.model.Chesspiece;
import htwg.se.model.Field;
import htwg.se.view.ChessButton;
import htwg.se.view.UI;
import htwg.util.Event;
import htwg.util.IObserver;
import htwg.util.Point;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI
implements UI,
IObserver,
ActionListener {
    static final Logger log = Logger.getLogger(GUI.class.getName());
    Icontroller controller;
    ChessButton[][] buttons;
    JFrame meinFrame;
    JPanel panel;
    JPanel panelGameField;
    JPanel panelScore;
    Image img;
    boolean firstpressed;
    boolean colorSwap = false;
    Point first;
    JLabel whichTurn;
    JLabel from;
    JLabel target;
    JDialog meinJDialog = new JDialog();
    JPanel panelGameOver = new JPanel();
    JButton buttonExit = new JButton("Beenden");
    JButton buttonReset = new JButton("neustart");

    public GUI(Icontroller cc) {
        this.controller = cc;
        this.controller.addObserver(this);
        this.panel = new JPanel();
        this.panelGameField = new JPanel();
        this.panelScore = new JPanel(new BorderLayout());
        this.panel = new JPanel(new BorderLayout());
        this.panelGameField.setLayout(new GridLayout(8, 8));
        this.whichTurn = new JLabel();
        this.from = new JLabel();
        this.target = new JLabel();
        this.panelScore.add((Component)this.whichTurn, "North");
        this.panelScore.add((Component)this.from, "West");
        this.panelScore.add((Component)this.target, "East");
        this.panel.add((Component)this.panelGameField, "Center");
        this.panel.add((Component)this.panelScore, "North");
        this.buttons = new ChessButton[8][8];
        this.meinFrame = new JFrame("Ultimate Chess");
        this.meinFrame.setDefaultCloseOperation(3);
        this.meinFrame.setSize(900, 900);
        this.meinFrame.add(this.panel);
        this.initField();
        this.drawField();
        this.meinFrame.setVisible(true);
        this.meinFrame.repaint();
    }

    private void initField() {
        int y = 7;
        while (y >= 0) {
            int x = 0;
            while (x < 8) {
                this.buttons[x][y] = new ChessButton();
                this.buttons[x][y].setFieldX(x);
                this.buttons[x][y].setFieldY(y);
                this.buttons[x][y].addActionListener(this);
                this.panelGameField.add(this.buttons[x][y]);
                ++x;
            }
            --y;
        }
    }

    private void drawField() {
        Field[][] field = this.controller.getField();
        String figure = "";
        int y = 7;
        while (y >= 0) {
            int x = 0;
            while (x < 8) {
                this.setButtonColorField(y, x);
                if (field[x][y].getChessPiece() != null) {
                    figure = String.valueOf(figure) + field[x][y].getChessPiece().getcolor();
                    figure = String.valueOf(figure) + field[x][y].getChessPiece().toChar();
                    figure = String.valueOf(figure) + this.buttons[x][y].getFieldColor();
                    figure = String.valueOf(figure) + ".jpg";
                    this.setButtonImage(y, x, figure);
                    figure = "";
                }
                ++x;
            }
            --y;
        }
        this.message(this.controller.getStatusMessage());
    }

    private void setButtonColorField(int y, int x) {
        try {
            this.img = ImageIO.read(this.getClass().getResource(this.whichColorField(x, y)));
            this.buttons[x][y].setIcon(new ImageIcon(this.img));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setButtonImage(int y, int x, String chessPiece) {
        try {
            this.img = ImageIO.read(this.getClass().getResource(chessPiece));
            this.buttons[x][y].setIcon(new ImageIcon(this.img));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String whichColorField(int x, int y) {
        if (x == 0) {
            this.swapColor();
        }
        if (this.colorSwap) {
            this.buttons[x][y].setFieldColor("w");
            this.swapColor();
            return "whiteField.jpg";
        }
        this.swapColor();
        this.buttons[x][y].setFieldColor("b");
        return "blackField.jpg";
    }

    private void swapColor() {
        this.colorSwap = !this.colorSwap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buttonReset) {
            this.restart();
        } else if (e.getSource() == this.buttonExit) {
            System.exit(0);
        }
        Object o = e.getSource();
        ChessButton cbutton = (ChessButton)o;
        this.pressed(cbutton.getFieldX(), cbutton.getFieldY());
    }

    public void winner() {
        this.from.setText("");
        this.target.setText("");
        this.meinFrame.setEnabled(false);
        this.buttonExit.addActionListener(this);
        this.buttonReset.addActionListener(this);
        this.meinJDialog.setTitle("Game Over");
        this.meinJDialog.add(this.panelGameOver);
        this.panelGameOver.add(this.buttonReset);
        this.panelGameOver.add(this.buttonExit);
        this.meinJDialog.setSize(200, 200);
        this.meinJDialog.setModal(true);
        this.meinJDialog.pack();
        this.meinJDialog.setVisible(true);
    }

    public void message(String text) {
        this.whichTurn.setText(text);
    }

    @Override
    public void update(Event e) {
        this.drawField();
        if (this.controller.checkWin()) {
            this.winner();
        }
    }

    @Override
    public void restart() {
        this.controller.reset();
        this.meinFrame.setEnabled(true);
        this.drawField();
    }

    @Override
    public void pressed(int x, int y) {
        if (this.firstpressed && new Point(x, y) != this.first) {
            this.from.setText("FROM x:" + x + " y: " + y);
            this.controller.move(this.first, new Point(x, y));
            this.firstpressed = false;
            return;
        }
        this.first = new Point(x, y);
        this.target.setText("TARGET x:" + x + " y: " + y);
        this.firstpressed = true;
    }
}

