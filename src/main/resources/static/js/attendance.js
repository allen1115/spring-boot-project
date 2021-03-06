$(function () {
    init();
    event_binding();
    //init third table
    function init() {
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
                                    return '<span style="display: inline-block;vertical-align: middle"><i class="fa fa-flag fa-2x pull-left" style="color: red;"></i></span>'
                                } else if (data === 'blue') {
                                    return '<span style="display: inline-block;vertical-align: middle"><i class="fa fa-flag fa-2x pull-left" style="color: blue;"></i></span>'
                                } else {
                                    return '';
                                }
                            }
                        },
                        {
                            "data": "note",
                            render: function(data, type, row){
                                data = data || '';
                                return "<span style='display: inline-block;width: 100%;text-align: right'><button style='background-color: transparent; border: 0' data-id='" + row.id + "'data-note=" + data + "><i class='fa fa-pencil-square-o fa-2x' aria-hidden='true' style='vertical-align: middle'></i></button></span>"
                            }
                        }
                    ],
                    data: data

                };
                $("#role_table").DataTable().destroy();
                $("#role_table").DataTable(dataTableOption);
                $('#role_table tbody').off('click').on('click', 'button', function () {
                    $('#note-id').val($(this)[0].dataset.id)
                    $('#note').val($(this)[0].dataset.note);
                    $('#myModal').modal('show');
                } );
                $('#role_table tbody').off('click','td').on('click', 'td', function () {
                    if(this.innerHTML.indexOf('button') > 0) {
                        return;
                    }
                    $(this).parent().toggleClass('selected');
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

        $('#clear_btn').on('click', function(){
            var Dtable = $('#role_table').DataTable();
            var arr = [];
            for(var i=0; i<Dtable.rows('.selected').data().length; i++) {
                arr.push(Dtable.rows('.selected').data()[i].id)
            }
            console.log(arr);
            $.ajax({
                url : '/student/unMark',
                method : 'POST',
                data : {data: arr},
                success : function() {
                    alert('Remove Mark Successfully.');
                    init();
                },
                error : function(err){
                    console.error(err);
                }
            })
        })

        $('#update_note').on('click', function(){
            var id = $('#note-id').val();
            var text = $('#note').val();
            $.ajax({
                url: "/student/updateNote",
                method: "POSt",
                contentType : 'application/json',
                data: JSON.stringify({id: id, note: text}),
                success: function(res) {
                    alert("Add Note Successfully.");
                    init();
                    $('#myModal').modal('hide');
                },
                error: function(err) {
                    console.error(err);
                }
            })
        })
    }
})