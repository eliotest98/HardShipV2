package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
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
import it.ship.servlets.gestioneCarrello.Acquista;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class AcquistaTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	Acquista acquista = mock(Acquista.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	Acquista acquistaTest = new Acquista();
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
				new Artista(2,"Ciccio"),
				new Etichetta(3,"Bho",4));
		when(requestMock.getSession().getAttribute("sc")).thenReturn(shoppingCart);
	}

	/*
	 * Dopo ogni test elimino l'utente appena creato.
	 */
	@AfterEach
	void tearDown() {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			Statement stmtSelect = conn.createStatement();
			stmtSelect.executeUpdate("DELETE FROM fattura WHERE InfoP='PayPal';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void acquisto() throws ServletException, IOException {
		when(requestMock.getParameter("method")).thenReturn("PayPal");
		when(requestMock.getParameter("indirizzo")).thenReturn("Via Circumvallazione");
		acquistaTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/home.jsp?cod=1");
	}

}
