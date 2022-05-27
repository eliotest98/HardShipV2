package it.ship.servlets.gestioneUtente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import it.ship.beans.Amministratore;
import it.ship.beans.Cliente;
import it.ship.beans.ShoppingCart;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println(user +" " + pass);

		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String dbName =
		 * "dbname"; String userName = "root"; String password = "dbpass";
		 */
		try {
			Cliente c = (Cliente) session.getAttribute("cliente");
			ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
			boolean flag=false;
			if (c == null) {
				c = new Cliente();

				Class.forName(driver).newInstance();
				conn = DriverManagerConnectionPool.getConnection();
				String query = "Select * from cliente where Username='" + user + "' && Password='" + pass + "' ;";
				System.out.println("query " + query);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery(query);
				if (rs.next()) {
					synchronized (session) {
						flag=true;
						System.out.println("Entrato");
						c.setID(rs.getInt(1));
						c.setNome(rs.getString(2));
						c.setCognome(rs.getString(3));
						c.setData(rs.getString(4));
						c.setUser(rs.getString(5));
						c.setPass(rs.getString(6));
						c.setCF(rs.getString(7));
						session.setAttribute("cliente", c);
						request.setAttribute("cliente", c);

					}
				} 
				if(flag){
					if (sc == null) {
						sc = new ShoppingCart();
					}
					System.out.println(c.getUser());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					session.setAttribute("sc", sc);
					String sessione = "on";
					request.setAttribute("sessione", sessione);
					response.sendRedirect("pages/home.jsp");
				}
			}	
			String on = "off";
			request.setAttribute("on", on);
			response.sendRedirect("pages/home.jsp");			
			conn.close();
			System.out.println("Disconnected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
