<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2025/08/19
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới danh mục</h1>
<form action="${pageContext.request.contextPath}/category/add" method="post">
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
    <label for="cateName">Tên danh mục:</label>
    <input type="text" id="cateName" name="cateName" value="${category.cateName}" />

    <label for="description">Mô tả:</label>
    <input type="text" id="description" name="description" value="${category.description}"/>

    <div style="display: flex; justify-content: center; align-items: center; gap: 20px">
        <label>Trạng thái:</label>
        <input type="radio" id="status" name="status" value="true"  <c:if test="${category.status}">checked</c:if> />
        <label for="status">Có</label>
        <input type="radio" id="notStatus" name="status" value="false"  <c:if test="${not category.status}">checked</c:if> />
        <label for="notStatus">Không</label>
    </div>

    <button type="submit">Thêm</button>
    <a href="/category">Quay lại</a>
</form>

</body>
</html>
