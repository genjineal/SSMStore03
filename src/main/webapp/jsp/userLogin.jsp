<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/1
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
    <%--    本地css--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/statics/localcss/userLogin.css">
<%--    Bootstrap--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/statics/css/bootstrap.min.css">
</head>
<body id="loginBody">
    <div class="login">
        <span class="logo">用户登录</span> <br>
        <div class="login_form">
            <form action="${pageContext.request.contextPath}/user/coderight">
                <span>用户名：</span>&nbsp;<input type="text" name="uname" required> <br>
                <span>密码：</span> <input type="password" name="password" required> <br>
                <%--    页面显示验证码图片：servlet请求放到图片src中--%>
                验证码：<input type="text" name="inputcode" required>
                <img id="img01" src="${pageContext.request.contextPath}/user/vccode" alt="验证码图片">
                <br> <br><a href="${pageContext.request.contextPath}/jsp/regUser.jsp">还没账号？点击注册</a>
                <a href="javascript:change();" style="margin-left: 20px;margin-bottom: 20px">看不清换一张</a> <br>
                <span style="color: red;width: 140px;margin-left: 5px;">${error}</span><br>
                <input type="submit" value="登录" class="login_btn"> <br>
            </form>
        </div>
    </div>

</body>
    <script type="application/javascript">
        function change(){
            //获取图片位置(对象)
            var img = document.getElementById("img01");
            img.src = "${pageContext.request.contextPath}/user/vccode?"+new Date().getTime();
        }
    </script>
</html>
