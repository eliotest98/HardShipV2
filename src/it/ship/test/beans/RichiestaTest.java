package it.ship.test.beans;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Richiesta;

public class RichiestaTest {
	Richiesta r = new Richiesta();
	
	@Before
	public void setUp(){
		r = new Richiesta(1,"nomeAlbum", "nomeArtista");
	}
	@After
	public void tearDown(){
		r = null;
	}
	@Test
	public void testGetId(){
		int id = r.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetNomeAlbum(){
		String nomeAlbum = r.getNomeAlbum();
		assertEquals("nomeAlbum", nomeAlbum);
	}
	@Test
	public void testGetNomeArtista(){
		String nomeArtista = r.getNomeArtista();
		assertEquals("nomeArtista", nomeArtista);
	}
	@Test
	public void testSetId(){
		int id = 1;
		r.setId(id);
		assertEquals(id, r.getId());
	}
	@Test
	public void testSetNomeAlbum(){
		String nomeAlbum ="nomeAlbum";
		r.setNomeAlbum(nomeAlbum);
		assertEquals(nomeAlbum, r.getNomeAlbum());
	}
	@Test
	public void testSetNomeArtista(){
		String nomeArtista ="nomeArtista";
		r.setNomeArtista(nomeArtista);
		assertEquals(nomeArtista, r.getNomeArtista());
	}
}
