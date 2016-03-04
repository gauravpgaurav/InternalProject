<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Abc Labs</title>
<style>
header, footer {
	background-color: black;
	color: white;
}

body {
	text-align: center;
}

table {
	width: 35%;
}

table, tr, td {
	border: 4px solid black;
	border-collapse: collapse;
	padding: 5px;
}

.btn {
	border: 3px dotted white;
	background-color: black;
	color: white;
}

.ico {
	height: 20px;
	float: right;
	width: 20px;
	float: right;
}
</style>
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<fmt:setLocale value="${param.local}" />
	<div>
		<a href="index.jsp?local=en"><img alt="en" src="images/en.png"
			class="ico"></a> <a href="index.jsp?local=de"><img alt="de"
			src="images/de.png" class="ico"></a> <a href="index.jsp?local=fr"><img
			alt="fr" src="images/fr.png" class="ico"></a>
	</div>

	<form>
		<table>
			<fmt:setBundle basename="LanguageData" var="msg" scope="page" />

			<tr>
				<td><label><fmt:message key="table.tr.role"
							bundle="${msg}" />:</label></td>
				<td><select>
						<option>Operator</option>
				</select></td>
			</tr>
			<tr>
				<td><label><fmt:message key="table.tr.labCode"
							bundle="${msg}" />:</label></td>
				<td><input type="text"
					placeholder=<fmt:message key="table.tr.placeholder.labCode" bundle="${msg}" />></td>
			</tr>
			<tr>
				<td><label><fmt:message key="table.tr.userName"
							bundle="${msg}" />:</label></td>
				<td><input type="text"
					placeholder=<fmt:message key="table.tr.placeholder.userName" bundle="${msg}" />></td>
			</tr>
			<tr>
				<td><label><fmt:message key="table.tr.passWord"
							bundle="${msg}" />:</label></td>
				<td><input type="password"
					placeholder=<fmt:message key="table.tr.placeholder.passWord" bundle="${msg}" />>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value=<fmt:message key="table.btn.submit" bundle="${msg}" />
					class="btn"></td>
			</tr>

		</table>
	</form>
	<footer>
		<%@ include file="Footer.html"%>
	</footer>
</body>
</html>