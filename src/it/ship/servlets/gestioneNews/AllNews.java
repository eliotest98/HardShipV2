package it.ship.servlets.gestioneNews;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ship.beans.News;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class AllNews
 */
public class AllNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "dbname"; String userName = "root"; String password = "dbpass";
		 */

		Statement st;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			ArrayList<News> cronaca = new ArrayList<News>();
			ArrayList<News> biografia = new ArrayList<News>();
			ArrayList<News> uscite = new ArrayList<News>();
			String qcronaca = "SELECT * FROM news WHERE Categoria = 'Cronaca' ORDER BY `news`.`Data`  DESC";
			String qbiografia = "SELECT * FROM news WHERE Categoria = 'Biografia' ORDER BY `news`.`Data`  DESC";
			String quscite = "SELECT * FROM news WHERE Categoria = 'Nuove uscite' ORDER BY `news`.`Data`  DESC";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(qcronaca);

			while (rs.next()) {
				News b = new News();
				b.setId(rs.getInt(1));
				b.setContenuto(rs.getString(2));
				b.setData(rs.getString(3));
				b.setAutore(rs.getString(4));
				b.setTitolo(rs.getString(5));
				b.setCopertina(rs.getString(6));
				b.setCategoria(rs.getString(7));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				cronaca.add(b);
				System.out.println("al :: " + b.toString());
			}
			rs = st.executeQuery(qbiografia);
			while (rs.next()) {
				News b = new News();
				b.setId(rs.getInt(1));
				b.setContenuto(rs.getString(2));
				b.setData(rs.getString(3));
				b.setAutore(rs.getString(4));
				b.setTitolo(rs.getString(5));
				b.setCopertina(rs.getString(6));
				b.setCategoria(rs.getString(7));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				biografia.add(b);
				System.out.println("al :: " + b.toString());
			}
			rs = st.executeQuery(quscite);
			while (rs.next()) {
				News b = new News();
				b.setId(rs.getInt(1));
				b.setContenuto(rs.getString(2));
				b.setData(rs.getString(3));
				b.setAutore(rs.getString(4));
				b.setTitolo(rs.getString(5));
				b.setCopertina(rs.getString(6));
				b.setCategoria(rs.getString(7));
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				uscite.add(b);
				System.out.println("al :: " + b.toString());
			}
			request.setAttribute("cronaca", cronaca);
			request.setAttribute("biografia", biografia);
			request.setAttribute("uscite", uscite);
			RequestDispatcher view = request.getRequestDispatcher("/pages/news.jsp");
			view.forward(request, response);
			conn.close();
			System.out.println("Disconnected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
