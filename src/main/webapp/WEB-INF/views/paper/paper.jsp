<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/27
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>论文展示</title>
</head>
<body>
<table>
    <tr>
        <td>论文题目</td>
        <td>备注</td>
        <td>发表时间</td>
        <td>期刊</td>
        <td>是否已读</td>
        <td>计划</td>
    </tr>
    <c:forEach items="${list}" var="paper">
        <tr>
            <td>${paper.paperName}</td>
            <td>${paper.paperName}</td>
            <td>${paper.paperName}</td>
            <td>${paper.paperName}</td>
            <td>${paper.paperName}</td>
            <td>${paper.paperName}</td>

        </tr>
    </c:forEach>
</table>



</body>
</html>
