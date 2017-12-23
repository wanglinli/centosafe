
//同步用户登陆日志文件
function loggedlog() {
    $.ajax({
        type: "POST",
        url: "/centosafe/updateLoggedLog",
        data:{},
        success:function (data) {
            if(data.code === 0){
                alert("日志同步成功!");
                getLoggedLog()
            }
        }
    });
}

//用户登陆日志内容
function getLoggedLog() {
    $('#logInfo').html("");
    $.ajax({
        type: "POST",
        url: "/centosafe/getLoggedLogInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                $.each(data.data,function (index,value) {
                    var content = '<tr><td>'+(index+1)+'</td><td>'+value+'</td></tr>';
                    $('#logInfo').append(content);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}

//同步用户ssh连接日志文件
function sshConneclog() {
    $.ajax({
        type: "POST",
        url: "/centosafe/updateSshConnecLog",
        data:{},
        success:function (data) {
            if(data.code === 0){
                alert("日志同步成功!");
                getSshConnecLog()
            }
        }
    });
}

//用户ssh连接日志内容
function getSshConnecLog() {
    $('#logInfo').html("");
    $.ajax({
        type: "POST",
        url: "/centosafe/getSshConnecLogInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                $.each(data.data,function (index,value) {
                    var content = '<tr><td>'+(index+1)+'</td><td>'+value+'</td></tr>';
                    $('#logInfo').append(content);
                });
            }else {
                alert(data.msg)
            }
        }
    })
}