$(document).on("click", "#createUserBtn", function() {
    jsRoutes.controllers.Application.postsignup().ajax({
        type: "POST",
        data: $("#createUserForm").serialize(),
         success: function(response) {
            console.log(response);
            alert("You will now be redirected.");
            window.location = "http://localhost:9000/login/";
             
         },
        error: function(response) {
            $("#createUserForm").html(response.responseText);
        }
    });
});
