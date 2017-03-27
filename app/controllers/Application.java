package controllers;

import java.io.IOException;

import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.view.tui.Tui;
import de.htwg.se.ws1516.fourwinning.view.gui.Gui;
import de.htwg.se.ws1516.fourwinning.controller.IGameController;
import de.htwg.se.ws1516.fourwinning.controller.impl.PlayerChangeEvent;
import de.htwg.se.ws1516.fourwinning.models.Player;
import de.htwg.se.ws1516.fourwinning.models.Feld;
import models.GridObserver;
import models.GridListener;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

public class Application extends Controller {
    
    static IGameController controller;
    static FourWinning game;
    static Feld[][] spielfeld;
    static Player aktiv;
    static Player eins;
    static Player zwei;
    static boolean instanceLoad = false;
    static boolean firstThrow = false;
    
    public static Result index() {
        return ok(views.html.index.render("Hello Play Framework"));
    }
    
    public static Result fourwinning() {
    	try {
			game = FourWinning.getInstance();
			controller = game.getController();
			eins = controller.getPlayerOne();
			zwei = controller.getPlayerTwo();
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
    	    
    	    spielfeld = controller.update();
    	    aktiv = controller.aktiverSpieler();
    	    int currentColumn = Integer.parseInt(command);
    	    String zugerfolgreich = (controller.zug(currentColumn, aktiv));
    	    spielfeld = controller.update();
    	    if(controller.spielGewonnen(spielfeld, aktiv))
    	        return ok(views.html.fourwinning.render("Fourwinning"));
    	    
    	    controller.notifyObservers(null);
    	    controller.changePlayer(eins, zwei);
    	    controller.notifyObservers(new PlayerChangeEvent());
    	    
    	    
			return ok(views.html.fourwinning.render("Fourwinning"));
	
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
    /*
    public static void setnameofplayer1(String name){
        // TODO: Save the name into the fourwinning module for the first player
        game.setPlayerNameOne(name);
    }
    
    public static void setnameofplayer2(String name){
        // TODO: Save the name into the fourwinning module for the first player 
        game.setPlayerNameTwo(name);
        try{
            game.startGame();
        } catch (java.io.IOException e) {
            e.printStackTrace();   
           
        }
    }*/
}
