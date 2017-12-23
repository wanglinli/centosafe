$(document).ready(function () {
    $("#memberInfo").html("");
    $.ajax({
        type: "GET",
        url: "/centosafe/getMemberInfo",
        data:{},
        success:function (data) {
            if(data.code === 0){
                $.each(data.data,function (index,member) {
                    var content = '<tr><td>'+(index+1)+'</td><td>'+member.id+'</td><td>'+member.name+'</td>';
                    $.each(member.roleSet,function (index,role) {
                        content += '<td>'+role.name+'</td></tr>';
                    });
                    $("#memberInfo").append(content);
                });

            }
        }
    });
});
