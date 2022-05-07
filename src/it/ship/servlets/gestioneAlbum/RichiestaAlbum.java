package it.ship.servlets.gestioneAlbum;

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

import java.sql.PreparedStatement;

import it.ship.beans.Album;
import it.ship.beans.Cliente;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class InserimentoAlbumUtente
 */
public class RichiestaAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiestaAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		Statement st;
		PreparedStatement ps;
		Cliente cli=(Cliente) request.getSession().getAttribute("cliente");
		System.out.print(cli.getUser());
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String artista = request.getParameter("art");
			String titolo = request.getParameter("tit");
			System.out.println(artista + " " +titolo);
			String query = "insert into richiesta values(null,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, titolo);
			ps.setString(2, artista);
			ps.setInt(3, cli.getID());
			ps.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("cliente", cli);
		RequestDispatcher view = request.getRequestDispatcher("/pages/home.jsp");
		view.forward(request, response);
	}

}
