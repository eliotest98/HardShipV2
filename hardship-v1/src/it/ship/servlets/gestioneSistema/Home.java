package it.ship.servlets.gestioneSistema;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.ship.beans.Album;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "dbname"; String userName = "root"; String password = "dbpass";
		 */

		Statement st;
		ArrayList<Album> card = new ArrayList<Album>();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "SELECT * FROM `album`  ORDER BY `Data`  DESC LIMIT 4;";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs = st.executeQuery(query);
			while (rs.next()) {
				Album b = new Album();
				b.setId(rs.getInt(1));
				b.setGenere(rs.getString(2));
				b.setTitolo(rs.getString(3));
				b.setCopertina(rs.getString(4));				
				b.setData(rs.getString(6));
				b.setDettagli(rs.getString(8));
				b.setEmbed(rs.getString(7));
				b.setNumBrani(rs.getInt(5));
				card.add(b);
			}
			String jcard = new Gson().toJson(card);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jcard);
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
