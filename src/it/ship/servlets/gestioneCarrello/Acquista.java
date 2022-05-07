package it.ship.servlets.gestioneCarrello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ship.beans.Cliente;
import it.ship.beans.ShoppingCart;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class Acquista
 */
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Acquista() {
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
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		String method = (String) request.getParameter("method");
		String indirizzo = (String) request.getParameter("indirizzo");
		System.out.println(method + indirizzo);
		ShoppingCart cart = (ShoppingCart) session.getAttribute("sc");
		Cliente c = (Cliente) session.getAttribute("cliente");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		ArrayList<Integer> articoli = (ArrayList<Integer>) session.getAttribute("articoli");
		Statement st;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			String query = "INSERT INTO fattura VALUES(null,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			Date data = new Date();
			ps.setString(1, method);
			ps.setString(2, indirizzo);
			ps.setString(3, format.format(data.getTime()));
			ps.setInt(4, c.getID());
			ps.executeUpdate();
			query = "SELECT MAX(ID) FROM fattura";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			int fattura;
			if (rs.next()) {
				fattura = rs.getInt(1);
				if(articoli!=null){
					for (int i = 0; i < articoli.size(); i++) {
						query = "INSERT INTO composizione VALUES(?,?)";
						ps = conn.prepareStatement(query);
						ps.setInt(1, fattura);
						ps.setInt(2, articoli.get(i));
						ps.executeUpdate();
					}
				}				

			}
			if(cart.getItemsOrdered().size()>0){
				request.setAttribute("Acquisto", true);}
			else{
				request.setAttribute("Acquisto", false);
			}
			cart.getItemsOrdered().clear();
			cart.getPrezzi().clear();
			if(articoli!=null)articoli.clear();
			session.setAttribute("sc", cart);
			session.setAttribute("articoli", articoli);
			response.setCharacterEncoding("UTF-8");
			RequestDispatcher view = request.getRequestDispatcher("/pages/home.jsp");
			view.forward(request, response);
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
