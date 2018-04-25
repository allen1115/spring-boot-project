$(function(){
    initChart();
    initSelect();
    init();
    initEmailBox();
    var myChart;
    function initChart(){
        var ctx = document.getElementById("bar_chart").getContext('2d');
        myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ["Jan", "Feb", "Mar", "Apr","May","Jun", "Jul","Aug","Sep","Oct","Nov","Dec"],
                datasets: [{
                    label: 'Attendance over a period',
                    data: [77, 15, 40, 58, 27, 60,50,89,70,56,50,40],
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
                            beginAtZero:true,
                            callback: function(value, index, values) {
                                return value+"%";
                            }
                        }
                    }]
                }
            }
        });
    }



    function initSelect() {
        var str = '';
        var arr = [
            {name:'Jun',id:1,value:77},
            {name:'Feb',id:2,value:15},
            {name:'Mar',id:3,value:40},
            {name:'Apr',id:4,value:58},
            {name:'May',id:5,value:27},
            {name:'Jun',id:6,value:60},
            {name:'Jul',id:7,value:50},
            {name:'Aug',id:8,value:89},
            {name:'Sep',id:9,value:80},
            {name:'Oct',id:10,value:56},
            {name:'Nov',id:11,value:50},
            {name:'Dec',id:12,value:40}
        ];
        for (var i=0;i<arr.length;i++){
            str += '<li><label><input type="checkbox" value="'+arr[i].id+'" data-name="'+arr[i].name+'" data-value="'+arr[i].value+'">'+arr[i].name+'</label></li>';
        }
        $('#yearId').html(str);
    }


    $("#yearId input").change(function(){

        var name = '';

        $('#yearId input').each(function () {//循环遍历checkbox
            var check=$(this).is(':checked');//判断是否选中
            if(check){
                name += $(this).attr('data-name')+',';
                $(this).attr('name',"yearId");
            }else {
                $(this).attr('name',"");
            }
        });
        if($("#yearId input:checked").length>3){
            $("#yearInput").val($("#yearId input:checked").length+" months are selected")
        }else{
            $("#yearInput").val(name.slice(0,-1));//去除最后的逗号
        }

    });

    $("#yearId").mouseover(function() {
        if (!$("#yearId").hasClass('hover')){//类hover在下面用来验证是否需要隐藏下拉，没有其他用途。
            $("#yearId").addClass('hover');
        }
    }).mouseout(function(){
        $("#yearId").removeClass('hover');
    });

    $("#form").on("click",function(e){
        $("#yearId").removeClass('hide');
        e.stopPropagation();
    })




    $(document).on('click',function() {
        if($("#yearId").css("display")==="block"){
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



            addData(myChart,label,data)
        }

        // if (!$("#yearInput").is(":focus") && !$("#yearId").hasClass('hover')) {//如果没有选中输入框且下拉不在hover状态。
        //
        //
        // } else {
        //     $("#yearId").removeClass('hide');
        // }
    });
    function addData(chart, label, data) {
        chart.data.labels = label;
        chart.data.datasets.forEach(function (dataset) {
            dataset.data = data;
        })
        chart.update();
    }



    function init(){
        var role = {
        data:[
            {
                "Date":"01/01/2018",
                'Name':'Sony',
                'Course':'CS',
                'Attendance':"19%"
            },
            {
                "Date":"01/01/2018",
                'Name':'Allen',
                'Course':'DataBase',
                'Attendance':"24%"
            },
            {
                "Date":"01/01/2018",
                'Name':'Peter',
                'Course':'Java',
                'Attendance':"78%"
            },
            {
                "Date":"01/01/2018",
                'Name':'Colin',
                'Course':'Python',
                'Attendance':"59%"
            },
            {
                "Date":"01/01/2018",
                'Name':'Meggie',
                'Course':'js',
                'Attendance':"70%"
            },
        ],
        initRoleTable : function(data){
            var dataTableOption={
                dom: '<"top"<"pull-left"l><"toolbar"><"pull-right"f><"pull-right create">>rt<"bottom"<"pull-left"i><"pull-right"p>><"clear">',
                iDisplayLength: 10,
                autoWidth: true,
                responsive: true,
                bSort: true,
                bFilterOnEnter: true,
                processing: false,
                order:[[0,"desc"]],
                columns : [
                    {
                        "data":"Date",
                        width:"25%",
                    },
                    {
                        "data":"Name",
                        width:"25%"
                    },
                    {
                        "data":"Course",
                        width:"30%",
                    },
                    {
                        "data":"Attendance",
                        width:"20%"
                    },
                ],
                data:data

            }
            $("#role_table").DataTable().destroy();
            $("#role_table").DataTable(dataTableOption);


        }
    }
        role.initRoleTable(role.data);
    }


    function getEmailBox() {
        var data = [
            {
                "name":"sony1",
                "id":"1",
                "content":"read it",
                "date":"01/01/2018"
            },

            {
                "name":"sony2",
                "id":"1",
                "content":"read it",
                "date":"01/01/2018"
            },
            {
                "name":"sony3",
                "id":"1",
                "content":"read it",
                "date":"01/01/2018"
            }
            ]
        return data
    }

    function initEmailBox(){
        var data = getEmailBox();
        $(".right_body").empty();
        for(var i=0;i<data.length;i++){
            var html = "<div class=\"email_box\">\n" +
                "                                <div class=\"info-name\">"+data[i].name+"</div>\n" +
                "                                <div class=\"info-date\">"+data[i].date+"</div>\n" +
                "                                <div data-id='"+data[i].id+"' data-content='"+data[i].content+"'><i class=\"fa fa-eye\"></i></div>\n" +
                "                            </div>"
            $(".right_body").append(html);
        }
    }

    $("#container1 .fa-eye").on("click",function (e) {
        $(e.currentTarget);
        $("#myModal").modal("show");
        $("#name").html($(e.currentTarget).parents(".email_box").find(".info-name").html())
        $("#date").html($(e.currentTarget).parents(".email_box").find(".info-date").html())
        $("#content").html("Content:"+$(e.currentTarget).parent().attr("data-content"))
    })

})