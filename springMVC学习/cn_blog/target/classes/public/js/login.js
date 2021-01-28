$(function () {
    //绑定表单提交事件：返回false相当于禁止表单默认提交
    $("#login_form").submit(function () {
        //校验表单数据-省略
        //发送ajax请求
        $.ajax({
            url: '../api/user/login',
            type: 'post',//请求方法
            data: $("#login_form").serialize(),//表单数据序列化为k1=v1&k2=v2
            // 前后端接口的数据：
            // 成功 {success: true}
            // 失败：{success: false, code: xxx, message: xxx}
            success: function (r) {//r: 响应体的数据
                //成功：跳转到首页
                if(r.success){
                    //js相对路径是以引入的html文件作为参照点：
                    // login.html跳转index.html的相对路径写法
                    window.location.href = "../index.html";
                }
                // 失败：显示错误信息
                else{
                    $("#error_message").show();
                    $("#error_message").html(r.message);
                }
            },
            error: function (r, t, e) {
                alert(r.status)
            }
        })
        return false;
    });
})