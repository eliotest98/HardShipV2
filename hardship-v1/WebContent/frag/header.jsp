<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>HardShip</title>
<script type="text/javascript"
	    src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>
<link rel='shourtcut icon'
	href='${pageContext.request.contextPath}/pages/favicon.ico'
	type='image/x-icon' />
<meta name="theme-color" content="#373641">
</head>


<body>
	<jsp:useBean id="Etichetta" scope="session" class="it.ship.beans.Etichetta" />
	<%@page import="it.ship.beans.Etichetta"%>
	<jsp:useBean id="Artista" scope="session" class="it.ship.beans.Artista" />
	<%@page import="it.ship.beans.Artista"%>
	<jsp:useBean id="utente" scope="session" class="it.ship.beans.Cliente" />
	<%@page import="it.ship.beans.Cliente"%>
	<%
		String s = "";
		if (session.getAttribute("cliente") != null) {
			s = "on";
		}
		if (session.getAttribute("cliente") == null) {
			s = "off";
		}
	%>

	<%
		Cliente c = (Cliente) session.getAttribute("cliente");
		if (c == null) {
			c = new Cliente();
		}
	%>

	<nav class="top-nav">
	<div class="nav-wrapper">
		<a href="${pageContext.request.contextPath}/pages/home.jsp"
			class="brand-logo">HARDSHIP</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<%
				if (s.equals("on")) {
			%>
			<li><a href="${pageContext.request.contextPath}/LogOut" class=""><i
					class="material-icons">settings_power</i></a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/carrello.jsp" class=""><i
					class="material-icons">shopping_cart</i></a></li>
				<!-- --QUI  -->
			<li><a	class=" modal-trigger " href="#modal2">
			<i class="material-icons">album</i></a></li>
			<%
				} else {
			%>
			<li><a
				href="${pageContext.request.contextPath}/pages/registra.jsp"
				class=""><i class="material-icons">add</i></a></li>
			<li><a class=" modal-trigger" href="#modal1"><i
					class="material-icons">person_pin</i></a></li>
			<%
				}
			%>

			<li>
				<div class="nav-wrapper">
					<a class='dropdown-button btn' href='#'
						data-activates='search-Results1'
						style="background: transparent; box-shadow: none; height: 64px; padding: 0%; width: 100%">
						<form style="height: 64px" method="post" name="frm"
							action="${pageContext.request.contextPath}/Search">
							<div class="input-field" style="height: 64px">
								<input autocomplete="off" class="search" name="pid" id="pid1"
									type="search" required> <label for="search"><i
									class="material-icons">search</i></label> <i class="material-icons">close</i>
								<ul style="" id='search-Results1' class='dropdown-content'>
								</ul>
							</div>
						</form>
					</a>
				</div>
			</li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<%
				if (s.equals("on")) {
			%>
			<li><a href="${pageContext.request.contextPath}/LogOut" class=""><i
					class="material-icons">settings_power</i></a></li>
			<li><a
				href="${pageContext.request.contextPath}/pages/carrello.jsp" class=""><i
					class="material-icons">shopping_cart</i></a></li>
				<!-- --QUI  -->
			<li><a	class=" modal-trigger " href="#modal2">
			<i class="material-icons">album</i></a></li>

			<%
				} else {
			%>
			<li><a
				href="${pageContext.request.contextPath}/pages/registra.jsp"
				class="waves-effect waves-teal btn-flat"><i
					class="material-icons">add</i>Registrati</a></li>
			<li><a class="waves-effect waves-teal btn-flat modal-trigger"
				href="#modal1"><i class="material-icons">person_pin</i>Login</a></li>
			<%
				}
			%>
			<li class="search">

				<form style="height: 64px" method="post" name="frm"
					action="${pageContext.request.contextPath}/Search">
					<div class="input-field" style="height: 64px">
						<label for="search"><i class="material-icons"
							style="color: black; position: fixed">search</i></label> <input
							autocomplete="off" class="search" name="pid2"
							placeholder="search" id="pid2" type="text" required
							style="color: #444; border-bottom: 0; box-shadow: 0 0px 0 0;">
						<div id="search-Results2" class="search-results"></div>
					</div>
				</form>
			</li>

		</ul>
	</div>
	</nav>


	<!--DROP DOWN MENU-->
	<!-- Dropdown Structure -->

	<ul id="dropdown1" class="dropdown-content">

	</ul>
	<ul id="dropdown2" class="dropdown-content">

	</ul>
	<ul id="dropdown3" class="dropdown-content">

	</ul>


	<nav>
	<div class="nav-wrapper">
		<ul>
			<!-- Dropdown Trigger -->
			<li><a id="somebutton" class="dropdown-button topBarButton"
				href="#!" data-activates="dropdown1">Artisti<i
					class="material-icons right">arrow_drop_down</i></a></li>
			<li><a class="dropdown-button topBarButton" href="#!"
				data-activates="dropdown2">Etichette<i
					class="material-icons right">arrow_drop_down</i></a></li>
			<li><a class="dropdown-button topBarButton" href="#!"
				data-activates="dropdown3">Generi<i class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
	</div>
	</nav>

	<!-- --QUI  -->
	<!-- Modal Structure -->
	<div id="modal2" class="modal">
		<div class="modal-content">
			<h4>RICHIESTA ALBUM</h4>
			<form id="insalbum" name="insalbum"
				action="${pageContext.request.contextPath}/InserimentoAlbumServlet" method="post"
				onsubmit="return validateForm()">
				<div class="input-field col s6">
					<input name="tit" id="tit" type="text" class="validate">
					<label for="tit">Titolo</label>
				</div>
				<div class="input-field col s6">
					<input name="art" id="art" type="text" class="validate">
					<label for="art">Artista</label>
				</div>
			</form>
			<div class="modal-footer">
				<button type="submit" form="insalbum"
					class=" modal-action modal-close waves-effect waves-green btn-flat" class="required">Invia</button>

				<button class="btn-flat modal-close wave-effect waves-green">Annulla</button>

			</div>

		</div>
	</div>
	<div id="modal1" class="modal">
		<div class="modal-content">
			<h4>ACCEDI</h4>
			<form id="login" name="login"
				action="${pageContext.request.contextPath}/LogIn" method="post"
				onsubmit="return validateForm()">
				<div class="input-field col s6">
					<input name="user" id="user" type="text" class="validate">
					<label for="user">Username</label>
				</div>
				<div class="input-field col s6">
					<input name="pass" id="pass" type="password" class="validate">
					<label for="pass">Password</label>
				</div>
			</form>
			<div class="modal-footer">
				<button type="submit" form="login"
					class=" modal-action modal-close waves-effect waves-green btn-flat">LOGIN</button>

				<button class="btn-flat modal-close wave-effect waves-green">Annulla</button>

			</div>

		</div>
	</div>
	<!-- Modal Structure -->
	<div id="modallog" class="modal">
		<div class="modal-content">
			<h4>ATTENZIONE</h4>
			<p>Devi riempire tutti i campi.</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Retry</a>
		</div>
	</div>
</body>

<script type="text/javascript">
/*
    Script per la validazione dei campi per il login.
*/
	function validateForm() {
		var a = document.forms["login"]["user"].value;
		var b = document.forms["login"]["pass"].value;
		if (a == null || a == "", b == null || b == "") {
			$('#modallog').openModal();
			return false;
		} else {
			return true;
		}
	}

</script>

<script>
	$('.button-collapse').sideNav();
</script>
<script>
/*
    Script che chiama la funzione loadMainMenu quando la pagina è pronta.
*/
	$(document).ready(function() {
		loadMainMenu();

	});
</script>

<script>
$(document).ready(function(){
	  $('.modal-trigger').leanModal();
	});
</script>
<script>
/*
    Script richiama la servlet NavBar per aggiungere gli elemnti ai dropdown button
*/
	function loadMainMenu() {
		$.get(
						"${pageContext.request.contextPath}/NavBar/",
						function(responseJson) {
							var table1 = $("#dropdown1");
							var table2 = $("#dropdown2");
							var table3 = $("#dropdown3");

							var menu1 = JSON.parse(responseJson[0]);
							var menu2 = JSON.parse(responseJson[1]);
							var menu3 = JSON.parse(responseJson[2]);

							$
									.each(
											menu1,
											function(index, Album) {

												var url = "${pageContext.request.contextPath}/View?param1=Artista&param3=Nome&param2="
														+ Album.nome;
												table1
														.append('<li><a href="'+url+'">'
																+ Album.nome
																+ "</a></li>");
											});
							$
									.each(
											menu2,
											function(index, Album) {
												var url = "${pageContext.request.contextPath}/View?param1=Etichetta&param3=Nome&param2="
														+ Album.nome;
												$("<li>")
														.appendTo(table2)
														.append(
																'<li><a href="'+url+'">'
																		+ Album.nome
																		+ "</a></li>");
											});
							$
									.each(
											menu3,
											function(index, Album) {
												var url =
"${pageContext.request.contextPath}/View?param1=Genere&param3=genere&param2="
														+ Album.genere;
												$(table3).append(
														'<li><a href="'+url+'">'
																+ Album.genere
																+ "</a></li>");
											});
						});
	}
</script>
<script type="text/javascript">
/*
    Script per la validazione dei campi per la richiesta inserimento album.
*/
$("#insalbum").validate({
    rules: {
    	tit: {
            required: true,
           	maxlength:30
        },
        art: {
            required: true,
           	maxlength:25
        }
    },
    //For custom messages
    messages: {
    	tit:{
            required: "Il campo titolo � obbligatorio",
            maxlength: "Il campo titolo non deve superare 30 caratteri alfanumerici",
    	},
        art: {
        	required: "Il campo artista � obbligatorio",
            maxlength: "Il campo artista non deve superare 25 caratteri",
        }



    }        ,
    errorElement : 'div',
    errorPlacement: function(error, element) {
      var placement = $(element).data('error');
      if (placement) {
        $(placement).append(error)
      } else {
        error.insertAfter(element);
      }
    }
    });
</script>

<script type="text/javascript">
/*
    Script per la validazione dei campi per il login.
*/
$("#login").validate({
    rules: {
    	user: {
            required: true,
           	maxlength:15,
           	minlength:2
        },
        pass: {
            required: true,
            maxlength:30,
           	minlength:6
        }
    },
    messages: {
    	user:{
            required: "Il campo Username � obbligatorio",
            maxlength: "Il campo Username non deve superare 15 caratteri alfanumerici",
            minlength: "Il campo Username deve contenere almeno 2 caratteri alfanumerici"
    	},
        pass: {
        	required: "Il campo Password � obbligatorio",
            maxlength: "Il campo Password non deve superare 30 caratteri",
            minlength: "Il campo Password deve contenere almeno 6 caratteri alfanumerici"
        }



    }        ,
    errorElement : 'div',
    errorPlacement: function(error, element) {
      var placement = $(element).data('error');
      if (placement) {
        $(placement).append(error)
      } else {
        error.insertAfter(element);
      }
    }
    });
</script>

</html>
