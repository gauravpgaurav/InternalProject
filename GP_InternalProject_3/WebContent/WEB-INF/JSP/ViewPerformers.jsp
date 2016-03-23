<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Performers</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<h3>Student List</h3>
	<table border="1" cellspacing="0">
		<tr>
			<td><label>Student ID</label></td>
			<td><label>Students Name</label></td>
			<td><label>Department</label></td>
			<td><label>Academic Mark Score</label></td>
			<td><label>Academic Event Score</label></td>
			<td><label>Sport Activity Score</label></td>
			<td><label>Cultural Activity Score</label></td>
			<td><label>Total Score</label></td>
			<td><label>Picture</label></td>
		</tr>

		<c:forEach items="${student}" var="student">
			<tr>
				<td>${student.studentId }</td>
				<td>${student.studentName }</td>
				<td>${student.department }</td>
				<td>${student.academicMarkScore }</td>
				<td>${student.academicEventScore }</td>
				<td>${student.sportActivityScore }</td>
				<td>${student.culturalActivityScore }</td>
				<td>${student.totalScore }</td>
				<td><img src="${student.imagePath}" height="100px" width=""></img></td>
		</c:forEach>
	</table>
</body>
</html>