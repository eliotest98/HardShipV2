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

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/materialize.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>



	<%@include file="../frag/header.jsp"%>
	<jsp:useBean id="albumv" scope="session" class="it.ship.beans.Album" />
	<%@page import="it.ship.beans.Album"%>
	<jsp:useBean id="cart" scope="session"
		class="it.ship.beans.ShoppingCart" />
	<%@page import="it.ship.beans.ShoppingCart"%>





	<div class="row">
		<div id="Rdiv">
			<div class="col s12 m12 l12" style="width: 600px;">
				<%
					int count = 0;
					ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");
					System.out.println(sc.getItemsOrdered().size());
				%>
				<h2 class="header">Carrello</h2>
				<ul class="s12 collection">
					<%
						if (sc != null) {
							for (int i = 0; i < sc.getItemsOrdered().size(); i++) {
					%>
					<li class=" collection-item avatar"><img
						src="../<%=sc.getItemsOrdered().get(i).getCopertina()%>" alt=""
						class="circle"> <span class="title"><%=sc.getItemsOrdered().get(i).getTitolo()%></span>
						<p><%=sc.getArtisti().get(i).getNome()%>
							<br>
							<%=sc.getEtichetta().get(i).getNome()%><br> Prezzo:
							<%=sc.getPrezzi().get(i).toString()%>
						</p> <a
						onclick="Materialize.toast('Elemento eliminato.', 4000);reload(this)"
						href="${pageContext.request.contextPath}/DeleteItem?n=<%=i%>"
						class="secondary-content"><i class="material-icons">clear</i></a>
					</li>
					<%
						}
					%>
				</ul>
				<%
					}
					if (sc.getItemsOrdered().size() == 0 || sc.getItemsOrdered() == null) {
				%>
				<h2>Aggiungi prima qualcosa al carrello</h2>
				<%
					}
				%>
			</div>
		</div>
		<div class="col s12 m12 l12">
			<div class="row">
				<h2 class="header">Dettagli</h2>
				<div class="card blue-grey darken-1">
					<form action="${pageContext.request.contextPath}/Acquista"
						class="col s12" name="formValidate" id="formValidate"
						method="post">
						<div class="row">
							<div class="input-field col s6">
								<input value="<%=c.getNome()%>" id="first_name"
									name="first_name" type="text" class="validate"> <label
									for="first_name">Nome</label>
							</div>
							<div class="input-field col s6">
								<input value="<%=c.getCognome()%>" id="last_name"
									name="last_name" type="text" class="validate"> <label
									for="last_name">Cognome</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input id="indirizzo" name="indirizzo" type="text"
									class="validate"> <label for="indirizzo">Indirizzo</label>
							</div>
						</div>

						<div class="row">
							<div class="input-field col s12">
								<select name="method" required="required">
									<option disabled selected></option>
									<option value="Carta di credito">Carta</option>
									<option value="Contrassegno">Contrassegno</option>
								</select><label data-error="Seleziona un metodo di pagamento">Metodo
									di Pagamento</label>
							</div>
						</div>
						<button class="btn waves-effect waves-light right" type="submit">
							Pay. <i class="material-icons right">check</i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- BOTTONE + FOOTER -->
	<%@include file="../frag/footer.jsp"%>
	<!--  SCRIPT -->
	<script>
	/*
	    Script che viene chiamato quando si cancella un articolo dal carello per ricaricare la sezione.
	*/
		function reload(a) {
			a.remove();
			$.ajax({
				url : location.href,
				async : true
			}).done(function(result) {
				$("#Rdiv").load(location.href + " #Rdiv");
			});
		}
	</script>
	<script>
		$(document).ready(function() {
			/*
			    Script che richiama le funzioni quando il documento è pronto.
			*/
			$('select').material_select();
			$('.modal-trigger').leanModal({
				dismissible : true,
				opacity : .5,
				in_duration : 300,
				out_duration : 200,
			});

		});
	</script>
	<script type="text/javascript">
	/*
	    Script per la validazione dei campi per il carello.
	*/
		jQuery.validator.addMethod("lettersonly", function(value, element) {
			return this.optional(element) || /^[a-z," "]+$/i.test(value);
		}, "Il campo non può contenere numeri e caratteri speciali.");

		$("#formValidate")
				.validate(
						{
							rules : {
								first_name : {
									required : true,
									minlength : 3,
									maxlength : 25,
									lettersonly : true
								},
								last_name : {
									required : true,
									minlength : 3,
									maxlength : 30,
									lettersonly : true
								},
								indirizzo : {
									required : true
								},
								method : {
									required : true
								}
							},
							//For custom messages
							messages : {
								first_name : {
									required : "Il campo nome è obbligatorio",
									maxlength : "Il campo nome non deve superare 30 caratteri",
									minlength : "Il campo nome deve contenere almeno 3 caratteri"
								},
								last_name : {
									required : "Il campo cognome è obbligatorio",
									maxlength : "Il campo cognome non deve superare 30 caratteri",
									minlength : "Il campo cognome deve contenere almeno 3 caratteri"
								},
								indirizzo : {
									required : "Il campo indirizzo è obbligatorio"
								},
								method : {
									required : "Seleziona un metodo di pagamento"
								}
							},
							errorElement : 'div',
							errorPlacement : function(error, element) {
								var placement = $(element).data('error');
								if (placement) {
									$(placement).append(error)
								} else {
									error.insertAfter(element);
								}
							}
						});
		$("select[required]").css({
			display : "block",
			height : 0,
			padding : 0,
			width : 0,
			position : 'absolute'
		});
	</script>
</body>
</html>
