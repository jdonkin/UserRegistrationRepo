<%@page import="edu.weber.cs4230.DAL.UsersDAO"%>
<%@page import="edu.weber.group.bean.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>
<%
Registration id = (Registration)session.getAttribute("UserData");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../forms.css" />
<link rel="stylesheet" type="text/css" href="../global.css" />

<link rel="stylesheet" type="text/css" href="../welcome.css" />
<title>Welcome</title>
</head>
<body>
<div id="header" style="float: right; width: 20%;">
<label style="font-size: 14px">Welcome, <%= id.getFirstName() %> <%= id.getLastName() %></label>
<a href="../Login?logout"><button>logout</button></a>

</div>
	<h1>Welcome</h1>	
	<div>
	<table>
		<tr>
  			<th colspan="2">User information</th>
		</tr>
		<tr>
			<td>
				Name:
			</td>
			<td>
				<%= id.getLastName() %>, <%= id.getFirstName() %>
			</td>
		</tr>
		<tr>
			<td>
				Username:
			</td>
			<td>
				<%= id.getUsername() %>
			</td>
			<td>
				<a href="changepassword.jsp"><button>Change Password</button></a>
			</td>
		</tr>
		<tr>
			<td>
				Email:
			</td>
			<td>
				<%= id.getEmail() %>
			</td>
			<td>
				<a href="changeemail.jsp"><button>Change Email</button></a>
			</td>
		</tr>
	</table>	
	</div>
		
</body>
</html>