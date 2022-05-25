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
public class LogInAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInAdmin() {
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
		System.out.println(user + pass);

		Amministratore c = new Amministratore();
			try {
				Boolean admin=false;
				Class.forName(driver).newInstance();
				conn = DriverManagerConnectionPool.getConnection();
				String query = "Select * from amministratore where Username='" + user + "' && Password='" + pass + "' ;";
				System.out.println("query " + query);
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery(query);
				if (rs.next()) {
					synchronized (session) {
						c.setUsername(rs.getString(1));
						c.setPassword(rs.getString(2));
						request.setAttribute("amministratore", c);
						admin=true;
					}
				}
				System.out.println(c.toString());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				if(admin){
				session.setAttribute("Amministratore", c);
				session.setMaxInactiveInterval(30*60);}
				response.sendRedirect("/pages/menager.jsp");
				conn.close();
				System.out.println("Disconnected!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}