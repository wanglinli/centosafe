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
