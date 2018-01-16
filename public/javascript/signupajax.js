$(document).on("click", "#createUserBtn", function() {
    jsRoutes.controllers.Application.postsignup().ajax({
        type: "POST",
        data: $("#createUserForm").serialize(),
         success: function(response) {
            if(response === "no_errors"){
                console.log(response);
            } 
             
         },
        error: function(response) {
            $("#createUserForm").html(response.responseText);
        }
    });
});
