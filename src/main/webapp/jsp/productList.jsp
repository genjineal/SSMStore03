<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/1
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城</title>
    <%--    本地css--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/statics/localcss/productList.css">
    <%--    Bootstrap--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/statics/css/bootstrap.min.css">

</head>
<body id="myBody">
    <div class="page">
<%--        导航--%>
        <div class="nav_top">
            <div class="nav">
                <div class="col-lg-3">logo</div>
                <div class="search col-lg-6">
                    <%--                条件查询--%>
                    <form action="${pageContext.request.contextPath}/pro/list" id="myForm">
                        <input class="rearchInput" type="text" name="detial" placeholder="请输入想找的商品..." value="${params.detial}">
                        <input id="currentPage" type="hidden" name="pageNum" value="${params.pageNum}">
                        <input type="submit" value="搜索" class="search_btn">
                    </form>
                </div>
            </div>
        </div>

<%--    中间内容--%>
        <div class="mainbox">
            <div class="container">
<%--                    侧边导航--%>
                    <div class="col-lg-2" id="nav_left">
                        <h3>商品服务分类</h3>
                        <form action="${pageContext.request.contextPath}/pro/list">
                            <ul>
                                <c:forEach items="${categoryList}" var="cate">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pro/list?typeId=${cate.typeId}">${cate.typeName}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </form>
                    </div>
<%--                轮播--%>
                    <div class="col-lg-6 lunbo">
                        <ul>
                            <li><img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/1.jpg" alt=""></li>
                            <li><img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/2.jpg" alt=""></li>
                            <li><img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/3.jpg" alt=""></li>
                            <li><img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/4.jpg" alt=""></li>
                            <li><img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/5.jpg" alt=""></li>
                        </ul>
                        <div>
                            <span></span>
                            <p>
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                                <span></span>
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-2 advance">
                        <h3>广</h3>
                        <h3>告</h3>
                        <h3>位</h3>
                        <h3>招</h3>
                        <h3>租</h3>
                    </div>
                    <div class="col-lg-2 userInfo">
                        <p>您好,${user.uname}&nbsp;欢迎购物~</p>
                        <p>
<%--                            跳转到用户个人中心页面--%>
                            <a href="${pageContext.request.contextPath}/user/updateSelect?uid=${user.uid}">个人中心</a>&nbsp;&nbsp;
<%--                        退出登录，回到登录页面--%>
                            <a href="backlogin">退出登录</a>
                        </p>
                    </div>

            </div>
        </div>
        <div class="brand">
            <img src="${pageContext.request.contextPath}/jsp/statics/images/lunbo/guanggao1.jpg" alt="">
        </div>
<%--        所有商品页--%>
        <div class="product_main">
            <div class="container">
                <div class="row">
                    <c:forEach items="${pageInfo.list}" var="pro" varStatus="status">
                        <div class="col-lg-2 product_box">
<%--                            跳转到商品的详情页 传递商品id--%>
                            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/pro/choicePro?pid=${pro.pid}">
                                <img style="height: 160px;width: 100%;" src="${pageContext.request.contextPath}/${pro.url}" alt="${pro.pname}">
                                <p>${pro.detial}</p>
                                <span style="color: red;">￥${pro.price}</span>
                                <button>立即购买</button>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
<%--            分页--%>
            <div class="fenye">
                <a href="${pageContext.request.contextPath}/pro/list?typeId=${params.typeId}&&detial=${params.detial}&&pageNum=1">首页</a>
                <a href="${pageContext.request.contextPath}/pro/list?typeId=${params.typeId}&&detial=${params.detial}&&pageNum=${pageInfo.pageNum-1}">上一页</a>
                <a href="${pageContext.request.contextPath}/pro/list?typeId=${params.typeId}&&detial=${params.detial}&&pageNum=${pageInfo.pageNum+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/pro/list?typeId=${params.typeId}&&detial=${params.detial}&&pageNum=${pageInfo.pages}">尾页</a>
                <br><span>第${pageInfo.pageNum}页/共${pageInfo.pages}页</span>
            </div>

<%--            <div class="fenye">--%>
<%--                <a href="javascript:toPage(1)">首页</a>--%>
<%--                <a href="javascript:toPage(${pageInfo.pageNum-1})">上一页</a>--%>
<%--                <a href="javascript:toPage(${pageInfo.pageNum+1})">下一页</a>--%>
<%--                <a href="javascript:toPage(${pageInfo.pages})">尾页</a>--%>
<%--                <br><span>第${pageInfo.pageNum}页/共${pageInfo.pages}页</span>--%>
<%--            </div>--%>

        </div>

<%--        尾部--%>
        <div class="footer" style="height: 400px">

        </div>
    </div>

</body>
    <script type="text/javascript">
        function toPage(pageNum) {
            let currentPage = document.getElementById("currentPage");
            currentPage.value = pageNum;
            /*let currentCate = document.getElementById("currentCate");
            currentCate.value = typeId;*/
            //表单提交
            let myForm = document.getElementById("myForm");
            myForm.submit();
        }
    </script>
<script src="${pageContext.request.contextPath}/jsp/statics/js/jquery-1.8.3.min.js"></script>
<script src="${pageContext.request.contextPath}/jsp/statics/localjs/productList.js"></script>
</html>
