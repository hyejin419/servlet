<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>format</title>
</head>
<body>
<h2>문자를 날짜로 형 변환</h2>
<fmt:parseDate var="a" value="2025/06/10" pattern="yyyy/mm/dd"/>
<p>${a}</p>

<h2>날짜형을 문자로 형 변환</h2>
<c:set var="now" value="<%=new Date()%>"/>
<p><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></p>
<p><fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/></p>

<h2>문자를 숫자로 형 변환</h2>
<fmt:parseNumber value="$3.14" pattern="$0.00"/>
<fmt:parseNumber value="1.123abc" type="number"/>

<h2>숫자를 문자로 형 변환</h2>
<fmt:formatNumber value="2000" pattern="0000.00"/>
</body>
</html>
