package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.ship.beans.Album;
import it.ship.beans.Artista;
import it.ship.beans.Cliente;
import it.ship.beans.Etichetta;
import it.ship.beans.ShoppingCart;
import it.ship.servlets.gestioneCarrello.Carrello;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class CarrelloTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	Carrello carrello = mock(Carrello.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	Carrello carrelloTest = new Carrello();
	ShoppingCart shoppingCart = new ShoppingCart();

	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(requestMock.getSession().getAttribute("cliente")).thenReturn(new Cliente(1, "Mario", "Rossi", "15-01-2022",
				"mario", "passwordTest", "ZCXZVJ86E03L710J", "mariorossi@test.com"));
		shoppingCart.addItem(
				new Album(1, "Pop", "Parla", "Parla", 14, "25-05-2022", "Bho", "Nuovo Album"), 20, 
				new Artista(1,"Ciccio"),
				new Etichetta(1,"Bho",4));
		when(requestMock.getSession().getAttribute("sc")).thenReturn(shoppingCart);
		ArrayList<Integer> articoli = new ArrayList<>();
		articoli.add(1);
		when(requestMock.getSession().getAttribute("articoli")).thenReturn(articoli);
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO digitale VALUES (null,?,?,?);");
			ps.setInt(1, 10);
			ps.setInt(2, 14);
			ps.setInt(3, 1);
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO album VALUES (null,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, "Pop");
			ps.setString(2, "Parla");
			ps.setString(3, "Parla");
			ps.setInt(4, 14);
			ps.setString(5, "25-05-2022");
			ps.setString(6, "Bho");
			ps.setString(7, "Nuovo Album");
			ps.setString(8, "root");
			ps.setInt(9, 1);
			ps.setInt(10, 1);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Dopo ogni test elimino l'utente appena creato.
	 */
	@AfterEach
	void tearDown() {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			Statement stmtSelect = conn.createStatement();
			stmtSelect.executeUpdate("DELETE FROM album WHERE Titolo='Parla';");
			stmtSelect.executeUpdate("DELETE FROM digitale WHERE Id_Album='1';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void acquisto() throws ServletException, IOException {
		when(requestMock.getParameter("id")).thenReturn("1");
		when(requestMock.getParameter("formato")).thenReturn("Bho");
		when(requestMock.getParameter("n")).thenReturn("0");
		carrelloTest.doPost(requestMock, responseMock);
		assert(responseMock.getStatus() == HttpServletResponse.SC_NO_CONTENT);
	}
	
}
