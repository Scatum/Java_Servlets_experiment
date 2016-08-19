$(document).ready(function () {

    var table = $('#data-table').DataTable({
        "ajax": 'user-data-table',
        type: "GET",
        "order": [[7, "desc"]]
    });


    $('#tasks-area').show();
    $("#projects-area").hide();
    $('#content-select').change(function () {
        $(".table-content").hide();
        var selected = $(this).find(':selected').val();
        switch (selected){
            case "all_tasks":
                $('#tasks-area').show();
                break;
            case "all_projects":
                $('#projects-area').show();
                if ( !$.fn.dataTable.isDataTable( '#data-table-projects' ) ) {
                    $('#data-table-projects').DataTable( {
                        "ajax": 'projects-status'
                    } );
                }
                break;
        }

    });

});

