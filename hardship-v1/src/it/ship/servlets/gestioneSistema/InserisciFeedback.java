package it.ship.servlets.gestioneSistema;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ship.beans.Album;
import it.ship.beans.Brano;
import it.ship.beans.Cd;
import it.ship.beans.Cliente;
import it.ship.beans.Digitale;
import it.ship.beans.Feedback;
import it.ship.beans.Vinile;

/**
 * Servlet implementation class Shop
 */
public class InserisciFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserisciFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Sono Entrato");
		PrintWriter out = response.getWriter();
		String testo = request.getParameter("testo");
		String idAlbum = request.getParameter("id");
		int utente=Integer.parseInt(request.getParameter("user"));
		Connection conn = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String driver = "com.mysql.jdbc.Driver";
		Statement st;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "insert into feedback values (null,?,?,?,?,?) ";
			String titolo=request.getParameter("titolo");
			System.out.println("query " + query);
			st = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, titolo);
			ps.setString(2, testo);
			ps.setString(3, format.format(cal.getTime()));
			ps.setInt(4, Integer.parseInt(idAlbum));
			ps.setInt(5, utente);
			int i = ps.executeUpdate();
			if(i >0){System.out.println("Feed inserito correttamente");}			
			request.setAttribute("param1", idAlbum);
			System.out.println("Faccio il redirect");
			conn.close();
			response.sendRedirect("/DettagliAlbum");
			System.out.println("Disconnected!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
