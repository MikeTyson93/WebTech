package controllers;

import java.io.IOException;

import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.view.tui.Tui;
import de.htwg.se.ws1516.fourwinning.view.gui.Gui;
import de.htwg.se.ws1516.fourwinning.controller.IGameController;
import models.GridObserver;
import models.GridListener;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

public class Application extends Controller {
    
    static IGameController controller;
    
    public static Result index() {
        return ok(views.html.index.render("Hello Play Framework"));
    }
    
    public static Result fourwinning() {
    	try {
			FourWinning game = FourWinning.getInstance();
			controller = game.getController();
			//Tui textui = game.getTui();
			//Gui graphicUi = new Gui(FourWinning.controller);
			//textui.createGameArea();

			return ok(views.html.fourwinning.render("Spielfeld gebaut"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public static Result playfourwinning(String command) {
    	try {
			Tui TextUI = FourWinning.getInstance().getTui();
			TextUI.runGameFromUrl(command);
			
			return ok(views.html.fourwinning.render("Fourwinning"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public static Result strategie(){
        return ok(views.html.strategie.render("Strategie"));
    
    }
    
    public static Result contact(){
        return ok(views.html.contact.render("Kontakte"));
    }
    
    public static WebSocket<String> connectWebSocket() {
        return new WebSocket<String>() {
            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
            	new GridObserver(controller,out);
            	new GridListener(in);
            }
            
        };
    }

}
