/**
 * 
 */
var dataList = document.getElementById('json-datalist');
var input = document.getElementById('ajax');

console.log("Reached Here")
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
				option.value = item.labCode;
				// Add the <option> element to the <datalist>.
				dataList.appendChild(option);
			});

		} else {
			// An error occured :(
			input.placeholder = "Unable to Load Data !";
		}
	}
};
// Set up and make the request.
request.open('GET', 'data/labList.json', true);
request.send();