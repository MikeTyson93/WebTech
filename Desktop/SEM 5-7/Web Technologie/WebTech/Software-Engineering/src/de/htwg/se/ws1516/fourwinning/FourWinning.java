package de.htwg.se.ws1516.fourwinning;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.logging.Level;
import java.io.IOException;
import java.util.logging.Logger;

import de.htwg.se.ws1516.fourwinning.view.TUI.*;
import de.htwg.se.ws1516.fourwinning.controller.IGameController;
import de.htwg.se.ws1516.fourwinning.view.GUI.*;

public class FourWinning {
	private static final Logger LOGGER = Logger.getLogger(Tui.class.getName());
	private Tui TextUI;
	protected IGameController controller;
	private static FourWinning instance;
	int rows;
	int columns;

	private FourWinning() throws IOException {
		Injector injector = Guice.createInjector(new FourWinningModule());
		controller = injector.getInstance(IGameController.class);
		
		TextUI = new Tui(controller);
		new Gui(controller);
		instance = null;
	}

	public static FourWinning getInstance() throws IOException {
		if (instance == null) {
			instance = new FourWinning();
		}
		return instance;
	}

	public Tui getTui() {
		return TextUI;
	}

	public static void main(String[] args) {
		try {
			LOGGER.setLevel(Level.INFO);
			FourWinning game = getInstance();
			game.TextUI.createGameArea();
			String continu = "next round";
			while ("next round" == continu) {
				continu = game.TextUI.runGame();
			}
			LOGGER.info(continu);
		} catch (java.io.IOException e) {
			LOGGER.log(Level.SEVERE, "exception", e);
		}
	}
}
