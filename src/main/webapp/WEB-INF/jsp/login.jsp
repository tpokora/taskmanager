<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="loginUrl" value="/j_spring_security_check" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/loginStyle.css" />"
	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/j_spring_security_check' />" method="post">
		<p id="loginFormTitle">Login to Taskmanager</p>
		<p>
			<input type="text" class="inputField"
				onfocus="if(this.value == 'Login') { this.value = ''; }"
				value="Login" name="j_username" />
		</p>
		<p>
			<input type="password" class="inputField"
				onfocus="if(this.value == 'password') { this.value = ''; }"
				value="password" name="j_password" />
		</p>
		<p>
			<input type="checkbox" value="remember"
				name="j_spring_security_remember_me" /> Remember me
		</p>
		<p class="loginButton">
			<input type="submit" value="Login" />
		</p>
		<p class="loginLink">
			<a href="register">Register now!</a>
		</p>
		<p class="loginLink">
			<a href="passwordreset">Forgot your password?</a>
		</p>
	</form>
</body>
</html>