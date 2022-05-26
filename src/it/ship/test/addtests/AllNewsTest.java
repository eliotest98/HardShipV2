package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import it.ship.servlets.gestioneNews.AllNews;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class AllNewsTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	AllNews allNews = mock(AllNews.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	AllNews allNewsTest = new AllNews();
	ShoppingCart shoppingCart = new ShoppingCart();

	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(requestMock.getSession().getAttribute("cliente")).thenReturn(new Cliente(1, "Mario", "Rossi", "15-01-2022",
				"mario", "passwordTest", "ZCXZVJ86E03L710J", "mariorossi@test.com"));
		shoppingCart.addItem(new Album(1, "Pop", "Parla", "Parla", 14, "25-05-2022", "Bho", "Nuovo Album"), 20,
				new Artista(1, "Ciccio"), new Etichetta(1, "Bho", 4));
		when(requestMock.getSession().getAttribute("sc")).thenReturn(shoppingCart);
		ArrayList<Integer> articoli = new ArrayList<>();
		articoli.add(1);
		when(requestMock.getSession().getAttribute("articoli")).thenReturn(articoli);
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO news VALUES (null,?,?,?,?,?,?,?);");
			ps.setString(1, "Nuovo Album");
			ps.setString(2, "26-05-2002");
			ps.setString(3, "Ciccio");
			ps.setString(4, "Parla");
			ps.setString(5, "Parla");
			ps.setString(6, "Cronaca");
			ps.setString(7, "root");
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO news VALUES (null,?,?,?,?,?,?,?);");
			ps.setString(1, "Nuovo Album");
			ps.setString(2, "26-05-2002");
			ps.setString(3, "Ciccio");
			ps.setString(4, "Parla");
			ps.setString(5, "Parla");
			ps.setString(6, "Biografia");
			ps.setString(7, "root");
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO news VALUES (null,?,?,?,?,?,?,?);");
			ps.setString(1, "Nuovo Album");
			ps.setString(2, "26-05-2002");
			ps.setString(3, "Ciccio");
			ps.setString(4, "Parla");
			ps.setString(5, "Parla");
			ps.setString(6, "Nuove uscite");
			ps.setString(7, "root");
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
			stmtSelect.executeUpdate("DELETE FROM news WHERE Titolo='Parla';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void acquisto() throws ServletException, IOException {
		allNewsTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/news.jsp?cod=1");
	}
	
}
