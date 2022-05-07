<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/materialize.min.js"></script>

	<%@include file="../frag/header.jsp"%>
	<jsp:useBean id="Album" scope="session" class="it.ship.beans.Album" />
	<%@page import="it.ship.beans.Album"%>
	<!--FINE NAV-->
	<main> <%
 	int count = 0;
 	String ricerca = (String) request.getAttribute("ricerca");
 	ArrayList<Album> a = new ArrayList<Album>();
 	if (request.getAttribute("piList") != null) {
 		a = (ArrayList<Album>) request.getAttribute("piList");
 		System.out.println(a);
 %>
	
	<%
			for (int i = 0; i < a.size(); i++) {
		%>
	<div class="row">
		<div class="col s12 m12 l12">
			<div class="card horizontal">
				<div class="card-image">
					<img class="search" src="<%=a.get(i).getCopertina()%>">
				</div>
				<div class="card-stacked">
					<div class="card-content">
						<p>
							<%=a.get(i).getTitolo()%> 
							<a class="btn-floating btn-small waves-effect" style="float: right;rgba(9, 86, 72, 0.68);" href="${pageContext.request.contextPath}/DettagliAlbum?param1=<%=a.get(i).getId() %>">
							<i class="material-icons">play_arrow</i>
						</a>
						</p>
						
					</div>

				</div>
			</div>
		</div>

		<%
				if (((i % 3) == 0 && i != 0)) {
			%>
	</div>
	<div class="row">
		<%
				}
			%>
		<%
				count++;
					}
			%>
	</div>


	<%
			}

			if (count == 0) {
		%>
	<p class="red-text lighten-1 center-align" style="font-size:22px;">Nessun risultato per la ricerca effettuata</p>
	<p class="center-align" style="font-size:22px;">Se si desidera richiedere un album da inserire è possibile compilando la form di Richiesta Album.</p>
	<p class="center-align" style="font-size:22px;">Questa form è possibile compilarla soltanto dagli utenti registrati.</p>
	<%
			}
		%> </main>

	<!-- SCRIPT-->
	<script>
		$(document).ready(function() {
			$('.slider').slider();
			$('.modal-trigger').leanModal({
				dismissible : true, // Modal can be dismissed by clicking outside of the modal
				opacity : .5, // Opacity of modal background
				in_duration : 300, // Transition in duration
				out_duration : 200, // Transition out duration
			});
		});
	</script>
	<script>
		$(".button-collapse").sideNav();
	</script>


	<!-- FOOTER -->

	<%@include file="../frag/footer.jsp"%>


</body>
</html>