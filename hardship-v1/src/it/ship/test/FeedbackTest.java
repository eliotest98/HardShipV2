package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Feedback;

public class FeedbackTest {

	Feedback f = new Feedback();
	
	@Before
	public void setUp(){
		f = new Feedback(1, "titolo", "testo", "data", "utente");
	}
	@After
	public void tearDown(){
		f = null;
	}
	@Test
	public void testGetId(){
		int id = f.getID();
		assertEquals(1, id);
	}
	@Test
	public void testGetTitolo(){
		String titolo = f.getTitolo();
		assertEquals("titolo", titolo);
	}
	@Test
	public void testGetData(){
		String data = f.getData();
		assertEquals("data", data);
	}
	@Test
	public void testGetUtente(){
		String utente = f.getUtente();
		assertEquals("utente", utente);
	}
	@Test
	public void testSetId(){
		int id = 1;
		f.setID(id);
		assertEquals(id, f.getID());
	}
	@Test
	public void testSetTitolo(){
		String titolo = "titolo";
		f.setTitolo(titolo);
		assertEquals(titolo, f.getTitolo());
	}
	@Test
	public void testSetData(){
		String data ="data";
		f.setData(data);
		assertEquals(data, f.getData());
	}
	@Test
	public void testSetUtente(){
		String utente = "utente";
		f.setUtente(utente);
		assertEquals(utente, f.getUtente());
	}

}
