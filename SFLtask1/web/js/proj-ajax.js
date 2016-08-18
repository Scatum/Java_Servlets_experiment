$(document).ready(function(){

    $("#delete-task").click(function(){
        var id =  $("#task-id").val();
        $.ajax
        ({
            type: "GET",
            data: 'id='+  id,
            url: "editTask",
            success:function(content)
            {
                location.href = "home"
            }
        });
    });

    $("#save-task-edit").click(function(){
        var id =  $("#task-id").val();
        $.ajax
        ({
            type: "POST",
            data: {"task-id":$("#task-id").val(),"task-name":$("#name").val(),"task-progres":$("#task-progres").val(),
                "assign-user":$("#assign-user").val(),"task-point":$("#point").val(), "task-description":$("#description").val()},
            url: "editTask",
            success:function(content)
            {
                location.href = "home"
            }
        });
    });


});