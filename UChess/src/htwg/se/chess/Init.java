package htwg.se.chess;

import java.util.Scanner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import htwg.se.controller.Icontroller;
import htwg.se.model.*;
import htwg.se.view.GUI;
import htwg.se.view.TUI;



public class Init {
	
	
	private static  Init instance;
	private  TUI tui;
	private  GUI gui;
	private  Injector injector;
	private  Icontroller cc;
	private  Scanner scanner;
	
	public Init() {

		// Set up Google Guice Dependency Injector
				injector = Guice.createInjector(new ChessModule());
				
				// Build up the application, resolving dependencies automatically by Guice
				cc = injector.getInstance(Icontroller.class);	
				
				tui = new TUI(cc);
				//gui = new GUI(cc);	
				
				new GameField();
			
				//ChessController cc = new ChessController(gameField);
				scanner = new Scanner(System.in);

				tui.update(null);
				//tui.getFigures();
	}
		
	public TUI getTui() {
		return tui;
	}

	public GUI getGui() {
		return gui;
	}

	public Icontroller getCc() {
		return cc;
	}

	public static void main(String[] args) {
		new Init();
	}

	public String getWTui() {
		return tui.getWtui();
	}
}
