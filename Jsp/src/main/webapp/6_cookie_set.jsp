<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 4.
  Time: 오후 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //쿠키는 서버에서 생성, 클라이언트로 전달
  Cookie cookie1 = new Cookie("userid", "apple");
  Cookie cookie2 = new Cookie("username", "김사과");
  cookie1.setMaxAge(1800); //1800초
  cookie2.setMaxAge(30);   //30초

  response.addCookie(cookie1);
  response.addCookie(cookie2);
%>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<h2>쿠키 설정</h2>
<p><a href="6_cookie_get.jsp">쿠키 가져오기</a></p>
</body>
</html>
