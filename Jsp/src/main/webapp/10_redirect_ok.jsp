<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 25. 6. 5.
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String userid = request.getParameter("userid");
//  request.setAttribute("userid", userid);  //적용안됨!
//  response.sendRedirect("10_redirect_result.jsp");  //새로운 객체를 만들어서 넘긴다.
%>
<html>
<head>
    <title>Title</title>
  <script>
    window.onload = function () {
      document.getElementById("hiddenValue").value = "<%=userid%>"
      document.getElementById("redirectForm").submit();   //post방식
    }

    //location.href="10_redirect_result.jsp?userid="" + "userid"  //get방식
  </script>
</head>
<body>
<form id="redirectForm" method="post" action="10_redirect_result.jsp">
  <input type="hidden" id="hiddenValue" name="userid" value="">
</form>
</body>
</html>
