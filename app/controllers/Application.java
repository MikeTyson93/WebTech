package controllers;

import java.io.IOException;

import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.view.TUI.Tui;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    
    public static Result index() {
        return ok(views.html.index.render("Hello Play Framework"));
    }
    
    public static Result fourwinning() {
    	try {
			Tui TextUI = FourWinning.getInstance().getTui();
			TextUI.createGameArea();
			TextUI.runGame();
			return ok(views.html.index.render(TextUI.toHtml()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}
