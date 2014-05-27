$(document).ready(function() {
        $('#table').dataTable({
            "sScrollY": "800px",
            "sScrollX": "100%",
            "bpaginate": true,
            "sPaginationType": "full_numbers",
            "bSort": true,
            "bFilter": true,
            "bSaveState": true,
            "bProcessing": true,
            "oLanguage": { "sEmptyTable": "No scores were found"},
            "aaSorting": []
        });
});
