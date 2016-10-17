package de.htwg.se.ws1516.fourwinning.controller.impl;
import de.htwg.se.ws1516.fourwinning.controller.*;

public class GameRunningState implements IGameState{
	
	@Override
	public void nextState(IGameController game){
		game.setState(new PlayerChangeState());
	}
	
	@Override
	public String toString(){
		return "GameRunningState";
	}
}
