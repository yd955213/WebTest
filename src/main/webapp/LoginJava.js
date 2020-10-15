function loginAjaxTest() {
    $.ajax({
        url:"./ServletLogin",
        type:"post",
        data:'&userName=yd1&passWord=123',
        dataType:"text",
        success:function (resp) {
            alert("Ajax请求成功, 服务器返回：" + resp)

        },
        error:function () {
            alert("Ajax请求失败")
        }
    })
}