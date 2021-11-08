<%--
  Created by IntelliJ IDEA.
  User: 2333
  Date: 2021/11/2
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <%--    本地css--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/statics/localcss/userReg.css">
    <%--    Bootstrap--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/statics/css/bootstrap.min.css">
</head>
<body id="loginBody">
    <div class="reg">
        <div class="reg_form">
            <span class="logo">用户注册</span>
            <form action="${pageContext.request.contextPath}/user/reg">
                <span>账号:</span><input type="text" required name="uname">
                <span class="error">${error}</span><br>
                <span>密码:</span><input type="text" required name="password"><br>
                <span>电话:</span><input type="text" name="uphone"><br>
                <span>地址:</span><input type="text" name="address"><br>
                <span>性别:</span><input type="text" required name="sex"><br>
                <span>年龄:</span><input type="text" name="age"><br>
                <input type="submit" value="注册" class="reg_btn">
                <a class="goLogin" href="${pageContext.request.contextPath}/jsp/userLogin.jsp">已有账号，点我登录</a>
            </form>
        </div>
    </div>

</body>
</html>
