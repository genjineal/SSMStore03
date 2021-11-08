<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/5
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    管理商品界面--%>
<div class="admin_right">
    <div class="search">
        <form action="${pageContext.request.contextPath}/pro/selectAllProduct" id="myForm">
            <input type="text" name="detial" class="input_text" value="${params.detial}">
            <input id="currentPage" type="hidden" name="pageNum" value="${params.pageNum}"/>
            <input	value="查 询" type="submit" class="searchbutton">
<%--            添加商品--%>
            <a href="${pageContext.request.contextPath}/pro/sendCategory" >添加商品</a>
        </form>
    </div>
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">商品编号</th>
            <th width="10%">商品名</th>
            <th width="10%">商品详情</th>
            <th width="10%">图片</th>
            <th width="10%">价格</th>
            <th width="10%">库存</th>
            <th width="10%">商品类型</th>
            <th width="10%">上架状态</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="pro" varStatus="status">
            <tr>
                <td>
                    <span>${status.count+(pageInfo.pageNum-1)*pageInfo.pageSize}</span>
                </td>
                <td>
                    <span>${pro.pname}</span>
                </td>
                <td style="font-size: 12px;">
                    <span>${pro.detial}</span>
                </td>
                <td>
                    <span> <img style="height: 40px" src="${pageContext.request.contextPath}/${pro.url}" alt="${pro.pname}"></span>
                </td>
                <td>
                    <span>${pro.price}</span>
                </td>
                <td>
                    <span>${pro.stock}</span>
                </td>
                <td>
                    <span>${pro.typeName}</span>
                </td>
                <td>
                    <span>
                        <c:if test="${pro.status==1}">上架中</c:if>
                        <c:if test="${pro.status==0}">已下架</c:if>
                    </span>
                </td>
                <td class="operation">
                    <span>
                        <a href="${pageContext.request.contextPath}/pro/adminSelectPro?pid=${pro.pid}">修改</a>
                    </span>
                    <span>
                            <a href="${pageContext.request.contextPath}/pro/deleteProById?pid=${pro.pid}&&url=${pro.url}" id="deleteUser">删除</a>
                    </span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="fenye">
        <div class="fenyeLeft">
            <p>第${pageInfo.pageNum}页/共${pageInfo.pages}页</p>
        </div>
        <div class="fenyeR">
            <a href="javascript:toPage(1)">首页</a>
            <a href="javascript:toPage(${pageInfo.pageNum-1})">上一页</a>
            <a href="javascript:toPage(${pageInfo.pageNum+1})">下一页</a>
            <a href="javascript:toPage(${pageInfo.pages})">尾页</a>
        </div>
    </div>
</div>
</section>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    function toPage(pageNum) {
        let currentPage = document.getElementById("currentPage");
        currentPage.value = pageNum;
        //表单提交
        let myForm = document.getElementById("myForm");
        myForm.submit();
    }
</script>
