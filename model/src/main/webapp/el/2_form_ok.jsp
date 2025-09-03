<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
    <title>el</title>
</head>
<body>
<h2>파라미터 값을 설정할 때 param 객체를 사용</h2>
<p>${param.userid}</p>
<p>${param.userpw}</p>
</body>
</html>
