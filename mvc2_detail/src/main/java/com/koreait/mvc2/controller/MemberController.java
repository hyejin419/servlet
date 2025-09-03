package com.koreait.mvc2.controller;

import com.koreait.mvc2.service.MemberService;
import com.koreait.mvc2.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.member") //이 클래스가 서블릿이고, "/member" URL로 요청이 들어오면 실행하라
public class MemberController extends HttpServlet {
    //MemberController: 서블릿 클래스의 이름
    //HttpServlet을 상속받았기 때문에 웹 요청을 처리할 수 있다.
    //이 클래스 안에는 doGet(), doPost() 같은 메서드를 만들어 GET/POST 요청을 처리한다.
    private static final long serialVersionUID = 1L;
    private MemberService service = new MemberServiceImpl();
    //즉, 회원 관련 로직(예: 로그인, 회원가입)을 처리하는 객체를 만들어 둔 것.

    public MemberController() {}


    //HTTP GET 요청 처리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }
    //클라이언트가 GET 요청을 보내면 이 메서드가 실행된다. → 내부에서 doAction() 메서드를 호출하여 공통 처리한다.


    //HTTP POST 요청 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }
    //POST 요청일 경우 실행되는 메서드 → 이 역시 doAction()을 호출해 GET/POST 구분 없이 처리



    //공통 로직 처리 (핵심)
    protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    //GET, POST를 공통으로 처리하는 메서드 → URI에 따라 분기처리.
    {
        req.setCharacterEncoding("UTF-8");
        String uri = req.getRequestURI();  //전체 요청 경로
        String context = req.getContextPath();  //애플리케이션 이름
        String command = uri.substring(context.length());  //순수 요청 경로만 추출. 이 command 값을 기준으로 어떤 작업을 할지 switch로 분기한다.

        switch (command) {
            case "/join.member":
                req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp); //join.jsp 페이지로 요청 전달.
                break;
            case "/joinForm.member":  // 회원가입 폼을 제출했을 때 서버에서 처리하는 로직
                service.join(req, resp);   //service.join(...) 메서드를 호출해서 실제 DB에 회원 정보를 저장하는 로직을 실행
                break;
                //사용자가 회원가입 폼을 작성하고 submit 버튼을 눌렀을 때 요청되는 주소.(form 태그에서 action="/joinForm.member"로 지정되어 있을 경우)
            case "/login.member":
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
                break;
            case "/loginForm.member":
                service.login(req, resp);
                break;
            case "/logout.member":
                service.logout(req, resp);
                break;
            case "/mypage.member":
                req.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(req, resp);
                break;
            case "/modifyForm.member":
                if(req.getMethod().equals("GET")) {
                    req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
                    //화면 전환만 하기 때문에 단순히 JSP로 포워딩(forward)한다. (회원정보 수정화면 보여주기)
                } else if (req.getMethod().equalsIgnoreCase("POST")) {
                    service.modify(req, resp);
                    //사용자가 modify.jsp에서 폼을 작성하고 제출하면 보통 POST 방식으로 서버에 데이터가 전송된다. (수정된 회원정보 서버에 반영)
                    //이 때는 실제로 회원 정보를 수정하는 비즈니스 로직이 실행되어야 하기 때문에, service.modify(req, resp)를 호출하여 처리하게 된다.
                }
                break;
            case "/delete.member":
                service.delete(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}