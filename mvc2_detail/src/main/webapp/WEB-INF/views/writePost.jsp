<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    com.koreait.mvc2.dto.MemberDTO user = (com.koreait.mvc2.dto.MemberDTO) session.getAttribute("user");
%>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<p><a href="mypage.member">마이페이지</a>  | <a href="board.post">게시판</a></p>

<%-- writePost.jsp 상단에 추가 --%>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<script>
    alert("<%= error %>");
</script>
<%
    }
%>
<h2>게시글을 작성해보세요</h2>
<form method="POST" action="write.post">
    <p>작성자: ${user.userid}</p>
    <p>제목: <input type="text" name="title" placeholder="제목" ></p>
    <p>내용: <textarea name="content" placeholder="내용을 입력해보세요"></textarea></p>
    <p><button type="submit">작성</button></p>
</form>
</body>
</html>
