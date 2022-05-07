<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HARDSHIP</title>
<meta charset="UTF-8">
<meta name="theme-color" content="#373641">
<link rel='shourtcut icon' href='favicon.ico' type='image/x-icon' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/materialize.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<style>
div.error {
	position: relative;
	top: -1rem;
	left: 0rem;
	font-size: 0.8rem;
	color: #FF4081;
	-webkit-transform: translateY(0%);
	-ms-transform: translateY(0%);
	-o-transform: translateY(0%);
	transform: translateY(0%);
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
	<jsp:useBean id="amministratore" scope="session"
		class="it.ship.beans.Amministratore" />
	<jsp:useBean id="DriverManagerConnectionPool" scope="session"
		class="it.ship.servlets.gestioneSistema.DriverManagerConnectionPool" />
	<%@page import="it.ship.beans.Amministratore"%>
	<%
		Amministratore a = (Amministratore) request.getSession().getAttribute("Amministratore");
		if (a != null) {
			request.getSession().setAttribute("Amministratore", a);
			java.sql.Connection conn = null;
			java.util.ArrayList<it.ship.beans.Richiesta> richieste = new java.util.ArrayList<it.ship.beans.Richiesta>();
			java.util.ArrayList<it.ship.beans.Cliente> utentirichieste = new java.util.ArrayList<it.ship.beans.Cliente>();
			java.util.ArrayList<Boolean> inseriri = new java.util.ArrayList<Boolean>();
			java.util.ArrayList<it.ship.beans.Richiesta> daEliminare = new java.util.ArrayList<it.ship.beans.Richiesta>();
			String driver = "com.mysql.jdbc.Driver";
			Boolean Notification = false;
			java.sql.Statement st;
			try {
				Class.forName(driver).newInstance();
				conn = DriverManagerConnectionPool.getConnection();
				System.out.println("Connected!");
				String query = "select * from richiesta as r , cliente as c where r.ID_cliente=c.ID";
				st = conn.createStatement();
				java.sql.ResultSet rs = st.executeQuery(query);
				System.out.println("Sono qui");
				while (rs.next()) {
					it.ship.beans.Richiesta richiestasingola = new it.ship.beans.Richiesta();
					richiestasingola.setId(rs.getInt(1));
					richiestasingola.setNomeAlbum(rs.getString(2));
					richiestasingola.setNomeArtista(rs.getString(3));
					richieste.add(richiestasingola);
					it.ship.beans.Cliente utentesingolo = new it.ship.beans.Cliente();
					utentesingolo.setUser(rs.getString(9));
					utentesingolo.setID(rs.getInt(4));
					utentirichieste.add(utentesingolo);
				}
				request.setAttribute("richieste", richieste);
			} catch (Exception e) {
				System.out.println(e);
			}
	%>
	<div class="container">
		<div class="row">
			<h4 class="red-text lighten-1 center-align">Notifiche
				inserimento Album</h4>
		</div>
		<form id="second" method="post"
			action="${pageContext.request.contextPath}/EliminaRichieste">
			<table class="responsive-table centered striped">
				<thead>
					<tr>
						<th data-field="utente">Nome Utente</th>
						<th data-field="artista">Artista</th>
						<th data-field="album">Album</th>
						<th data-field="check">Inserito</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < richieste.size(); i++) {
					%>
					<tr>
						<td><%=utentirichieste.get(i).getUser()%></td>
						<td><%=richieste.get(i).getNomeArtista()%></td>
						<td><%=richieste.get(i).getNomeAlbum()%></td>
						<td><input type="checkbox" name="check" id="<%=i%>"
							value="<%=i%>" /><label for="<%=i%>"></label></td>
						<td><input name="idnotifica"
							style="visibility: hidden; width: 1px; height: 1px;"
							value="<%=richieste.get(i).getId()%>"></input></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

			<!-- Bottone -->


			<button class="btn waves-effect waves-light right" type="submit"
				form="second">Elimina Inseriti</button>
		</form>
		<button onclick="location.href='${pageContext.request.contextPath}/pages/menager.jsp';"
			class="btn waves-effect waves-light left" type="submit" name="action">Torna
			al pannello</button>
	</div>
	<%
		} else {
	%>
	<h4 class="red-text lighten-1 center-align">Sezione riservata.</h4>
	<%
		}
	%>


</body>
</html>