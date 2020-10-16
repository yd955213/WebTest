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
// 表单JSon
function loginAjaxJson(){
    $.ajax({
        url:"./ServletLogin",
        type:"post",
        data:$("form").serialize(),
        dataType:"json",
        success:function (res) {
            $("#loginJson")[0].innerText=res["msg"];
            if(res["code"] == 0) {
                $("#loginJson")[0].style.color="green";
            }else {
                $("#loginJson")[0].style.color="red";
            }
        },
        error:function () {
            alert("Ajax请求失败");
        }
    })
}