
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <p>SSM整合栗子</p>
        <img src="image/weijie.jpg" style="height: 100px;width: 100px">
        <table>
            <tr>
                <td><a href="addStudent.jsp">学生注册</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">学生查询</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
