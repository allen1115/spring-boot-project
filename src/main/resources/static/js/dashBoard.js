$(function () {
    initBarChart();
    initPieChart();
    initLineChart();
    initSelect();
    // init();
    initEmailBox();
    addEvent();
    //init first table
    var myChart;


    
    function initBarChart() {
        var ctx = document.getElementById("bar_chart").getContext('2d');
        myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ["Week1", "Week2", "Week3", "Week4", "Week5", "Week6", "Week7", "Week8", "Week9", "Week10", "Week11", "Week12"],
                datasets: [{
                    label: 'Attendance over a period',
                    data: [77, 15, 40, 58, 27, 60, 50, 89, 70, 56, 50, 40],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            callback: function (value, index, values) {
                                return value + "%";
                            }
                        }
                    }]
                }
            }
        });
    }
    function initPieChart() {
        var ctx = document.getElementById("pie_chart").getContext('2d');
        myChart_pie = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ["Attend","Absent"],
                datasets: [{
                    label: 'Attendance for different subject',
                    data: [77, 23],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)'

                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)'

                    ],
                    borderWidth: 1
                }]
            },
            // options: {
            //     scales: {
            //         yAxes: [{
            //             ticks: {
            //                 beginAtZero: true,
            //                 callback: function (value, index, values) {
            //                     return value + "%";
            //                 }
            //             }
            //         }]
            //     }
            // }
        });
    }
    function initLineChart() {
        var ctx = document.getElementById("line_chart").getContext('2d');
        myChart_line = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["2014", "2015", "2016", "2017", "2018"],
                datasets: [{
                    label: 'Attendance for recent year',
                    data: [77, 84, 89, 91,90],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            callback: function (value, index, values) {
                                return value + "%";
                            }
                        }
                    }]
                }
            }
        });
    }


//first table data
    function initSelect() {
        var str = '';
        var arr = [
            {name: 'Week1', id: 1, value: 77},
            {name: 'Week2', id: 2, value: 15},
            {name: 'Week3', id: 3, value: 40},
            {name: 'Week4', id: 4, value: 58},
            {name: 'Week5', id: 5, value: 27},
            {name: 'Week6', id: 6, value: 60},
            {name: 'Week7', id: 7, value: 50},
            {name: 'Week8', id: 8, value: 89},
            {name: 'Week9', id: 9, value: 70},
            {name: 'Week10', id: 10, value: 56},
            {name: 'Week11', id: 11, value: 50},
            {name: 'Week12', id: 12, value: 40}
        ];
        str+="<li><label id='select_all'>Select All</label></li>"
        for (var i = 0; i < arr.length; i++) {
            str += '<li><label><input type="checkbox" value="' + arr[i].id + '" data-name="' + arr[i].name + '" data-value="' + arr[i].value + '" checked class="checkbox_select">' + arr[i].name + '</label></li>';
        }
        $('#yearId').html(str);
    }


    function addEvent(){
        $("#select_all").on("click",function(){
            $("input.checkbox_select").prop("checked",true);
        })

        $("#yearId input").change(function () {

            var name = '';

            $('#yearId input').each(function () {//循环遍历checkbox
                var check = $(this).is(':checked');//判断是否选中
                if (check) {
                    name += $(this).attr('data-name') + ',';
                    $(this).attr('name', "yearId");
                } else {
                    $(this).attr('name', "");
                }
            });
        });


        $("#pie_Select").on("change",function(){
            var value =$("#pie_Select").find("option:selected").val();
            if(value==1){
                myChart_pie.data.datasets.forEach(function (dataset) {
                    dataset.data = [77,23];
                })

            }else if(value==2){
                myChart_pie.data.datasets.forEach(function (dataset) {
                    dataset.data = [75,25];
                })

            }else if(value==3){
                myChart_pie.data.datasets.forEach(function (dataset) {
                    dataset.data = [85,15];
                })

            }
            myChart_pie.update();
        });



        $("#yearId").mouseover(function () {
            if (!$("#yearId").hasClass('hover')) {//类hover在下面用来验证是否需要隐藏下拉，没有其他用途。
                $("#yearId").addClass('hover');
            }
        }).mouseout(function () {
            $("#yearId").removeClass('hover');
        });

        $("#form").on("click", function (e) {
            $("#yearId").removeClass('hide');
            e.stopPropagation();
        })


//close select dropdown
        $(document).on('click', function () {
            if ($("#yearId").css("display") === "block") {
                var name = '';
                var label = [];
                var data = [];
                $('#yearId input').each(function () {//遍历checkbox
                    var check = $(this).is(':checked');//判断是否选中
                    if (check) {
                        name += $(this).attr('data-name') + ',';
                        $(this).attr('name', "yearId");
                        label.push($(this).attr("data-name"));
                        data.push($(this).attr("data-value"))
                    } else {
                        $(this).attr('name', "");
                    }
                });
                // $("#yearInput").val(name.slice(0, -1));//去除最后的逗号
                $("#yearId").addClass('hide');


                addData(myChart, label, data)
            }
            if ($("#yearId input:checked").length > 3) {
                $("#yearInput").val($("#yearId input:checked").length + " weeks are selected")
            } else {
                $("#yearInput").val(name.slice(0, -1));//去除最后的逗号
            }

            // if (!$("#yearInput").is(":focus") && !$("#yearId").hasClass('hover')) {//如果没有选中输入框且下拉不在hover状态。
            //
            //
            // } else {
            //     $("#yearId").removeClass('hide');
            // }
        });
    }


    function addData(chart, label, data) {
        chart.data.labels = label;
        chart.data.datasets.forEach(function (dataset) {
            dataset.data = data;
        })
        chart.update();
    }




//second table data
    function initEmailBox() {
        $.ajax({
            url : "/repliedEmail/getAllRepliedEmails",
            method : 'GET',
            success : function(res) {
                generateEmailBox(res);
            },
            error : function(err) {
                alert(err);
            }
        })

    }

    function generateEmailBox(data) {
        $(".right_body").empty();
        for (var i = 0; i < data.length; i++) {
            var html = "<div class=\"email_box\">\n" +
                "                                <div class=\"info-name\">" + data[i].name + "</div>\n" +
                "                                <div class=\"info-date\">" + moment(data[i].replied_date).format('YYYY-MM-DD') + "</div>\n" +
                "                                <div data-email='" + data[i].email + "' data-subject='" + data[i].email_subject + "' data-content='" + data[i].absence_reason + "' ><i class=\"fa fa-eye\"></i></div>\n" +
                "                            </div>"
            $(".right_body").append(html);
        }

        $("#container1 .fa-eye").on("click", function (e) {
            $("#myModal").modal("show");
            $("#subject").html("Email Subject: " + $(e.currentTarget).parent().attr("data-subject"))
            $("#from").html("From: " + $(e.currentTarget).parent().attr("data-email"))
            $("#content").html("Absence Reason: " + $(e.currentTarget).parent().attr("data-content"))
        })
    }

})