<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="edu.weber.group.bean.Registration" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>

<% 
//edu.weber.group.bean.Registration bean = new edu.weber.group.bean.Registration();
Registration bean=(Registration) request.getAttribute("bean");
int status = bean.getStatus();

if (status == 1){%>
	<h3>User name is already in use</h3>
	<%@include file="Registration.jsp" %>
<%}
if (status ==2){%>
	<h3>User name is invalid</h3>
	<%@include file="Login.html" %>
	<%}%><%
if (status ==3){%>
	<h3>Password is incorrect</h3>
	
	<%@include file="Login.html" %>
	<% }%> 

<% if (status ==4){%>
	<h3>Password is incorrect: Please Log back in</h3>
	
	<%@include file="Login.html" %>
	<% }%>

<% if (status ==5){%>
	<h3>Your emails don't match</h3>
	
	<%@include file="UserArea/changeemail.jsp" %>
	<% }%>

	
<%if (status ==6){%>
	<h3>Password is incorrect: Please Log back in</h3>
	
	<%@include file="Login.html" %>
	<% }%>
	
<%if (status ==7){%>
	<h3>Passwords don't match</h3>
	
	<%@include file="UserArea/changepassword.jsp" %>
	<% }%>


</body>
</html>