

package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.ship.servlets.gestioneAlbum.VisualizzaAlbum;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class VisualizzaAlbumTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	VisualizzaAlbum visualizzaAlbum = mock(VisualizzaAlbum.class);
	VisualizzaAlbum visualizzaAlbum2 = mock(VisualizzaAlbum.class);
	VisualizzaAlbum visualizzaAlbum3 = mock(VisualizzaAlbum.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	VisualizzaAlbum visualizzaAlbumTest = new VisualizzaAlbum();
	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() throws SQLException {

		when(requestMock.getSession()).thenReturn(sessionMock);
		Connection conn = DriverManagerConnectionPool.getConnection();
		Statement stmtSelect = conn.createStatement();
		stmtSelect.executeUpdate("insert INTO  Album (genere,titolo,copertina,data,dettagli,embed,numero_brani,username_admin,ID_etichetta,ID_artista) VALUES('genereTest','titoloTest','test','2022-01-15','dettaglitest','embed','1','root','1','3');");
		stmtSelect.executeUpdate("insert INTO  Artista (id,nome) VALUES('3','nomeTest');");
	}
	
	/*
	 * Dopo ogni test elimino l'utente appena creato.
	 */
	@AfterEach
	void tearDown() {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			Statement stmtSelect = conn.createStatement();
			stmtSelect.executeUpdate("DELETE FROM album WHERE Copertina='test';");
			stmtSelect.executeUpdate("DELETE FROM artista WHERE nome='nomeTest';");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void visualizzaAlbumPerArtista() throws ServletException, IOException {
		
		when(requestMock.getParameter("param1")).thenReturn("Artista");
		when(requestMock.getParameter("param2")).thenReturn("test");
		when(requestMock.getParameter("param3")).thenReturn("Copertina");


		visualizzaAlbumTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/searchview.jsp?cod=1");
	}
	
	@Test
	void visualizzaAlbumPerGenere() throws ServletException, IOException {
		
		when(requestMock.getParameter("param1")).thenReturn("Genere");
		when(requestMock.getParameter("param2")).thenReturn("test");
		when(requestMock.getParameter("param3")).thenReturn("Copertina");


		visualizzaAlbumTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/searchview.jsp?cod=1");
	}
	
	@Test
	void visualizzaAlbumPerEtichetta() throws ServletException, IOException {
		
		when(requestMock.getParameter("param1")).thenReturn("Etichetta");
		when(requestMock.getParameter("param2")).thenReturn("test");
		when(requestMock.getParameter("param3")).thenReturn("Copertina");


		visualizzaAlbumTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/searchview.jsp?cod=1");
	}

}