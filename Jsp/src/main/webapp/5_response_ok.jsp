<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 4.
  Time: 오후 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String name = request.getParameter("name");
  String age = request.getParameter("age");

  int a = Integer.parseInt(age);


  if(a > 19) {
    //주류 구매 페이지로 이동
    response.sendRedirect("5_response_success.jsp");
  }else{
    response.sendRedirect("5_response_fail.jsp");
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
