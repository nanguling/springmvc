
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                //alert("btn click")
                $.ajax({
                    //url:"returnVoidAjax.do",
                    //url:"returnStudentAjax.do",
                    //url:"returnStudentAjaxArray.do",
                    url:"returnStringData.do",
                    data:{
                        name:"薇姐",
                        age:14
                    },
                    type:"post",
                    //dataType:"json",
                    dataType:"text",
                    success:function (resp) {
                        //resp从服务器端返回的是json格式的字符串 {"name":"薇姐","age":14}
                        //jquery会把json字符串转为json对象，赋值给resp
                        //alert(resp.name+"  "+resp.age)
                        //alert(resp[0].name+"  "+resp[0].age+" , "+resp[1].name+"  "+resp[1].age);
                        /*$.each(resp,function (i,n) {
                            alert(n.name+" "+n.age)
                        })*/
                        alert("返回的是文本数据:"+resp)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnStringView.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form>

    <p>处理器方法返回String表示视图完整路径</p>
    <form action="returnStringView2.do" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交参数">
    </form><br><br>
    <button id="btn">发起ajax请求</button>
</body>
</html>
