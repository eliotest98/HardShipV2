<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta charset="UTF-8">
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
</head>

<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/materialize.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/background-color-theif.js"></script>

	<%@ include file="../frag/header.jsp"%>
	<jsp:useBean id="Digitale" scope="session"
		class="it.ship.beans.Digitale" />
	<%@page import="it.ship.beans.Digitale"%>
	<jsp:useBean id="Album" scope="session" class="it.ship.beans.Album" />
	<%@page import="it.ship.beans.Album"%>
	<jsp:useBean id="Vinyl" scope="session" class="it.ship.beans.Vinile" />
	<%@page import="it.ship.beans.Vinile"%>
	<jsp:useBean id="CD" scope="session" class="it.ship.beans.Cd" />
	<%@page import="it.ship.beans.Cd"%>
	<jsp:useBean id="Brani" scope="session" class="it.ship.beans.Brano" />
	<%@page import="it.ship.beans.Brano"%>
	<jsp:useBean id="Feed" scope="session" class="it.ship.beans.Feedback" />
	<%@page import="it.ship.beans.Feedback"%>
	<!--FINE NAV-->
	<%
		Album a = new Album();
		String arti = (String) request.getAttribute("artista");
		String eti = (String) request.getAttribute("etichetta");
		a = (Album) request.getAttribute("b");
		Digitale dig = new Digitale();
		dig = (Digitale) request.getAttribute("Digitale");
		Vinile vinyl = new Vinile();
		vinyl = (Vinile) request.getAttribute("Vinyl");
		Cd cd = new Cd();
		cd = (Cd) request.getAttribute("CD");
		ArrayList<Brano> brani = new ArrayList<Brano>();
		brani = (ArrayList<Brano>) request.getAttribute("Brani");
		ArrayList<Feedback> feedback = new ArrayList<Feedback>();
		feedback = (ArrayList<Feedback>) request.getAttribute("feedback");
	%>
	<main>


	<div class="row">
		<div class="col s12 m6 ">
			<div class="col s12 m7">
				<div class="card">
					<div class="card-image">
						<img id="backgroundImage" class="materialboxed"
							src="<%=a.getCopertina()%>">
					</div>

				</div>

			</div>
			<div class="card-panel white">
				<span class="black-text"><h3 class="header">
				Titolo: <%=a.getTitolo()%></h3>
					<h4>
						Artista:
						<%=arti%></h4>
					<h4>
						Etichetta :
						<%=eti%></h4> </span>
				<%
					if (null != session.getAttribute("cliente")) {
				%>
				<a id="backGroundColor"
					class="btn-floating btn-large waves-effect waves-light right modal-trigger1"
					href="#modal3"><i class="material-icons">shop</i></a>
				<%
					} else {
				%>
				<a id="backGroundColor"
					class="btn-floating btn-large waves-effect waves-light right modal-trigger2"
					href="#modal4"><i class="material-icons">shop</i></a>
				<%
					}
				%>
				<table class="bordered">
					<thead>
						<tr>
							<th data-field="id">Elenco tracce</th>

						</tr>
					</thead>

					<tbody>
						<%
							for (int i = 0; i < brani.size(); i++) {
						%>
						<tr>
							<%
								String str = brani.get(i).getDurata();
							%>
							<td><%=brani.get(i).getTitolo()%></td>
							<td width="25"><%=str%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col s12 m6">
			<div class="card-panel">

				<span > <%=a.getDettagli()%><br>
				</span>
				<%
					if (a.getEmbed() != null) {
				%>
				<%=a.getEmbed()%><br>
				<%
					}
				%>
			</div>


		</div>

	</div>
	<div class="col s12 m6">
	<h4 class="center-align tial">Commenti</h4>
		<div class="card-panel" style="background:rgba(9, 86, 72, 0.12);padding-left:100px;padding-right:100px;">
			
			<%
				if (feedback.size() == 0) {
			%>
			<span class="white-text">Nessun utente ha ancora lasciato un
				feedback per questo album </span>

			<%
				}
			%>
			<%
				for (int i = 0; i < feedback.size(); i++) {
			%>
			<div class="row">
				<p class="flow-text">
				<div class="row">
					<!-- NOME UTENTE -->
					<span class="utente" style="font-size:18px;" ><%=feedback.get(i).getUtente()%></span>
					<!-- DATA -->
					<span class="bold right"><%=feedback.get(i).getData()%></span>
				</div>
				<!-- TITOLO -->
				<span class="title " ><%=feedback.get(i).getTitolo()%><br></span>

				</p>
				<!-- TESTO -->
				<span class="datacommento" ><%=feedback.get(i).getTesto()%><br></span>
			</div>
			<div class="divider"></div>
			<%
				}
			%>
		</div>
	</div>
	<%
			if (session.getAttribute("cliente") != null) {
		%>
	<div class="row">
		<form id="feedback" name="feedback" class="col s12 m12 l12"
			action='${pageContext.request.contextPath}/InserisciFeedback'
			method="post">
			<input placeholder="" id="id" name="id" type="text" class="hidden" value="<%=a.getId()%>">
					<input placeholder="" id="user" name="user" type="text"	class="hidden" value="<%=c.getID()%>">
			<div class="input-field col s12">
				<input placeholder="" id="titolo" name="titolo" type="text"
					class="validate"> <label for="titolo">Titolo</label>
			</div>
			<div class="row">
				<div class="input-field col s12 m12 l12">
					<textarea id="testo" name="testo" class="materialize-textarea"></textarea>
					<label for="icon_prefix2">Inserisci il tuo commento qui</label>
				</div>
			</div>
		</form>
		<button form="feedback" class="btn waves-effect waves-light right"
			id="submit" type="submit" name="action"
			onclick="Materialize.toast('Commento inserito correttamente', 4000)">
			Commenta <i class="material-icons right">send</i>
		</button>
	</div>
	<%
			}
		%> </main>


	<!-- BOTTONE + FOOTER -->
	<!--FINE Bottone -->
	<%@ include file="../frag/footer.jsp"%>
	<!-- OFFLINE MODAL -->
	<!-- Modal Structure -->
	<div id="modal4" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>ATTEZIONE</h4>
			<p>Devi essere loggato per poter acquistare.</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class=" modal-action modal-close waves-effect waves-green btn-flat">Continue</a>
		</div>
	</div>


	<!-- Modal Structure -->
	<div id="modal3" class="modal bottom-sheet">
		<div class="modal-content">
			<div class="row">
				<h4>
					Seleziona il formato
					<button class="btn-flat modal-close right wave-effect waves-green">
						<h6>Ok</h6>
					</button>
				</h4>
				<ul class="collection">
					<li class="collection-item avatar"><img
						src="<%=a.getCopertina()%>" alt="" class="circle"> <span
						class="title">Digitale</span>
						<p>
							Prezzo:
							<%=dig.getPrezzo()%>
							<br> Copie:
							<%=dig.getNumCopie()%>
						</p> <%
 	if (dig.getNumCopie() == 0) {
 %> <a class="secondary-content  waves-effect waves-light btn disabled"><i
							class="material-icons left">shop</i></a> <%
 	} else {
 %> <a id="refresh"
						onClick="Materialize.toast('Carrello aggiornato!', 3000, 'rounded')"
						href="${pageContext.request.contextPath}/Carrello?id=<%=a.getId() %>&formato=digitale"
						class="secondary-content  waves-effect waves-light btn"><i
							class="material-icons left">shop</i></a> <%
 	}
 %></li>
					<li class="collection-item avatar"><img
						src="<%=a.getCopertina()%>" alt="" class="circle"> <span
						class="title">Vinyl</span>
						<p>
							Prezzo:
							<%=vinyl.getPrezzo()%>
							<br> Copie:
							<%=vinyl.getNumCopie()%>
						</p> <%
 	if (vinyl.getNumCopie() == 0) {
 %> <a class="secondary-content  waves-effect waves-light btn disabled"><i
							class="material-icons left">shop</i></a> <%
 	} else {
 %> <a id="refresh"
						onClick="Materialize.toast('Carrello aggiornato!', 3000, 'rounded')"
						href="${pageContext.request.contextPath}/Carrello?id=<%=a.getId() %>&formato=vinile"
						class="secondary-content  waves-effect waves-light btn"><i
							class="material-icons left">shop</i></a> <%
 	}
 %></li>
					<li class="collection-item avatar"><img
						src="<%=a.getCopertina()%>" alt="" class="circle"> <span
						class="title">CD</span>
						<p>
							Prezzo:
							<%=cd.getPrezzo()%>
							<br> Copie:
							<%=cd.getNumCopie()%>
						</p> <%
 	if (cd.getNumCopie() == 0) {
 %> <a class="secondary-content  waves-effect waves-light btn disabled"><i
							class="material-icons left">shop</i></a> <%
 	} else {
 %> <a
						onClick="Materialize.toast('Carrello aggiornato!', 3000, 'rounded')"
						href="${pageContext.request.contextPath}/Carrello?id=<%=a.getId()%>&formato=cd"
						class="secondary-content  waves-effect waves-light btn"><i
							class="material-icons left">shop</i></a> <%
 	}
 %></li>
				</ul>
			</div>

		</div>
	</div>

	<!-- SCRIPT-->
	<script>
			$(".button-collapse").sideNav();
		</script>


 	<script> 
		$(document)
 					.ready(
						function() {

// 								var backgroundColorThief = new BackgroundColorTheif();
// 							var rgb = backgroundColorThief
// 									.getBackGroundColor(document
// 												.getElementById("backgroundImage"));
// 								document.getElementById("backGroundColor").style.backgroundColor = 'rgb('
//  										+ rgb[0]
//  										+ ','
//  										+ rgb[1]
//  										+ ','
//  										+ rgb[2]
//  										+ ')';
//  								var rgb1 = backgroundColorThief
//  										.getBackGroundColor(document
//  												.getElementById("backgroundImage"));
//  								document.getElementById("submit").style.backgroundColor = 'rgb('
//  										+ rgb[0]
//  										+ ','
// 										+ rgb[1]
// 										+ ','
//  										+ rgb[2]
//  										+ ')';

 								$('.materialboxed').materialbox();
								$('.modal-trigger').leanModal({
								dismissible : true, // Modal can be dismissed by clicking outside of the modal
									opacity : .5, // Opacity of modal background
									in_duration : 300, // Transition in duration
 									out_duration : 200, // Transition out duration
 								});
								$('.modal-trigger2').leanModal({
 									dismissible : true, // Modal can be dismissed by clicking outside of the modal
 									opacity : .5, // Opacity of modal background
 									in_duration : 300, // Transition in duration
									out_duration : 200, // Transition out duration

							});
						$('.modal-trigger1').leanModal({
								dismissible : true, // Modal can be dismissed by clicking outside of the modal
 									opacity : .5, // Opacity of modal background
									in_duration : 300, // Transition in duration
 									out_duration : 200, // Transition out duration
								});
							});
</script>
<script type="text/javascript">
/* JQuery per la validazione della form di Aggiunta Feedback*/
$("#feedback").validate({
    rules: {
    	titolo: {
            required: true,
           	maxlength:25
        },
        testo: {
            required: true,
           	maxlength:1024
        }
    },
    //For custom messages
    messages: {
    	titolo:{
            required: "Il campo titolo è obbligatorio",
            maxlength: "Il campo titolo non deve superare 25 caratteri alfanumerici",
    	},
    	testo: {
        	required: "Il campo testo è obbligatorio",
            maxlength: "Il campo testo non deve superare 1024 caratteri",
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
</body>
</html>