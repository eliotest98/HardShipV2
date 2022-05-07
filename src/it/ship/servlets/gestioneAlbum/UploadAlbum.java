package it.ship.servlets.gestioneAlbum;

import java.io.IOException;
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

import it.ship.beans.Amministratore;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class UploadAlbum
 */
public class UploadAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadAlbum() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement st;
		Amministratore x= (Amministratore) request.getSession().getAttribute("Amministratore");
		int album = 0;
		int idartista = 0;
		int idetichetta = 0;
		int iddigitale = 0;
		int idvinile = 0;
		int idcd = 0;
		ArrayList<Integer> idbrani = new ArrayList<Integer>();

		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		try {
			String query;
			PreparedStatement ps;
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			// IMPORTO TUTTO
			String autore = request.getParameter("artista");
			String titolo = request.getParameter("titolo");
			String genere = request.getParameter("genere");
			String data = request.getParameter("data");
			String dettagli = request.getParameter("dettagli");
			String etichetta = request.getParameter("etichetta");
			int nbrani = Integer.parseInt(request.getParameter("brani"));
			int digitale = Integer.parseInt(request.getParameter("digitale"));
			int vinile = Integer.parseInt(request.getParameter("vinile"));
			int cd = Integer.parseInt(request.getParameter("cd"));
			int pdigitale = Integer.parseInt(request.getParameter("pdigitale"));
			int pvinile = Integer.parseInt(request.getParameter("pvinile"));
			int pcd = Integer.parseInt(request.getParameter("pcd"));
			String file = "img/" + request.getParameter("fileName");
			String[] brani = request.getParameterValues("tbrani");
			String[] durate = request.getParameterValues("dbrani");
			// AGGIUNGO ARTISTA
			query = "INSERT IGNORE INTO artista (Nome) VALUES (?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, autore);
			ps.executeUpdate();
			int ic = ps.executeUpdate();

			if (ic > 0) {
				ResultSet i = ps.getGeneratedKeys();
				if (i.next()) {
					idartista = i.getInt(1);

				}
			}
			if (ic == 0) {
				query = "SELECT ID FROM artista WHERE Nome = ? ";
				ps = conn.prepareStatement(query);
				ps.setString(1, autore);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idartista = rs.getInt(1);
				}
			}
			System.out.println("ID AUTORE:" + idartista);
			System.out.println("AGGIUNTO ARTISTA : " + idartista);
			// AGGIUNGO L'ETICHETTA
			query = "INSERT IGNORE INTO etichetta (Nome) VALUES (?);";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, etichetta);
			ps.executeUpdate();
			ic = ps.executeUpdate();

			if (ic > 0) {
				ResultSet i = ps.getGeneratedKeys();
				if (i.next()) {
					idetichetta = i.getInt(1);

				}
			}
			if (ic == 0) {
				query = "SELECT ID FROM artista WHERE Nome = ? ";
				ps = conn.prepareStatement(query);
				ps.setString(1, etichetta);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					idetichetta = rs.getInt(1);
				}
			}
			System.out.println("AGGIUNGO L'ETICHETTA" + idetichetta);
			System.out.println(brani.length + "  " + durate.length);
			System.out.println(autore + titolo + genere + data + dettagli + etichetta + nbrani + file + brani[1]
					+ durate[1] + digitale + vinile + cd + pdigitale + pvinile + pcd);
			// CREO L'ALBUM
			query = "insert into album values (null,?,?,?,?,?,null,?,?,?,?) ";
			System.out.println("query " + query);
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, genere);
			ps.setString(2, titolo);			
			ps.setString(3, file);
			ps.setInt(4, nbrani);
			ps.setString(5, data);
			ps.setString(6, dettagli);
			ps.setString(7, "root");
			ps.setInt(8, idetichetta);
			ps.setInt(9, idartista);
			
			ps.executeUpdate();
			ResultSet id = ps.getGeneratedKeys();
			if (id.next()) {
				album = id.getInt(1);
			}
			System.out.println("AGGIUNTO ALBUM :" + album);

			// AGGIUNGO COPIE DIGITALI
			query = "insert into digitale VALUES(null,?,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pdigitale);
			ps.setInt(2, digitale);
			ps.setInt(3, album);
			ps.executeUpdate();
			id = ps.getGeneratedKeys();
			if (id.next()) {
				iddigitale = id.getInt(1);
			}
			System.out.println("HO AGGIUNTO DIGITALE" + iddigitale);
			// AGGIUNGO VINILI
			query = "insert into vinile VALUES(null,?,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pvinile);
			ps.setInt(2, vinile);
			ps.setInt(3, album);
			ps.executeUpdate();
			id = ps.getGeneratedKeys();
			if (id.next()) {
				idvinile = id.getInt(1);
			}
			System.out.println("AGGIUNTI VINILI" + idvinile);
			// AGGIUNGO CD
			query = "insert into cd VALUES(null,?,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, pcd);
			ps.setInt(2, cd);
			ps.setInt(3, album);
			ps.executeUpdate();
			id = ps.getGeneratedKeys();
			if (id.next()) {
				idcd = id.getInt(1);
			}
			System.out.println("AGGIUNTI I CD" + idcd);
			// AGGIUNGO I BRANI
			query = "insert into brano VALUES(null,?,?,?,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < brani.length - 1; i++) {
				System.out.println(brani[i]);
				ps.setString(1, brani[i]);
				ps.setInt(4, album);
				ps.setString(2, data.substring(7));
				ps.setString(3, durate[i]);
				ps.setInt(5, idartista);
				ps.executeUpdate();
				System.out.println("AGGIUNGO BRANO " + brani[i].toString());
				id = ps.getGeneratedKeys();
				if (id.next()) {
					idbrani.add((int) id.getLong(1));
				}
			}
			
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			request.setAttribute("AlbumRisultato", true);
			request.getSession().setAttribute("Amministratore", x);
			request.getRequestDispatcher("/pages/menager.jsp").forward(request, response);
			conn.close();

			System.out.println("Disconnected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
