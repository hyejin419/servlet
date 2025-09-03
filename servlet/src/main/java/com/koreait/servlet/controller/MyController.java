package com.koreait.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//이름에 관계없이 .korea 로 끝나는 모든 URL 매핑
//http://localhost:8080/servlet_war_exploded/controller/join.korea (get, post)
@WebServlet("*.korea")
public class MyController extends HttpServlet {
    private static final long serialVersionUID = 1L; //직렬화

    public MyController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }


    protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String command = uri.substring(contextPath.length());

        System.out.println(uri); //  /servlet_war_exploded/controller/join.korea 전체경로
        System.out.println(contextPath);  //  /servlet_war_exploded 루트
        System.out.println(command);  //  /controller/join.korea 루트로부터 실제 리소스가 어디인지

        if (command.equals("/controller/join.korea")) {
            System.out.println("do join!!");
        } else if (command.equals("/controller/login.korea")) {
            System.out.println("do login!!");
        } else if (command.equals("/controller/info.korea")) {
            System.out.println("do info!!");
        } else if (command.equals("/controller/modify.korea")) {
            System.out.println("do modify!!");
        }
    }
}