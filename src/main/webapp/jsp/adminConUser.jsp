<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/5
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    管理用户界面--%>
    <div class="admin_right">
        <div class="search">
            <form action="${pageContext.request.contextPath}/user/selectAllUser" id="myForm">
                <input type="text" name="uname" class="input_text" value="${params.uname}">
                <input id="currentPage" type="hidden" name="pageNum" value="${params.pageNum}"/>
                <input	value="查 询" type="submit" class="searchbutton">
            </form>
        </div>
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编号</th>
                <th width="20%">用户账号</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">地址</th>
                <th width="10%">用户状态</th>
                <th width="20%">操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="users" varStatus="status">
                <tr>
                    <td>
                        <span>${status.count+(pageInfo.pageNum-1)*pageInfo.pageSize}</span>
                    </td>
                    <td>
                        <span>${users.uname}</span>
                    </td>
                    <td>
                        <span>${users.sex}</span>
                    </td>
                    <td>
                        <span>${users.age}</span>
                    </td>
                    <td>
                        <span>${users.uphone}</span>
                    </td>
                    <td>
                        <span>${users.address}</span>
                    </td>
                    <td>
                        <span>
                            <c:if test="${users.status==1}">正常</c:if>
                            <c:if test="${users.status==0}">封禁</c:if>
                        </span>
                    </td>
                    <td class="operation">
                        <span>
                            <a href="${pageContext.request.contextPath}/user/selectUserById?uid=${users.uid}">修改</a>
                        </span>
                        <span>
                            <a href="${pageContext.request.contextPath}/user/deleteUserById?uid=${users.uid}" id="deleteUser">删除</a>
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
