package it.ship.servlets.gestioneAlbum;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ship.beans.Album;
import it.ship.beans.Cliente;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class VisualizzaAlbum
 */
public class VisualizzaAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizzaAlbum() {
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
			String pidd = request.getParameter("param1");
			String pid = request.getParameter("param2");
			String piddd=request.getParameter("param3");
			String query=null;
			ArrayList al = null;
			ArrayList<Album> pid_list = new ArrayList<Album>();
			if(pidd.equalsIgnoreCase("Artista"))
			{
			query = "select * from album as a,artista as ar  where ar.ID=a.ID_artista AND " + piddd + "  LIKE '%" + pid + "%'";
			}
			else if(pidd.equalsIgnoreCase("Etichetta"))
			{
				query = "select * from album as a,etichetta as e  where e.ID=a.ID_etichetta AND " + piddd + "  LIKE '%" + pid + "%'";
			}
			else if(pidd.equalsIgnoreCase("Genere"))
			{
			query = "select * from album where " + piddd + "  LIKE '%" + pid + "%'";
			}
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
				pid_list.add(b);

				System.out.println("al :: " + b.toString());
			}
			request.setAttribute("piList", pid_list);
			request.setAttribute("ricerca", pid);
			response.sendRedirect("/pages/searchview.jsp?cod=1");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
