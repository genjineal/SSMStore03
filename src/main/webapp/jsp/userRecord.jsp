<%--
  Created by IntelliJ IDEA.
  User: 2333
  Date: 2021/11/6
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/uhead.jsp"%>
<%--    订单管理页面--%>
<div class="admin_right">
    <div class="search">
        <form action="${pageContext.request.contextPath}/selectUserRecord" id="myForm">
            <input type="hidden" name="uid" value="${params.uid}">
            <input type="text" name="uname" class="input_text" value="${params.uname}">
            <input id="currentPage" type="hidden" name="pageNum" value="${params.pageNum}"/>
            <input	value="查 询" type="submit" class="searchbutton">
        </form>
    </div>
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">商品编号</th>
            <th width="15%">商品名</th>
            <th width="5%">购买数量</th>
            <th width="10%">接收人</th>
            <th width="10%">接收人电话</th>
            <th width="10%">接收人地址</th>
            <th width="10%">订单状态</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="record" varStatus="status">
            <tr>
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
                            <a href="${pageContext.request.contextPath}/userDeleteRecord?rid=${record.rid}&&uid=${record.uid}">确认收货</a>
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
