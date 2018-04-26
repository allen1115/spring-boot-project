$(function(){
    var addEvent = function(){
        $(document).on("click",".fa-edit",function(e){
            var id=$(e.currentTarget).attr("data-id");
            var user_role = {}
            privilege.data.map(function (index,keyValue) {
                if(index.ROLE_ID===id){
                    user_role = index;
                    return
                }
            })

            var idList = user_role.PRI_LIST;
            $("#myModal .modal-body").empty();
            var html = "<div id=''>"
            for(var i=0;i<privilege.PRIList.length;i++){

                html+="<div class='checkbox_role'><input type='checkbox' data-id='"+privilege.PRIList[i].PRI_ID+"' value='"+privilege.PRIList[i].PRI_NAME+"'>"+privilege.PRIList[i].PRI_NAME+"</div>"

            }



            html+="</div>"
            $("#myModal .modal-body").append(html);
            for(var k=0;k<idList.length;k++){

                $("#myModal input[data-id='"+idList[k]+"']").prop('checked',true);

            }

            $("#myModal").modal("show");



        })

        $(document).on("click","#addRole",function () {
            $("#myModal_add").modal("show");

        })
        $(document).on("click","#addPri",function () {
            $("#myModal_addpri").modal("show");

        })
    }

    var privilege = {
        getPrivilegeList:function () {
            $.ajax({
                url:"",
                method:"get",
                success:function (res) {
                    privilege.PRIList = [
                        {
                            "PRI_NAME":"read",
                            "PRI_ID":"1"
                        },
                        {
                            "PRI_NAME":"write",
                            "PRI_ID":"2"
                        },
                        {
                            "PRI_NAME":"add",
                            "PRI_ID":"3"
                        },
                        {
                            "PRI_NAME":"delete",
                            "PRI_ID":"4"
                        }

                    ]
                    privilege.initRoleList()
                },
                error:function () {

                }

            })
        },
        initRoleList:function () {
            $.ajax({
                url:"",
                method:"get",
                success:function (data) {
                    privilege.data =[
                        {
                            'ROLE_NAME':'student',
                            'ROLE_ID':"1",
                            "PRI_LIST":[
                                "1"
                            ]
                        },
                        {
                            'ROLE_NAME':'teacher',
                            'ROLE_ID':"2",
                            "PRI_LIST":[
                                "1","2","3","4"
                            ]
                        },
                        {
                            'ROLE_NAME':'admin',
                            'ROLE_ID':"3",
                            "PRI_LIST":[
                                "1","3","4"
                            ]
                        },
                    ]

                    privilege.initTable();

                },
                error:function () {

                }

            })
        },
        initTable:function () {
            var dataTableOption={
                dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                iDisplayLength: 10,
                autoWidth: false,
                responsive: true,
                bSort: true,
                bFilterOnEnter: true,
                processing: false,
                order:[[0,"desc"]],
                columns : [
                    {
                        "data":"ROLE_NAME",
                        width:"400px",
                    },
                    {
                        "data":"PRI_LIST",
                        width:"200px",
                        render:function(data,type,row,meta){

                            html = "<span class='privilegeList'>"
                            for (var i=0;i<row.PRI_LIST.length;i++){
                                for(var k=0;k<privilege.PRIList.length;k++){
                                    if(row.PRI_LIST[i]===privilege.PRIList[k].PRI_ID){
                                        html+=privilege.PRIList[k].PRI_NAME+", ";
                                    }
                                }
                            }
                            html = html.slice(0,html.length-2);
                            html +="</span><span class='fa fa-edit' data-id='"+row.ROLE_ID+"'></span>"

                            // var html = "<input type=\"text\" placeholder=\"Select Privilege\" readonly class='select_box'>" +
                            //     "                                <ul  class=\"hide\" id='select_box"+row.ROLE_ID+"'>\n";
                            //
                            // for(var i=0;i<privilege.PRIList.length;i++){
                            //     for(var k=0;k<row.PRI_LIST.length;k++){
                            //
                            //     }
                            //     if(privilege.PRIList[i].PRI__ID===row.ROLE_ID){
                            //         html+='<li><label><input type="checkbox" value="'+privilege.PRIList[i].PRI_ID+'" data-name="'+privilege.PRIList[i].PRI_NAME+'" data-value="'+privilege.PRIList[i].PRI_ID+'" checked>'+privilege.PRIList[i].PRI_NAME+'</label></li>'
                            //     }else{
                            //         html+='<li><label><input type="checkbox" value="'+privilege.PRIList[i].PRI_ID+'" data-name="'+privilege.PRIList[i].PRI_NAME+'" data-value="'+privilege.PRIList[i].PRI_ID+'">'+privilege.PRIList[i].PRI_NAME+'</label></li>'
                            //     }
                            // }
                            //
                            //
                            // html+="</ul>";
                            return html
                        }
                    },
                ],
                data:privilege.data

            }
            $("#privilege_table").DataTable().destroy();
            $("#privilege_table").DataTable(dataTableOption);
        }
    }
    var role = {
        getRoleList:function(){
            $.ajax({
                url:"",
                method:"get",
                success:function (res) {
                    role.roleList = [
                        {
                            "ROLE_NAME":"student",
                            "ROLE_ID":"1"
                        },
                        {
                            "ROLE_NAME":"teacher",
                            "ROLE_ID":"2"
                        },
                        {
                            "ROLE_NAME":"admin",
                            "ROLE_ID":"3"
                        }

                    ]
                    role.initUserList()
                },
                error:function () {

                }

            })
        },



        initUserList:function(){
            $.ajax({
                url:"",
                method:"get",
                success:function (data) {
                    role.data =[
                        {
                            'USER_NAME':'sony',
                            'USER_DES':'student',
                            'USER_ROLE_ID':"1",
                            "USER_ID":"1"
                        },
                        {
                            'USER_NAME':'allen',
                            'USER_DES':'teacher',
                            'USER_ROLE_ID':"2",
                            "USER_ID":"2"
                        },
                        {
                            'USER_NAME':'peter',
                            'USER_DES':'teacher',
                            'USER_ROLE_ID':"3",
                            "USER_ID":"3"
                        },
                    ]


                    role.initTable();

                },
                error:function () {

                }

            })


        },
        initTable:function () {
            var dataTableOption={
                dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                iDisplayLength: 10,
                autoWidth: false,
                responsive: true,
                bSort: true,
                bFilterOnEnter: true,
                processing: false,
                order:[[0,"desc"]],
                columns : [
                    {
                        "data":"USER_NAME",
                        width:"200px",
                    },
                    {
                        "data":"USER_ID",
                        width:"100px",
                        render:function(data,type,row,meta){
                            var selectHtml = "<select id='"+row.USER_ID+"'>";
                            for (var i=0;i<role.roleList.length;i++){
                                if(role.roleList[i].ROLE_ID === row.USER_ROLE_ID){
                                    selectHtml += "<option value='"+role.roleList[i].ROLE_ID+"' selected>"+role.roleList[i].ROLE_NAME+"</option>"
                                }else{
                                    selectHtml += "<option value='"+role.roleList[i].ROLE_ID+"'>"+role.roleList[i].ROLE_NAME+"</option>"
                                }

                            }
                            selectHtml +="</select>"
                            return selectHtml
                        }
                    },
                ],
                data:role.data

            }
            $("#role_table").DataTable().destroy();
            $("#role_table").DataTable(dataTableOption);
        }

    }
    var role_func = {
        initRole:function () {
            $.ajax({
                url:"",
                method:"",
                success:function (res) {
                    role_func.data = [
                        {
                            "ROLE_NAME":"student",
                            "ROLE_ID":"1"
                        },
                        {
                            "ROLE_NAME":"teacher",
                            "ROLE_ID":"2"
                        },
                        {
                            "ROLE_NAME":"admin",
                            "ROLE_ID":"3"
                        }
                    ]

                    role_func.initTable()
                },
                error:function (err) {

                }
            })
        },
        initTable:function () {
            var dataTableOption={
                dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                iDisplayLength: 10,
                autoWidth: false,
                responsive: true,
                bSort: true,
                bFilterOnEnter: true,
                processing: false,
                order:[[0,"desc"]],
                columns : [
                    {
                        "data":"ROLE_NAME",
                        width:"200px"
                    },
                    {
                        "data":"ROLE_ID",
                        width:"100px",
                        render:function(data,type,row,meta){
                            return "<span class='fa fa-remove' data-id='"+data+"'></span>"
                        }
                    },
                ],
                data:role_func.data

            }
            $("#role_list_table").DataTable().destroy();
            $("#role_list_table").DataTable(dataTableOption);
        }
    }
    var pri_func = {
        initpri:function () {
            $.ajax({
                url:"",
                method:"",
                success:function (res) {
                    pri_func.data = [
                        {
                            "PRI_NAME":"read",
                            "PRI_ID":"1"
                        },
                        {
                            "PRI_NAME":"write",
                            "PRI_ID":"2"
                        },
                        {
                            "PRI_NAME":"add",
                            "PRI_ID":"3"
                        },
                        {
                            "PRI_NAME":"delete",
                            "PRI_ID":"4"
                        }
                    ]

                    pri_func.initTable()
                },
                error:function (err) {

                }
            })
        },
        initTable:function () {
            var dataTableOption={
                dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                iDisplayLength: 10,
                autoWidth: false,
                responsive: true,
                bSort: true,
                bFilterOnEnter: true,
                processing: false,
                order:[[0,"desc"]],
                columns : [
                    {
                        "data":"PRI_NAME",
                        width:"200px"
                    },
                    {
                        "data":"PRI_ID",
                        width:"100px",
                        render:function(data,type,row,meta){
                            return "<span class='fa fa-remove' data-id='"+data+"'></span>"
                        }
                    },
                ],
                data:pri_func.data

            }
            $("#pri_list_table").DataTable().destroy();
            $("#pri_list_table").DataTable(dataTableOption);
        }
    }
    function init(){
        role.getRoleList();
        privilege.getPrivilegeList();
        role_func.initRole();
        pri_func.initpri()
        addEvent()
    }
    init()
})