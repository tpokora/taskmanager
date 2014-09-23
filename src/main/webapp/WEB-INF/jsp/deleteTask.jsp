<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh"content="5;url=<c:url value="/main/tasklist"/> "> <!--  wersja dla openshift bez taskmanager -->
<title>Insert title here</title>
<link href="<c:url value="/resources/css/registerStyle.css" />" rel="stylesheet" />
</head>
<body>
	<div id="regConfirm">
		<h3>Task has been deleted!</h3>
		<p>Now you will be redirected to task list page.</p>
	</div>
</body>
</body>
</html>