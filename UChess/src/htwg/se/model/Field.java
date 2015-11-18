package htwg.se.model;

import htwg.util.Point;

public class Field {
	private Point position;
	private Chesspiece c;
	
	public Field(Point p) {
		this.position = p;
		this.c = null;
	}
	
	public Field(Point p, Chesspiece c) {
		this.position = p;
		this.c = c;
	}
	
	public Point getFieldCoordinates() {
		return position;
	}
	
	public Chesspiece getChessPiece() {
		return c;
	}
	
	public void setChessPiece(Chesspiece c) {
		this.c = c;
	}
}
