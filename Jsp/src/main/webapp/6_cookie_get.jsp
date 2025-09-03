<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 4.
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if (cookieName.equals("userid")) {
                String cookieValue = cookie.getValue();
                out.print("userid 쿠키의 값: " + cookieValue);
            } else {
                out.print("쿠키가 존재하지 않습니다.");
            }
        }
    }
%>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<h2>쿠키 가져오기</h2>
</body>
</html>
