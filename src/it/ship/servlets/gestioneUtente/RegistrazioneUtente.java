package it.ship.servlets.gestioneUtente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ship.beans.Album;
import it.ship.beans.Brano;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class NavBar
 */@WebServlet("/RegistrazioneUtente")
public class RegistrazioneUtente extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530301059480826772L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Connection conn = null;
		try {
			conn = DriverManagerConnectionPool.createDBConnection();
			System.out.println("Connected!");
			String nome = request.getParameter("first_name");
			String cognome = request.getParameter("last_name");
			String user = request.getParameter("user");
			String pass = request.getParameter("password");
			String cf = request.getParameter("CF");
			String data = request.getParameter("data");
			String email = request.getParameter("email");
			System.out.println(nome + cognome + user + pass + cf + data + email);
			String query = "insert into cliente values (null,?,?,?,?,?,?,?)";
			System.out.println("query " + query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, data);
			ps.setString(4, user);
			ps.setString(5, pass);
			ps.setString(6, cf);
			ps.setString(7, email);
			System.out.println("query " + ps.toString());
			int i = ps.executeUpdate();
			if (i>0) {
				System.out.println("GG");
			}

			response.sendRedirect("pages/home.jsp?cod=1");
			conn.close();

			System.out.println("Disconnected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}