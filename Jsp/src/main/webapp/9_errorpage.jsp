<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="9_errorpage_error.jsp" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
<h2>errorpage</h2>
<p>의도치 않게 에러가 발생했습니다.</p>
<%
    String abc = (String)session.getAttribute("ABC");
    abc.charAt(3); //에러발생!

%>
</body>
</html>
