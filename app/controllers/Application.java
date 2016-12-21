package controllers;

import java.io.IOException;

import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.view.tui.Tui;
import de.htwg.se.ws1516.fourwinning.view.gui.Gui;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    
    public static Result index() {
        return ok(views.html.index.render("Hello Play Framework"));
    }
    
    public static Result fourwinning() {
    	try {
			FourWinning game = FourWinning.getInstance();
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
}
