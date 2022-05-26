package it.ship.test.addtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
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
import it.ship.servlets.gestioneAlbum.UploadAlbum;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class UploadAlbumTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	UploadAlbum uploadAlbum = mock(UploadAlbum.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	UploadAlbum uploadAlbumTest = new UploadAlbum();
	
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
			stmtSelect.executeUpdate("DELETE FROM artista WHERE Nome='Pippo';");
			stmtSelect.executeUpdate("DELETE FROM etichetta WHERE Nome='etichettaTest';");
			stmtSelect.executeUpdate("DELETE FROM album WHERE Genere='Pop';");
			stmtSelect.executeUpdate("DELETE FROM digitale WHERE prezzo='1';");
			stmtSelect.executeUpdate("DELETE FROM vinile WHERE prezzo='2';;");
			stmtSelect.executeUpdate("DELETE FROM cd WHERE prezzo='3';");
			stmtSelect.executeUpdate("DELETE FROM brano WHERE Titolo='test3';");
			stmtSelect.executeUpdate("DELETE FROM brano WHERE Titolo='test4';");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void uploadAlbum() throws ServletException, IOException {
		String[] tBraniList = new String [] {"test3","test4","test5"};
		String[] dBraniList = new String [] {"test3","test4","test5"};

		
		when(requestMock.getParameter("artista")).thenReturn("Pippo");
		when(requestMock.getParameter("titolo")).thenReturn("Titolo");
		when(requestMock.getParameter("genere")).thenReturn("Pop");
		when(requestMock.getParameter("data")).thenReturn("15-01-2022");
		when(requestMock.getParameter("dettagli")).thenReturn("Canta");
		when(requestMock.getParameter("etichetta")).thenReturn("etichettaTest");
		when(requestMock.getParameter("brani")).thenReturn("1");
		when(requestMock.getParameter("digitale")).thenReturn("2");
		when(requestMock.getParameter("vinile")).thenReturn("3");
		when(requestMock.getParameter("cd")).thenReturn("4");
		when(requestMock.getParameter("pdigitale")).thenReturn("1");
		when(requestMock.getParameter("pvinile")).thenReturn("2");
		when(requestMock.getParameter("pcd")).thenReturn("3");
		when(requestMock.getParameter("fileName")).thenReturn("fileNameTest");
		when(requestMock.getParameterValues("tbrani")).thenReturn(tBraniList);
		when(requestMock.getParameterValues("dbrani")).thenReturn(dBraniList);


		uploadAlbumTest.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("pages/menager.jsp?cod=1");
	}

}



