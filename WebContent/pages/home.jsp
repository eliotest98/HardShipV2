<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="theme-color" content="#373641">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link rel='shourtcut icon' href='favicon.ico' type='image/x-icon'/>
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

	<!--FINE NAV-->
	
	<div id="fail" class="modal">
    <div class="modal-content">
      <h4>Errore</h4>
      <p>Username o password errata</p>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
    </div>
  </div>
  <%if(request.getAttribute("on") =="off"){ %>
	<script type="text/javascript">$('#fail').openModal();
</script>

	<% } %>
	<% Boolean x=(Boolean)request.getAttribute("Acquisto");		
	if(x!= null){
		if(x==true){
			%>
	<script>alert("Acquisto effettuato");</script>
	<%}else{%>
	 <script>alert("Acquisto non effettuato");</script>
	 <%}} %>
		<div class="parallax-container">
			<div class="parallax">
				<img src="${pageContext.request.contextPath}/img/home1.png">
			</div>
		</div>
	<div class="section white">
		<h4>ULTIMI NOTIZIE</h4>
		<div id="pre2" class="progress">
      <div class="indeterminate"></div>
  </div>
		<div class="row" id="lastnews"></div>
		<h5 class="right-align"><a href="${pageContext.request.contextPath}/AllNews">Vedi tutte le Notizie</a></h5>
	</div>



	<!-- SCRIPT-->
	<script>
	/* Script per il caricamento delle ultime news caricate nel sito*/
	function loadLastNews() {
    	$.get("/ship/Notizie/", function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
            var side = $("#lastnews"); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
            
            console.log(responseJson);
            $.each(responseJson, function(index, News) {    // Iterate over the JSON array.
            	var notizia= '<div class="col s12 m4 l4"> \
                    <div class="card"> \
                    <div class="card-image"> \
                      <img class="activator" src='+News.copertina+'> \
                    </div> \
                    <div class="card-content">\
                    <span class="card-title activator grey-text text-darken-4" style="text-shadow: 0px 0px 0px;"> '+News.titolo+'<i class="material-icons right">more_vert</i></span>\
                    <p>\
					<a href="${pageContext.request.contextPath}/ReadMore?news='+News.id+'">Read more</a>\
				</p>\
                  </div>\
                    <div class="card-reveal"> \
                    <span class="card-title grey-text text-darken-4"style="text-shadow: 0px 0px 0px;">'+News.titolo+'<i class="material-icons right">close</i></span> \
                    <p>'+News.contenuto+'</p>\
                  		</div> \
                  </div> \
              </div>';
            		
            		
            		side                  // Create HTML <tr> element, set its text content with currently iterated item and append it to the <table>.
               .append(notizia);     // Create HTML <td> element, set its text content with price of currently iterated product and append it to the <tr>.
            });
            $("#pre2").hide();
        });
    }
	</script>
	<script>
        $(document).ready(function(){
        	loadLastNews();
        	$('.parallax').parallax();
      		$('.slider').slider();
      		$('.modal-trigger').leanModal({
      	      dismissible: true, // Modal can be dismissed by clicking outside of the modal
      	      opacity: .5, // Opacity of modal background
      	      in_duration: 300, // Transition in duration
      	      out_duration: 200, // Transition out duration
      	    }
      	  );
        	
    	});</script>


	<!-- BOTTONE + FOOTER -->
	<%@include file="../frag/footer.jsp"%>
</body>
</html>