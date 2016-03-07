$(document).ready(
		function() {

			var currentTime = new Date();
			// First Date Of the month
			var startDateFrom = new Date(currentTime.getFullYear(), currentTime
					.getMonth(), 1);
			// Last Date Of the Month
			var startDateTo = new Date(currentTime.getFullYear(), currentTime
					.getMonth() + 1, 0);

			console.log(startDateFrom);

			// $("#datepicker").attr("min",startDateFrom);
			// $('#eg").prop('checked',true);
			// $("#eg").prop('checked',true);
		});