<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Labs</title>
<link type="text/css" href="styles/Styles.css" rel="stylesheet">

</head>
<body>
	<div id="langContainer">
		<a href="index.jsp?local=en"><img alt="en" src="images/en.png"
			class="ico"></a> <a href="index.jsp?local=de"><img alt="de"
			src="images/de.png" class="ico"></a> <a href="index.jsp?local=fr"><img
			alt="fr" src="images/fr.png" class="ico"></a>
	</div>
	<br>
	<br>
	<br>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<br>

	<fmt:setLocale value="${param.local}" />

	<br>
	<form action="Validate_Servlet" method="post">
		<table>
			<fmt:setBundle basename="LanguageData" var="msg" scope="page" />

			<tr>
				<th><label><fmt:message key="table.tr.role"
							bundle="${msg}" />:</label></th>
				<td><select name="role">
						<option selected="selected">Administrator</option>
						<option>Manager</option>
						<option>Lab Technician</option>
						<option>Operator</option>
				</select></td>
			</tr>
			<tr>
				<th><label><fmt:message key="table.tr.labCode"
							bundle="${msg}" />:</label></th>
				<td><datalist id="json-datalist"></datalist> <input type="text"
					name="labCode" id="ajax" list="json-datalist"
					placeholder=<fmt:message key="table.tr.placeholder.labCode" bundle="${msg}" />></td>
			</tr>
			<tr>
				<th><label><fmt:message key="table.tr.userName"
							bundle="${msg}" />:</label></th>
				<td><input type="text" name="userName"
					placeholder=<fmt:message key="table.tr.placeholder.userName" bundle="${msg}" />></td>
			</tr>
			<tr>
				<th><label><fmt:message key="table.tr.passWord"
							bundle="${msg}" />:</label></th>
				<td><input type="password" name="passWord"
					placeholder=<fmt:message key="table.tr.placeholder.passWord" bundle="${msg}" />>
				</td>
			</tr>
			<tr style="background-color: silver;">
				<td colspan="2"><input type="submit"
					value=<fmt:message key="table.btn.submit" bundle="${msg}" />
					class="btn"></td>
			</tr>

		</table>
		<br> <br>
	</form>
	<footer>
		<%@ include file="Footer.html"%>
	</footer>
</body>
<script type="text/javascript" src="scriptLib/Ajax_Json.js"></script>
</html>