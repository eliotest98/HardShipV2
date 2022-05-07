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

import it.ship.beans.Album;
import it.ship.beans.Brano;
import it.ship.beans.Cd;
import it.ship.beans.Cliente;
import it.ship.beans.Digitale;
import it.ship.beans.Feedback;
import it.ship.beans.Vinile;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class Shop
 */
public class DettagliAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DettagliAlbum() {
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
			int idArtista=0;
			int idetichetta=0;
			String Artista =null;
			String Etichetta=null;
			Cliente cli= (Cliente) request.getSession().getAttribute("cliente");
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String pid = request.getParameter("param1");
			if(pid== null){
				pid = (String) request.getAttribute("param1");
			}

			ArrayList al = null;
			String query = "select * from album where ID  LIKE '%" + pid + "%'";

			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			Album b = new Album();
			if (rs.next()) {
				b.setId(rs.getInt(1));
				b.setGenere(rs.getString(2));
				b.setTitolo(rs.getString(3));
				b.setCopertina(rs.getString(4));				
				b.setData(rs.getString(6));
				b.setDettagli(rs.getString(8));
				b.setEmbed(rs.getString(7));
				b.setNumBrani(rs.getInt(5));
				idArtista=rs.getInt(11);
				idetichetta=rs.getInt(10);
			}
			query = "select * FROM artista WHERE ID="+idArtista;
			rs = st.executeQuery(query);
			if (rs.next()) {
				Artista=rs.getString(2);
			}
			query = "select * FROM etichetta WHERE ID="+idetichetta;
			rs = st.executeQuery(query);
			if (rs.next()) {
				Etichetta=rs.getString(2);
			}
			Digitale dig = new Digitale();
			query = "select * FROM digitale as d,album as al WHERE al.ID=" + pid + " AND d.ID_album=al.ID";
			rs = st.executeQuery(query);
			if (rs.next()) {
				dig.setId(rs.getInt(1));
				dig.setPrezzo(rs.getInt(2));
				dig.setNumCopie(rs.getInt(3));
			}
			Vinile vynil = new Vinile();
			query = "select * FROM vinile as v,album as al WHERE al.ID=" + pid + " AND v.ID_album=al.ID";
			rs = st.executeQuery(query);
			if (rs.next()) {
				vynil.setId(rs.getInt(1));
				vynil.setPrezzo(rs.getInt(2));
				vynil.setNumCopie(rs.getInt(3));
			}
			Cd cd = new Cd();
			query = "select * FROM cd as c,album as al WHERE al.ID=" + pid + " AND c.ID_album=al.ID";
			rs = st.executeQuery(query);
			if (rs.next()) {
				cd.setId(rs.getInt(1));
				cd.setPrezzo(rs.getInt(2));
				cd.setNumCopie(rs.getInt(3));
			}
			ArrayList<Brano> brani = new ArrayList<Brano>();
			query = "select * FROM brano as br, album as al WHERE al.ID=br.ID_album AND al.ID=" +b.getId()+"";
			System.out.println(query);
			rs = st.executeQuery(query);
			while (rs.next()) {
				Brano n = new Brano();
				n.setId(rs.getInt(1));
				n.setTitolo(rs.getString(2));
				n.setAnno(rs.getString(3));
				n.setDurata(rs.getString(4));
				brani.add(n);

				System.out.println("aggiungo: " + n.getTitolo());
			}
			ArrayList<Feedback> feedback = new ArrayList<Feedback>();
			query = "select * FROM feedback as feed , cliente as cli WHERE ID_Album="+b.getId()+" AND feed.ID_Cliente=cli.ID";
			rs = st.executeQuery(query);
			while (rs.next()) {
				Feedback n = new Feedback();
				n.setID(rs.getInt(1));
				n.setTitolo(rs.getString(2));
				n.setTesto(rs.getString(3));
				n.setData(rs.getString(4));
				n.setUtente(rs.getString(12));
				feedback.add(n);

				System.out.println("aggiungo: " + n.toString());
			}
			request.setAttribute("etichetta", Etichetta);
			request.setAttribute("artista", Artista);
			request.setAttribute("Brani", brani);
			request.setAttribute("CD", cd);
			request.setAttribute("Vinyl", vynil);
			request.setAttribute("Digitale", dig);
			request.setAttribute("b", b);
			request.setAttribute("feedback", feedback);
			request.setAttribute("ricerca", pid);
			request.getSession().setAttribute("cliente", cli);
			RequestDispatcher view = request.getRequestDispatcher("/pages/shop.jsp");
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
