package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Brano;

public class BranoTest {
	Brano b = new Brano();

	@Before
	public void setUp(){
		b = new Brano(1,"titolo", "anno", "durata");
	}
	@After 
	public void tearDown(){
		b = null;
	}
	@Test
	public void testGetId(){
		int id = b.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetTitolo(){
		String titolo = b.getTitolo();
		assertEquals("titolo", titolo);
	}
	@Test
	public void testGetAnno(){
		String anno = b.getAnno();
		assertEquals("anno", anno);
	}
	@Test
	public void testGetDurata(){
		String durata = b.getDurata();
		assertEquals("durata", durata);
	}
	@Test
	public void testSetId(){
		int id = 1;
		b.setId(id);
		assertEquals(id, b.getId());
	}
	@Test
	public void testSetTitolo(){
		String titolo = "titolo";
		b.setTitolo(titolo);
		assertEquals(titolo, b.getTitolo());
	}
	@Test
	public void testSetAnno(){
		String anno = "anno";
		b.setAnno(anno);
		assertEquals(anno, b.getAnno());
	}
	@Test
	public void testSetDurata(){
		String durata = "durata";
		b.setDurata(durata);
		assertEquals(durata, b.getDurata());
	}

}
