package htwg.se.view;



public interface UI {

	/*
	 * Resets the Game
	 */
	public void restart();
	/*
	 * tells the Controller, which Field has been selected
	 */
	public void pressed(int x, int y);
	

}
