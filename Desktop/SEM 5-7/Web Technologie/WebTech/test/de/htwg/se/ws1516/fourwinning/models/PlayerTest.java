package de.htwg.se.ws1516.fourwinning.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import de.htwg.se.ws1516.fourwinning.models.Player;

public class PlayerTest {
	
	public static Player p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Player("Sebastian",10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayer() {
		Player tp = new Player("Michael",10);
		assertEquals(tp.getName(),"Michael");
		assertEquals(tp.getMenge(),10);
	}

	@Test
	public void testGetName() {
		assertEquals(p.getName(),"Sebastian");
	}

	@Test
	public void testSetActive() {
		p.setActive(true);
		assertEquals(true, p.active);
		p.setActive(false);
		assertEquals(false, p.active);
	}

	@Test
	public void testGetActive() {
		p.active = true;
		assertEquals(p.active, p.getActive());
		p.active = false;
		assertEquals(p.active, p.getActive());
	}

	@Test
	public void testChipSetted() {
		p.menge = 10;
		p.chipSetted();
		assertEquals(9,p.menge);
	}

	@Test
	public void testGetMenge() {
		p.menge = 10;
		assertEquals(10,p.getMenge());
	}

}
