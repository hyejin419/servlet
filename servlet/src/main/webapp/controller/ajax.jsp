<%--
  Created by IntelliJ IDEA.
  User: gpwls
  Date: 2025-06-09
  Time: 오후 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script>
        function ajaxRegist(){
            const userid = document.querySelector("input[name='userid']").value
            const password = document.querySelector("input[name='password']").value
            const age = document.querySelector("input[name='age']").value
            const gender = document.querySelector("input[name='gender']:checked")?.value

            fetch("regist.ajax", {
                method: "POST",
                headers: {
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                body: "userid=" + userid + "&password=" + password + "&age=" + age + "&gender=" + gender
            }).then(function(response){
                return response.json()
            }).then(function(data){
                console.log((data))
            }).catch(function(err){
                console.log(err);
            })

        }
        function ajaxLogin(){
            const userid = document.querySelector("input[name='userid']").value
            const password = document.querySelector("input[name='password']").value

            fetch("login.ajax", {
                method: "POST",
                headers: {
                    'Content-Type':'application/x-www-form-urlencoded'
                },
                body: "userid=" + userid + "&password=" + password
            }).then(function(response){
                return response.json()
            }).then(function(data){
                console.log((data))
            }).catch(function(err){
                console.log(err);
            })

        }
    </script>
</head>
<body>
<p>아이디: <input type="text" name="userid"></p>
<p>비밀번호: <input type="password" name="password"></p>
<p>나이: <input type="text" name="age"></p>
<p>성별: 남:<input type="radio" name="gender" value="남자"> 여:<input type="radio" name="gender" value="여자"></p>
<p><button type="button" onclick="ajaxRegist()">AJAX 회원가입</button></p>
<p><button type="button" onclick="ajaxLogin()">AJAX 로그인</button></p>
</body>
</html>





