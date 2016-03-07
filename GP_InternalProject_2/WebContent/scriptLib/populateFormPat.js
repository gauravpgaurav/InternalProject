/**
 * 
 */
var dataList_pat = document.getElementById('json-datalist-pat');
var input_pat = document.getElementById('ajax_pat');

// Create a new XMLHttpRequest.
var requestPat = new XMLHttpRequest();

// Handle state changes for the request.
requestPat.onreadystatechange = function(response) {
	if (requestPat.readyState === 4) {
		if (requestPat.status === 200) {
			// Parse the JSON
			var jsonOptions = JSON.parse(requestPat.responseText);
			// Loop over the JSON array.
			jsonOptions.forEach(function(item) {
				// Create a new <option> element.
				var option = document.createElement('option');
				// Set the value using the item in the JSON array.
				option.value = item.patCode;
				// Add the <option> element to the <datalist>.
				dataList_pat.appendChild(option);
			});

		} else {
			// An error occured :(
			input_pat.placeholder = "Unable to Load Data !";
		}
	}
};

requestPat.open('GET', 'data/patient.json', true);
requestPat.send();

function fillPatientDetails() {

	var patCode = document.getElementById("ajax_pat");
	var patName = document.getElementById("patName");
	var patAge = document.getElementById("patAge");
	var patHandPhone = document.getElementById("patHandPhone");
	var patEmail = document.getElementById("patEmail");
	var patFemale = document.getElementById("patFemale");
	var patMale = document.getElementById("patMale");

	var requestPat = new XMLHttpRequest();

	// Handle state changes for the request.
	requestPat.onreadystatechange = function(response) {
		if (requestPat.readyState === 4) {
			if (requestPat.status === 200) {

				// Parse the JSON
				var jsonOptions = JSON.parse(requestPat.responseText);
				// Loop over the JSON array.
				jsonOptions.forEach(function(item) {
					if (patCode.value == item.patCode) {
						patName.value = item.name;
						patAge.value = item.age;
						patHandPhone.value = item.handPhone;
						patEmail.value = item.email;
					} 
				});
			} else {
				console.log("Test Cleared!")
				patName.value = "";
				patAge.value = "";
				patHandPhone.value = "";
				patEmail.value = "";
			}
		}
	};

	requestPat.open('GET', 'data/patient.json', true);
	requestPat.send();
}
