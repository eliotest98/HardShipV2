package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Artista;

public class ArtistaTest {
	private Artista a = new Artista();

	@Before
	public void setUp(){
		a = new Artista(1, "nome");
	}
	@After
	public void tearDown(){
		a = null;
	}
	
	@Test
	public void testGetId(){
		int id = a.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetNome(){
		String nome = a.getNome();
		assertEquals("nome", nome);
	}
	@Test
	public void testSetId(){
		int id = 1;
		a.setId(id);
		assertEquals(id, a.getId());
	}
	@Test
	public void testSetNome(){
		String nome = "nome";
		a.setNome(nome);
		assertEquals(nome, a.getNome());
	}
}
