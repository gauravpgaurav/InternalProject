<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Student Details</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>

	<h2>Insert Student Details</h2>
	<br>
	<hr>
	<form:form action="submitDetails" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Student ID :</td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><form:input path="studentName" /></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><form:select path="department" items="${department}" /></td>
			</tr>
			<tr>
				<td>Academic Marks (Out of 100) :</td>
				<td><form:input path="academicMarkScore" /></td>
			</tr>
			<tr>
				<td>Academic Event Score (Out of 100) :</td>
				<td><form:input path="academicEventScore" /></td>
			</tr>
			<tr>
				<td>Sports Activity Score (Out of 100) :</td>
				<td><form:input path="sportActivityScore" /></td>
			</tr>
			<tr>
				<td>Cultural Activity Score (Out of 100) :</td>
				<td><form:input path="culturalActivityScore" /></td>
			</tr>
			<tr>
				<td>Upload Picture :</td>
				<td><input name="image" type="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save Data"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>