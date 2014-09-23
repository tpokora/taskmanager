<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<div class="top">
			<div class="loginBar">
				Hello, ${suser.username} <a href="${logoutUrl}" class="logoutButton">Log
					out</a>
			</div>
		</div>
		<div class="main">
			<table id="taskTable">
				<tr>
					<th class="taskCell">Task ${suser.username}</th>
					<th class="dateCell">Due date</th>
					<th class="actionCell">Action</th>
				</tr>
				<c:forEach var="task" items="${suser.taskList}">
					<tr>
						<td class="taskCell">${task.task}</td>
						<td class="dateCell">${task.formatedDate}</td>
						<td class="actionCell"><a href="delete/${task.taskId}"
							class="deleteTaskLink">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="bottom">
			<form:form action="new" modelAttribute="task" method="post">
				<table>
					<tr>
						<td>Task:</td>
						<td><form:textarea path="task" rows="3" cols="30" /></td> 
					</tr>
					<tr>
						<td></td><td><form:errors path="task" cssClass="taskError" /></td>
					</tr>
					<tr>
						<td>Due date:</td>
						<td><form:input path="dueDate" placeholder="DD/MM/YYYY" /></td> 
					</tr>
					<tr>
						<td></td><td><form:errors path="dueDate" cssClass="taskError" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add Task" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>