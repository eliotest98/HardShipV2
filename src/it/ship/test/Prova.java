package it.ship.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.ship.beans.Cliente;
import it.ship.servlets.gestioneAlbum.DettagliAlbum;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

class Prova {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);

	@BeforeEach
	void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
	}

	@Test
	void visualizzaDettagliAlbum() {
		DettagliAlbum dettagliAlbum = new DettagliAlbum();
		try {
			sessionMock.setAttribute("cliente", new Cliente(0, "elio", "testa", "15/02/2022", "eliotesta98",
					"eliotesta98", "TSTLEI98D09I805P", "e.testa7@studenti.unisa.it"));
			requestMock.
			dettagliAlbum.doGet(requestMock, responseMock);
			sessionMock.removeAttribute("cliente");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void test() {
		System.out.println("Strunz");
	}

}
