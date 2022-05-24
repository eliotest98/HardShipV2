package it.ship.test.beans;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Album;

public class AlbumTest {
	Album a = new Album();
	
	@Before
	public void setUp(){
		a = new Album(1,"genere", "titolo", "img.png",1,"dd/MM/yyyy","", "dettagli");
	}
	@After
	public void tearDown(){
		a = null;
	}

	@Test
	public void testGetId() {
		int id = a.getId();
		assertEquals(1, id);
	}
	@Test
	public void testGetGenere() {
		String genere = a.getGenere();
		assertEquals("genere", genere);
	}
	@Test
	public void testGetTitolo() {
		String titolo = a.getTitolo();
		assertEquals("titolo", titolo);
	}
	@Test
	public void testGetCopertina() {
		String copertina = a.getCopertina();
		assertEquals("img.png", copertina);
	}
	@Test
	public void testGetNumBrani() {
		int numBrani = a.getNumBrani();
		assertEquals(1, numBrani);
	}
	@Test
	public void testGetData() {
		String data = a.getData();
		assertEquals("dd/MM/yyyy", data);
	}
	@Test
	public void testGetEmbed() {
		String embed = a.getEmbed();
		assertEquals("", embed);
	}
	@Test
	public void testGetDettagli() {
		String dettagli = a.getDettagli();
		assertEquals("dettagli", dettagli);
	}
	@Test
	public void testSetId(){
		int id = 1;
		a.setId(id);
		assertEquals(id, a.getId());
	}
	@Test
	public void testSetGenere(){
		String genere = "genere";
		a.setGenere(genere);
		assertEquals(genere, a.getGenere());
	}
	@Test
	public void testSetTitolo(){
		String titolo = "Titolo";
		a.setTitolo(titolo);
		assertEquals(titolo, a.getTitolo());
	}
	@Test
	public void testSetCopertina(){
		String copertina = "copertina";
		a.setCopertina(copertina);
		assertEquals(copertina, a.getCopertina());
	}
	@Test
	public void testSetNumBrani(){
		int numBrani = 1;
		a.setNumBrani(numBrani);
		assertEquals(numBrani, a.getNumBrani());
	}
	@Test
	public void testSetData(){
		String data = "dd/MM/yyyy";
		a.setData(data);
		assertEquals(data, a.getData());
	}
	@Test
	public void testSetEmbed(){
		String embed = "embed";
		a.setEmbed(embed);
		assertEquals(embed, a.getEmbed());
	}
	@Test
	public void testSetDettagli(){
		String dettagli = "dettagli";
		a.setDettagli(dettagli);
		assertEquals(dettagli, a.getDettagli());
	}

}
