package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Etichetta;

public class EtichettaTest {
	Etichetta e = new Etichetta();
	
	@Before
	public void setUp(){
		e = new Etichetta(1,"nome", 1);
	}
	@After
	public void tearDown(){
		e = null;
	}
	@Test
	public void testGetId(){
		int id = e.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetNome(){
		String nome = e.getNome();
		assertEquals("nome", nome);
	}
	@Test
	public void testGetFeed(){
		int feed = e.getFeed();
		assertEquals(1, feed);
		
	}

}
