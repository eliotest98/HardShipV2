package it.ship.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;
import it.ship.servlets.gestioneUtente.RegistrazioneUtente;

class RegistrazioneEnteTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	RegistrazioneUtente registrazioneUtente = mock(RegistrazioneUtente.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	RegistrazioneUtente regUtenteTest = new RegistrazioneUtente();

	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
	}

	/*
	 * Dopo ogni test elimino l'utente appena creato.
	 */
	@AfterEach
	void tearDown() {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			Statement stmtSelect = conn.createStatement();
			stmtSelect.executeUpdate("DELETE FROM cliente WHERE CodiceFiscale='ZCXZVJ86E03L710J';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testTrue() throws ServletException, IOException {
		when(requestMock.getParameter("first_name")).thenReturn("Mario");
		when(requestMock.getParameter("last_name")).thenReturn("Rossi");
		when(requestMock.getParameter("user")).thenReturn("mario");
		when(requestMock.getParameter("password")).thenReturn("passwordTest");
		when(requestMock.getParameter("CF")).thenReturn("ZCXZVJ86E03L710J");
		when(requestMock.getParameter("data")).thenReturn("2022-01-15");
		when(requestMock.getParameter("email")).thenReturn("mariorossi@test.com");
		regUtenteTest.doPost(requestMock, responseMock);
		System.out.println(requestMock.getContextPath());
		verify(responseMock).sendRedirect("/pages/home.jsp?cod=1");

	}

}
