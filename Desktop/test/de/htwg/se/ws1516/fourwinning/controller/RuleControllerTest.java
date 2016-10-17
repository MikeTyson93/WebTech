package de.htwg.se.ws1516.fourwinning.controller;

import static org.junit.Assert.*;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import de.htwg.se.ws1516.fourwinning.FourWinningModule;
import de.htwg.se.ws1516.fourwinning.controller.impl.RuleController;
import de.htwg.se.ws1516.fourwinning.models.Feld;
import de.htwg.se.ws1516.fourwinning.models.Player;

public class RuleControllerTest {

	protected static IGameController g;
	private static RuleController r;
	private static Player p1;
	private static Player p2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Injector injector = Guice.createInjector(new FourWinningModule());
		g = injector.getInstance(IGameController.class);
		g.createPlayers("Sebastian", "Michael");
		g.baueSpielfeld(4, 4);
		r = new RuleController(6,6);
		p1 = new Player("Sebastian",10);
		p2 = new Player("Michael",10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRuleController() {
		RuleController rTest = new RuleController(5,6);
		assertEquals(6,rTest.getColumn());
		assertEquals(5,rTest.getRow());
	}

	@Test
	public void testFourInRow() {

		g.baueSpielfeld(4, 4);
//		assertTrue(1 == r.fourInRow(3, g.update(), p1));
		g.zug(0, p1);
//		assertEquals(1, r.fourInRow(3, g.update(), p1));
		g.zug(1, p2);
//		assertEquals(1, r.fourInRow(3, g.update(), p2));
		g.zug(2, p2);
		g.zug(3, p2);
		g.zug(0, p1);
		g.zug(1, p1);
		g.zug(2, p1);
		g.zug(3, p1);
		assertEquals(4, r.fourInRow(2, g.update(), p1));
		g.baueSpielfeld(10, 10);
		g.zug(0, p1);
		g.zug(1, p1);
		g.zug(2, p1);
		g.zug(3, p2);
		g.zug(4, p1);
		g.zug(5, p1);
		g.zug(6, p1);
		g.zug(7, p1);
		
	}

	@Test
	public void testFourInColumn() {
		g.baueSpielfeld(4, 4);
//		assertEquals(1, r.fourInColumn(0, g.update(), p1));
		g.zug(0, p1);
//		assertEquals(2, r.fourInColumn(0, g.update(), p1));
		g.zug(0, p2);
//		assertEquals(1, r.fourInColumn(0, g.update(), p2));
		g.zug(1, p1);
		g.zug(1, p1);
		g.zug(1, p1);
		g.zug(1, p1);
		assertEquals(4, r.fourInColumn(1, g.update(), p1));
		g.baueSpielfeld(10, 10);
		g.zug(0,p1);
		g.zug(0,p1);
		g.zug(0,p1);
		g.zug(0,p1);
		g.zug(0,p2);
		g.zug(0,p1);
		g.zug(0,p1);
		g.zug(0,p1);
		assertEquals(4,r.fourInColumn(0, g.update(), p1));
		
	}

	@Test
	public void testFourDiagonalLeftToRight() {
		g.baueSpielfeld(5,5);
		assertTrue(1 == r.fourDiagLeftToRight(g.update(), p1, 0, 4));
		g.zug(1, p1);
		g.zug(1, p2);
		g.zug(1, p1);
		g.zug(2, p2);
		g.zug(4, p1);
		g.zug(3, p2);
		g.zug(1, p1);
		g.zug(2, p2);
		g.zug(2, p1);
		g.zug(2, p2);
		g.zug(3, p1);
        assertEquals(4, r.fourDiagLeftToRight(g.update(), p1, 3,3));
        g.zug(0, p2);
        g.zug(0, p1);
        g.zug(0, p2);
        g.zug(0, p1);
        g.zug(4, p2);
        g.zug(0, p1);
        assertEquals(5, r.fourDiagLeftToRight(g.update(), p1, 0,0));
	}
	
	
	@Test
	public void testfourDiagLeftToRightTwo(){
		g.baueSpielfeld(4, 4);
		g.zug(0, p1);
		assertTrue(1 != r.fourDiagLeftToRight(g.update(), p1, 3, 0));
		g.zug(0, p1);
		g.zug(1,p2);
		assertTrue(1 != r.fourDiagLeftToRight(g.update(), p1, 2, 0));
		g.zug(1, p2);
		g.zug(1, p2);
		assertTrue(1 != r.fourDiagLeftToRight(g.update(), p2, 2, 1));
	}
	
	@Test
	public void testFourDiagonalLeftToRight2() {
        g.baueSpielfeld(10, 10);
        g.zug(0, p1);
        g.zug(1, p1);
        g.zug(1, p1);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p1);
        g.zug(3, p2);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p1); 
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        assertTrue(4 == r.fourDiagRightToLeft(g.update(), p1, 2, 7));
        
	}
	
	@Test
	public void testHilfeLeftToRight(){
		g.baueSpielfeld(1, 1);
		g.zug(0, p1);
		
		List<Integer> test = r.helpFourDiagLeftToRight(g.update(), p1, 0, 0);
		assertTrue(test.get(0) == 0);
		assertTrue(test.get(1) == 0);
		g.baueSpielfeld(4, 4);
		g.zug(0, p1);
		g.zug(1, p1);
		g.zug(1, p2);
		List<Integer> test3 = r.helpFourDiagLeftToRight(g.update(), p2, 2, 1);
		assertTrue(test3.get(0) == 2);
		assertTrue(test3.get(1) == 1);
	}
	
	@Test
	public void testHilfeRightToLeft(){
		g.baueSpielfeld(1, 1);
		g.zug(0, p1);
		
		List<Integer> test = r.helpFourDiagRightToLeft(g.update(), p1, 0, 0);
		assertTrue(test.get(0) == 0);
		assertTrue(test.get(1) == 0);
		g.baueSpielfeld(4, 4);
		g.zug(3, p1);
		g.zug(2, p1);
		g.zug(2, p2);
		List<Integer> test2 = r.helpFourDiagRightToLeft(g.update(), p2, 2 , 2);
		assertTrue(test2.get(0) == 2);
		assertTrue(test2.get(1) == 2);
	}
	
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testHilfeRightToLeftTwo(){
		g.baueSpielfeld(4, 4);
		g.zug(3, p1);
		g.zug(2, p2);
		g.zug(2, p2);
		List<Integer> test3 = r.helpFourDiagRightToLeft(g.update(), p1, 3, 3);
		assertTrue(test3.get(0) != 3);
		assertTrue(test3.get(1) != 3);
	}
	

	@Test
	public void testFourDiagRightToLeftTwo(){
		g.baueSpielfeld(4, 4);
		g.zug(3, p1);
		g.zug(3, p1);
		g.zug(2, p2);
		assertTrue(1 == r.fourDiagRightToLeft(g.update(), p1, 2, 3));
	}
	
    @Test
    public void testFourDiagonalRightToLeft(){
        g.baueSpielfeld(5,5);
//        assertTrue(1 == r.fourDiagRightToLeft(g.update(), p1, 1, 4));
        g.zug(4, p1); 
        g.zug(4,p2);
        g.zug(4,p1);
        g.zug(4,p2);
        g.zug(4,p1);
        g.zug(3,p2);
        g.zug(3,p1);
        g.zug(3,p2);
        g.zug(3,p1);
        g.zug(2,p2);
        g.zug(2,p1);
        g.zug(1,p2);
        g.zug(2,p1);
        g.zug(1,p1);

        assertEquals(4, r.fourDiagRightToLeft(g.update(), p1, 3, 1));
        g.zug(1,p2);
        g.zug(0,p1);

        assertEquals(5, r.fourDiagRightToLeft(g.update(), p1, 4, 0));
        
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testExceptiondiagonaltwo(){
    	g.baueSpielfeld(2, 2);
    	r.fourDiagLeftToRight(g.update(), p1, 3, 4);
    }
    
    @Test
    public void testFourDiagonalRightToLeft2(){
    	g.baueSpielfeld(10, 10);
        g.zug(9, p1);
        g.zug(8, p1);
        g.zug(8, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(6, p2);
        g.zug(6, p2);
        g.zug(6, p2);
//        g.zug(6, p2);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p1);
        g.zug(4, p2);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(3, p1);
        g.zug(3, p1);
        g.zug(3, p1);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p1);
        g.zug(2, p2);
        g.zug(2, p2);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(2, p2);
        g.zug(2, p1);
        g.zug(2, p2);
        g.zug(2, p1);
        assertTrue(4 != r.fourDiagLeftToRight(g.update(), p1, 7, 2));
    }
    
	
	@Test
	public void testGetDraw() {
		//Test Erfolg
		
		Feld [][] feld = new Feld[r.getColumn()][r.getRow()];
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = new Feld(i,j,p1);
			}
		}
		assertEquals(true, r.getDraw(feld));
		//Test Fehlschlag
		Feld [][] feld2 = new Feld[r.getColumn()][r.getRow()];
		for (int i = 0; i < feld2.length; i++) {
			for (int j = 0; j < feld2[i].length; j++) {
				feld2[i][j] = new Feld(i,j,null);
			}
		}
		//r.getDraw(feld);
		
		assertEquals(false, r.getDraw(feld2));
	}

	@Test
	public void testGetWinRow() {
		g.baueSpielfeld(4, 4);
		g.zug(0, p1);
		g.zug(1, p1);
		
		g.zug(2, p1);
		assertEquals(true, r.getWin(g.update(), p1, 3, 3));
		g.zug(3, p2);
		

		assertEquals(true, r.getWin(g.update(), p1, 3, 3));
    }
    
    @Test
    public void testGetWinColumn(){
        g.baueSpielfeld(4, 4);
        g.zug(0, p1);
        g.zug(0, p1);
        g.zug(0, p1);
        g.zug(0, p1);
        assertEquals(true, r.getWin(g.update(), p1, 0, 0));
    }
    
    @Test
    public void testGetWinRowAndColumn(){
    	g.baueSpielfeld(4, 4);
    	g.zug(0, p1);
        g.zug(0, p1);
        g.zug(0, p1);
        g.zug(0, p1);
        g.zug(1, p2);
        g.zug(1, p2);
        g.zug(1, p2);
        g.zug(2, p2);
        g.zug(2, p2);
        g.zug(2, p2);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p2);
		g.zug(1, p1);
		g.zug(2, p1);
		g.zug(3, p1);
		
		assertEquals(true, r.getWin(g.update(), p1, 0, 0));
    }
    
    @Test 
    public void testGetWinDiagonalEins(){
    	g.baueSpielfeld(10, 10);
        g.zug(0, p1);
        g.zug(1, p1);
        g.zug(1, p1);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p1);
        g.zug(3, p2);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p2);
        g.zug(6, p1);
        g.zug(6, p1); 
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p2);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        assertEquals(true, r.getWin(g.update(), p1,2 , 7));
    }
    
    @Test
    public void testGetWinDiagonalZwei(){
    	g.baueSpielfeld(10, 10);
        g.zug(9, p1);
        g.zug(8, p1);
        g.zug(8, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(7, p1);
        g.zug(6, p2);
        g.zug(6, p2);
        g.zug(6, p2);
//        g.zug(6, p2);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p2);
        g.zug(5, p1);
        g.zug(5, p1);
        g.zug(4, p2);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(4, p1);
        g.zug(4, p2);
        g.zug(4, p1);
        g.zug(3, p1);
        g.zug(3, p1);
        g.zug(3, p1);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p2);
        g.zug(3, p1);
        g.zug(2, p2);
        g.zug(2, p2);
        g.zug(2, p1);
        g.zug(2, p1);
        g.zug(2, p2);
        g.zug(2, p1);
        g.zug(2, p2);
        g.zug(2, p1);
        assertEquals(true, r.getWin(g.update(), p1,2 , 2));
    }
    
    @Test
    public void getWinFalseDiag(){
    	g.baueSpielfeld(4, 4);
    	g.zug(0,p1);
    	g.zug(1, p1);
    	g.zug(1, p1);
    	boolean test = (r.getWin(g.update(), p1, 2, 1));
    	assertTrue( true == (test)); 
    	
    }
    
    @Test
    public void getWinFalseDiag3(){
    	g.baueSpielfeld(4, 4);
    	g.zug(0,p1);
    	g.zug(1, p1);
    	g.zug(1, p1);
    	g.zug(2, p1);
    	g.zug(2, p1);
    	g.zug(2, p1);
    	g.zug(3, p2);
    	g.zug(3, p2);
    	g.zug(3, p2);
    	g.zug(3, p1);
    	boolean test2 = (r.getWin(g.update(), p1, 0, 3));
    	assertTrue(test2 == true);
    }
    
    @Test
    public void getWinFalseDiag2(){
    	g.baueSpielfeld(4, 4);
    	g.zug(3,p1);
    	g.zug(2, p1);
    	g.zug(2, p1);
    	boolean test2 = (r.getWin(g.update(), p1, 2, 2));
    	assertTrue(test2 == true);
    	}
    
    
    @Test
    public void getWinFalseDiag4(){
    	g.zug(3,p1);
    	g.zug(2, p1);
    	g.zug(2, p1);
    	g.zug(1, p1);
    	g.zug(1, p1);
    	g.zug(1, p1);
    	g.zug(0, p2);
    	g.zug(0, p2);
    	g.zug(0, p2);
    	g.zug(0, p1);
    	boolean test4 = (r.getWin(g.update(), p1, 0, 0));
    	assertTrue(test4 == true);
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testExceptiondiagonal(){
    	g.baueSpielfeld(2, 2);
    	r.fourDiagLeftToRight(g.update(), p1, 1, 3);
    }
    
    @Test
    public void testfourDiagLeftToRight2(){
    	g.baueSpielfeld(3, 3);
    	g.zug(0, p1);
    	g.zug(0, p1);
    	g.zug(0, p1);
    }
}
	


