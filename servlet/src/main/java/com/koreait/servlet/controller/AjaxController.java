package com.koreait.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AjaxController() {}

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

        System.out.println(req.getParameter("userid"));
        System.out.println(req.getParameter("password"));

        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");

        if(command.equals("/controller/regist.ajax")) {
            resp.setContentType("application/json; charset=UTF8;");
            resp.getWriter().write("{\"userid\":\"" + userid +"\", \"msg\":\"가입되었습니다.\"}");
        }else if(command.equals("/controller/login.ajax")) {
            resp.setContentType("application/json; charset=UTF8;");
            resp.getWriter().write("{\"userid\":\"" + userid +"\", \"msg\":\"로그인되었습니다.\"}");
        }
    }
}