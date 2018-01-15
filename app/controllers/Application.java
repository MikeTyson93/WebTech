package controllers;

import java.io.IOException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import de.htwg.se.ws1516.fourwinning.FourWinning;
import de.htwg.se.ws1516.fourwinning.view.tui.Tui;
import de.htwg.se.ws1516.fourwinning.view.gui.Gui;
import de.htwg.se.ws1516.fourwinning.controller.IGameController;
import de.htwg.se.ws1516.fourwinning.controller.impl.PlayerChangeEvent;
import de.htwg.se.ws1516.fourwinning.controller.impl.PlayerCreateEvent;
import de.htwg.se.ws1516.fourwinning.controller.impl.WaitForPlayerEvent;
import de.htwg.se.ws1516.fourwinning.controller.impl.FullSessionEvent;
import de.htwg.se.ws1516.fourwinning.controller.impl.GameStartEvent;
import de.htwg.se.ws1516.fourwinning.models.Player;
import de.htwg.se.ws1516.fourwinning.models.Feld;
import models.GridObserver;
import models.GridListener;
import models.UserInfoDB;
import models.UserInfo;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

import play.data.Form;
import play.mvc.Controller;
import java.util.*;
import play.mvc.Result;
import views.html.login;
import views.formdata.LoginFormData;
import views.formdata.SignUpFormData;
import play.mvc.Security;

import play.data.DynamicForm;
import play.libs.F;
import play.libs.Json;
import play.libs.openid.OpenID;

public class Application extends Controller {
    
    static IGameController controller;
    static FourWinning game;
    static Feld[][] spielfeld;
    static Player aktiv;
    static Player eins;
    static Player zwei;
    static boolean instanceLoad = false;
    static boolean firstThrow = false;
    
    private static Map<String, String> userDB = new HashMap<>();{
    userDB.put("mimerkle@htwg-konstanz.de", "michi");
    userDB.put("sttrube@htwg-konstanz.de", "stephan");
    userDB.put("boger@htwg-konstanz.de", "marko");
    }
    
    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(views.html.index.render("Hello Play Framework", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
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
    	    //controller.changePlayer(eins, zwei);
    	    //controller.notifyObservers(new PlayerChangeEvent());
		return ok(views.html.fourwinning.render("Fourwinning"));
	
    }
    
    public static Result createPlayers(String name){
        Player one = controller.getPlayerOne();
        if (one.getName() == "NameSpieler1"){
            one.setName(name);
            controller.notifyObservers(new PlayerCreateEvent());
            controller.notifyObservers(new WaitForPlayerEvent());
            return ok(views.html.fourwinning.render("Fourwinning"));
        }
        
        Player two = controller.getPlayerTwo();
        if (two.getName() == "NameSpieler2"){
            two.setName(name);
            controller.notifyObservers(new PlayerCreateEvent());
            controller.notifyObservers(new GameStartEvent());
            return ok(views.html.fourwinning.render("Fourwinning"));
        } else {
            // Both players are created -> Session is full!
            controller.notifyObservers(new FullSessionEvent());
            return ok(views.html.fourwinning.render("Fourwinning"));
        }
        
    }
    
    @Security.Authenticated(Secured.class)
    public static Result strategie(){
        return ok(views.html.strategie.render("Strategie", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    
    }
    
    @Security.Authenticated(Secured.class)
    public static Result contact(){
        return ok(views.html.contact.render("Kontakte",  Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    
    public static WebSocket<String> connectWebSocket() {
        return new WebSocket<String>() {
            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {
            	new GridObserver(controller,out);
            	new GridListener(in);
            }
            
        };
    }
    
    public static Result login() {
        Form<LoginFormData> formData = Form.form(LoginFormData.class);
        return ok(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

    
    public static Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return badRequest(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
        }
        else {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.Application.index());
        }
    }
 
  
    @Security.Authenticated(Secured.class)
    public static Result logout() {
        session().clear();
        return redirect(routes.Application.index());
    }
    
    public static Result signupForm() {
        Form<SignUpFormData> formData = Form.form(SignUpFormData.class);
        return ok(views.html.signup.render("Sign Up", formData));
    }
    
    /*public Result signup() {
        Form<LoginFormData> loginform = Form.form(LoginFormData.class).bindFromRequest();

        ObjectNode response = Json.newObject();
        LoginFormData account = loginform.get();
        boolean exists = userDB.containsKey(account.email);

        if (loginform.hasErrors() || exists) {
            response.put("success", false);
            response.put("errors", loginform.errorsAsJson());
            if (exists) {
                flash("errors", "Account already exists");
            }

            return badRequest(views.html.signup.render(loginform));
        } else {
            userDB.put(loginform.get().email, loginform.get().password);
            session().clear();
            session("email", loginform.get().email);
            return redirect(routes.Application.index());
        }
    }*/
    
    public Result postsignup(){
        Form<SignUpFormData> loginform = Form.form(SignUpFormData.class).bindFromRequest();
        String email = loginform.get().email;
        String password = loginform.get().password;
        System.out.println("Email: " + email);
        UserInfoDB.addUserInfo("", email, password);
        return redirect(routes.Application.login());
    }
    
    public static Result auth() {
        //Google has discontinued OpenID support and as of July 22nd 2015 has removed this endpoint.
        String providerUrl = "https://www.google.com/accounts/o8/id";
        String returnToUrl = "http://localhost:9000/openID/verify";

        Map<String, String> attributes = new HashMap<>();
        attributes.put("Email", "http://schema.openid.net/contact/email");
        attributes.put("FirstName", "http://schema.openid.net/namePerson/first");
        attributes.put("LastName", "http://schema.openid.net/namePerson/last");

        F.Promise<String> redirectUrl = OpenID.redirectURL(providerUrl, returnToUrl, attributes);
        return redirect(redirectUrl.get(3000));
    }
    
     public Result verify() {
        F.Promise<OpenID.UserInfo> userInfoPromise = OpenID.verifiedId();
        OpenID.UserInfo userInfo = userInfoPromise.get(3000);
        session().clear();
        session("email", userInfo.attributes.get("Email"));
        return redirect(
                routes.Application.index()
        );
    }
}


