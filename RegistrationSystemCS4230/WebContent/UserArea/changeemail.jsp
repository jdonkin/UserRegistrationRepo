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
<title>Change Your Email</title>
</head>
<body>
<div class="round">
	<h2 class="center" id="title">Update Password</h2>
	<input type="button" value="Back" onclick()="history.back()">
</div>
<div id="stylized" class="myform" ng-app="myApp">
	<form method="post" name="regForm" novalidate class="css-form" action="../Edit">
		<fieldset>
		<input type="hidden" name="submit" value="change email" />
			<label>email:
			<div ng-show="regForm.email.$dirty && regForm.email.$invalid">
				<span class="small" ng-show="regForm.email.$error.required">Add your email</span>
				<span class="small" ng-show="regForm.email.$error.email">Not Valid</span>
				<span class="good" ng-show="regForm.email.$valid">Good!</span>
			</div>
			</label> <input type="email" name="email" id="email" value="<%= id.getEmail() %>" ng-model="email" required/> <br />
			
			<label>confirm email:
			<div ng-show="regForm.confirmEmail.$dirty">
				<span class="small" ng-show="regForm.confirmEmail.$error.match">email does not match</span>
				<span class="small" ng-show="regForm.confirmEmail.$error.required">Required</span>
				<span class="good" ng-show="regForm.confirmEmail.$valid">Good!</span>
			</div>
			</label> <input type="text" name="confirm" id="confirmEmail" value="" ng-model="confirmEmail" match="email" required/><br />
		
					<button type="submit" ng-disabled="regForm.$invalid">Submit</button>
		</fieldset>
	</form>
</div>
</body>
</html>