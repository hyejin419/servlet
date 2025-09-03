<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
<h2>el</h2>
<p>el 태그는 jsp의 표현식을 대체함</p>

${1+2}<br>
${'안녕하세요, EL'}
${1 >= 2}<br>
${1<2 || 1>2}<br>
${1<2 && 1>2}<br>
${1==1 ? '같다':'다르다'}<br>
${'김사과' == '김사과'}<br>
${'김사과' eq '김사과'}<br>
${5 gt 3}<br>
${3 lt 4}<br>


</body>
</html>
