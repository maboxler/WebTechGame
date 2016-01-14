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

	ArrayList<String> figures = new ArrayList<String>();
	String bgColor = "w";
	Map<String, String> m1 = new LinkedHashMap<String, String>();
	List<LinkedHashMap> l1 = new LinkedList<LinkedHashMap>();

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
		
		int count1=0,count2=0;
		
		testAusgabe = this.createXCoordinates(testAusgabe);
		figures.clear();
		for (int y = 7; y >= 0; --y) {
			testAusgabe = createYCoordinates(testAusgabe, y);

			testAusgabe += "|";
			for (int x = 0; x <= 7; ++x) {

				if (field[x][y].getChessPiece() != null) {
					testAusgabe += field[x][y].getChessPiece().getcolor();
					testAusgabe += field[x][y].getChessPiece().toChar();
					jsonArrayBuilder(field, y, x, false);
					count1++;

					if (x != 7) {
						changeColor();
					}

				} else {
					testAusgabe += "  ";
					jsonArrayBuilder(field, y, x, true);
					count2++;
					if (x != 7) {
						changeColor();
					}
				}
				testAusgabe += "|";
			}

			feld += testAusgabe + "\n";
			testAusgabe = "";
			
		}
		
		System.out.println("count1: " + count1);
		System.out.println("count2: " + count2);
		
		message(feld);
		message(controller.getStatusMessage());

		feld = feld.replaceAll("\n", "<br>");

		return feld;
	}

	private void changeColor() {
		if (bgColor == "w") {
			bgColor = "b";
		} else
			bgColor = "w";
	}

	public String getFigures() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":\"field\",\"figures\" : [");
		for (int i = 0; i < figures.size(); i++) {
			sb.append(figures.get(i));
			if (i < figures.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]}");
		System.out.println(sb.toString());
		return sb.toString();
	}

	private void jsonArrayBuilder(Field[][] field, int y, int x, boolean leer) {

		if(!leer){
			figures.add("{\"figure\":\"" + field[x][y].getChessPiece().toChar() + "\", \"color\":\""
					+ field[x][y].getChessPiece().getcolor() + "\", \"bg\":\"" + bgColor + "\"," + "\"pos\":\"" + x + y
					+ "\"}");
		}
		else {
			figures.add("{\"figure\":\"" + "x" + "\", \"color\":\""
					+ "x" + "\", \"bg\":\"" + bgColor + "\"," + "\"pos\":\"" + x + y
					+ "\"}");
		}
		
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
