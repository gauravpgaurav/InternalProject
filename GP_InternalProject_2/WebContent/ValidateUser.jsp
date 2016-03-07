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
	<h3>
		Lab Code :
		<%
		out.print(request.getParameter("labCode"));
	%>
	</h3>
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
			<td><datalist id="json-datalist-pat"></datalist> <input
				type="text" name="patCode" id="ajax_pat" list="json-datalist-pat"
				placeholder="Enter Patient Code" onkeyup="fillPatientDetails()"
				onblur="fillPatientDetails()"></td>
			<th>Patient Name :</th>
			<td><input type="text" id="patName" name="patName"></td>
			<th>Patient Age :</th>
			<td><input type="number" min="1" id="patAge" name="patAge"></td>
		</tr>
		<tr>
			<th>Mobile Number :</th>
			<td><input type="number" id="patHandPhone" name="patHandPhone"></td>
			<th>Email :</th>
			<td><input type="email" id="patEmail" name="patEmail"></td>
			<th>Gender :</th>
			<td>Female <input type="radio" name="gender" value="female"
				id="patFemale"> Male <input type="radio" name="gender"
				value="male" id="patMale"></td>
		</tr>
		<tr>
			<th>Doctor Code :</th>
			<td colspan="2"><datalist id="json-datalist-doc"></datalist> <input
				type="text" name="docCode" id="ajax_doc" list="json-datalist-doc"
				placeholder="Enter Doctor Code" onkeyup="fillDoctorDetails()"
				onblur="fillDoctorDetails()"></td>
			<th>Doctor Name :</th>
			<td colspan="2"><input type="text" id="docName"></td>
		</tr>
	</table>

	<br>
	<br>
	<hr>
	<h3>Test Details</h3>
	<table id="target">
		<tr>
			<th>Test Code</th>
			<th>Test Name</th>
			<th>Amount</th>

		</tr>
		<tr>
			<td><datalist id="json-datalist-test"></datalist> <input
				type="text" name="testCode" id="ajax_test" list="json-datalist-test"
				placeholder="Enter Test Code" onkeyup="fillTestDetails()"
				onblur="fillTestDetails()"></td>
			<td><input type="text" id="testName" name="testName"></td>
			<td><input type="text" id="testCost" name="testCost"></td>
		</tr>
	</table>
	<table id="answerTable">

		<tr>
			<td style="width: 173px">Total :</td>
			<td style="width: 173px"></td>
		</tr>
		<tr>
			<td style="width: 173px"><input type="button"
				value="Add More Test" class="btn" id="addRow"></td>
			<td style="width: 173px"><input type="button"
				value="Confirm Test" class="btn"></td>
		</tr>
	</table>
	<br>
	<br>
	<footer>
		<%@ include file="Footer.html"%>
	</footer>
</body>
<script type="text/javascript" src="scriptLib/populateFormDoc.js"></script>
<script type="text/javascript" src="scriptLib/populateFormPat.js"></script>
<script type="text/javascript" src="scriptLib/populateTest.js"></script>
</html>