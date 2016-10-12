package de.htwg.se.ws1516.fourwinning.controller.impl;

import de.htwg.se.ws1516.fourwinning.controller.*;

public class PlayerBuildState implements IGameState{

	@Override
	public void nextState(IGameController game){
		game.setState(new GameRunningState());
	}
}
