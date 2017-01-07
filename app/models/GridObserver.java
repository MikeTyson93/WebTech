package models;

import play.mvc.WebSocket;
import play.mvc.WebSocket.Out;
import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.controller.impl.*;
import de.htwg.se.ws1516.fourwinning.controller.*;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Event;


public class GridObserver implements IObserver {
	
	private Out<String> out;
	private IGameController controller;


	public GridObserver(IGameController controller,WebSocket.Out<String> out) {

		System.out.println("controller: ");
		System.out.println(controller);

		System.out.println("this: ");
		System.out.println(this);

		controller.addObserver(this);
		this.controller = controller;
		this.out = out;
	}

	@Override
	public void update(Event e) {
	    if (e == null) {
			out.write(controller.getSpielfeld().toJson());	
		    System.out.println("WUI was updated");
		}
        else if (e instanceof GameOverEvent) {
			String gameOver = String.format("Game Over! Winner is: %s%n!%n", controller.aktiverSpieler().getName());
			out.write(gameOver);
			
		} else if (e instanceof GameDrawEvent){
			String gameDraw = "Draw";
    		out.write(gameDraw);
		}
    }
}
