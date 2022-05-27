package it.ship.servlets.gestioneSistema;

import java.io.IOException;import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.ship.beans.Album;
import it.ship.beans.Artista;
import it.ship.beans.Etichetta;

/**
 * Servlet implementation class NavBar
 */
public class NavBar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530301059480826772L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "dbname"; String userName = "root"; String password = "dbpass";
		 */

		Statement st;
		ArrayList<Artista> band = new ArrayList<Artista>();
		ArrayList<Album> generi = new ArrayList<Album>();
		ArrayList<Etichetta> etichette = new ArrayList<Etichetta>();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "select * from Artista";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Artista b = new Artista();
				b.setId(rs.getInt(1));
				b.setNome(rs.getString(2));
				band.add(b);

			}
			query = "select * from etichetta";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Etichetta e = new Etichetta();
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setFeed(rs.getInt(3));
				etichette.add(e);
			}
			query = "select  * from album GROUP BY Genere";
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
				generi.add(b);
			}
			String jband = new Gson().toJson(band);
			String jetichetta = new Gson().toJson(etichette);
			String jgeneri = new Gson().toJson(generi);

			String[] list = { jband, jetichetta, jgeneri };

			String all = new Gson().toJson(list);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(all);
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