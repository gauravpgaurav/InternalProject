<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Labs</title>
<link rel="stylesheet" type="text/css" href="styles/Styles.css">
</head>
<script type="text/javascript" src="scriptLib/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="scriptLib/utilFunctions.js"></script>
<body>

	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<br>
	<br>
	<table>
		<tr>
			<th>Order Number :</th>
			<td><input type="text"></td>
			<th>Collection Date :</th>
			<td><input type="date" id="datepicker"></td>
			<th>Collection Type :</th>
			<td>Lab <input type="radio" name="collectionType" value="lab">
				Home <input type="radio" name="collectionType" value="Home"></td>
		</tr>
		<tr>
			<th>Patient Code :</th>
			<td><input type="text"></td>
			<th>Patient Name :</th>
			<td><input type="text"></td>
			<th>Patient Age :</th>
			<td><input type="number" min="1"></td>
		</tr>
		<tr>
			<th>Mobile Number :</th>
			<td><input type="number"></td>
			<th>Email :</th>
			<td><input type="email"></td>
			<th>Gender :</th>
			<td>Female <input type="radio" name="gender" value="female">
				Male <input type="radio" name="gender" value="male"></td>
		</tr>
		<tr>
			<th>Doctor Code :</th>
			<td colspan="2"><input type="text"></td>
			<th>Doctor Name :</th>
			<td colspan="2"><input type="text"></td>
		</tr>
	</table>

	<br>
	<br>
	<hr>
	<h3>Test Details</h3>
	<table>
		<tr>
			<th>Test Code</th>
			<th>Test Name</th>
			<th>Amount</th>

		</tr>

		<tr>
			<td>Total :</td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Add More Test"></td>
			<td colspan="2"><input type="button" value="Confirm Test"></td>
		</tr>
	</table>
	<br>
	<br>
	<footer>
		<%@ include file="Footer.html"%>
	</footer>
</body>
</html>