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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import it.ship.beans.Cliente;
import it.ship.servlets.gestioneUtente.LogInAdmin;

class LoginAdminTest {

	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpServletResponse responseMock = mock(HttpServletResponse.class);
	HttpSession sessionMock = mock(HttpSession.class);
	LogInAdmin logInAdmin = new LogInAdmin();
	RequestDispatcher dispatcherMock = mock(RequestDispatcher.class);
	PrintWriter mockedOut = mock(PrintWriter.class);
	ServletContext mockedServletContext  = mock(ServletContext.class);


	
	/*
	 * Prima di ogni test simula la sessione dell'utente.
	 */
	@BeforeEach
	public void setUp() {
		when(requestMock.getSession()).thenReturn(sessionMock);
	
		
	}

	@Test
	void testTrue() throws ServletException, IOException {
		doReturn(mockedServletContext).when(requestMock).getServletContext();
		when(requestMock.getParameter("user")).thenReturn("root");
		when(requestMock.getParameter("pass")).thenReturn("root");
		logInAdmin.doPost(requestMock, responseMock);
		verify(responseMock).sendRedirect("/pages/menager.jsp");

	}

}



