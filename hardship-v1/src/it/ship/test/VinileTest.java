package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Cd;
import it.ship.beans.Vinile;

public class VinileTest {

	Vinile v = new Vinile();
	
	@Before
	public void setUp(){
		v = new Vinile(1,1,1);
	}
	@After
	public void tearDown(){
		v = null;
	}
	@Test
	public void testGetId(){
		int id = v.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetPrezzo(){
		int prezzo = v.getPrezzo();
		assertEquals(1, prezzo);
	}
	@Test
	public void testGetNumCopie(){
		int numCopie = v.getNumCopie();
		assertEquals(1, numCopie);
	}
	@Test
	public void testSetId(){
		int id = 1;
		v.setId(id);
		assertEquals(id, v.getId());
	}
	@Test
	public void testSetPrezzo(){
		int prezzo = 1;
		v.setPrezzo(prezzo);
		assertEquals(prezzo, v.getPrezzo());
	}
	@Test
	public void testSetNumCopie(){
		int numCopie = 1;
		v.setNumCopie(numCopie);
		assertEquals(numCopie, v.getNumCopie());
	}


}
