package com.koreait.mvc2.dao;

import com.koreait.mvc2.dto.MemberDTO;
import com.koreait.mvc2.util.DBUtil;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public boolean insertMember(MemberDTO member) {
        //insertMember 메서드는 MemberDTO 객체를 매개변수로 받아,그 안의 정보를 데이터베이스에 저장하고, 성공 여부를 boolean 값으로 반환
        String sql = """
            insert into member (userid, userpw, name, hp, email,
            gender, ssn1, ssn2, zipcode, address1, address2, address3)
            values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)     
        """;  //SQL 쿼리문을 String 형태로 작성
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            //pstmt: 위에서 작성한 sql을 실행할 준비 객체
            //→ try-with-resources 문법이므로 자동으로 닫힘
            pstmt.setString(1, member.getUserid());
            pstmt.setString(2, member.getUserpw());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getHp());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getGender());
            pstmt.setString(7, member.getSsn1());
            pstmt.setString(8, member.getSsn2());
            pstmt.setString(9, member.getZipcode());
            pstmt.setString(10, member.getAddress1());
            pstmt.setString(11, member.getAddress2());
            pstmt.setString(12, member.getAddress3());   //세션에 저장됨
            return pstmt.executeUpdate() == 1;
            //SQL 실행.
            //executeUpdate()는 영향을 받은 행(row)의 수를 반환하는데, 정상적으로 한 명이 등록되면 1이므로 true 반환, 그렇지 않으면 false.
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public MemberDTO login(String userid, String userpw) {
        //userid와 userpw를 매개변수로 받아 로그인에 성공하면 MemberDTO 객체를 반환하고, 실패하면 null을 반환.
        String sql = "select * from member where userid = ? and userpw = ?";

        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userid);  //첫 번째 ?에 아이디 값 바인딩
            pstmt.setString(2, userpw);
            ResultSet rs = pstmt.executeQuery();
            //쿼리를 실행하고 결과를 ResultSet으로 받아온다. SELECT 쿼리 결과가 여기에 들어감
            if(rs.next()){  //결과가 있으면 (즉, 로그인 성공했다면) 다음 코드 실행
                MemberDTO member = new MemberDTO();  //빈 MemberDTO 객체 생성 (기본 생성자)
                member.setIdx(rs.getInt("idx"));
                member.setUserid(rs.getString("userid"));
                member.setName(rs.getString("name"));
                member.setHp(rs.getString("hp"));
                member.setEmail(rs.getString("email"));
                member.setGender(rs.getString("gender"));
                member.setZipcode(rs.getString("zipcode"));
                member.setAddress1(rs.getString("address1"));
                member.setAddress2(rs.getString("address2"));
                member.setAddress3(rs.getString("address3"));
                member.setPoint(Integer.parseInt(rs.getString("point")));
                return member;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }  //에러가 발생하면 콘솔에 출력하고, null 반환 (로그인 실패)
        return null;  //ResultSet에 결과가 없었을 경우에도 null 반환
    }
    public boolean updateMember(MemberDTO dto) {
        String sql = """
                update member set name=?, hp=?, email=?, gender=?,
                zipcode=?, address1=?, address2=?, address3=?
                where userid=?
                """;
        try(Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getHp());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getGender());
            pstmt.setString(5, dto.getZipcode());
            pstmt.setString(6, dto.getAddress1());
            pstmt.setString(7, dto.getAddress2());
            pstmt.setString(8, dto.getAddress3());
            pstmt.setString(9, dto.getUserid());
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteMember(String userid) {
        String sql = "delete from member where userid=?";
        try(Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userid);
            return pstmt.executeUpdate() == 1;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}