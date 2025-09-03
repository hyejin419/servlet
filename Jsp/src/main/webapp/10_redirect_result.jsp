<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String userid = request.getParameter("userid");
%>
<html>
<head>
    <title>redirect</title>
</head>
<body>
<p>전달받은 userid: <%=userid%></p>
</body>
</html>
