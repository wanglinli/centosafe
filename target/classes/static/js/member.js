function getMemberInfo() {
    $("#info").html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getMemberInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                var th = '<tr><td width="10%">序号</td><td width="">用户ID</td><td width="">用户名</td> <td width="">用户角色</td></tr>';
                $('#info').append(th);
                $.each(data.data,function (index,member) {
                    var content = '<tr><td>'+(index+1)+'</td><td>'+member.id+'</td><td>'+member.name+'</td>';
                    $.each(member.roleSet,function (index,role) {
                        content += '<td>'+role.name+'</td></tr>';
                    });
                    $("#info").append(content);
                });

            }
        }
    });
}