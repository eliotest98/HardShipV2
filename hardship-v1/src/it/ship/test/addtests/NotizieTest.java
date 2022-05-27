package it.ship.test.addtests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.ship.servlets.gestioneNews.Notizie;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class NotizieTest {


	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	Notizie notizie = mock(Notizie.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	Notizie notizieTest = new Notizie();
	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO news VALUES (null,?,?,?,?,?,?,?);");
			ps.setString(1, "Nuovo Album");
			ps.setString(2, "26-05-2002");
			ps.setString(3, "Ciccio");
			ps.setString(4, "Parla");
			ps.setString(5, "Parla");
			ps.setString(6, "Pop");
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
	void test() throws ServletException, IOException {
		responseMock.setContentType("application/json");
		responseMock.setCharacterEncoding("UTF-8");
		notizieTest.doGet(requestMock, responseMock);
	}

}
