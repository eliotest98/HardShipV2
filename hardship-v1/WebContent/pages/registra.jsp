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
	    src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>	
	<script type="text/javascript" 
		src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/additional-methods.min.js"></script>

	<%@ include file="../frag/header.jsp"%>


	<!---Fine navbar---->
	<div>
		<form class="formValidate col s12"  id="formValidate" novalidate="novalidate"
			action="${pageContext.request.contextPath}/Reg" method="post">
			<div class="row">
				<div class="input-field col s6">
					<input name="first_name" id="first_name" type="text"
						class="validate"> <label for="first_name">Nome</label>
				</div>
				<div class="input-field col s6">
					<input name="last_name" id="last_name" type="text" class="validate">
					<label for="last_name">Cognome</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input name="user" id="user" type="text" class="validate">
					<label for="user">Username</label>
				</div>
				<div class="input-field col s6">
					<input name="password" id="password" type="password"
						class="validate"> <label for="password">Password</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input name="CF" id="CF" type="text" class="validate"> <label
						for="CF">Codice Fiscale</label>
				</div>
				<!-- DATA PICKER -->

				<div class="input-field col s6">
					<input name="data" id="data" type="date" class="datepicker"
						placeholder="Data di nascita">
				</div>
			</div>
			<div class="row">
				<div class="row">
					<div class="input-field col s12">
						<input name="email" id="email" type="email" class="validate">
						<label for="email" data-error="Inserire un email corretta." >Email</label>
					</div>
				</div>
			</div>
		</form>
		<!-- Bottone -->
		<button href="home.jsp" form="formValidate" class="btn waves-effect waves-light right"
			type="submit" name="action">
			Submit <i class="material-icons right">send</i>
		</button>
	</div>
	<!-- Modal Structure -->
	
	</div>
	<!-- fine form-->
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
	<script>$(".button-collapse").sideNav();</script>
	<script type="text/javascript">
	/* jQuery per la validazione della form di registrazione  */
	jQuery.validator.addMethod("lettersonly", function(value, element) 
			{
			return this.optional(element) || /^[a-z," "]+$/i.test(value);
			}, "Il campo non può contenere numeri e caratteri speciali."); 
	jQuery.validator.addMethod("email", function(value, element) 
			{
			return this.optional(element) || /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/.test(value);
			}, "Il campo email non rispetta il formato"); 
	
	;
	$("#formValidate").validate({
        rules: {
        	first_name: {
                required: true,
               	minlength:3,
               	maxlength:25,
               	lettersonly:true
            },
            last_name: {
                required: true,
                minlength:3,
               	maxlength:30,
               	lettersonly:true
            },
            user: {
				required: true,
				minlength:2,
               	maxlength:15
			},
			password: {
				required: true,
				minlength:6,
               	maxlength:30,
				equalTo: "#password"
			},
			data:{
				required:true
			},
			CF: {
                required: true,
                minlength:16,
               	maxlength:16
            },
			email:{
				required:true,
				minlength:10,
				maxlength:50,
				email:true
			}
        },
        //For custom messages
        messages: {
        	first_name:{
                required: "Il campo nome è obbligatorio",
                maxlength: "Il campo nome non deve superare 30 caratteri",
                minlength: "Il campo nome deve contenere almeno 3 caratteri"
        	},
            last_name: {
            	required: "Il campo cognome è obbligatorio",
                maxlength: "Il campo cognome non deve superare 30 caratteri",
                minlength: "Il campo cognome deve contenere almeno 3 caratteri"
            },
            user: {
				required: "Il campo username è obbligatorio",
				minlength: "Il campo username deve contenere almeno 2 caratteri alfanumerici",
               	maxlength:"Il campo username non deve superare 15 caratteri",
			},
			password: {
				required: "Il campo password è obbligatorio",
				minlength: "Il campo password deve contenere almeno 6 caratteri alfanumerici",
               	maxlength:"Il campo password non deve superare 30 caratteri"
			},
			CF: {
                required: "Il campo codice fiscale è obbligatorio",
                minlength: "Il campo codice fiscale deve contenere 16 caratteri alfanumerici",
               	maxlength: "Il campo codice fiscale deve contenere 16 caratteri alfanumerici"
            },
			data:{
				required:"Il campo data è obbligatorio"
			},
            email:{
				required: "Il campo email è obbligatorio",
				minlength: "Il campo email deve contenere almeno 10 caratteri alfanumerici",
				maxlength: "Il campo email non deve superare 50 caratteri",
				email: "Il campo email non rispetta il formato"
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

	<!--FINE Bottone -->
	<%@ include file="../frag/footer.jsp"%>
</body>
</html>