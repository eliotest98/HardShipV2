package it.ship.test.addtests;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.ship.beans.Cliente;
import it.ship.servlets.gestioneAlbum.RichiestaAlbum;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class RichiestaAlbumTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	RichiestaAlbum richiestaAlbum = mock(RichiestaAlbum.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	RichiestaAlbum richiestaAlbumTest = new RichiestaAlbum();
	ServletContext mockedServletContext  = mock(ServletContext.class);

	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() throws SQLException {

		when(requestMock.getSession()).thenReturn(sessionMock);
		when(requestMock.getSession().getAttribute("cliente")).thenReturn(new Cliente(1, "Mario", "Rossi", "15-01-2022",
				"mario", "passwordTest", "ZCXZVJ86E03L710J", "mariorossi@test.com"));	}
	
	/*
	 * Dopo ogni test elimino l'utente appena creato.
	 */
	@AfterEach
	void tearDown() {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			Statement stmtSelect = conn.createStatement();
			stmtSelect.executeUpdate("DELETE FROM richiesta WHERE Artista='ArtistaTest';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void richiestaAlbum() throws ServletException, IOException {
		doReturn(mockedServletContext).when(requestMock).getServletContext();
		when(requestMock.getParameter("art")).thenReturn("ArtistaTest");
		when(requestMock.getParameter("tit")).thenReturn("testTitolo");


		richiestaAlbumTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("/pages/home.jsp?cod=1");
	}


}