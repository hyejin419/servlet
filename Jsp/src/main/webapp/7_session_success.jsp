<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("userid") == null) {
        response.sendRedirect("7_session.jsp");
    }
    String userid = (String)session.getAttribute("userid");
%>
<html>
<head>
    <title>session</title>
</head>
<body>
<h2>환영합니다:)</h2>
<p><%=userid%>님 로그인되었습니다.</p>
<p>[<a href = "7_session_logout.jsp">로그아웃</a>]</p>
</body>
</html>
