$(document)
		.ready(
				function() {
					var temp = $("#rowCount").val();
					testList(temp);
					$("#answerTable").width($("#target").width() + 18);

					$("#addRow")
							.click(
									function() {

										var count = parseInt($("#rowCount")
												.val()) + 1;
										$("#rowCount").val(count);
										// console.log("Count :" + count);
										$("#target")
												.append(
														"<tr><td><datalist id='json-datalist-test"
																+ count
																+ "'></datalist> <input type='text' name='testCode'"
																+ count
																+ "'  id='ajax_test"
																+ count
																+ "' list='json-datalist-test"
																+ count
																+ "'placeholder='Enter Test Code' onkeyup='fillTestDetails("
																+ count
																+ ")'onblur='fillTestDetails("
																+ count
																+ ")'></td><td><input type='text' id='testName"
																+ count
																+ "' name='testName"
																+ count
																+ "'></td><td><input type='text' id='testCost"
																+ count
																+ "' name='testCost"
																+ count
																+ "'></td></tr>");

										testList(count);

									});
				});

function testList(iter) {
	var dataList = document.getElementById("json-datalist-test" + iter);
	var input = document.getElementById("ajax_test" + iter);

	var request = new XMLHttpRequest();

	request.onreadystatechange = function(response) {
		if (request.readyState === 4) {
			if (request.status === 200) {
				var jsonOptions = JSON.parse(request.responseText);
				jsonOptions.forEach(function(item) {
					var option = document.createElement('option');
					option.value = item.testCode;
					dataList.appendChild(option);
				});

			} else {

			}
		}
	};

	request.open('GET', 'data/test.json', true);
	request.send();
}
function fillTestDetails(iter) {

	var dataList = document.getElementById('json-datalist-test' + iter);
	var input = document.getElementById('ajax_test' + iter);
	var testName = document.getElementById("testName" + iter);
	var testCost = document.getElementById("testCost" + iter);
	var request = new XMLHttpRequest();
	// Handle state changes for the request.

	request.onreadystatechange = function(response) {
		if (request.readyState === 4) {
			if (request.status === 200) {

				// Parse the JSON
				var jsonOptions = JSON.parse(request.responseText);
				// Loop over the JSON array.
				jsonOptions.forEach(function(item) {

					if (input.value == item.testCode) {

						testName.value = item.testName;
						testCost.value = item.testCost;
						calculateTotal(item.testCost);
					}
				});
			} else {
			}
		}
	};

	request.open('GET', 'data/test.json', true);
	request.send();

}

function calculateTotal(cost) {

	var sum = parseInt($("#totalCost").html());
	var count = parseInt($("#rowCount").val());
	console.log("Count :" + count);
	// console.log("Test 0 = " + $("#testCost0").val());
	// for (i = 0; i < count; i++) {
	// sum += parseInt($("#testCost" + i).val());
	//
	// }
	sum += parseInt(cost);
	$("#totalCost").html(sum);
}