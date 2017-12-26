//用户登陆日志内容
function getLoggedInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getLoggedInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>Linux用户登录日志</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//用户ssh连接日志内容
function getSshConnectInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getSshConnectInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>用户ssh连接日志</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//系统发行版本
function getVersionInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getVersionInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>系统发行版本</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//top命令信息
function getTopInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getTopInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>top命令信息</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//磁盘状态
function getDfInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getDfInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>磁盘状态</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//进程状态
function getPsInfo() {
    $('#info').html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getPsInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr style="text-align: center"><td>进程状态</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,value) {
                    var tbody = '<tr><td>'+value+'</td></tr>';
                    $('#info').append(tbody);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}