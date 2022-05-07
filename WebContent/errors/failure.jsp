<%@ page contentType="text/html; charset=US-ASCII" %>
<%@ page isErrorPage="true" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
	
	<title>Error JSP</title>
</head>

<body>

	<%@ include file="../frag/header.jsp" %>

	<div id="err" class="clear">
		<p>
			<b>An exception was raised!</b><br/>
			<%= exception.toString() %>
		</p>
		<p>
			<b>Exception message is:</b><br/>
			<%= exception.getMessage() %>
		</p>
		<p>
			<b>Stacktrace is:</b><br/>
<%
			// this will send trace to the browser's screen
			exception.printStackTrace(new java.io.PrintWriter(out));
			// this will send it to the log file
			exception.printStackTrace();
%>
		</p>

	</div>

	<%@ include file="../frag/footer.jsp" %>

</body>
</html>