window.onload = function(){
    $("#login").off("click").on("click", function(){
        $.ajax({
            url: "/login",
            method: "post",
            data: JSON.stringify({username: $("#username").val(), password: $("#password").val()}),
            contentType: "application/json",
            success: function(result) {
                if(result === 'success') {
                    window.location.href = '/';
                } else {
                    alert(result);
                    $('#username').val('');
                    $('#password').val('')
                }
            },
            error: function(result) {
                alert("error " + result);
            }
        })
    })
}