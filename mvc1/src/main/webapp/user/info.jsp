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
<head>
    <title>회원정보 수정</title>
</head>
<body>
<h2>회원정보 수정</h2>
<form method="post" action="result.jsp">
    <input type="hidden" name="action" value="update">

    <p>아이디: <input type="text" name="userid" value="<%= user.getUserid() %>"></p>
    <p>비밀번호: <input type="password" name="userpw" value="<%= user.getUserpw() %>"></p>
    <p>이름: <input type="text" name="name" value="<%= user.getName() %>"></p>
    <p>휴대폰: <input type="text" name="hp" value="<%= user.getHp() %>"></p>
    <p>이메일: <input type="email" name="email" value="<%= user.getEmail() %>"></p>
    <p>성별:
        <select name="gender">
            <option value="남자" <%= "남자".equals(user.getGender()) ? "selected" : "" %>>남자</option>
            <option value="여자" <%= "여자".equals(user.getGender()) ? "selected" : "" %>>여자</option>
        </select>
    </p>
    <p>주민등록번호:
        <input type="text" name="ssn1" value="<%= user.getSsn1() %>"> -
        <input type="password" name="ssn2" value="<%= user.getSsn2() %>">
    </p>
    <p>우편번호: <input type="text" name="zipcode" value="<%= user.getZipcode() %>"></p>
    <p>주소: <input type="text" name="address1" value="<%= user.getAddress1() %>"></p>
    <p>상세주소: <input type="text" name="address2" value="<%= user.getAddress2() %>"></p>
    <p>참고항목: <input type="text" name="address3" value="<%= user.getAddress3() %>"></p>

    <p><button type="submit">수정 완료</button></p>
</form>
</body>
</html>

