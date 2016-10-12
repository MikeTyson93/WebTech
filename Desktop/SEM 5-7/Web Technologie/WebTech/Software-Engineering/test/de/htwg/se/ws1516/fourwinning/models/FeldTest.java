package de.htwg.se.ws1516.fourwinning.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeldTest {

	public static Player p;
	public static Player p2;
	public static Feld f;
	
	@Before
	public void setUp() throws Exception {
		p = new Player("Sebastian", 5);
		 p2 = new Player("Michi", 5);
		 f = new Feld(5, 5, p);
	}


	@Test
	public void testFeld() {
		
		Feld testfeld = new Feld(6, 5, p);	
		assertEquals(testfeld.getX(), 6);
		assertEquals(testfeld.getY(), 5);
		assertEquals(testfeld.getOwner(), p);
	}

	@Test
	public void testGetSet() {
		if (p2 != null && f != null) {
		f.setOwner(p2);
		assertEquals(true, f.getSet());
		}
	}

	@Test
	public void testGetOwner() {
		if (p2 != null && f != null) {
		f.setOwner(p2);
		assertEquals(f.getOwner(), f.getOwner());
		f.setOwner(p);
		assertEquals(f.getOwner(), f.getOwner());
		}
	}

	@Test
	public void testSetOwner() {
		if (p2 != null && f != null) {
		f.setOwner(p2);
		assertEquals(p2, f.getOwner());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		p = null;
		p2 = null;
		f = null;
	}

}
