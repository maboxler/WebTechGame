package htwg.se.model;

import java.util.ArrayList;

import htwg.util.Point;

import java.util.List;

public class Bishop extends Chesspiece {

	private List<Point> validMovesList;
	
	public Bishop(int x, int y, char color) {
		super(x, y, color);
		validMovesList = new ArrayList<Point>();
	}

	@Override
	public Point[] validMove(int x, int y) {

		if (equalPosition(x, y) || outRange(x,y)) {
			return null;
		}
		
		whichDirection(x, y);
		return listToArray();

	}
	
	private boolean outRange(int x, int y) {
		if(x >= 8 || x < 0) {
			return true;
		}
		else if(y >= 8 || y < 0) {
			return true;
		}
		
		return false;
	}
		
	private void whichDirection(int x, int y) {
			diagonal(x, y);
	}

	private boolean equalPosition(int x, int y) {
		if (this.x == x && this.y == y)
			return true;

		return false;
	}

	private Point[] listToArray() {
		Point pointField[] = new Point[validMovesList.size()];
		int i = 0;
		for (Point point : validMovesList) {
			
			if(i == 0) {
				i++;	
			} else {
				pointField[i-1] = point;
				i++;
			}
			
		}
		validMovesList.clear();

		return pointField;
	}

	private void diagonal(int x, int y) {
		if (this.y < y) {
			upDiagonal(x, y);
		} else {
			downDiagonal(x, y);
		}

	}

	private void upDiagonal(int x, int y) {
		if(x < this.x) {
			leftUpDiagonal(x);
		} else {
			rightUpDiagonal(x);
		}

	}

	private void leftUpDiagonal(int x) {
		int n = 0;
		for (int i = x; i >= x; i--) {
			validMovesList.add(new Point(this.x - n, this.y + n));
			n++;
		}
		
	}

	private void rightUpDiagonal(int x) {
		int n = 0;
		for (int i = this.x; i <= x; i++) {
			validMovesList.add(new Point(this.x + n, this.y + n));
			n++;
		}
	}

	private void downDiagonal(int x, int y) {
		if(x<this.x) {
			leftDownDiagonal(y);
		} else {
			rightDownDiagonal(x);
		}

	}
	
	private void leftDownDiagonal(int x) {
		int n = 0;
		for (int i = this.x; i >= x; i--) {
			validMovesList.add(new Point(this.x - n, this.y - n));
			n++;
		}
		
	}
	
	private void rightDownDiagonal(int x) {
		int n = 0;
		for (int i = this.x; i <= x; i++) {
			validMovesList.add(new Point(this.x + n, this.y - n));
			n++;
		}
		
	}

	@Override
	public char toChar() {
		return 'B';
	}

}
