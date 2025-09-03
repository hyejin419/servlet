<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
<p>${userid}(request)</p>
<p>${name}(session)</p>
<p>${age}(application)</p>
<p>${requestScope.userid}</p>
<p>${sessionScope.name}</p>
<p>${applicationScope.age}</p>
<hr>
<p>${requestScope.dto}</p>
<p>${requestScope.dto.idx}</p>
<p>${requestScope.dto.userid}</p>
<p>${requestScope.dto.name}</p>
</body>
</html>
