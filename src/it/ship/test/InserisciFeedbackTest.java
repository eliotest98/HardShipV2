package it.ship.test;

import static org.junit.jupiter.api.Assertions.*;
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

import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;
import it.ship.servlets.gestioneSistema.InserisciFeedback;

class InserisciFeedbackTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	InserisciFeedback inserisciFeedback = mock(InserisciFeedback.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	InserisciFeedback inserisciFeedbackTest = new InserisciFeedback();
	
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
			stmtSelect.executeUpdate("DELETE FROM feedback WHERE Titolo='Parla';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test() throws ServletException, IOException {
		when(requestMock.getParameter("testo")).thenReturn("Parla Parla");
		when(requestMock.getParameter("id")).thenReturn("1");
		when(requestMock.getParameter("user")).thenReturn("1");
		when(requestMock.getParameter("titolo")).thenReturn("Parla");
		inserisciFeedbackTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("/DettagliAlbum");
	}

}
