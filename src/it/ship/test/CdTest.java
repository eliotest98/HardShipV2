package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.ship.beans.Cd;

public class CdTest {
	Cd c = new Cd();
	
	@Before
	public void setUp(){
		c = new Cd(1,1,1);
	}
	@After
	public void tearDown(){
		c = null;
	}
	@Test
	public void testGetId(){
		int id = c.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetPrezzo(){
		int prezzo = c.getPrezzo();
		assertEquals(1, prezzo);
	}
	@Test
	public void testGetNumCopie(){
		int numCopie = c.getNumCopie();
		assertEquals(1, numCopie);
	}
	@Test
	public void testSetId(){
		int id = 1;
		c.setId(id);
		assertEquals(id, c.getId());
	}
	@Test
	public void testSetPrezzo(){
		int prezzo = 1;
		c.setPrezzo(prezzo);
		assertEquals(prezzo, c.getPrezzo());
	}
	@Test
	public void testSetNumCopie(){
		int numCopie = 1;
		c.setNumCopie(numCopie);
		assertEquals(numCopie, c.getNumCopie());
	}



}
