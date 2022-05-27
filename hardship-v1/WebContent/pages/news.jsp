<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="theme-color" content="#373641">
<link rel='shourtcut icon' href='favicon.ico' type='image/x-icon' />
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

	<jsp:useBean id="news" scope="session" class="it.ship.beans.News" />
	<%@page import="it.ship.beans.News"%>
	<!--FINE NAV-->
	<%
		ArrayList<News> cronaca = (ArrayList<News>) request.getAttribute("cronaca");
		ArrayList<News> biografie = (ArrayList<News>) request.getAttribute("biografia");
		ArrayList<News> uscite = (ArrayList<News>) request.getAttribute("uscite");
	%>

	<div class="parallax-container">
		<div class="parallax">
			<img src="${pageContext.request.contextPath}/img/large_3.png"
				style="display: block; transform: translate3d(-50%, 298px, 0px);">
		</div>
	</div>
	<div class="section white">
		<div class="row container">
			<h4>BIOGRAFIE</h4>

			<div class="row">
				<%
					for (int i = 0; i < biografie.size(); i++) {
				%>
				<div class="col s12 m6 l4">
					<div class=" card">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="<%=biografie.get(i).getCopertina()%>">
						</div>
						<div class="card-content">
							<span class="card-title activator grey-text text-darken-4"><%=biografie.get(i).getTitolo()%><i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="${pageContext.request.contextPath}/ReadMore?news=<%=biografie.get(i).getId() %>">Read more</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><%=biografie.get(i).getTitolo()%><i
								class="material-icons right">close</i></span>
							<p>
								Articolo a cura di:
								<%=biografie.get(i).getAutore()%></p>
						</div>
					</div>

				</div>

				<%
					}
				%>
			</div>
		</div>
	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="${pageContext.request.contextPath}/img/large_3.png"
				style="display: block; transform: translate3d(-50%, 298px, 0px);">
		</div>
	</div>
	<div class="section white">
		<div class="row container">
			<h4>CRONACA</h4>

			<div class="row">
				<%
					for (int i = 0; i < cronaca.size(); i++) {
				%>

				<div class="col s12 m6 l4">
					<div class=" card">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="<%=cronaca.get(i).getCopertina()%>">
						</div>
						<div class="card-content">
							<span class="card-title activator grey-text text-darken-4"><%=cronaca.get(i).getTitolo()%><i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="${pageContext.request.contextPath}/ReadMore?news=<%=cronaca.get(i).getId() %>">Read more</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"> <%=cronaca.get(i).getTitolo()%><i
								class="material-icons right">close</i></span>
							<p>
								Articolo a cura di:<%=cronaca.get(i).getAutore()%></p>
						</div>
					</div>
				</div>

				<%
					}
				%>
			</div>

		</div>


	</div>
	<div class="parallax-container">
		<div class="parallax">
			<img src="${pageContext.request.contextPath}/img/large_3.png"
				style="display: block; transform: translate3d(-50%, 298px, 0px);">
		</div>
	</div>
	<div class="section white">
		<div class="row container">
			<h4>Nuove uscite</h4>

			<div class="row">
				<%
					for (int i = 0; i < uscite.size(); i++) {
				%>

				<div class="col s12 m6 l4">
					<div class=" card">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="<%=uscite.get(i).getCopertina()%>">
						</div>
						<div class="card-content">
							<span class="card-title activator grey-text text-darken-4"><%=uscite.get(i).getTitolo()%><i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="${pageContext.request.contextPath}/ReadMore?news=<%=uscite.get(i).getId() %>">Read more</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"> <%=uscite.get(i).getTitolo()%><i
								class="material-icons right">close</i></span>
							<p>
								Articolo a cura di:<%=uscite.get(i).getAutore()%></p>
						</div>
					</div>
				</div>

				<%
					}
				%>
			</div>

		</div>


	</div>


	<!-- SCRIPT -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('.parallax').parallax();

		});
	</script>

	<!--FINE Bottone -->
	<%@include file="../frag/footer.jsp"%>


</body>
</html>