<%--
  Created by IntelliJ IDEA.
  User: 64897
  Date: 2021/11/6
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="common/head.jsp"%>
<%--    管理员添加商品界面--%>
<div class="admin_right">
    <div class="search">
        <h3 style="color: red;">*填写商品信息前，请先上传图片!</h3>
    </div>
    <%--        提交表单--%>
    <form action="${pageContext.request.contextPath}/pro/insertPro" >
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">商品名</th>
                <th width="30%">商品详情</th>
                <th width="10%">图片</th>
                <th width="10%">价格</th>
                <th width="10%">库存</th>
                <th width="10%">商品类型</th>
                <th width="10%">上架状态</th>
            </tr>

            <tr>
                <td>
                    <span><input type="text" name="pname" value=""></span>
                </td>
                <td>
                    <span><input type="text" name="detial" value=""/></span>
                </td>
                <td>
                    <span><input id="url" type="text" required readonly name="url" value="${url}"></span>
                </td>
                <td>
                    <span><input type="text"  name="price" value=""></span>
                </td>
                <td>
                    <span><input type="text"  name="stock" value=""></span>
                </td>
                <td>
                    <span>
                        <select name="typeid">
                            <option value="">请选择</option>
                            <c:forEach items="${categoryList}" var="cate">
                                <option  value="${cate.typeId}" selected>${cate.typeName}</option>
                            </c:forEach>
                        </select>
                    </span>
                </td>
                <td>
                    <span><input type="text"  name="status" value=""></span>
                </td>
            </tr>
        </table>
        <input type="submit" value="添加" class="confirm_btn">
    </form>
    <div>
<%--        上传图片后 不让显示--%>
        <form id="fileForm" action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file" required>
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</section>
<%@include file="common/foot.jsp"%>
<script type="text/javascript">
    window.onload = function () {
        let url = document.getElementById("url");
        if (url.value !=null){
            url.style.display = "hidden";
        }
    }

</script>
