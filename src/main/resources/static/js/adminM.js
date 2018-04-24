$(function(){
    self={
        init:function(){

            $('#select-button').dropdown();
            self.initLevel();
            self.initCheckNumber();
            self.addEvent();
            self.initNORESdate({});
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
            var data = [
                "40","60","80"
            ]
            return data
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
            data = 3
            return data
        },

        initLevel:function() {
            var data = self.getLavel().sort(self.sortNumber);
            $("#level_attendance").html("");
            for(var i=0;i<data.length;i++){
                var html = "<div data-level='"+data[i]+"'><span class='level_width'>Level "+(data.length-i)+":</span> attendance lower than "+data[i]+"%   <span class='fa fa-icon-edit' style='color:#FA4659;cursor:pointer;margin-left:10px'></span></div>";
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
            var data = typeof data=="object"?self.getNORES_time():data;
            $("#no-r_time").val(data);
            $("#no-r_data").val(data);
            $("#no-r_time").attr("disabled",true);
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
        addLevel:function(){

        }
    }

    self.init();

})