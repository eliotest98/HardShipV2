package it.ship.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import it.ship.beans.Cliente;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;
import it.ship.servlets.gestioneUtente.LogIn;

class LoginTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	LogIn logIn = new LogIn();
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	PrintWriter mockedOut = mock(PrintWriter.class);
	ServletContext mockedServletContext  = mock(ServletContext.class);


	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() throws SQLException {
		when(requestMock.getSession()).thenReturn(sessionMock);
		Connection conn = DriverManagerConnectionPool.getConnection();
		Statement stmtSelect = conn.createStatement();
		stmtSelect.executeUpdate("insert INTO  cliente (nome,cognome,datanascita,username,password,codicefiscale,email) VALUES('Mario','Rossi','2022-01-15','mario','passwordTest','ZCXZVJ86E03L710J','mariorossi@test.com');");
		conn.close();
		
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

		doReturn(mockedServletContext).when(requestMock).getServletContext();
		when(requestMock.getParameter("user")).thenReturn("mario");
		when(requestMock.getParameter("pass")).thenReturn("passwordTest");
		logIn.doPost(requestMock, responseMock);
		verify(responseMock,times(2)).sendRedirect("/pages/home.jsp");

	}

}
