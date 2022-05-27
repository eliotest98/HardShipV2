package it.ship.test.addtests;

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

import it.ship.servlets.gestioneAlbum.LiveSearch;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class LiveSearchTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	LiveSearch liveSearch = mock(LiveSearch.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	LiveSearch liveSearchTest = new LiveSearch();

	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO album VALUES (null,?,?,?,?,?,?,?,?,?,?);");
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
			ps = conn.prepareStatement("INSERT INTO etichetta VALUES (null,?,?);");
			ps.setString(1, "Bho");
			ps.setInt(2, 1);
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO artista VALUES (null,?);");
			ps.setString(1, "Vasco");
			ps.executeUpdate();
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
			stmtSelect.executeUpdate("DELETE FROM album WHERE Titolo='Parla';");
			stmtSelect.executeUpdate("DELETE FROM etichetta WHERE Nome='Bho';");
			stmtSelect.executeUpdate("DELETE FROM artista WHERE Nome='Vasco';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void searchAlbumTitolo() throws ServletException, IOException {
		when(requestMock.getParameter("pid")).thenReturn("Par");
		liveSearchTest.doGet(requestMock, responseMock);
	}
	
	@Test
	void searchNomeEtichetta() throws ServletException, IOException {
		when(requestMock.getParameter("pid")).thenReturn("Bho");
		liveSearchTest.doGet(requestMock, responseMock);
	}
	
	@Test
	void searchNomeCantante() throws ServletException, IOException {
		when(requestMock.getParameter("pid")).thenReturn("Vas");
		liveSearchTest.doGet(requestMock, responseMock);
	}

}
