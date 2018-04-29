$(function () {
    init();
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
                    order: [[0, "desc"]],
                    columns: [
                        {
                            "data": "name",
                            width: "25%"
                        },
                        {
                            "data": "email",
                            width: "25%"
                        },
                        {
                            "data": "program",
                            width: "40%"
                        },
                        {
                            "data": "avgAttendance",
                            width: "10%",
                            render : function(data) {
                                return data + "%"
                            }
                        }
                    ],
                    data: data

                };
                $("#role_table").DataTable().destroy();
                $("#role_table").DataTable(dataTableOption);
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
})