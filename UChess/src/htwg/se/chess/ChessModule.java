package htwg.se.chess;

import htwg.se.controller.Icontroller;

import com.google.inject.AbstractModule;

public class ChessModule extends AbstractModule  {

	@Override
	protected void configure() {
		bind(Icontroller.class).to(htwg.se.controller.ChessController.class);
	}


}
