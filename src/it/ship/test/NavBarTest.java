package it.ship.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;
import it.ship.servlets.gestioneSistema.NavBar;

class NavBarTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	NavBar navBar = mock(NavBar.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	NavBar navBarTest = new NavBar();
	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO artista VALUES (null,?);");
			ps.setString(1, "Ciccio");
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO etichetta VALUES (null,?,?);");
			ps.setString(1, "Bho");
			ps.setInt(2, 1);
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO album VALUES (null,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, "Pop");
			ps.setString(2, "Parla");
			ps.setString(3, "Copri");
			ps.setInt(4, 14);
			ps.setString(5, "25-05-2022");
			ps.setString(6, "Bho");
			ps.setString(7, "Parla Parla");
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
			stmtSelect.executeUpdate("DELETE FROM artista WHERE Nome='Ciccio';");
			stmtSelect.executeUpdate("DELETE FROM etichetta WHERE Nome='Bho';");
			stmtSelect.executeUpdate("DELETE FROM album WHERE Titolo='Parla';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test() throws ServletException, IOException {
		when(requestMock.getParameter("method")).thenReturn("PayPal");
		when(requestMock.getParameter("indirizzo")).thenReturn("Via Circumvallazione");
		responseMock.setContentType("application/json");
		responseMock.setCharacterEncoding("UTF-8");
		navBarTest.doGet(requestMock, responseMock);
	}

}
