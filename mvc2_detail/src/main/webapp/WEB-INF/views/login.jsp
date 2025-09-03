<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-11
  Time: 오전 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>login</h2>
<form method="post" action="loginForm.member">
  <input type="hidden" name="action" value="login">
  <p>id: <input type="text" name="userid"></p>
  <p>password: <input type="password" name="userpw"></p>
  <p><button type="submit">login</button></p>
</form>
</body>
</html>
