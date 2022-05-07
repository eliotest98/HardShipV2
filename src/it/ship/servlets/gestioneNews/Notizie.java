package it.ship.servlets.gestioneNews;

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

import it.ship.beans.News;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class Home
 */
public class Notizie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Notizie() {
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
		Statement st;
		ArrayList<News> slide = new ArrayList<News>();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "SELECT * FROM `news`  ORDER BY `news`.`Data`  DESC LIMIT 4;";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs = st.executeQuery(query);
			while (rs.next()) {
				News b = new News();
				b.setId(rs.getInt(1));
				b.setContenuto(rs.getString(2));
				b.setData(rs.getString(3));
				b.setAutore(rs.getString(4));
				b.setTitolo(rs.getString(5));
				b.setCopertina(rs.getString(6));
				b.setCategoria(rs.getString(7));
				slide.add(b);
			}
			String jslide = new Gson().toJson(slide);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jslide);
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
