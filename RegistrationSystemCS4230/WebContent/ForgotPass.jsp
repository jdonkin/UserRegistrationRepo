<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Forgotten Password</title>
</head>
<body>

	<form action = "ResetPassword" method = "post">
		Enter your Email: <input type = "text" name = "email">
		<br>
		<input type = "submit" name = "submit">
		
	
	</form>
	<br />
	<% if (session.getAttribute("BadEmail") != null) { %>
		<p style="font-foreground: red;">Email dosn't exist.</p>
	<% } %>

</body>
</html>