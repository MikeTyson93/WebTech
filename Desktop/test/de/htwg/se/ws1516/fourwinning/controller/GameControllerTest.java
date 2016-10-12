package de.htwg.se.ws1516.fourwinning.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.htwg.se.ws1516.fourwinning.FourWinningModule;
import de.htwg.se.ws1516.fourwinning.controller.impl.AreaBuildState;
import de.htwg.se.ws1516.fourwinning.controller.impl.PlayerChangeEvent;
import de.htwg.se.ws1516.fourwinning.models.Player;
import de.htwg.util.CreateCommand;
import de.htwg.util.observer.IObserver;
import de.htwg.util.observer.Observable;

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
		g.createPlayers("Sebastian", "Michael");
		Player p1 = g.getPlayerOne();
		assertEquals(p1.getName(), "Sebastian");

		Player p2 = g.getPlayerTwo();
		assertEquals(p2.getName(), "Michael");
		assertEquals(g.getState().toString(), "PlayerBuildState");
		assertEquals(g.getStatusText(), "Players created");
		assertEquals(g.getStatus(), GameStates.CREATE_PLAYERS);
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
	
	@Test
	public void testeStates(){
		g.baueSpielfeld(2, 2);
		g.setState(new AreaBuildState());
		assertEquals(g.getState().toString(), "AreaBuildState");
		g.getState().nextState(g);
		assertEquals(g.getState().toString(), "PlayerBuildState");
		g.getState().nextState(g);
		assertEquals(g.getState().toString(), "GameRunningState");
		g.getState().nextState(g);
		assertEquals(g.getState().toString(), "PlayerChangeState");
		g.getState().nextState(g);
		assertEquals(g.getState().toString(), "GameRunningState");
	}
	
	@Test
	public void testeSetSpielFeld(){
		g.baueSpielfeld(4, 4);
		g.setSpielfeld(null);
		assertEquals(g.getSpielfeld(), null);
	}
	
	@Test
	public void testeRedo(){
		
		g.baueSpielfeld(4, 4);
		g.redo();
		assertEquals(g.update()[3][0].getSet(), true);
		g.zug(0, p1);
		g.zug(1, p1);
		assertEquals(g.spielGewonnen(g.update(), p1), false);
		g.redo();
		g.zug(2, p1);
		g.redo();
		g.zug(3, p1);
		CreateCommand test = new CreateCommand();
		assertTrue(0 == test.redoCommand());
		
	}
	
	@Test
	public void testeUndo(){
		g.baueSpielfeld(4, 4);
		g.zug(0, p1);
		g.undo();
		g.zug(0, p1);
		g.undo();
		g.zug(0, p1);
		g.undo();
		g.zug(0, p1);
		assertEquals(g.spielGewonnen(g.update() , p1), true);
	}
	
	@Test
	public void playerChangeEvent(){
		PlayerChangeEvent pce = new PlayerChangeEvent();
		assertTrue(pce instanceof PlayerChangeEvent);
	}

	@Test
	public void testObserver(){
		g.baueSpielfeld(4, 4);
		g.notifyObservers();
		g.removeAllObservers();
		assertEquals(g.getObserverList().isEmpty(), true);
	}
	
	@Test
	public void testNotDraw(){
		g.baueSpielfeld(2, 1);
		g.zug(0, p1);
		assertEquals(g.spielDraw(g.update()), false);
	}

	

}
