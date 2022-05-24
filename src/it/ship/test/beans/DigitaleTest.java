package it.ship.test.beans;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Cd;
import it.ship.beans.Digitale;

public class DigitaleTest {
	Digitale d = new Digitale();
	@Before
	public void setUp(){
		d = new Digitale(1,1,1);
	}
	@After
	public void tearDown(){
		d = null;
	}
	@Test
	public void testGetId(){
		int id = d.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetPrezzo(){
		int prezzo = d.getPrezzo();
		assertEquals(1, prezzo);
	}
	@Test
	public void testGetNumCopie(){
		int numCopie = d.getNumCopie();
		assertEquals(1, numCopie);
	}
	@Test
	public void testSetId(){
		int id = 1;
		d.setId(id);
		assertEquals(id, d.getId());
	}
	@Test
	public void testSetPrezzo(){
		int prezzo = 1;
		d.setPrezzo(prezzo);
		assertEquals(prezzo, d.getPrezzo());
	}
	@Test
	public void testSetNumCopie(){
		int numCopie = 1;
		d.setNumCopie(numCopie);
		assertEquals(numCopie, d.getNumCopie());
	}
	

}
