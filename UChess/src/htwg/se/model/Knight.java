package htwg.se.model;

import java.util.ArrayList;
import java.util.List;

import htwg.util.Point;

public class Knight extends Chesspiece {
	
	private List<Point> validMovesList;

	public Knight(int x, int y, char color) {
		super(x, y, color);
		
		validMovesList = new ArrayList<Point>();
	}

	@Override
	public Point[] validMove(int x, int y) {
		
		if (equalPosition(x, y) || outRange(x, y) || tMove(x,y)) {
			return null;
		}

		//whichDirection(x, y);

		return listToArray();
	}
	
	private boolean tMove(int x, int y) {
		List<Point> allMoveList = new ArrayList<Point>();
		Point move = new Point(x,y);
		//up
		allMoveList.add(new Point(this.x+1, this.y+2));
		allMoveList.add(new Point(this.x-1, this.y+2));
		//down
		allMoveList.add(new Point(this.x+1, this.y-2));
		allMoveList.add(new Point(this.x-1, this.y-2));
		//righ
		allMoveList.add(new Point(this.x+2, this.y+1));
		allMoveList.add(new Point(this.x+2, this.y-1));
		//left
		allMoveList.add(new Point(this.x-2, this.y+1));
		allMoveList.add(new Point(this.x-2, this.y-1));
		
		for (Point point : allMoveList) {
			if(move.equals(point)) {
				validMovesList.add(move);
				return false;
			}
		}

		return true;
	}

	private boolean outRange(int x, int y) {
		if (x >= 8 || x < 0) {
			return true;
		} else if (y >= 8 || y < 0) {
			return true;
		}

		return false;
	}
	
//	private void whichDirection(int x, int y) {
//		if (x != this.x && y > this.y) {
//			up(x, y);
//		} else 
//			down(x, y);
//		
//	}
//	
//	private void up(int x, int y) {
//		if(x < this.x)
//			upLeft(x,y);
//		else
//			upRight(x,y);
//		
//	}
//	
//	private void upLeft(int x, int y) {
//		
//			if(this.x == x && this.y == y)
//			validMovesList.add(new Point(x, y));
//			else if(this.x == x && this.y == y)
//			validMovesList.add(new Point(x-2, y+1));
//			validMovesList.add(new Point(x-1, y+2));
//	}
//
//	private void upRight(int x, int y) {
//		validMovesList.add(new Point(x, y));
//		validMovesList.add(new Point(x+2, y+1));
//		validMovesList.add(new Point(x+1, y+2));	
//	}
//
//	private void down(int x, int y) {
//		if(x < this.x)
//			downLeft(x,y);
//		else
//			downRight(x,y);
//		
//	}
//	
//	private void downLeft(int x, int y) {
//		validMovesList.add(new Point(x, y));
//		validMovesList.add(new Point(x-2, y-1));
//		validMovesList.add(new Point(x-1, y-2));
//		
//	}
//
//	private void downRight(int x, int y) {
//		validMovesList.add(new Point(x, y));
//		validMovesList.add(new Point(x+2, y-1));
//		validMovesList.add(new Point(x+1, y-2));
//	}

	private boolean equalPosition(int x, int y) {
		if (this.x == x && this.y == y)
			return true;

		return false;
	}
	
	private Point[] listToArray() {
		Point pointField[] = new Point[validMovesList.size()];
		int i = 0;
		pointField[i] = validMovesList.get(i);
		validMovesList.clear();
		return pointField;
	}
	
	
	@Override
	public char toChar() {
		return 'H';
	}

}
