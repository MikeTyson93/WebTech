package de.htwg.se.ws1516.fourwinning.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import de.htwg.se.ws1516.fourwinning.models.PlayArea;
import de.htwg.se.ws1516.fourwinning.models.Player;
import de.htwg.se.ws1516.fourwinning.models.Feld;

public class PlayAreaTest {

	public static PlayArea pa;
	public static Player p1;
	public static Player p2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pa = new PlayArea(10,10);
		p1 = new Player("Sebastian", 10);
		p2 = new Player("Michael", 10);

	}

	@After
	public void tearDown() throws Exception {
		pa = null;
	}

	@Test
	public void testPlayArea() {
		PlayArea patest = new PlayArea(10,10);
		assertEquals(patest.getColumns(),10);
		assertEquals(patest.getRows(),10);

	}

	@Test
	public void testBuildArea() {
		//Test ob die Matrix richtig gebaut wurde
				PlayArea patest = new PlayArea(10,8);
				int row = patest.getFeld().length;
				assertEquals(row,10);
				
				for(int i = 0; i < patest.getFeld().length; i++) {
					assertEquals(patest.getFeld()[i].length,8);
				}

	}

	@Test
	public void testSetChip() {
		PlayArea patest = new PlayArea(1,1);
		int test = patest.setChip(0, p1);
		//assertEquals(-2, test); Dieser Test muss bei Aktivierung fehlschlagen, was er auch tut.
		test = patest.setChip(0, p2);
		assertEquals(-2, test);
		assertEquals(-2, patest.setChip(3, p1));
		assertEquals(-2, patest.setChip(1, p1));
        assertEquals(-2, patest.setChip(-3, p1));
		

	}

	@Test
	public void testGetColumns() {
		if (pa != null)
		assertEquals(10,pa.getColumns());
	}

	@Test
	public void testGetRows() {
		if (pa != null)
		assertEquals(10,pa.getRows());
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testGetFeld() {
		PlayArea patest = new PlayArea(10,10);	
		assertEquals(patest.getFeld(), patest.getFeld());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSetFeld(){
		PlayArea setFeldTest = new PlayArea(1,1);
		Feld[][] vergleich = new Feld[1][1];
		vergleich[0][0] = new Feld(0, 0, null);
		setFeldTest.setFeld(vergleich);
		assertEquals(setFeldTest.getFeld(), vergleich);
	}

}
