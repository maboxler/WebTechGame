package htwg.se.model;

import htwg.util.Point;

public interface Piece {
	/*
	 * returns the Position of the Piece.
	 */
	public Point getPosition();
	
	/*
	 * getter for the color.
	 */
	public char getcolor();
	
	/*
	 * setter for the Position of the Piece.
	 */
	public void setPosition(Point p);
	
	/* 	checks if the Move form the Current position to
 	 *	the new X and Y is valid or not. It won't check if there are 
	 *	other pieces in the way Returns the Way to the Point(inclusive) if possible and 
	 *	null if there is no Way for the figure to get there.
	 */
	public Point[] validMove(int x,int y);
	
	/*
	 * returns a char for the representing Piece
	 */
	public char toChar();
	
	/*
	 * returns the moved Attribute of the Piece
	 */
	public boolean getMoved();
}
