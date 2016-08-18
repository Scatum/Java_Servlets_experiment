$(document).ready(function(){

	$('#dev_type').hide();
	
    $('#manager').change(function(){
        if(this.checked){
            $('#dev_type').hide();
        }

    });

  $('#developer').change(function(){
        if(this.checked){
            $('#dev_type').show();
        }
   

    });

});