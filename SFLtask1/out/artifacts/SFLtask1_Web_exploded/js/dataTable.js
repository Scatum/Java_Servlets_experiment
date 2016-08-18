$(document).ready(function() {

    $('#data-table').DataTable( {
        "ajax": 'user-data-table',
        "order": [[ 7, "desc" ]]
    } );
    
   
} );

