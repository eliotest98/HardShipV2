package it.ship.servlets.gestioneAlbum;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ship.beans.Amministratore;
import it.ship.beans.Cliente;
import it.ship.beans.Richiesta;
import it.ship.servlets.gestioneSistema.DriverManagerConnectionPool;

/**
 * Servlet implementation class EliminaRichieste
 */
public class EliminaRichieste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaRichieste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Amministratore a=(Amministratore)request.getSession().getAttribute("Amministratore");
		String[] richieste=request.getParameterValues("idnotifica");
		String[] daEliminare=request.getParameterValues("check");
		for(int i=0;i<daEliminare.length;i++){
			Connection conn = null;
			String driver = "com.mysql.jdbc.Driver";
			Statement st;
			PreparedStatement ps;
			try {
				Class.forName(driver).newInstance();
				conn = DriverManagerConnectionPool.getConnection();
				String query = "delete from richiesta where ID="+richieste[Integer.parseInt(daEliminare[i])];
				ps = conn.prepareStatement(query);
				ps.executeUpdate();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("Amministratore", a);
		RequestDispatcher view = request.getRequestDispatcher("/pages/notificaAdmin.jsp");
		view.forward(request, response);
	}

}
