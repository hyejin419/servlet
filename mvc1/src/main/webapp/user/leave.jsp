<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.mvc1.data.MemberDTO" %>
<%
    MemberDTO user = (MemberDTO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head><title>회원 탈퇴</title></head>
<body>
<h2>정말 탈퇴하시겠습니까?</h2>
<form method="post" action="result.jsp">
    <input type="hidden" name="action" value="leave">
    <input type="hidden" name="userid" value="<%= user.getUserid() %>">
    비밀번호 확인: <input type="password" name="userpw"><br><br>
    <input type="submit" value="탈퇴하기">
</form>
</body>
</html>
