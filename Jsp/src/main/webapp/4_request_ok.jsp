<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 4.
  Time: 오전 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Arrays"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid=request.getParameter("userid");
    String userpw=request.getParameter("userpw");
    String[] hobby=request.getParameterValues("hobby"); //여러개이므로 배열로 받아야 함
%>
<html>
<head>
    <title>request</title>
</head>
<body>
    <p>아이디: <%=userid%></p>
    <p>비밀번호: <%=userpw%></p>
    <p>취미: <%=Arrays.toString(hobby)%></p>
</body>
</html>
