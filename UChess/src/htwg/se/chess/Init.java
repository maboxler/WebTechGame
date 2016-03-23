/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.google.inject.Guice
 *  com.google.inject.Injector
 *  com.google.inject.Module
 */
package htwg.se.chess;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import htwg.se.chess.ChessModule;
import htwg.se.controller.Icontroller;
import htwg.se.model.GameField;
import htwg.se.view.GUI;
import htwg.se.view.TUI;
import htwg.util.Event;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Init {
    private static Init instance;
    private TUI tui;
    private GUI gui;
    private Injector injector = Guice.createInjector((Module[])new Module[]{new ChessModule()});
    private Icontroller cc = (Icontroller)this.injector.getInstance((Class)Icontroller.class);
    private Scanner scanner;

    public Init() {
        this.tui = new TUI(this.cc);
        new htwg.se.model.GameField();
        this.scanner = new Scanner(System.in);
        System.out.println("erstes" + this.tui.getFigures());
        System.out.println("zweites" + this.tui.getFigures());
        this.tui.update(null);
    }

    public TUI getTui() {
        return this.tui;
    }

    public GUI getGui() {
        return this.gui;
    }

    public Icontroller getCc() {
        return this.cc;
    }

    public static void main(String[] args) {
        new htwg.se.chess.Init();
    }

    public String getWTui() {
        return this.tui.getWtui();
    }
}

