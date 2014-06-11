var dt = {
	"sScrollX": "100%",
	"bpaginate": true,
	"sPaginationType": "full_numbers",
	"bSort": false,
	"bFilter": false,
	"bSaveState": true,
	"bProcessing": false,
	"oLanguage": { "sEmptyTable": "No scores were found"},
	"lengthMenu": [[20, 50, -1], [20, 50, "All"]]
};

$(document).ready(function() {
	$('#table').dataTable(dt);
});
