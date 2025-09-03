<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 4.
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> list = Arrays.asList("apple", "banana", "orange", "melon");
%>
<h2>select 태그에 list의 값을 반복문으로 생성</h2>
<select>
<% for (int i=0; i<list.size(); i++) { %>
    <option value="<%=list.get(i)%>"><%=list.get(i)%></option>
<% } %>
</select>
</body>
</html>
