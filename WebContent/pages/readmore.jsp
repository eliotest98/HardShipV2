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
		News notizia = (News) request.getAttribute("news");
	%>

	<div class="parallax-container">
		<div class="parallax">
			<img src="<%= notizia.getCopertina() %>"
				style="display: block; transform: translate3d(-50%, 298px, 0px);">
		</div>
	</div>
	<div class="section white">
		<div class="row container">
			<h4><%= notizia.getTitolo() %></h4>
			<p class="grey-text text-lighten-1 right-align"><%=notizia.getData()%>, <%=notizia.getAutore() %></p>
			<p class="grey-text text-darken-3 lighten-3"><%=notizia.getContenuto() %></p>
			<a class="left"href="javascript:history.back()"><i class="material-icons left">undo</i></a>
			
			</div>


	</div>


	<!-- SCRIPT -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('.parallax').parallax();
			$('.materialboxed').materialbox();

		});
	</script>

	<!--FINE Bottone -->
	<%@include file="../frag/footer.jsp"%>


</body>
</html>