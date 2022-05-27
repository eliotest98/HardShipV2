package it.ship.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.ship.beans.Amministratore;

public class AmministratoreTest {
	private Amministratore a = new Amministratore();
	
	
	@Before
	public void setUp(){
		a = new Amministratore("root", "root");
	}
	@After
	public void tearDown(){
		a = null;
	}
	@Test
	public void testGetUsername(){
		String username = a.getUsername();
		assertEquals("root", username);
	}
	@Test
	public void testGetPassword(){
		String username = a.getUsername();
		assertEquals("root", username);
	}
	@Test
	public void testSetUsername(){
		String username = "root";
		a.setUsername(username);
		assertEquals(username, a.getUsername());
	}
	@Test
	public void testSetPassword(){
		String password = "root";
		a.setPassword(password);
		assertEquals(password, a.getPassword());
	}
	

}
