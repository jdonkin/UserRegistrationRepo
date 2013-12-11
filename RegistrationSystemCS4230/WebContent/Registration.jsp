<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage = "ErrorPage.jsp" %>
<%@page import="edu.weber.cs4230.DAL.UsersDAO"%>
<%@page import="edu.weber.group.bean.Registration"%>
<%
Registration mybean = null;
if (session.getAttribute("bean") != null) {
	mybean = (Registration) session.getAttribute("bean");
} else {
	mybean = new Registration();
}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="forms.css">
<link rel="stylesheet" type="text/css" href="angularjs.css">
<link rel="stylesheet" type="text/css" href="global.css" />
<script src="http://code.angularjs.org/1.2.1/angular.min.js"></script>
<script src="checkInput.js"></script> 

</head>
<body>

<div class="round">
	<h2 class="center" id="title">Register</h2>
</div>
<div id="stylized" class="myform" ng-app="myApp">
<form action="Register" method="post" name="regForm" novalidate class="css-form">
	<fieldset>
		<label>First name:
		<div ng-show="regForm.firstName.$dirty">
			<span class="small" ng-show="regForm.firstName.$error.required">First Name Required</span>
		</div>
		</label> <input type="text" name="firstName" id="firstName" ng-model="user.firstname" <%
		if(mybean.getFirstName() != null)
		{
			%>value="<% mybean.getFirstName(); %>"
			<%
		}
			%>required/><br />
		
		<label>Last name:
		<div ng-show="regForm.lastName.$dirty">
			<span class="small" ng-show="regForm.lastName.$error.required">Last Name Required</span>
		</div>
		</label><input type="text" name="lastName" id="lastName" ng-model="user.lastname" 
		<%
		if(mybean.getLastName() != null)
		{
			%>value="<% mybean.getLastName(); %>"
			<%
		}
		%>
		required /><br />
		<% if (session.getAttribute("bean") != null) { %>
		<p>user name exist!!!</p>
		<% } %>
		<label>username:
		<div ng-show="regForm.username.$dirty">
			<span class="small" ng-show="regForm.username.$error.required">Username required</span>
			<span class="small" ng-show="!regForm.username.$error.minLength && !regForm.username.$error.maxLength && regForm.username.$error.pattern && regForm.username.$dirty">letters &amp; numbers only</span>
			<span class="small" ng-show="!regForm.username.$error.required && (regForm.username.$error.minlength || regForm.username.$error.maxlength) && regForm.username.$dirty">between 5 and 20 characters</span>
			<span class="good" ng-show="regForm.username.$valid">Good!</span>
		</div>
		</label> <input type="text" name="username" id="username" ng-model="user.username" ng-minlength="5" ng-maxlength="20" ng-pattern="/^[A-z][A-z0-9]*$/" 
		<%
		if(mybean.getUsername() != null)
		{
			%>value="<% mybean.getUsername(); %>"
			<%
		}
		%>
		required  /><br />
		
		<label>password:
		<div ng-show="regForm.password.$dirty">
			<span class="small" ng-show="regForm.password.$error.required && regForm.password.$dirty">Password Required</span>
   			<span class="small" ng-show="!regForm.password.$error.required && (regForm.password.$error.minlength || regForm.password.$error.maxlength) && regForm.password.$dirty">Between 8 &amp; 20 chars.</span>
   			<span class="small" ng-show="!regForm.password.$error.required && !regForm.password.$error.minlength && !regForm.password.$error.maxlength && regForm.password.$error.pattern && regForm.password.$dirty">Ex: Way2Go!!</span>
   			<span class="good" ng-show="regForm.password.$valid">Good!</span>
		</div>
		</label> <input type="password" name="password" id="password" ng-model="password" ng-minlength="8" ng-maxlength="20" ng-pattern="/(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z])/" required  /><br />
		<div ng-show="regForm.password.$dirty"><br />
		</div>
		<label>confirm password:
		<div ng-show="regForm.confirmPassword.$dirty">
			<span class="small" ng-show="regForm.confirmPassword.$error.match">Both passwords must match</span>
			<span class="small" ng-show="regForm.confirmPassword.$error.required">Required</span>
			<span class="good" ng-show="regForm.confirmPassword.$valid">Good!</span>
		</div>
		</label> <input type="password" id='confirmPassword' required name='confirmPassword' match="password" ng-model="confirmPassword"><br />
		
		
		<label>email:
		<div ng-show="regForm.email.$dirty && regForm.email.$invalid">
			<span class="small" ng-show="regForm.email.$error.required">Add your email</span>
			<span class="small" ng-show="regForm.email.$error.email">Not Valid</span>
			<span class="good" ng-show="regForm.email.$valid">Good!</span>
		</div>
		
		</label> <input type="email" name="email" id="email" ng-model="email" 
		<%
		if(mybean.getEmail() != null)
		{
			%>value="<% mybean.getEmail(); %>"
			<%
		}
		%>
		required/> 
		
		<label>confirm email:
		<div ng-show="regForm.confirmEmail.$dirty">
			<span class="small" ng-show="regForm.confirmEmail.$error.match">email does not match</span>
			<span class="small" ng-show="regForm.confirmEmail.$error.required">Required</span>
			<span class="good" ng-show="regForm.confirmEmail.$valid">Good!</span>
		</div>
		</label> <input type="text" name="confirmEmail" id="confirmEmail" ng-model="confirmEmail" match="email" required /><br />
		<button type="reset" ng-click="reset()">Reset</button>
		<button type="submit" ng-disabled="regForm.$invalid">Submit</button>		
	</fieldset>
</form>

</div>
</body>
</html>