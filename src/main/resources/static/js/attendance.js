$(function () {
    init();
    event_binding();
    //init third table
    function init() {
        // TODO add real data for student table
        var role = {
            initRoleTable: function (data) {
                var dataTableOption = {
                    dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                    iDisplayLength: 10,
                    autoWidth: true,
                    responsive: true,
                    bSort: true,
                    bFilterOnEnter: true,
                    processing: false,
                    order: [[1, "desc"]],
                    columns: [
                        {
                            "data": "name"
                        },
                        {
                            "data": "email"
                        },
                        {
                            "data": "program"
                        },
                        {
                            "data": "avgAttendance",
                            render : function(data) {
                                return data + "%"
                            }
                        },
                        {
                            "data": "flag",
                            render : function(data) {
                                if(data === 'red') {
                                    return '<span><i class="fa fa-flag fa-2x pull-left" style="color: red;"></i></span>'
                                } else if (data === 'blue') {
                                    return '<span><i class="fa fa-flag fa-2x pull-left" style="color: blue;"></i></span>'
                                } else {
                                    return '';
                                }
                            }
                        }
                    ],
                    data: data

                };
                $("#role_table").DataTable().destroy();
                $("#role_table").DataTable(dataTableOption);
                $('#role_table tbody').off('click','tr').on('click', 'tr', function () {
                    $(this).toggleClass('selected');
                })
            }
        };
        $.ajax({
            url: "/student/getAllStudents",
            method: 'GET',
            success: function (res) {
                role.initRoleTable(res);
            },
            error: function (err) {
                alert(err);
            }
        })

    }

    function event_binding(){
        $('#red_btn').on('click', function() {
            var Dtable = $('#role_table').DataTable();
            var arr = [];
            for(var i=0; i<Dtable.rows('.selected').data().length; i++) {
                arr.push(Dtable.rows('.selected').data()[i].id)
            }
            console.log(arr);
            $.ajax({
                url : '/student/markAsRed',
                method : 'POST',
                data : {data: arr},
                success : function() {
                    alert('Mark Red Successfully.');
                    init();
                },
                error : function(err){
                    console.error(err);
                }
            })

        })

        $('#blue_btn').on('click', function() {
            var Dtable = $('#role_table').DataTable();
            var arr = [];
            for(var i=0; i<Dtable.rows('.selected').data().length; i++) {
                arr.push(Dtable.rows('.selected').data()[i].id)
            }
            console.log(arr);
            $.ajax({
                url : '/student/markAsBlue',
                method : 'POST',
                data : {data: arr},
                success : function() {
                    alert('Mark Blue Successfully.');
                    init();
                },
                error : function(err){
                    console.error(err);
                }
            })

        })
    }
})