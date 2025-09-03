<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int total = 0;

  if(application.getAttribute("total_count") != null) {
    total = (int)application.getAttribute("total_count");
  }

  application.setAttribute("menu", Arrays.asList("홈", "등록", "구매", "마이페이지"));
  application.setAttribute("total_count", ++total);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <p><a href="8_application_home.jsp">다음페이지로</a></p>
  <p>누적된 총계: <%=total%></p>
</body>
</html>
