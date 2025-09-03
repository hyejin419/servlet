package com.koreait.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    //서블릿이 최초 로딩될 때 단 1회만 실행되는 초기화 메서드
    public void init() {
        message = "Hello World!";
    }

    //클라이언트의 GET 요청을 처리
    //HttpServletRequest: 클라이언트 요청 정보를 담은 객체 (node.js의 request 객체)
    //HttpServletResponse: 서버에서 클라이언트로 전달될 응답 정보를 담은 객체 (node.js의 response 객체)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
        response.setContentType("text/html; charset=UTF-8");  //html 안의 한글
        response.setCharacterEncoding("UTF-8");  //콘솔이나 실제 클래스 안에서 쓰이는 한글

        // try-with-resources 문법으로 안전하게 사용
        // <!DOCTYPE html>: HTML5 명시
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
        }
    }
    //서블릿이 톰캣 종료 또는 언로드 시 호출
    //리소스 해제, 커넥션 풀 반환
    public void destroy() {
    }
}