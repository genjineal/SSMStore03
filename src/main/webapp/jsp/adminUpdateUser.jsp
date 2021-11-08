<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/5
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    管理员修改用户界面--%>
    <div class="admin_right">
        <div class="search">

        </div>
<%--        提交表单--%>
        <form action="${pageContext.request.contextPath}/user/updateUser">
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编号</th>
                    <th width="10%">用户账号</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="20%">地址</th>
                    <th width="20%">用户状态(1为正常,0为封禁)</th>
                </tr>

                <tr>
                    <td>
                        <span><input type="text" readonly name="uid" value="${userinfo.uid}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="uname" value="${userinfo.uname}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="sex" value="${userinfo.sex}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="age" value="${userinfo.age}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="uphone" value="${userinfo.uphone}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="address" value="${users.address}"></span>
                    </td>
                    <td>
                        <span><input type="text"  name="status" value="${userinfo.status}"></span>
                    </td>
                </tr>
            </table>
            <input type="submit" value="确认修改" class="confirm_btn">
        </form>
    </div>
</section>
<%@include file="common/foot.jsp"%>
