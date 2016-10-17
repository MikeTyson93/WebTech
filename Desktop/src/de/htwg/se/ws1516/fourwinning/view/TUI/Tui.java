package de.htwg.se.ws1516.fourwinning.view.tui;

import de.htwg.se.ws1516.fourwinning.controller.impl.*;
import de.htwg.se.ws1516.fourwinning.controller.*;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Event;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Inject;

import de.htwg.se.ws1516.fourwinning.models.*;

public class Tui implements IObserver {

	IGameController spiel;
	private static final String NEWLINE = System.getProperty("line.separator");
	private static final Logger LOGGER = Logger.getLogger(Tui.class.getName());
	private static Scanner eingabe;
	Player eins;
	Player zwei;
	Player aktiv = eins;
	Feld[][] spielfeld;
	int rows = 0;
	int columns = 0;
	String zugerfolgreich;
	String next = "next round";
	
	@Inject
	public Tui(IGameController spiel) {
		this.spiel = spiel;
		spiel.addObserver(this);
	}

	public void ausgabe(Feld[][] feld, int rows, int columns, Player eins, Player zwei) {
		StringBuilder sb = new StringBuilder();
		LOGGER.setLevel(Level.FINER);
		LOGGER.info("Ausgabe");
		sb.append(NEWLINE);
		for (int k = 0; k < rows; k++) {
			for (int l = 0; l < columns; l++) {
				if (feld[k][l].getSet()) {
					if (feld[k][l].getOwner().getName().equals(eins.getName())) {
						sb.append("[X]\t");
						
					} else if (feld[k][l].getOwner().getName().equals(zwei.getName())) {
						sb.append("[O]\t");
					
					}
				} else {
					sb.append("[ ]\t");
				
				}
			}
			sb.append(NEWLINE);
		}
		String ausgabe = sb.toString();
		LOGGER.info(ausgabe);
	}

	public void createGameArea() {
		eingabe = new Scanner(System.in);
		LOGGER.info("Rows werden von GUI übernommen");
		rows = spiel.getRows();
		LOGGER.info("Columns werden von GUI übernommen");
		columns = spiel.getColumns();
		spiel.setRows(rows);
		spiel.setColumns(columns);

		spiel.baueSpielfeld(rows, columns);
		LOGGER.info(spiel.getStatusText());
	}

	public void createPlayers() {
		eingabe = new Scanner(System.in);
		LOGGER.info("Spieler eins wird von GUI erstellt");
		String one = spiel.getPlayerOne().getName();
		LOGGER.info("Spieler zwei wird von GUI erstellt");
		String two = spiel.getPlayerTwo().getName();
		spiel.createPlayers(one, two);
		LOGGER.info(spiel.getStatusText());
		eins = spiel.getPlayerOne();
		zwei = spiel.getPlayerTwo();
		eins.setActive(true);
		zwei.setActive(false);
	}

	public String playGame() {
		spielfeld = spiel.update();
		eingabe = new Scanner(System.in);
		aktiv = spiel.aktiverSpieler();
		LOGGER.info(spiel.getStatusText());

		String rowExplain = String.format("%nMachen sie Ihren Zug, geben sie dafuer die Column an, zwischen 0 und %d%n",
				columns - 1);
		LOGGER.info(rowExplain);

		LOGGER.info("Um den letzten Zug zu widerholen, geben sie redo ein");
		String currentColumnString = eingabe.next();
		if ("redo".equals(currentColumnString)) {
			spiel.redo();
			spielerwaechsel(eins, zwei);
		} else {
			spielfeld = spiel.update();
			int currentColumn = Integer.parseInt(currentColumnString);
			zugerfolgreich = (spiel.zug(currentColumn, aktiv));
			LOGGER.info(zugerfolgreich);
		}
		spiel.notifyObservers();
		String whoHasWon = "";
		if (spiel.spielGewonnen(spielfeld, aktiv)) {
			
			return "";
		}
		LOGGER.info(spiel.getStatusText());
		LOGGER.info(whoHasWon);
		
		if (spiel.spielDraw(spielfeld)) {
			
			return "";
		}
		LOGGER.info(spiel.getStatusText());
		LOGGER.info("");
		LOGGER.info("%n%n Schreibe undo, um den Zug rueckgaengig zu machen, ansonsten beliebige taste %n%n");
		String undo = eingabe.next();
		if ("undo".equals(undo)) {
			spiel.undo();
			spielfeld = spiel.update();
			return next;
		}
		spiel.notifyObservers(new PlayerChangeEvent());
		return next;
	}

	public void spielerwaechsel(Player eins, Player zwei) {
		spiel.changePlayer(eins, zwei);
	}

	public String runGame() {

		if (spiel.getState() instanceof PlayerBuildState) {
			createPlayers();
			spiel.getState().nextState(spiel);
			return next;
		} else if (spiel.getState() instanceof GameRunningState) {
			spiel.getState().nextState(spiel);
			String rueck = playGame();
			spielerwaechsel(eins, zwei);
			return rueck;
		} else if (spiel.getState() instanceof PlayerChangeState) {
			spiel.getState().nextState(spiel);
			return next;
		}
		return null;
	}

	@Override
	public void update(Event e) {
		if (e == null) {
			ausgabe(spielfeld, rows, columns, eins, zwei);
			spiel.changePlayer(eins, zwei);
		} else if (e instanceof GameOverEvent) {
			String gameOver = String.format("%n%s hat das Spiel gewonnen!%n", aktiv.getName());
			LOGGER.info(gameOver);
		} else if (e instanceof GameDrawEvent){
			String gameDraw = "Draw";
			LOGGER.info(gameDraw);
		}
	}

}
