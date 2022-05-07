<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RAFAMusic</title>
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

.notification{
margin:30px;
bot:10px;
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
		
		Boolean x=(Boolean)request.getAttribute("NewsRisultato");		
		
		if(x!= null && x==true){
			%>
	<script>alert("News aggiunta");</script>
	<%
		}
		x=(Boolean) request.getAttribute("AlbumRisultato");
		if(x!= null && x==true){
			%>
	<script>alert("Album aggiunto");</script>
	<%
		}
		if (a != null) {
		request.getSession().setAttribute("Amministratore", a);
		java.sql.Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		Boolean Notification=false;
		java.sql.Statement st;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManagerConnectionPool.getConnection();
			System.out.println("Connected!");
			String query = "select * from richiesta";
			System.out.println("query " + query);
			st = conn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				Notification=true;
			}
		}catch(Exception e){
			System.out.println(e);
		}
	%>
	<div class="container">
		<div class="row">
			<h4 class="red-text lighten-1 center-align">Pannello d'amministrazione</h4>
		</div>
		
		<div class="row">
			<div class="col s12 m9 l10 section scrollspy">
				<h4 id="addalbum">Aggiungi Album</h4>
				<form id="frist" class="col s12" method="post"
					action="${pageContext.request.contextPath}/UploadAlbum">
					<div class="row">
						<div class="input-field col s6">
							<input name="titolo" id="titolo" type="text" class="validate">
							<label for="titolo">Titolo</label>
						</div>
						<div class="input-field col s6">
							<input name="artista" id="Artista" type="text" class="validate">
							<label for="artista">Artista</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="genere" id="genere" type="text" class="validate">
							<label for="titolo">Genere</label>
						</div>
						<div class="input-field col s6">
							<input name="data" id="Artista" type="text" class="validate">
							<label for="data">Rilascio</label>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s6">
							<input name="brani" type="text" class="validate" /> <label
								for="brani">Num° traccia</label>
						</div>
						<div class="input-field col s6">
							<input name="etichetta" id="etichetta" type="text"
								class="validate"> <label for="etichetta">Etichetta</label>
						</div>

					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="digitale" type="text" class="validate"> <label
								for="digitale">Num° Digitale</label>
						</div>
						<div class="input-field col s6">
							<input name="pdigitale" type="text" class="validate"></input> <label
								for="pdigitale">Prezzo</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="vinile" type="text" class="validate"> <label
								for="vinile">Num° Vinile</label>
						</div>
						<div class="input-field col s6">
							<input name="pvinile" type="text" class="validate"></input> <label
								for="pvinile">Prezzo</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="cd" type="text" class="validate"> <label
								for="cd">Num° CD</label>
						</div>
						<div class="input-field col s6">
							<input name="pcd" type="text" class="validate"></input> <label
								for="pcd">Prezzo</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input name="fileName" id="copertina" type="text"
								class="validate"> <label for="fileName">Copertina</label>
							<div class="input-field col s12">
								<textarea name="dettagli" id="dettagli"
									class="materialize-textarea"></textarea>
								<label for="dettagli">Dettagli</label>
							</div>
						</div>
					</div>
					<div class="cand_fields section scrollspy">
						<h4 id="addtracks">Aggiungi Traccia</h4>
						<table class="highlight" id="tracks">
							<thead>
								<tr>
									<td>Titolo</td>
									<td>Durata</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input name="tbrani" type="text" class="validate"
										placeholder="Titolo"></td>
									<td><input name="dbrani" type="text" class="validate"
										placeholder="Durata"></td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="template" style="display: none">
						<table>
							<tr>
								<td><input name="Titolo" type="text" class="validate"
									placeholder="Title"></td>
								<td><input name="dbrani" type="text" class="validate"
									placeholder="Durata"></td>
							</tr>
						</table>
					</div>
				</form>
				<h4>Aggiungi Copertina</h4>
				<div id="cover" class="row section scrollspy">
					<form id="second" name="Form" class="col s12" method="post"
						action="${pageContext.request.contextPath}/UploadServlet"
						enctype="multipart/form-data">
						<div class="file-field input-field">
							<div class="btn">
								<span>File</span> <input name="dataFile" id="fileChooser"
									type="file">
									
							</div>
							<div class="file-path-wrapper">
								<input name="fileName" class="file-path validate" type="text">
							</div>
						</div>
					</form>
				</div>
				<button form="frist" id="subbut"
					class="btn waves-effect waves-light left" type="submit"
					name="action">Aggiungi Album</button>
				<button form="second" id="subbut2"
					class="btn waves-effect waves-light right" type="submit"
					name="action">Upload File</button>
				<div class="row">
					<div class="col s12 m9 l10 section scrollspy">
						<h4 id="addalbum">Add News</h4>
						<form id="third" class="col s12" method="post"
							action="${pageContext.request.contextPath}/UploadNews"
							accept-charset="UFT-8">
							<div class="row">
								<div class="input-field col s6">
									<input name="newstitolo" id="titolo" type="text"
										class="validate"> <label for="newstitolo">Titolo</label>
								</div>
								<div class="input-field col s6">
									<input name="author" id="Artista" type="text" class="validate">
									<label for="author">Autore</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s6">
									<select name="method" required="required" class="validate">
										<option value="" disabled selected>Categoria</option>
										<option value="Biografia">Biografia</option>
										<option value="Cronaca">Cronaca</option>
										<option value="Nuove uscite">Nuove uscite</option>
									</select><label data-error="Seleziona una Categoria">Categoria</label>
								</div>
								<div class="input-field col s6">
									<input name="newscopertina" id="newscopertina" type="text"
										class="validate"> <label for="newscopertina">Copertina</label>
								</div>
							</div>
							<div class="row">
								<div class="row">
									<div class="input-field col s12">
										<i class="material-icons prefix">mode_edit</i>
										<textarea name="newstext" id="newstext"
											class="materialize-textarea"></textarea>
										<label for="icon_prefix2"> Testo</label>
									</div>
								</div>
							</div>
						</form>
						<button form="third" id="subbut"
							class="btn waves-effect waves-light left" type="submit"
							name="action">Inserisci News</button>
					</div>
				</div>
			</div>
			<!-- --QUI  -->
			
			<div class="col hide-on-small-only m3 l2 ">
				<div class="toc-wrapper pinned">
					<ul class="section table-of-contents">
					<% if(Notification)
					{%>
						<li><a href="${pageContext.request.contextPath}/pages/notificaAdmin.jsp" class="section red-text lighten-1 scrollspy">Notifiche</a></li> 
					<% }else{%>
						<li><a href="#" onclick="alert('Nessuna notifica disponibile')" class="section scrollspy">Notifiche</a></li> 
					<%} %>
						<li></li>
						<li></li>
						<li><a href="#addalbum" class="section scrollspy">Aggiungi Album</a></li>
						<li><a href="#addtracks" class="section scrollspy">Aggiunti Tracce</a></li>
						<li><a href="#cover" class="section scrollspy">Aggiunti Copertina</a></li>
						<li><a href="#third" class="section scrollspy">Aggiungi News</a></li>
					</ul>
				</div>
				
			</div>
		</div>
		
		
		
		

	</div>
	<%
		} else {
	%>
	<h4 class="red-text lighten-1 center-align">Sezione riservata.</h4>
	<%
		}
	%>

	<!--FINE Bottone -->
	<%@include file="../frag/footer.jsp"%>
	<!--  SCRIPT -->
	<!-- SCRIPT -->
	<script>  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 50, // Creates a dropdown of 15 years to control year
    max: new Date(),
    format: "dd/mm/yyyy",
    today: '',
    clear: 'Chiudi',
    close: 'Ok'
	});</script>
	<script type="text/javascript">
	/* JQuery per validare la form di Inserimento Album e inoltre sono stati inseriri dei metodi aggiuntivi per l'inserimento specifico in alcune field */
	
	jQuery.validator.addMethod("lettersonly", function(value, element) 
			{
			return this.optional(element) || /^[a-z," "]+$/i.test(value);
			}, "Il campo non può contenere numeri e caratteri speciali."); 
	jQuery.validator.addMethod("numbersonly", function(value, element) 
			{
			return this.optional(element) || /^[0-9," "]+$/i.test(value);
			}, "Il campo non può contenere  caratteri."); 
	jQuery.validator.addMethod("prezzonly", function(value, element) 
			{
			return this.optional(element) || /^\d{1,4}(\.\d{1,2})?$/i.test(value);
			}, "Il campo non può contenere  caratteri."); 
	jQuery.validator.addMethod("durataonly", function(value, element) 
			{
			return this.optional(element) || /^\d{1,2}(\:\d{2})?$/i.test(value);
			}, "Il campo non può contenere  caratteri."); 

	$("#frist").validate({
        rules: {
        	titolo: {
                required: true,
               	maxlength:30
            },
            artista: {
                required: true,
               	maxlength:25,
               	lettersonly:true
            },
            genere: {
				required: true,
               	maxlength:30
			},
			copertina: {
				required: true
			},
			brani: {
                required: true,
                numbersonly:true,
                maxlength:10
            },
			etichetta:{
				required:true,
				maxlength:25
			},
			digitale:{
				required:true,
				numbersonly:true,
				maxlength:9
			},
			pdigitale:{
				required:true,
				prezzonly:true
			},
			vinile:{
				required:true,
				numbersonly:true,
				maxlength:9
			},
			pvinile:{
				required:true,
				prezzonly:true
			},
			cd:{
				required:true,
				numbersonly:true,
				maxlength:9
			},
			pcd:{
				required:true,
				prezzonly:true
			},
			tbrani:{
				required:true,
				maxlength:256
			},
			data:{
				required:true
			},
			dbrani:{
				required:true,
				durataonly:true
			},
			dettagli:{
				required:true,
				maxlength:256
			},
			fileName:{
				required:true
			}
        },
        //For custom messages
        messages: {
        	titolo:{
                required: "Il campo titolo è obbligatorio",
                maxlength: "Il campo nome non deve superare 30 caratteri alfanumerici",
        	},
            artista: {
            	required: "Il campo artista è obbligatorio",
                maxlength: "Il campo artista non deve superare 25 caratteri",
            },
            genere: {
				required: "Il campo genere è obbligatorio",
				maxlength: "Il campo genere non deve superare 30 caratteri",
            },
			brani: {
				required: "Il campo n.brani è obbligatorio",
				maxlength: "Il campo n.brani non deve superare 10 cifre"
			},
			etichetta: {
                required: "Il campo etichetta è obbligatorio",
               	maxlength: "Il campo etichetta non deve superare 25 caratteri alfanumerici"
            },
           digitale:{
				required: "Il campo digitale è obbligatorio",
				maxlength: "Il campo digitale non deve superare 9 cifre"
			},
			pdigitale: {
                required: "Il campo prezzo è obbligatorio",
                prezzonly: "Non rispetta il formato"
            },
            vinile:{
				required: "Il campo vinile è obbligatorio",
				maxlength: "Il campo vinile non deve superare 9 cifre"
			},
			pvinile: {
                required: "Il campo prezzo è obbligatorio",
                prezzonly: "Non rispetta il formato"
            },
			data:{
				required:"Il campo data è obbligatorio"
			},
            cd:{
				required: "Il campo cd è obbligatorio",
				maxlength: "Il campo cd non deve superare 9 cifre"
			},
			pcd: {
                required: "Il campo prezzo è obbligatorio",
                prezzonly: "Non rispetta il formato"
            },
            copertina:{
				required: "Il campo copertina è obbligatorio",
			},
			dettagli: {
                required: "Il campo dettagli è obbligatorio",
                maxlength:"Il campo dettagli non deve superare 256 caratteri "
            },
            tbrani: {
                required: "Il campo titolo brano è obbligatorio",
                maxlength:"Il campo titolo brano non deve superare 256 caratteri "
            },
            dbrani: {
                required: "Il campo durata brano è obbligatorio",
                durataonly : "Il formato è errato"
            } ,
			fileName:{
				required:"Il campo copertina è obbligatorio"
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
    /* JQuery per validare la form di Inserimento News*/

	$("#third").validate({
        rules: {
        	newstitolo: {
                required: true,
               	maxlength:50
            },
            author: {
                required: true,
               	maxlength:25
            },
            method: {
				required: true
			},
			newscopertina: {
				required: true
			},
			newstext: {
                required: true
            }
        },
        //For custom messages
        messages: {
        	newstitolo:{
                required: "Il campo titolo news è obbligatorio",
                maxlength: "Il campo titolo news non deve superare 50 caratteri",
        	},
            artista: {
            	required: "Il campo autore è obbligatorio",
                maxlength: "Il campo artista non deve superare 25 caratteri",
            },
            method: {
				required: "Il campo categoria è obbligatorio"
            },
			newscopertina: {
				required: "Il campo news copertina è obbligatorio"
			},
			newstext: {
                required: "Il campo testo news è obbligatorio"
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
	<script>
	/* JQuery per l'aggiunta automatica di fields in base al num° Tracce*/
		$('[name="brani"]').on('change', function() {
			// Not checking for Invalid input
			if (this.value != '') {
				var val = parseInt(this.value, 10);
				var rows = $('#tracks tr'), rowCnt = rows.length - 1; // Allow for header row
				if(val<100){
				if (rowCnt > val) {
					for (var i = rowCnt; i > val; i--) {
						rows[i].remove();
					}
				}
				if (rowCnt < val) {
					for (var i = 0; i < val - rowCnt; i++) {
						// Clone the Template
						var $cloned = $('.template tbody').clone();
						// For each Candidate append the template row
						$('#tracks tbody').append($cloned.html());
					}
				}}
			}
		});
	</script>

	<script>
	 
        $(document).ready(function(){
        	 $('select').material_select();
        	 $('.scrollspy').scrollSpy();

        	
    	});</script>
</body>
</html>