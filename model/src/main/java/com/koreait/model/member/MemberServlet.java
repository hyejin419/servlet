package com.koreait.model.member;

import com.koreait.model.db.DBUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/members")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public MemberServlet() {}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, String>> memberList = new ArrayList<>();
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(("select * from member"));
            ResultSet rs = pstmt.executeQuery()){
            while (rs.next()) {
                Map<String, String> member = new HashMap<>();
                member.put("idx", rs.getString("idx"));
                member.put("userid", rs.getString("userid"));
                member.put("name", rs.getString("name"));
                member.put("hp", rs.getString("hp"));
                member.put("email", rs.getString("email"));
                member.put("gender", rs.getString("gender"));
                memberList.add(member);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        request.setAttribute("memberList", memberList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/1_members.jsp");
        dispatcher.forward(request, response);
    }
}
