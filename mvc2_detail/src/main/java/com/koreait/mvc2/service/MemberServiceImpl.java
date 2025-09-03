package com.koreait.mvc2.service;

import com.koreait.mvc2.dao.MemberDAO;
import com.koreait.mvc2.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberServiceImpl implements MemberService {

    private MemberDAO dao = new MemberDAO();


    //회원가입 폼 → DB 저장 → 결과 표시
    @Override
    public void join(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        MemberDTO dto = new MemberDTO();  //회원 정보를 저장하는 빈 객체 생성
        dto.setUserid(req.getParameter("userid"));
        dto.setUserpw(req.getParameter("userpw"));
        dto.setName(req.getParameter("name"));
        dto.setHp(req.getParameter("hp"));
        dto.setEmail(req.getParameter("email"));
        dto.setGender(req.getParameter("gender"));
        dto.setSsn1(req.getParameter("ssn1"));
        dto.setSsn2(req.getParameter("ssn2"));
        dto.setZipcode(req.getParameter("zipcode"));
        dto.setAddress1(req.getParameter("address1"));
        dto.setAddress2(req.getParameter("address2"));
        dto.setAddress3(req.getParameter("address3"));
        //req.getParameter("파라미터명"): HTML 폼에서 사용자가 입력한 값을 가져온다. > 각 입력값을 dto 객체에 저장

        boolean success = dao.insertMember(dto); //dto에 담긴 정보를 DAO를 통해 DB에 저장. 그 결과를 success라는 boolean변수에 저장.
        req.setAttribute("success", success);  //success라는 이름으로 success값을 저장. jsp로 넘어갈 떄 사용할 수 있도록 요청객체(req)에 데이터를 담는다.
        req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);  //요청을 jsp파일로 포워딩(전달).

    }


    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String userpw = req.getParameter("userpw");  //로그인 폼에서 입력한 userid와 userpw 값을 꺼낸다.

        MemberDTO dto = dao.login(userid, userpw);
        //DAO에서 로그인 정보를 확인함 (아이디, 비밀번호 일치 확인)
        //일치하면 MemberDTO 객체가 반환, 실패하면 null 반환
        if (dto != null){
            req.getSession().setAttribute("user", dto);  //로그인한 유저 정보를 세션에 저장 (다른 페이지에서도 유지 가능)
            req.setAttribute("loginUser", dto);  //현재 JSP에서 사용할 수 있도록 요청 속성에 저장
        }
        req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
    }

    @Override
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("login.member");
    }

    @Override
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");
        //세션에 저장된 user속성을 꺼낸다. MemberDTO로 형변환하여 사용. 즉, 현재 로그인 중인 사용자 정보 전체를 sessionDto에 담는다.
        MemberDTO dto = new MemberDTO();  //수정할 회원정보를 담을 새로운 객체를 만든다.
        dto.setUserid(sessionDto.getUserid());
        dto.setName(req.getParameter("name"));
        dto.setUserpw(req.getParameter("userpw"));
        dto.setHp(req.getParameter("hp"));
        dto.setEmail(req.getParameter("email"));
        dto.setGender(req.getParameter("gender"));
        dto.setZipcode(req.getParameter("zipcode"));
        dto.setAddress1(req.getParameter("address1"));
        dto.setAddress2(req.getParameter("address2"));
        dto.setAddress3(req.getParameter("address3"));
        boolean isModify = dao.updateMember(dto);
        if (isModify){
            req.getSession().setAttribute("isModify", isModify);  //정보수정 한 다음 세션에 반영. true이면 다시 세팅 (안하면 DB는 바뀌지만 화면이 바뀌지 않음)
            req.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(req, resp);
            //req.getSession().setAttribute("isModify", isModify);: isModify 값을 세션에 저장.이후 JSP나 다른 요청에서 사용 가능.
            //req.getRequestDispatcher(...).forward(req, resp);: 클라이언트에게 리다이렉션하지 않고 서버 내에서 해당 JSP로 요청을 전달.
            //isModify가 true일 경우에만 JSP로 포워딩됩니다.

        }

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");  //로그인된 ~ 세션에 담기
        if (sessionDto != null){
            dao.deleteMember(sessionDto.getUserid());
            req.getSession().invalidate();
        }
        resp.sendRedirect("login.member");

    }
}