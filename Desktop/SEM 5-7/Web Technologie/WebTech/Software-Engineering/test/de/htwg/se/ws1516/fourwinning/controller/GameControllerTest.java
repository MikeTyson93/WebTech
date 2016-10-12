package de.htwg.se.ws1516.fourwinning.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.se.ws1516.fourwinning.FourWinningModule;

import de.htwg.se.ws1516.fourwinning.models.Player;

public class GameControllerTest {
	private static IGameController g;
	private static Player p1;
	private static Player p2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p1 = new Player("Sebastian", 5);
		p2 = new Player("Michael", 5);
		Injector injector = Guice.createInjector(new FourWinningModule());
		g = injector.getInstance(IGameController.class);
		g.createPlayers("Sebastian", "Michael");
	}

	@Test
	public void testGameController() {
		Injector injector = Guice.createInjector(new FourWinningModule());
		IGameController tg = injector.getInstance(IGameController.class);
		tg.setRows(5);
		tg.setColumns(5);
		assertEquals(tg.getColumns(), 5);
		assertEquals(tg.getRows(), 5);

	}

	@Test
	public void testBaueSpielfeld() {
		g.baueSpielfeld(5, 5);
		int reihe = g.getRows();
		int spalte = g.getColumns();
		assertEquals(5, reihe);
		assertEquals(5, spalte);
	}

	@Test
	public void testCreatePlayers() {
		/*
		 * Player p = new Player("Hans", 5); assertEquals("Hans", p.getName());
		 * assertEquals(5, p.getMenge());
		 */
		g.createPlayers("Sebastian", "Michael");
		Player p1 = g.getPlayerOne();
		assertEquals(p1.getName(), "Sebastian");

		Player p2 = g.getPlayerTwo();
		assertEquals(p2.getName(), "Michael");

	}

	@Test
	public void testAktiverSpieler() {
		g.getPlayerOne().setActive(true);
		g.getPlayerTwo().setActive(false);
		assertEquals(g.aktiverSpieler(), g.getPlayerOne());
		g.getPlayerOne().setActive(false);
		g.getPlayerTwo().setActive(true);
		assertEquals(g.aktiverSpieler(), g.getPlayerTwo());
	}

	@Test
	public void testGetPlayerOne() {
		Player p = g.getPlayerOne();
		assertEquals(p.getName(), "Sebastian");
	}

	@Test
	public void testGetPlayerTwo() {
		Player p = g.getPlayerTwo();
		assertEquals(p.getName(), "Michael");
	}

	@Test
	public void testChangePlayer() {
		g.changePlayer(g.getPlayerTwo(), g.getPlayerOne());
		Player p = g.getPlayerOne();
		assertEquals(p.getName(), "Sebastian");
		g.changePlayer(g.getPlayerTwo(), g.getPlayerOne());
		p = g.getPlayerOne();
		assertEquals(p.getName(), "Sebastian");
	}

	@Test
	public void testZug() {
		g.baueSpielfeld(1, 2);
		assertEquals(g.zug(0, p1), "Zug erfolgreich");
		assertEquals(g.zug(0, p1), "Zug fehlgeschlagen");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUpdate() {
		g.baueSpielfeld(10, 10);
		assertEquals(g.update(), g.getSpielfeld().getFeld());
	}

	@Test
	public void testSpielGewonnen() {
		g.baueSpielfeld(4, 4);
		for (int i = 0; i < 4; i++) { //4 erfolgreiche Züge werden gemacht bis zum Sieg
		g.zug(0, p1);
		}
		assertEquals(g.spielGewonnen(g.update() , p1), true);
		
	}

	@Test
	public void testSpielDraw() {
		g.baueSpielfeld(1,1);
		g.zug(0, p1);
		assertEquals(true, g.spielDraw(g.update()));
	}
	
	@Test
	public void testSetRows(){
		g.setRows(2);
		assertEquals(2, g.getRows());
	}
	
	@Test
	public void testGetRows(){
		g.baueSpielfeld(2,2);
		assertEquals(2, g.getRows());
	}
	

}
