package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.ship.servlets.gestioneNews.UploadNews;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class UploadNewsTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	UploadNews uploadNews = mock(UploadNews.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	UploadNews uploadNewsTest = new UploadNews();
	
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
			stmtSelect.executeUpdate("DELETE FROM news WHERE Autore='Mario Rossi';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void uploadNews() throws ServletException, IOException {
		when(requestMock.getParameter("newstitolo")).thenReturn("Nuova Canzone");
		when(requestMock.getParameter("author")).thenReturn("Mario Rossi");
		when(requestMock.getParameter("categoria")).thenReturn("Pop");
		when(requestMock.getParameter("newscopertina")).thenReturn("Nuova Canzone");
		when(requestMock.getParameter("newstext")).thenReturn("Canta");
		uploadNewsTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/menager.jsp?cod=1");
	}

}
