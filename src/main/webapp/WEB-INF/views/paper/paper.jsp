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
        <td>计划</td>
        <td>笔记</td>
    </tr>
    <c:forEach items="${list}" var="paper">
        <tr>
            <td><a href="file:///${paperPath}" target=_blank>${paper.paperName}</a></td>
            <td>${paper.noteSummary}</td>
            <td>${paper.publishYear}</td>
            <td>${paper.paperName}</td>
            <td><a href="${pageContext.request.servletContext}/papers/newPlan?doi=${paper.doi}">指定计划</a></td>
            <td><a href="file:///${paper.notePath}" target="_blank">阅读笔记</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
