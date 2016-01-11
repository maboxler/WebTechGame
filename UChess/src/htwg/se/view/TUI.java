package htwg.se.view;

import htwg.se.controller.Icontroller;
import htwg.se.model.Field;
import htwg.util.Event;
import htwg.util.IObserver;
import htwg.util.Point;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class TUI implements UI, IObserver {
	static final Logger log = Logger.getLogger(TUI.class.getName());

	Icontroller controller;
	boolean firstpressed;
	Point first;		

	ArrayList figures = new ArrayList<String>();
	 
	  Map<String, String> m1 = new LinkedHashMap<String, String>();
	  List<LinkedHashMap>  l1 = new LinkedList<LinkedHashMap>();
	
	public TUI(Icontroller controller) {
		this.controller = controller;
		firstpressed = false;
		first = null;
		controller.addObserver(this);
	}
	
	public Icontroller getTuiController() {	
		return controller;
	}

	public String printUI() {
		Field field[][] = controller.getField();
		String testAusgabe = "";
		String feld = "";

		testAusgabe = this.createXCoordinates(testAusgabe);
		for (int y = 7; y >= 0; --y) {
			testAusgabe = createYCoordinates(testAusgabe, y);
			
			testAusgabe += "|";
			for (int x = 0; x <= 7; ++x) {
				if (field[x][y].getChessPiece() != null) {
					testAusgabe += field[x][y].getChessPiece().getcolor();
					testAusgabe += field[x][y].getChessPiece().toChar();

					jsonArrayBuilder(field, y, x);
					
				} else {
					testAusgabe += "  ";
				}
				testAusgabe += "|";
			}

			feld += testAusgabe + "\n";
			testAusgabe = "";
		}
		message(feld);
		message(controller.getStatusMessage());
		
		feld = feld.replaceAll("\n", "<br>"); 
		
		
		// System.out.println(figures);
		
		
		
		return feld;
	}

	public String getFigures() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":\"field\",\"figures\" : [");
		for(int i = 0; i < figures.size(); i++){
			sb.append(figures.get(i));
			if(i < figures.size() - 1){
				sb.append(",");
			}
		}
		sb.append("]}");
		figures.clear();
		System.out.println(sb.toString());
		return sb.toString();
	}

	private void jsonArrayBuilder(Field[][] field, int y, int x) {
		
		figures.add("{\"figure\":\"" + field[x][y].getChessPiece().toChar() + "\", \"color\":\"" + field[x][y].getChessPiece().getcolor() + "\", \"bg\":\"w\"," + "\"pos\":\""+x + y + "\"}");
		
//		m1.put("figure",""+field[x][y].getChessPiece().toChar());		  
//		m1.put("color",""+field[x][y].getChessPiece().getcolor());		  
//		m1.put("bg", "w"); 	
//		m1.put("pos", ""+x+""+y);
//		figures.add(m1);
	}	

	private String createYCoordinates(String testAusgabe, int y) {
		testAusgabe += y + "";
		return testAusgabe;
	}

	private String createXCoordinates(String field) {
		for (int xx = 0; xx <= 7; ++xx) {
			field += "  " + xx;
		}
		field += "\n";

		return field;
	}

	@Override
	public void restart() {
		controller.reset();
	}

	public boolean processInputLine(String line) {
		if (line.matches("[0-7][0-7] [0-7][0-7]")) {
			pressed((int) line.charAt(0) - 48, (int) line.charAt(1) - 48);
			pressed((int) line.charAt(3) - 48, (int) line.charAt(4) - 48);
			return true;
		}
		return false;
	}

	@Override
	public void pressed(int x, int y) {
		if (firstpressed) {
			controller.move(first, new Point(x, y));
			firstpressed = false;
			return;
		}
		first = new Point(x, y);
		firstpressed = true;

	}

	public void message(String text) {
		log.info("\n" + text);

	}

	@Override
	public void update(Event e) {
		printUI();
		if (controller.checkWin())
			message("GAME OVER");
	}

	public String getWtui() {
		Field field[][] = controller.getField();
		String testAusgabe = "";
		String feld = "";

		testAusgabe = this.createXCoordinates(testAusgabe);
		for (int y = 7; y >= 0; --y) {
			testAusgabe = createYCoordinates(testAusgabe, y);
			
			testAusgabe += "|";
			for (int x = 0; x <= 7; ++x) {
				if (field[x][y].getChessPiece() != null) {
					testAusgabe += field[x][y].getChessPiece().getcolor();
					testAusgabe += field[x][y].getChessPiece().toChar();
				} else {
					testAusgabe += "  ";
				}
				testAusgabe += "|";
			}

			feld += testAusgabe + "\n";
			testAusgabe = "";
		}
		
		feld = feld.replaceAll("\n", "<br>"); 
		
		return feld;
	}

}
