package it.ship.servlets.gestioneNews;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ship.beans.Amministratore;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class UploadNews
 */
public class UploadNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			// IMPORTO TUTTO
			String autore = request.getParameter("newstitolo");
			String titolo = request.getParameter("author");
			String categoria = (String) request.getParameter("categoria");
			String copertina = request.getParameter("newscopertina");
			String text = request.getParameter("newstext");

			Calendar cal = Calendar.getInstance();

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println(autore + titolo + categoria + copertina + text + format.format(cal.getTime()));
			Amministratore x= (Amministratore) request.getSession().getAttribute("Amministratore");
			// CREO LA NEWS
			String query = "INSERT INTO news VALUES(null,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, text);
			ps.setString(2, format.format(cal.getTime()));
			ps.setString(3, titolo);
			ps.setString(4, autore);
			ps.setString(5, copertina);
			ps.setString(6, categoria);
			ps.setString(7, "root");
			ps.executeUpdate();
			request.setAttribute("NewsRisultato", true);
			request.getSession().setAttribute("Amministratore", x);
			request.getRequestDispatcher("/pages/menager.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
