package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.News;

public class NewsTest {
	News n = new News();
	
	@Before
	public void setUp(){
		n = new News(1, "contenuto", "data", "autore", "titolo", "copertina", "categoria");
	}
	@After
	public void teardDown(){
		n = null;
	}
	@Test
	public void testGetId(){
		int id = n.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetContenuto(){
		String contenuto  = n.getContenuto();
		assertEquals("contenuto", contenuto);
	}
	@Test
	public void testGetData(){
		String data = n.getData();
		assertEquals("data", data);
	}
	@Test
	public void testGetAutore(){
		String autore = n.getAutore();
		assertEquals("autore", autore);
	}
	@Test
	public void testGetTitolo(){
		String titolo = n.getTitolo();
		assertEquals("titolo", titolo);
	}
	@Test
	public void testGetCopertina(){
		String copertina = n.getCopertina();
		assertEquals("copertina", copertina);
	}
	@Test
	public void testGetCategoria(){
		String categoria = n.getCategoria();
		assertEquals("categoria", categoria);
	}
	@Test
	public void testSetId(){
		int id = 1;
		n.setId(id);
		assertEquals(id, n.getId());
	}
	@Test
	public void testSetContenuto(){
		String contenuto = "contenuto";
		n.setContenuto(contenuto);
		assertEquals(contenuto, n.getContenuto());
	}
	@Test
	public void testSetData(){
		String data="data";
		n.setData(data);
		assertEquals(data, n.getData());
	}
	@Test
	public void testSetAutore(){
		String autore = "autore";
		n.setAutore(autore);
		assertEquals(autore, n.getAutore());
	}
	@Test
	public void testSetTitol(){
		String titolo = "titolo";
		n.setTitolo(titolo);
		assertEquals(titolo, n.getTitolo());
	}
	@Test
	public void testSetCopertina(){
		String copertina = "copertina";
		n.setCategoria(copertina);
		assertEquals(copertina, n.getCopertina());
	}
	@Test
	public void testSetCategoria(){
		String categoria = "categoria";
		n.setCategoria(categoria);
		assertEquals(categoria, n.getCategoria());
	}
	
	

}
