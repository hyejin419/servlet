<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%
    request.setAttribute("userid", "apple");
    request.setAttribute("age", 25);

    List<String> hobby = Arrays.asList("movie", "music", "exercise", "game");
    request.setAttribute("hobby", hobby);
%>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<h2>Hello:) ${userid}!!</h2>
<%--조건문--%>
<c:if test="${age>19}">
    <p>adult</p>
</c:if>
<c:if test="${age<=19}">
    <p>minor</p>
</c:if>

<%-- 반복문 --%>
<h2>hobby</h2>
<ul>
    <c:forEach var="h" items="${hobby}">
        <li>${h}</li>
    </c:forEach>
</ul>
<hr>
<%
    //스크립트릿: 1~10까지 합
    int sum = 0;
    for(int i=1; i<=10; i++) {
        sum +=i;
    }
%>
    <p>1~10까지의 합: <%=sum%></p>

    <c:set var="sum" value="0"/>
    <c:forEach var="i" begin="1" end="10" step="1">
        <c:set var="sum" value="${sum + i}"/>
    </c:forEach>
<p>1~10까지의 합: <c:out value="${sum}"/></p>

<hr>

<h2>GuGuDan</h2>
<c:forEach var="i" begin="2" end="9">
    <h3>📌 ${i}단</h3>
    <ul>
        <c:forEach var="j" begin="1" end="9">
            <li>${i} x ${j} = ${i * j}</li>
        </c:forEach>
    </ul>
</c:forEach>

<hr>

<h2>배열(arrangement)</h2>
<c:set var="arr" value="<%=new int[]{10, 20, 30, 40, 50}%>"/>
<c:forEach var="i" items="${arr}" varStatus="stat">
    <p>${i}</p>
    <p>i's index: ${stat.index}</p>
    <p>i's count: ${stat.count}</p>
</c:forEach>

<hr>

<h2>choose</h2>
<c:choose>
    <c:when test="${param.userid == 'apple'}">
        <p>hello, apple:)</p>
    </c:when>
    <c:when test="${param.userid == 'banana'}">
        <p>hello, banana:)</p>
    </c:when>
    <c:otherwise>
        <p>hello, guest!</p>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${param.age>19}">
    <p>adult</p>
    </c:when>
    <c:otherwise>
        <p>minor</p>
    </c:otherwise>
</c:choose>

</body>
</html>
