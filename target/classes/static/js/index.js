
//首页表格信息
$(document).ready(function () {
    $.ajax({
        type:"GET",
        url:"/centosafe/getTopInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th='<tr style="text-align: center"><td>详情</td></tr>';
                $("#info").append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
});

//博客链接
function blog() {
    $.ajax({
        type: "GET",
        url: "/centosafe/blog",
        data:{},
        success:function (data) {
            window.location.href=data.data;
        }
    })
}

//github链接
function github() {
    $.ajax({
        type: "GET",
        url: "/centosafe/github",
        data:{},
        success:function (data) {
            window.location.href=data.data;
        }
    })
}


//注销
function dologout() {
    $.ajax({
        type: "GET",
        url: "/centosafe/logout",
        data:{},
        success:function (data) {
            alert("注销成功！");
            window.location.href=data.data;
        }
    })
}
