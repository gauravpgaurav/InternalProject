$(document)
		.ready(
				function() {

					testList();
					$("#answerTable").width($("#target").width() + 18);

					$("#addRow")
							.click(
									function() {

										$("#target")
												.append(
														"<tr><td>123</td><td>TEst</td><td>Rs.500</td></tr>");
									});
				});

function testList() {
	var dataList = document.getElementById('json-datalist-test');
	var input = document.getElementById('ajax_test');

	// Create a new XMLHttpRequest.
	var request = new XMLHttpRequest();

	// Handle state changes for the request.
	request.onreadystatechange = function(response) {
		if (request.readyState === 4) {
			if (request.status === 200) {
				// Parse the JSON
				var jsonOptions = JSON.parse(request.responseText);
				// Loop over the JSON array.
				jsonOptions.forEach(function(item) {
					// Create a new <option> element.
					var option = document.createElement('option');
					// Set the value using the item in the JSON array.
					option.value = item.testCode;
					// Add the <option> element to the <datalist>.
					dataList.appendChild(option);
				});

			} else {
				// An error occured :(
				input.placeholder = "Unable to Load Data !";
			}
		}
	};

	request.open('GET', 'data/test.json', true);
	request.send();
}
function fillTestDetails() {

	var dataList = document.getElementById('json-datalist-test');
	var input = document.getElementById('ajax_test');
	var testName = document.getElementById("testName");
	var testCost = document.getElementById("testCost");
	var request = new XMLHttpRequest();
	// Handle state changes for the request.

	request.onreadystatechange = function(response) {
		if (request.readyState === 4) {
			if (request.status === 200) {

				// Parse the JSON
				var jsonOptions = JSON.parse(request.responseText);
				// Loop over the JSON array.
				jsonOptions.forEach(function(item) {
					console.log(item.testCode + " : " + item.testName + " : "
							+ item.testCost + ":" + input.value);
					if (input.value == item.testCode) {
						console.log("Matches");
						testName.value = item.testName;
						testCost.value = item.testCost;
					}
				});
			} else {
			}
		}
	};

	request.open('GET', 'data/test.json', true);
	request.send();
}