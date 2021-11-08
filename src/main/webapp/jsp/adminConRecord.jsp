<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/5
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    订单管理页面--%>
<div class="admin_right">
    <div class="search">
        <form action="${pageContext.request.contextPath}/selectAllRecord" id="myForm">
            <input type="text" name="uname" placeholder="收件人" class="input_text" value="${params.uname}">
            <input type="text" name="uphone" placeholder="联系电话" class="input_text" value="${params.uphone}">
            <input id="currentPage" type="hidden" name="pageNum" value="${params.pageNum}"/>
            <input	value="查 询" type="submit" class="searchbutton">
        </form>
    </div>
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">用户编号</th>
            <th width="10%">商品编号</th>
            <th width="10%">商品名</th>
            <th width="10%">购买数量</th>
            <th width="10%">接收人</th>
            <th width="10%">接收人电话</th>
            <th width="10%">接收人地址</th>
            <th width="10%">订单状态</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="record" varStatus="status">
            <tr>
                <td>
                    <span>${record.uid}</span>
                </td>
                <td>
                    <span>${record.pid}</span>
                </td>
                <td>
                    <span>${record.pname}</span>
                </td>
                <td>
                    <span>${record.amount}</span>
                </td>
                <td>
                    <span>${record.uname}</span>
                </td>
                <td>
                    <span>${record.uphone}</span>
                </td>
                <td>
                    <span>${record.address}</span>
                </td>
                <td>
                        <span>
                            <c:if test="${record.status==1}">已发货</c:if>
                            <c:if test="${record.status==0}">未发货</c:if>
                        </span>
                </td>
                <td class="operation">
                        <span>
                            <a href="${pageContext.request.contextPath}/sendRecord?rid=${record.rid}">发货</a>
                        </span>&nbsp;&nbsp;&nbsp;
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
