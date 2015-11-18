package htwg.se.view;

import javax.swing.JButton;

public class ChessButton extends JButton {

	private static final long serialVersionUID = 1L;
	int cx;
	int cy;
	String fieldColor;
	String chessPiece;
		
	public String getChessPiece() {
		return chessPiece;
	}
	public void setChessPiece(String chessPiece) {
		this.chessPiece = chessPiece;
	}
	
	public int getFieldX() {
		return cx;
	}
	public void setFieldX(int x) {
		this.cx = x;
	}
	
	public int getFieldY() {
		return cy;
	}
	
	public void setFieldY(int y) {
		this.cy = y;
	}
	public void setFieldColor(String color) {
		fieldColor = color;
		
	}
	public String getFieldColor() {
		return fieldColor;
		
	}
	
	

}
