$(function(){
    self={
        emailData:[],
        init:function(){

            $('#select-button').dropdown();
            // self.initLevel();
            self.initCheckNumber();
            self.addEvent();
            self.getNORES_time();
            self.initEmailBox();
            self.getLavel();
        },
        addEvent:function(){
            $("#upload_button").on("click",function(){
                var value = $('#adminManagement').cron("value")
                console.log()
            })
            $("input[type=number]").on("change",function(){
                if($(this).val()>100||$(this).val()<0){
                    $(this).val("")

                }
            });
            $("#check_list input").on("click",function(e){
                e.stopPropagation();
                self.changeCheckList();
            })

            $("#cronTime input").on("click",self.pickCronType)

            $("#check_list input[type=checkbox]").on("click",self.select_number)

            $("#level_attendance .fa-edit").on("click",self.change_setting)
            $("#level_attendance .fa-save").on("click",self.save_setting)

            $("#upload_button_days").on("click",function () {
                if($("#no-r_time").val()===""){
                    $("#no-r_time").attr("placeholder","Enter a number")
                    return ;
                }
                $.ajax({
                    url:"",
                    data:{
                        "time":$("#no-r_time").val()
                    },
                    method:"post",
                    success:function (res) {
                        self.getNORES_time()
                    }
                })
            })

            $("#upload_button_per").on("click",function(){
                if($("#level_attendance input").eq(0).val()===""){
                    $("#level_attendance input").eq(0).attr("placeholder","Percentage")
                    return
                }if($("#level_attendance input").eq(1).val()===""){
                    $("#level_attendance input").eq(1).attr("placeholder","Percentage")
                    return
                }if($("#level_attendance input").eq(2).val()===""){
                    $("#level_attendance input").eq(2).attr("placeholder","Percentage")
                    return
                }
                if($("#level_attendance input").eq(0).val()<=$("#level_attendance input").eq(1).val()){
                    alert("First number must greater than second one")
                    return
                }
                if($("#level_attendance input").eq(1).val()<=$("#level_attendance input").eq(2).val()){
                    alert("Second number must greater than third one")
                    return
                }
                if($("#level_attendance input").eq(0).val()<0||$("#level_attendance input").eq(1).val()<0||$("#level_attendance input").eq(2).val()<0){
                    alert("Number must greater than 0")
                    return
                }
                var data = {first:$("#level_attendance input").eq(0).val(), second: $("#level_attendance input").eq(1).val(), third:$("#level_attendance input").eq(2).val()};
                $.ajax({
                    url:"/admin/updateLvlOfAttendance",
                    method:"post",
                    contentType : 'application/json',
                    data:JSON.stringify(data),
                    success:function (res) {
                        alert('Update Successfully.');
                        self.getLavel();
                        
                    }
                })
            })

        },
        sortNumber:function(a,b){
            return a - b
        },
        pickCronType:function(e){
            $("#cronTime .form-control").attr("disabled",true)
            $(e.currentTarget).parents(".radio-time").find("input[type='number']").removeAttr("disabled")
        },
        select_number:function(){

        },
        change_setting:function(e){
            $("#no-r_time").removeAttr("disabled");
            $("#percentageSort").removeAttr("disabled");
            $("#check_list input").attr("disabled")
        },
        save_setting:function(e){
            $(e.currentTarget).parentElement().find(".change-area").hide();
            $(e.currentTarget).parentElement().find(".data-area").show();
            $("#add_new_level input").html("");
            self.initLevel();
        },
        getLavel:function(){
            //TODO
            //get info in third tab and init
            $.ajax({
                url:"/admin/getThresholdConfig",
                method:"get",
                success:function(res){
                    //res is a array like ["80","60","40"]
                    self.initLevel(res)
                },
                error:function(){

                }

            })
        },
        getCheckNumber:function(){
            var data = [
                {'name':"allen","checked":true},
                {'name':"maggie","checked":false},
                {'name':"peter","checked":true},
                {'name':"sony","checked":false},
                {'name':"kelvin","checked":true},
                {'name':"dou","checked":false},
                {'name':"colin","checked":false}
            ];
            return data;
        },

        getNORES_time:function(){
            //TODO
            //get info in second tab
            $.ajax({
                url:"",
                method:"get",
                success:function(res){
                    //res.data = number
                    self.initNORESdate(res.data)
                }

            })

        },

        initLevel:function(data) {
            // data = ["80","60","40"]
            var data = data.sort(self.sortNumber);
            $("#level_attendance").html("");
            for(var i=0;i<data.length;i++){
                var html = "<div data-level='"+data[i]+"'><span class='level_width'>Level "+(data.length-i)+":</span> attendance lower than <input type='number' value='"+data[i]+"' class='form-control' style='display: inline-block'>%   <span class='fa fa-icon-edit' style='color:#FA4659;cursor:pointer;margin-left:10px'></span></div>";
                $("#level_attendance").prepend(html)
            }
            // $("#level_attendance").append("<div id='add_new_level'><span class='level_width'></span><input placeholder='Create new Level' class='form-control' style='display:inline-block;width:178px'><span class='fa fa-save' style='color:#FA4659;cursor:pointer;margin-left:10px'></span></div>")

        },
        initCheckNumber:function(){
            var data = self.getCheckNumber();
            $("#check_list").html("");
            for(var i=0;i<data.length;i++){
                var checked = data[i].checked?'checked':''
                var html = "<div class='col-md-4'><input type='checkbox'"+checked+">"+data[i].name+"</div>";
                $("#check_list").append(html)
            }
            self.changeCheckList();
        },
        initNORESdate:function(data){
            var data = typeof data=="object"?0:data;
            $("#no-r_time").val(data);
            // $("#no-r_data").val(data);

        },
        initPercentage:function(data){

          $("#percentageSort").val(data).attr("disabled",true);

        },
        changeCheckList:function(){
            if($("#check_list input[checked]").length>0){
                $("#select-button span").html($("#check_list input:checked").length+"   number(s) selected")
            }else{
                $("#select-button span").html("Select Numbers")
            }
            $("#check_list input").attr("disabled")
        },



        initEmailBox:function () {
            $.ajax({
                url : "/admin/getAllEmailTemplate",//get email template
                method : 'GET',
                success : function(res) {
                    // res = [
                    //     {
                    //         "template":"template",
                    //         "subject":"subject",
                    //         "id":1
                    //     },
                    //     {
                    //         "template":"template2",
                    //         "subject":"subject2",
                    //         "id":2
                    //     }
                    // ]


                    self.emailData = res;
                    self.generateEmailBox(self.emailData);
                },
                error : function(err) {
                    alert(err);
                }
            })

        },

        generateEmailBox:function (data) {
        $("#table_body").empty();
            for (var i = 0; i < data.length; i++) {
                // var html = "<div class=\"email_box\">\n" +
                //     "                                <div class=\"info-name\">" + data[i].name + "</div>\n" +
                //     "                                <div class=\"info-date\">" + moment(data[i].date).format('YYYY-MM-DD') + "</div>\n" +
                //     "                                <div data-email='" + data[i].email + "' data-subject='" + data[i].email_subject + "' data-content='" + data[i].absence_reason + "' ><i class=\"fa fa-eye\"></i></div>\n" +
                //     "                            </div>";
                var html = '<tr><td>'+data[i].templateName+'</td><td>' + data[i].level + '</td><td><i class="fa fa-edit" data-id="'+data[i].id+'" data-subject="'+data[i].templateName+'" data-template="'+data[i].templateBody+'"></i></td></tr>'
                $("#table_body").append(html);
            }

            $("#table_body .fa-edit").on("click", function (e) {

                $("#myModal").modal("show");
                $("#email_subject").val($(e.currentTarget).attr("data-subject"))
                $("#template").val($(e.currentTarget).attr("data-template"))
                $("#submit_email").attr("data-id",$(e.currentTarget).attr("data-id"))
            })

            $("#submit_email").on("click",function () {
                if($("#email_subject").val()===""){
                    $("#email_subject").attr("placeholder","Enter Subject")
                    return
                }

                if($("#template").val()===""){
                    $("#template").attr("placeholder","Enter Template")
                    return
                }
                var data={
                    "id":$("#submit_email").attr("data-id"),
                    "subject":$("#email_subject").val(),
                    "template":$("#template").val()
                }
                $.ajax({
                    url:"/admin/updateEmailTemplateByID",
                    contentType : 'application/json',
                    data:JSON.stringify(data),
                    method:"post",
                    success:function (res) {
                        $("#myModal").modal("hide");
                        alert('Update Successfully.');
                        self.initEmailBox();
                    }
                })
            })
        }
    }

    self.init();

})