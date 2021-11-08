<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/5
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>商城管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/statics/localcss/pubulic.css">
</head>
<body>
<%--    头部--%>
    <header class="admin_head">
        <h1>商城管理系统</h1>
        <div class="admin_headR">
            <p><span style="color: #fff21b"> ${user.uname}</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath}/pro/backlogin">退出</a>
        </div>
    </header>
<%--    主体内容--%>
    <section class="admin_main">
        <div class="left_nav">
            <h2 class="leftH2">功能列表</h2>
            <nav>
                <ul class="list">
                    <li><a href="${pageContext.request.contextPath }/pro/selectAllProduct">商品管理</a></li>
                    <li ><a href="${pageContext.request.contextPath }/selectAllRecord">订单管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/user/selectAllUser">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/pro/backlogin">退出系统</a></li>
                </ul>
            </nav>
        </div>

