package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.ship.servlets.gestioneNews.VisualizzaNews;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class VisualizzaNewsTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	VisualizzaNews visualizzaNews = mock(VisualizzaNews.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	VisualizzaNews visualizzaNewsTest = new VisualizzaNews();
	int id = 0;

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
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM news");
			if (rs.next())
				id = rs.getInt(1);
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
	void visualizzaNews() throws ServletException, IOException {
		when(requestMock.getParameter("news")).thenReturn(id+"");
		visualizzaNewsTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/readmore.jsp?cod=1");
	}
	
}
