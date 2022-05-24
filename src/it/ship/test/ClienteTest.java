package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Cliente;

public class ClienteTest {
	Cliente c = new Cliente();
	
	@Before
	public void setUp(){
		c = new Cliente(1,"nome", "cognome", "data", "username", "password", "codiceFiscale","email");
	}
	@After
	public void tearDown(){
		c = null;
	}
	
	@Test
	public void testGetId(){
		int id = c.getID();
		assertEquals(1, id);
	}
	@Test
	public void testGetNome(){
		String nome = c.getNome();
		assertEquals("nome", nome);
	}
	@Test
	public void testGetCognome(){
		String cognome = c.getCognome();
		assertEquals("cognome", cognome);
	}
	@Test
	public void testGetData(){
		String data = c.getData();
		assertEquals("data", data);
	}
	@Test
	public void testGetUsername(){
		String username = c.getUser();
		assertEquals("username", username);
	}
	@Test
	public void testGetPassword(){
		String password = c.getPass();
		assertEquals("password", password);
	}
	@Test
	public void testGetCodiceFiscale(){
		String codiceFiscale = c.getCF();
		assertEquals("codiceFiscale", codiceFiscale);
	}
	@Test
	public void testGetEmail(){
		String email = c.getEmail();
		assertEquals("email", email);
	}
	@Test
	public void testSetId(){
		int id = 1;
		c.setID(id);
		assertEquals(id, c.getID());
	}
	@Test
	public void testSetNome(){
		String nome ="nome";
		c.setNome(nome);
		assertEquals(nome, c.getNome());
	}
	@Test
	public void testSetCognome(){
		String cognome = "cognome";
		c.setCognome(cognome);
		assertEquals(cognome, c.getCognome());
	}
	@Test
	public void testSetData(){
		String data = "data";
		c.setData(data);
		assertEquals(data, c.getData());
	}
	@Test
	public void testSetUsername(){
		String username = "username";
		c.setUser(username);
		assertEquals(username, c.getUser());
	}
	@Test
	public void testSetPassword(){
		String password = "password";
		c.setPass(password);
		assertEquals(password, c.getPass());
	}
	@Test
	public void testSetCodiceFiscale(){
		String codiceFiscale = "codiceFiscale";
		c.setCF(codiceFiscale);
		assertEquals(codiceFiscale, c.getCF());
	}
	@Test
	public void testSetEmail(){
		String email = "email";
		c.setEmail(email);
		assertEquals(email, c.getEmail());
	}
}
