<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/6
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    管理员修改商品界面--%>
<div class="admin_right">
    <div class="search">

    </div>
    <%--        提交表单--%>
    <form action="${pageContext.request.contextPath}/pro/updatePro">
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">商品编号</th>
                <th width="10%">商品名</th>
                <th width="30%">商品详情</th>
                <th width="10%">图片</th>
                <th width="10%">价格</th>
                <th width="10%">库存</th>
                <th width="10%">上架状态</th>
            </tr>

            <tr>
                <td>
                    <span><input type="text" readonly name="pid" value="${product.pid}"></span>
                </td>
                <td>
                    <span><input type="text" readonly name="pname" value="${product.pname}"></span>
                </td>
                <td>
                    <span><input type="text"  name="detial" value="${product.detial}"/></span>
                </td>
                <td>
                    <span><img style="height: 40px;" src="${pageContext.request.contextPath}/${product.url}" alt="${product.pname}"></span>
                </td>
                <td>
                    <span><input type="text"  name="price" value="${product.price}"></span>
                </td>
                <td>
                    <span><input type="text"  name="stock" value="${product.stock}"></span>
                </td>
                <td>
                    <span><input type="text"  name="status" value="${product.status}"></span>
                </td>
            </tr>
        </table>
        <input type="submit" value="确认修改" class="confirm_btn">
    </form>
</div>
</section>
<%@include file="common/foot.jsp"%>
