<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/2
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product.pname}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/statics/localcss/productDetial.css">
</head>
<body>
    <div class="detial_page">
<%--        详情头部--%>
        <div class="det_top">
            <div>
                <h3>>${product.pname}</h3>
            </div>
        </div>
<%--        详情内容部分--%>
        <div class="det_main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 pro_box_left">
                        <img src="${pageContext.request.contextPath}/${product.url}" alt="${product.pname}">
                    </div>
                    <div class="col-lg-7 pro_box_right">
<%--                        提交表单 添加数据到订单表--%>
                        <form action="${pageContext.request.contextPath}/insertRecord">
                            <div>
                                <h4>${product.detial}</h4>
                                <input type="hidden" name="uid" value="${user.uid}">
                                <input type="hidden" name="pid" value="${product.pid}">
                                <input type="hidden" name="pname" value="${product.pname}">
                                <p>价格<span><i>￥</i> ${product.price}</span></p>
                                <p>配送至 <span>
                                <input type="text" name="address" required value="${user.address}"></span>
                                    <span id="count" style="font-size: 16px;"></span>
                                </p>
                                <p>收件人<span><input type="text" required name="uname" value="${user.uname}"></span></p>
                                <p>收件人电话<span><input type="text" required name="uphone" value="${user.uphone}"></span></p>
                                <hr style="border: 0.5px dotted #999999; margin-top: 10px;">
                                <%--                            订单的数量--%>
                                <div class="amount">
                                    <input type="text" required id="proAmount" name="amount" value="1" oninput="if (value>${product.stock})value=${product.stock}">
                                    <a href="javascript:addAmount();">+</a>
                                    <a id="minus" href="javascript:minusAmount()">-</a>
                                </div>
                                <input type="submit" value="提交订单" id="buy_btn" >
                            </div>
                        </form>
                        <div  class="backstore">
                            <a href="${pageContext.request.contextPath}/backstore"><返回商城</a>
                        </div>
                    </div
                </div>
            </div>
        </div>


    </div>
</body>
    <script src="${pageContext.request.contextPath}/jsp/statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            let stock = ${product.stock};//库存信息
            let count = document.getElementById("count");//获取显示信息的span的id
            let buy_btn = document.getElementById("buy_btn");
            if (stock == 0){
                count.style.color = "red";
                count.innerText = "您要的宝贝已卖光~";
                //库存为0时 不让点击
                buy_btn.className +="disabled";
            }else if (stock <=10){
                count.style.color = "#000000";
                count.innerText = "库存紧张";
            }else{
                count.style.color = "#999999";
                count.innerText = "库存充足";
            }
        }
        function addAmount() {
            let amount = document.getElementById("proAmount");

            if (amount.value >= ${product.stock}){
                amount.value  = ${product.stock};
            }else if(amount.value==''){
                amount.value = 1;
            }else {
                amount.value = parseInt(amount.value)+1;
            }
        }
        function minusAmount() {
            let minus = document.getElementById("minus");
            let amount = document.getElementById("proAmount");
            if (amount.value==1 || amount.value=='' || amount.value<=0){
                amount.value = 1;
            }else{
                amount.value -= 1;
            }
        }
    </script>
</html>
