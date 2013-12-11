<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>
<jsp:useBean id="id" class="edu.weber.group.bean.Registration"/>
<jsp:setProperty property="*" name="id"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../forms.css">
<link rel="stylesheet" type="text/css" href="../angularjs.css">
<link rel="stylesheet" type="text/css" href="../global.css" />
<script src="http://code.angularjs.org/1.2.1/angular.min.js"></script>
<script src="../checkInput.js"></script> 
<title>Update Info</title>
</head>
<body>
<div class="round">
	<h2 class="center" id="title">Update</h2>
</div>
	<div id="stylized" class="myform" ng-app="myApp">
	
	<input type="button" value="Back" onclick()="history.back()">
	
	<form method="post" name="regForm" onsubmit="return validateForm()" novalidate class="css-form" action="Edit">
		<fieldset>
			<label>First name:</label> <input type="text" name="firstName" id="firstName" value="<% id.getFirstName(); %>" /> <br />
			
			<label>Last name:</label><input type="text" name="lastName" id="lastName" value="<% id.getLastName(); %>" /><br />
			
			<label>User name:</label> <input type="text" name="username" id="username" value="<% id.getUsername(); %>" /><br />			
			
			<label>email:</label> <input type="email" name="email" id="email" value="<% id.getEmail(); %>" /> <button type="submit" value="Change Email">Change Email</button> <br />
						
			<button type="submit" ng-disabled="regForm.$invalid" value="Change Password">Change Password</button>
		</fieldset>
	</form>
</div>
</body>
</html>