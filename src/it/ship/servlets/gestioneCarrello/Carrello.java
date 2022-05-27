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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ship.beans.Album;
import it.ship.beans.Artista;
import it.ship.beans.Cliente;
import it.ship.beans.Etichetta;
import it.ship.beans.ShoppingCart;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class Home
 */
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Carrello() {
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
		ArrayList<Integer> articoli = new ArrayList<Integer>();
		articoli = (ArrayList<Integer>) session.getAttribute("articoli");
		if (articoli == null) {
			articoli = new ArrayList<Integer>();
		}
		Statement st;
		Cliente s = (Cliente) session.getAttribute("cliente");
		ShoppingCart carello = (ShoppingCart) session.getAttribute("sc");
		System.out.println("Prendo il carello");
		if (carello == null) {
			System.out.println("carello vuoto");
			carello = new ShoppingCart();

			System.out.println("carello creato nel carellojava");

		}

		Album b = new Album();
		int prezzo = 0;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			// String query = "SELECT * FROM `album` INNER JOIN "+ formato+" ON
			// album.ID = "+formato+".ID AND album.ID="+album+"";
			String query = "SELECT * FROM `album` INNER JOIN " + formato + " ON  album.ID=" + album + " LIMIT 1";
			System.out.println("query " + query);
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				b.setId(rs.getInt(1));
				b.setGenere(rs.getString(2));
				b.setTitolo(rs.getString(3));
				b.setCopertina(rs.getString(4));				
				b.setData(rs.getString(6));
				b.setDettagli(rs.getString(8));
				b.setEmbed(rs.getString(7));
				b.setNumBrani(rs.getInt(5));
				prezzo = rs.getInt(13);
			}
			query = "select et.ID , et.Nome , et.Feed from etichetta as et , album as alb where alb.ID= " + b.getId() + "";
			rs = st.executeQuery(query);
			Etichetta e=null;
			while (rs.next()) {
				e = new Etichetta();
				e.setId(rs.getInt(1));
				e.setNome(rs.getString(2));
				e.setFeed(rs.getInt(3));
			}
			query = "select art.ID , art.Nome from artista as art , album as alb where alb.ID= " + b.getId() + " ";
			System.out.println(query);
			rs = st.executeQuery(query);
			Artista a=null;
			while (rs.next()) {
				a=new Artista();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
			}
				carello.addItem(b, prezzo , a , e);
				System.out.println(prezzo);
				System.out.println("aggiungo b al carello");
				query = " INSERT INTO articolo VALUES (null,?,?,?);";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, 1);
				System.out.println("aggiungo il prezzo" + prezzo);
				ps.setInt(2, prezzo);
				ps.setInt(3, b.getId());
				System.out.println(query);
				ps.executeUpdate();

			for (int j = 0; j < carello.getItemsOrdered().size(); j++) {

				System.out.println(carello.getItemsOrdered().toString());
			}
			// query = "INSERT INTO Carrello VALUES ("+s.getID()+",
			// "+id_articolo+"");
			session.setAttribute("cliente", s);
			session.setAttribute("sc", carello);
			session.setAttribute("articoli", articoli);
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
