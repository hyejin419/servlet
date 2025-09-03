<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오후 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>member list</title>
</head>
<body>
<table border="1">
  <tr>
    <th>IDX</th>
    <th>id</th>
    <th>name</th>
    <th>phone</th>
    <th>email</th>
    <th>gender</th>
  </tr>
<c:forEach var="member" items="${memberList}">
  <tr>
    <td>${member.idx}</td>
    <td>${member.userid}</td>
    <td>${member.name}</td>
    <td>${member.hp}</td>
    <td>${member.email}</td>
    <td>${member.gender}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>
