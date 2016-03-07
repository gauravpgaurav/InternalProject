/**
 * 
 */
var dataList_doc = document.getElementById('json-datalist-doc');
var input_doc = document.getElementById('ajax_doc');

// Create a new XMLHttpRequest.
var requestDoc = new XMLHttpRequest();

// Handle state changes for the request.
requestDoc.onreadystatechange = function(response) {
	if (requestDoc.readyState === 4) {
		if (requestDoc.status === 200) {
			// Parse the JSON
			var jsonOptions = JSON.parse(requestDoc.responseText);
			// Loop over the JSON array.
			jsonOptions.forEach(function(item) {
				// Create a new <option> element.
				var option = document.createElement('option');
				// Set the value using the item in the JSON array.
				option.value = item.docCode;
				// Add the <option> element to the <datalist>.
				dataList_doc.appendChild(option);
			});

		} else {
			// An error occured :(
			input_doc.placeholder = "Unable to Load Data !";
		}
	}
};
// Set up and make the request.
requestDoc.open('GET', 'data/doctor.json', true);
requestDoc.send();

function fillDoctorDetails() {
	var docCode = document.getElementById("ajax_doc");
	var docName = document.getElementById("docName");

	// Handle state changes for the request.
	requestDoc.onreadystatechange = function(response) {
		if (requestDoc.readyState === 4) {
			if (requestDoc.status === 200) {

				// Parse the JSON
				var jsonOptions = JSON.parse(requestDoc.responseText);
				// Loop over the JSON array.
				jsonOptions.forEach(function(item) {
					if (docCode.value == item.docCode) {
						docName.value = item.docName;
					}
				});
			} else {
				docCode.value = "";
				docName.value = "";
			}
		}
	};

	requestDoc.open('GET', 'data/doctor.json', true);
	requestDoc.send();
}