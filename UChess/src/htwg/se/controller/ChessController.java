package htwg.se.controller;

import com.google.inject.Inject;

import htwg.se.model.*;
import htwg.util.*;




public class ChessController extends Observable implements Icontroller{
	private GameField gamefield;
	private boolean blackturn;
	
	@Inject
	public ChessController( GameField gamefield) {
		this.gamefield = gamefield;
		blackturn = true;
	}
	
	public Field[][] getField() {
		return gamefield.getField();
	}
	
	public String getStatusMessage() {
		if(blackturn)
			return "It's blacks turn";
		return "It's whites turn";
	}
	
	public void move(Point start, Point goal) {
		if (checkTurn(start)) {
			if (gamefield.moveCheck(start, goal)) {
				gamefield.moveAfterCheck(start, goal);
				blackturn = (!blackturn);
			}
		}
		
		notifyObservers();
		
	}
	

	
	private boolean checkTurn(Point start) {
		Field field[][] = gamefield.getField();
		Chesspiece piece = field[start.getX()][start.getY()].getChessPiece();		
		if(piece == null) {
			return false;
		} 
		return colorCheck(piece);
	}
	
	public void reset() {
		gamefield = new GameField();
		blackturn = true;
		notifyObservers();
	}
	
	private boolean colorCheck(Chesspiece piece) {
		if(blackturn) {
			return piece.getcolor() == 'b';
		}
		return piece.getcolor() == 'w';
	}
	
	public boolean checkWin() {
		return gamefield.blackWon() || gamefield.whiteWon();
	}
}
