$(document).ready(function(){

    $('.admin-function').hide();
    $('#all-tasks-content').show();

    $('#admin-option').change(function(){
     var selected = $(this).find(':selected').val();
        $('.admin-function').hide();

        switch (selected){
            case "new-project":
                $('#new-project-content').show();
                break;
            case "new-task":
                $('#new-task-content').show();
                break;
            case "all-tasks":
                $('#all-tasks-content').show();
                break;
            case "all-developers":
                $('#all-developers-content').show();
                if ( !$.fn.dataTable.isDataTable( '#developers-info-data-table' ) ) {
                    $('#developers-info-data-table').DataTable( {
                        "ajax": 'developers-data'
                    } );
                }
                break;
        }
    });

    $('#new-project-content').submit(function() {
        if ($.trim($("#description").val()) === "" || $.trim($("#proj-name").val()) === "") {
            alert('you did not fill out one of the fields');
            return false;
        }
    });

});