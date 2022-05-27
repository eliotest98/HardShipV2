package it.ship.servlets.gestioneAlbum;

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

import com.google.gson.Gson;

import it.ship.beans.Album;
import it.ship.beans.Artista;
import it.ship.beans.Etichetta;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class NavBar
 */
public class LiveSearch extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1530301059480826772L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		
		ArrayList<Etichetta> etichette = new ArrayList<Etichetta>();
		ArrayList<Album> album = new ArrayList<Album>();
		ArrayList<Artista> artisti = new ArrayList<Artista>();
		String pid = request.getParameter("pid");

		Statement st;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "select * from album where Titolo LIKE '%" + pid + "%'";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
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
				album.add(b);
				System.out.println(b.getTitolo());

			}
			query = "select * from etichetta where Nome LIKE '%" + pid + "%'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Etichetta e = new Etichetta();
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setFeed(rs.getInt(3));
				etichette.add(e);
				System.out.println(e.getNome());
			}
			query = "select * from artista where Nome LIKE '%" + pid + "%'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Artista b = new Artista();
				b.setId(rs.getInt(1));
				b.setNome(rs.getString(2));
				artisti.add(b);
				System.out.println("aggiungo=" + b.getNome());
			}
			System.out.println(artisti.size());
			String jalbum = new Gson().toJson(album);
			String jetichetta = new Gson().toJson(etichette);
			String jband = new Gson().toJson(artisti);

			String[] list = { jalbum, jetichetta, jband };

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
	}
}