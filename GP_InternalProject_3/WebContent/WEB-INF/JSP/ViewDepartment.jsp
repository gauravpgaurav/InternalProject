<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Department Top 3</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
</head>
<body>
	<h1>View Department Wise Top 3</h1>
	<br>
	<hr>

	<c:forEach items="${department}" var="req">
		<spring:url value="/viewTopDetails/${req}" var="url" htmlEscape="true"></spring:url>
		<a href="${url}">${req} </a>
		<br>
	</c:forEach>

</body>
</html>