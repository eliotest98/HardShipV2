package it.ship.test.gestioneUtente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import it.ship.servlets.gestioneUtente.RegistrazioneUtente;

class RegistrazioneUtenteTest {
	
	HttpServletRequest requestMock =  mock(HttpServletRequest.class);
	MockHttpServletResponse responseMock = new MockHttpServletResponse();
	HttpSession sessionMock =  mock(HttpSession.class);
	RegistrazioneUtente registrazioneUtente = mock(RegistrazioneUtente.class);
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	RegistrazioneUtente regUtenteTest = new RegistrazioneUtente();

	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
	}
	
	
	
	@Test
	void testTrue() throws ServletException, IOException {
		when(requestMock.getParameter("frist_name")).thenReturn("Mario");
		when(requestMock.getParameter("last_name")).thenReturn("Rossi");
		when(requestMock.getParameter("user")).thenReturn("mario");
		when(requestMock.getParameter("password")).thenReturn("passwordTest");
		when(requestMock.getParameter("CF")).thenReturn("ZCXZVJ86E03L710J");
		when(requestMock.getParameter("data")).thenReturn("2022-01-15");
		when(requestMock.getParameter("email")).thenReturn("mariorossi@test.com");
		regUtenteTest.doPost(requestMock, responseMock);
		System.out.println(requestMock.getContextPath());
		verify(responseMock).sendRedirect(requestMock.getContextPath()+"/pages/home.jsp");

	}

}
