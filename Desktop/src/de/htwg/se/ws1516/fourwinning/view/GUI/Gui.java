
package de.htwg.se.ws1516.fourwinning.view.gui;

import de.htwg.se.ws1516.fourwinning.controller.IGameController;

import java.util.logging.Level;
import java.util.logging.Logger;
import de.htwg.se.ws1516.fourwinning.controller.impl.GameDrawEvent;
import de.htwg.se.ws1516.fourwinning.controller.impl.GameOverEvent;
import de.htwg.se.ws1516.fourwinning.models.Feld;
import de.htwg.se.ws1516.fourwinning.models.Player;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;


import javax.swing.*;

import com.google.inject.Inject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Gui extends JFrame implements ActionListener, IObserver {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8169521783214478709L;
	String fehler = "Ungueltige Spielparameter eingegeben";
	JButton[] einwerfen;
	JPanel einwerfenPanel;
	JTextField lSpieler;
	JMenuBar menueBar;
	JMenu datei;
	JMenuItem close;
	JMenu info;
	JMenuItem autor;
	JMenuItem newGame;
	JMenu zug;
	JMenuItem zugUndo;
	JMenuItem zugRedo;
	private GameMatrix gm;
	private int rows;
	private int columns;
	private IGameController spiel;
	private Player eins;
	private Player zwei;
	private Player aktiv;
	private Feld[][] spielfeld;
	private static final Logger LOGGER = Logger.getLogger(Gui.class.getName());

	@Inject
	public Gui(IGameController spiel) throws IOException{
		this.spiel = spiel;
		spiel.addObserver(this);
	}

	public void createGameArea() throws IOException {
		try {
			
			this.rows = Integer.parseInt(JOptionPane.showInputDialog("Anzahl Reihen"));
			this.columns = Integer.parseInt(JOptionPane.showInputDialog("Anzahl Spalten"));
			einwerfenPanel = new JPanel();
			spiel.setRows(rows);
			spiel.setColumns(columns);
			spiel.baueSpielfeld(rows, columns);
			menueBar = new JMenuBar();
			datei = new JMenu();
			datei.setText("Datei");
			menueBar.add(datei);
			close = new JMenuItem("Beenden");
			close.addActionListener(this);
			newGame = new JMenuItem("Neues Spiel");
			newGame.addActionListener(this);
			datei.add(newGame);
			datei.add(close);
			zug = new JMenu("Zug");
			menueBar.add(zug);
			zugUndo = new JMenuItem("Zug rückgängig machen");
			zugUndo.addActionListener(this);
			zug.add(zugUndo);
			zugRedo = new JMenuItem("Zug wiederholen");
			zugRedo.addActionListener(this);
			zug.add(zugRedo);
			info = new JMenu();
			info.setText("Info");
			menueBar.add(info);
			autor = new JMenuItem("Autor");
			autor.addActionListener(this);
			info.add(autor);
			setJMenuBar(menueBar);
			einwerfen = new JButton[columns];
			setTitle("4 gewinnt");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			this.setLocationRelativeTo(null);
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, fehler, "Fehler",
					JOptionPane.ERROR_MESSAGE);
			LOGGER.log(Level.SEVERE, fehler , x);
			return;
		}
		createPlayers();
	}

	public void createPlayers() {
		try {
			String one = JOptionPane.showInputDialog("Name des ersten Spielers angeben.");
			String two = JOptionPane.showInputDialog("Name des zweiten Spielers angeben.");
			spiel.createPlayers(one, two);
			this.eins = spiel.getPlayerOne();
			this.zwei = spiel.getPlayerTwo();
			eins.setActive(true);
			zwei.setActive(false);
			einwerfenPanel.setLayout(new GridLayout(1, columns));
			this.add(einwerfenPanel, BorderLayout.NORTH);
			for (int i = 0; i < columns; i++) {
				einwerfen[i] = new JButton();
				einwerfen[i].setText(Integer.toString(i + 1));
				einwerfen[i].addActionListener(this);
				einwerfenPanel.add(einwerfen[i]);
			}

			this.gm = new GameMatrix(rows, columns);

			this.add(gm, BorderLayout.CENTER);
			lSpieler = new JTextField(spiel.aktiverSpieler().getName() + " ist am Zug!");

			this.add(lSpieler, BorderLayout.SOUTH);
			this.setResizable(true);
			this.setResizable(false);
			this.pack();

			setVisible(true);
		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, "Ungültige Spielparameter eingegeben", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			LOGGER.log(Level.SEVERE,fehler, x);
			return;
		}
		
	}


	public void setGelb(int rows, int columns) {
		this.gm.setGelb(rows, columns);
	}

	public void setRot(int rows, int columns) {
		this.gm.setRot(rows, columns);
	}

	public void setLeer(int rows, int columns) {
		this.gm.setLeer(rows, columns);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object quelle = e.getSource();
		playGame(quelle);
	}

	public void playGame(Object quelle) {
		if (quelle == zugUndo) {
			spiel.undo();
			spielfeld = spiel.update();
			return;
		}

		if (quelle == zugRedo) {
			spiel.redo();
			spielfeld = spiel.update();
			ausgabe(rows, columns, eins, zwei);
			return;
		}

		if (quelle == close) {
			Runtime.getRuntime().halt(0);
		}

		if (quelle == autor) {
			JOptionPane.showMessageDialog(null, "Sebastian Gerstmeier & Michael Merkle", "Autor",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		for (int i = 0; i < einwerfen.length; i++) {
			if (quelle == einwerfen[i]) {
				
				spielfeld = spiel.update();
				
				aktiv = spiel.aktiverSpieler();
				spiel.zug(i, aktiv);
				
				if (spiel.spielGewonnen(spielfeld, aktiv)) {
					
					Runtime.getRuntime().halt(0);
				}
				
				if (spiel.spielDraw(spielfeld)) {
					
					Runtime.getRuntime().halt(0);
				}
				
				
				lSpieler.setText(spiel.aktiverSpieler().getName() + " ist am Zug!");

			}
			
		}

	}
	
	@Override
	public void update(Event e) {
		if(e == null){
			ausgabe(rows, columns, eins, zwei);
		} else if (e instanceof GameOverEvent){
			String gameOver = String.format("%n%s hat das Spiel gewonnen!%n", aktiv.getName());

			JOptionPane.showMessageDialog(null,gameOver, "Gewinner: " + aktiv.getName(),
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e instanceof GameDrawEvent){
			JOptionPane.showMessageDialog(null, "Game Draw!", "",
					JOptionPane.ERROR_MESSAGE);
			Runtime.getRuntime().halt(0);
		}
	}
	

	public void ausgabe(int rows, int columns, Player eins, Player zwei) {
		spielfeld = spiel.update();
		for (int k = 0; k < rows; k++) {
			for (int l = 0; l < columns; l++) {
				if (spielfeld[k][l].getSet()) {
					if (spielfeld[k][l].getOwner().getName().equals(eins.getName())) {
						this.setGelb(k, l);
						gm.repaint();
					} else if (spielfeld[k][l].getOwner().getName().equals(zwei.getName())) {
						this.setRot(k, l);
						gm.repaint();
					}
				} else {
					this.setLeer(k, l);
					gm.repaint();
				}
			}

		}

	}
}
