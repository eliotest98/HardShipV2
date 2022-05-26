package it.ship.servlets.gestioneCarrello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ship.beans.ShoppingCart;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class DeleteItem
 */
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		String album = request.getParameter("id");
		String formato = request.getParameter("formato");
		System.out.println(album + formato);
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		
		HttpSession session = request.getSession();
		Statement st;
		ShoppingCart carello = (ShoppingCart) session.getAttribute("sc");
		ArrayList<Integer> articoli = (ArrayList<Integer>) session.getAttribute("articoli");
		int index = Integer.parseInt(request.getParameter("n"));
		carello.deletItem(index);
		articoli.remove(index);
		session.setAttribute("articoli", articoli);
		session.setAttribute("sc", carello);
		System.out.println("Prendo il carello");

		int prezzo = 0;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "SELECT * FROM `album`INNER JOIN digitale ON album.ID = digitale.ID AND album.ID=" + album
					+ "";
			System.out.println("query " + query);
			st = conn.createStatement();

			System.out.println("aggiungo b al carello");

			System.out.println("Elemento eliminato");
			session.setAttribute("sc", carello);
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
