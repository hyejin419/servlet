<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> list = (List)application.getAttribute("menu");
    int total = (int)application.getAttribute("total_count");
%>
<html>
<head>
    <title>application</title>
</head>
<body>
<ul>
    <% for(String menu:list) {%>
        <li><%=menu%></li>
    <%}%>
</ul>
<p><%=total%></p>
</body>
</html>
