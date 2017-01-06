package models;

import play.mvc.WebSocket;
import play.mvc.WebSocket.In;
import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.controller.impl.*;
import de.htwg.se.ws1516.fourwinning.controller.*;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Event;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import controllers.Application;


public class GridListener{
	
	private In<String> in;


	public GridListener(WebSocket.In<String> in) {
		this.in = in;
		listen();
	}

    public void listen(){
	    in.onMessage(new Callback<String>() {
                   public void invoke(String event) {
                       /*
                       if (event.startsWith("player1:"))
                            Application.setnameofplayer1(event);
                       if (event.startsWith("player2:"))
                            Application.setnameofplayer2(event);*/
                       Application.playfourwinning(event);
               }
        });
    }
}
