$(function () {
    $("#login_form").submit(function () {//绑定表单提交事件

        //alert("submit")
        $.ajax({
            //url:"../view/main.html",
            url:"../api/user/login",
            type:"get",
            //contentType:"x-www-form-urlencoded",
            data:$("#login_form").serialize(),//请求数据，使用表单的数据
            dataType:"json",//响应数据类型
            success:function (data) {
                //返回数据success为true，跳转到main，反之提示报错信息
                if (data.success) {
                    window.location.href="main.html"
                }else {
                    alert(JSON.stringify(data))//json对象转字符串
                }
            },
            error:function (request,textStatus,error) {//只有当响应状态码为4xx，5xx才进入error
                alert(request.status)
            }
        })
        return false;
    })
})