package de.htwg.se.ws1516.fourwinning.models;



public class PlayAreaFactory implements IPlayerAreaFactory{

	@Override
	public PlayAreaInterface create(int rows, int columns) {
		return new PlayArea(rows,columns); 
	}

	
}
