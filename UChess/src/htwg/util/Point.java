package htwg.util;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Point p) {
		if(p.getX() == this.x && p.getY() == this.y)
			return true;
		return false;
	}

	
}
