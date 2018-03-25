$(function(){
    var role = {
        data:[
                {
                    'USER_NAME':'sony',
                    'USER_DES':'stu',
                    'USER_stu_role':"yes"
                },
                {
                    'USER_NAME':'allen',
                    'USER_DES':'teacher',
                    'USER_stu_role':"yes"
                },
                {
                    'USER_NAME':'peter',
                    'USER_DES':'teacher',
                    'USER_stu_role':"no"
                },
            ],
        initRoleTable : function(data){
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
                        width:"100px",
                    },
                    {
                        "data":"USER_DES",
                        width:"100px"
                    },
                    {
                        "data":"USER_stu_role",
                        width:"100px",
                        render:function(data,type,row,meta){
                            var check = data == "yes"?'checked':'';
                            return "<input type='checkbox' "+check+">"
                        }
                    },
                ],
                data:data

            }
            $("#role_table").DataTable().destroy();
            $("#role_table").DataTable(dataTableOption);
        }
    }
    function init(){
        role.initRoleTable(role.data);
    }
    init()
})