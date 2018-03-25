window.onload = function(){
    $("#add-user").off("click").on("click", function(){
        $.ajax({
            url: "/user/addUser",
            method: "post",
            data: JSON.stringify({username: $("#username").val(), password: $("#password").val()}),
            contentType: "application/json",
            dataType: "json",
            success: function(result) {
                alert("success " + result);
            },
            error: function(result) {
                alert("error " + result);
            }
        })
    })
}