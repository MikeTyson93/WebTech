package de.htwg.se.ws1516.fourwinning;
import com.google.inject.AbstractModule;

import de.htwg.se.ws1516.fourwinning.controller.IGameController;
import de.htwg.se.ws1516.fourwinning.models.IPlayerAreaFactory;


public class FourWinningModule extends AbstractModule{
	 @Override
	    protected void configure() {

	        bind(IPlayerAreaFactory.class)
	                .to(de.htwg.se.ws1516.fourwinning.models.PlayAreaFactory.class);
	        bind(IGameController.class).to(
	                de.htwg.se.ws1516.fourwinning.controller.impl.GameController.class);

	    }
}
