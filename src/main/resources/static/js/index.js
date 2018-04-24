$(function(){
    $(document).on("scroll",function(e){
        if($(document).scrollTop()>=91){
            $(".menu-section").css("position","fixed");
            $("#menu-title").css("display","inline-block")
        }else{
            $(".menu-section").css("position","relative");
            $("#menu-title").css("display","none")
            
        }
    })

    

    Window.showAlert = function(msg){
        $("#showAlert").remove()
        var alertHtml = "<div id='showAlert'><div id='showAlert_text'>"+msg+"</div><div id='showAlert_button'>OK</div><div>";
        $("body").append(alertHtml);
        $("#showAlert_button").on("click",function(){
            $("#showAlert").remove();
        })
    }




})