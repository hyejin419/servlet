<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-10
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.model.MemberDTO" %>
<%
  request.setAttribute("userid", "apple"); <%--request: 현재 요청 동안 유지--%>
  session.setAttribute("name", "김사과");  <%--session: 브라우저가 닫히거나 세션이 만료될 때까지 유지--%>
  application.setAttribute("age", 20);  <%--applictiaon: 서버 전체에서 공유되는 범위--%>

    MemberDTO dto = new MemberDTO(1, "apple", "1111", "김사과", "010-1111-1111", "apple@apple.com", "여자", "001011", "4068518", "06774", "서울 서초구 강남대로 27", "AT센터", "(양재동)", "2025-06-10", 1000);
    request.setAttribute("dto", dto);

  request.getRequestDispatcher("3_object_ok.jsp").forward(request,response);
%>
<%--포워딩(forwarding): 서버 내부에서, 클라이언트(사용자) 모르게 다른 JSP나 서블릿으로 요청을 넘겨주는 것--%>
<html>
<head>
    <title>el</title>
</head>
<body>

</body>
</html>
