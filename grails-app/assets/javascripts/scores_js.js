$(document).ready(function() {
        var dt = $('#table').dataTable({
            "sScrollY": "800px",
            "sScrollX": "100%",
            "bpaginate": true,
            "sPaginationType": "full_numbers",
            "bSort": true,
            "bFilter": true,
            "bSaveState": true,
            "bProcessing": true,
            "oLanguage": { "sEmptyTable": "No scores were found"},
            "aaSorting": [],
            "ajax": "/ghcp/api/scores",
            "columns": [
              { "data": "strokes" },
              { "data": "rating" },
              { "data": "slope" },
              { "data": "playedOn" },
              { "data": "differential" }
            ]
        });
        
//        event.preventDefault();
//       var h = 
    	   $.getJSON("handicap", function(data) {
    	   	  $("#handicap").html(data.handicap);
       });
});
