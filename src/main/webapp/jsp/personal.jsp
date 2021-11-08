<%--
  Created by IntelliJ IDEA.
  User: 2333
  Date: 2021/11/3
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/uhead.jsp"%>
    <%--    修改用户信息--%>
<div class="admin_right">
    <div class="search">
    </div>
    <form action="${pageContext.request.contextPath}/user/userUpdateSelf">
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编号</th>
                <th width="20%">用户账号</th>
                <th width="10%">用户密码</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">地址</th>
            </tr>
                <tr>
                    <td>
                        <span><input type="text" name="uid" readonly value="${user2.uid}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="uname" readonly value="${user2.uname}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="password" value="${user2.password}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="sex" readonly value="${user2.sex}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="age"  value="${user2.age}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="uphone" value="${user2.uphone}"></span>
                    </td>
                    <td>
                        <span><input type="text" name="address" value="${user2.address}"></span>
                    </td>
                </tr>
        </table>
        <input type="submit" value="确认修改" class="confirm_btn">
    </form>