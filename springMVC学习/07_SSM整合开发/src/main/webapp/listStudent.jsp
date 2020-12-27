
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>ajax查询学生</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //界面加载完成之后就自动发起ajax请求
            fun()

            $("#btn").click(function () {
                fun()
            })
        })

        function fun() {
            $.ajax({
                url:"listStudent.do",
                type:"get",
                dataType:"json",
                success:function (resp) {
                    //先清除之前的数据
                    $("#info").html("")
                    //再添加数据
                    $.each(resp,function (i,n) {
                        //alert(n.id+" "+n.name+" "+n.age)
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("<tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="info">

        </tbody>
    </table>
    <input type="button" value="查询数据" id="btn">
</div>
</body>
</html>
