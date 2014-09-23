<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/registerStyle.css" />" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<form:form action="new" modelAttribute="newUser">
		<p id="loginFormTitle">Register</p>
		<form:errors path="*">
			<p class="regError" ><spring:message code="error.global" /></p>
		</form:errors>
		<p class="formLabel">Login: </p>
		<p><form:input path="login" value="" /></p>
			<p class="regError" >
				<form:errors path="login" />
			</p>
		<p class="formLabel">Password: </p>
		<p><form:password path="password" value="" /></p>
		<p class="regError" >
			<form:errors path="password" />
		</p>
		<p class="formLabel">Confirm password: </p>
		<p><form:password path="confirmPassword" /></p>
		<p class="formLabel">E-mail: </p>
		<p><form:input path="email" value="" /></p>
		<p class="regError" >
			<form:errors path="email" />
		</p>
		<p class="loginButton"><input type="submit" value="Register" /></p>
	 </form:form>
</body>
</html>