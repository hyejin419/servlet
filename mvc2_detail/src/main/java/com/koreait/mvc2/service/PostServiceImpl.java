package com.koreait.mvc2.service;

import com.koreait.mvc2.dao.PostDAO;
import com.koreait.mvc2.dto.CommentDTO;
import com.koreait.mvc2.dto.MemberDTO;
import com.koreait.mvc2.dto.PostDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDAO dao = new PostDAO();

    @Override
    public void isLogged(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");
        if (sessionDto !=null) {
            req.getRequestDispatcher("WEB-INF/views/writePost.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("login.member");
        }
    }

    @Override
    public void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDTO dto = new PostDTO();
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");
        dto.setUser_id(sessionDto.getUserid());

        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        boolean success = dao.insertPost(dto);
        if (success) {
            resp.sendRedirect("board.post");
        }else{
            req.setAttribute("error", "게시글 작성 중 오류가 발생했습니다.");
            req.getRequestDispatcher("WEB-INF/views/writePost.jsp").forward(req, resp);
        }
    }

    @Override
    public void showPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostDTO> postList = dao.getAllPost();
        req.setAttribute("posts", postList);
        req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
    }

    @Override
    public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idx = Integer.parseInt(req.getParameter("idx"));
        // 포스트 가져오기
        PostDTO onePost = dao.getOnePostByIdx(idx);
        // 모든 댓글 가져오기
        List<CommentDTO> comments = dao.getAllCommentByBoard_idx(idx);
        // 포스트에 해당하는 댓글 수 가져오기
        if (comments == null) {
            comments = new ArrayList<>();
        }
        int commentCount = comments.size();

        req.setAttribute("onePost", onePost);
        req.setAttribute("comments", comments);
        req.setAttribute("commentCount", commentCount);
        req.getRequestDispatcher("WEB-INF/views/detail.jsp").forward(req, resp);
    }

    @Override
    public void editPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idx = Integer.parseInt(req.getParameter("idx"));
        PostDTO onePost = dao.findPostByIdx(idx);
        req.setAttribute("onePost", onePost);
        req.getRequestDispatcher("WEB-INF/views/editPost.jsp").forward(req, resp);
    }


    @Override
    public void editDone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDTO dto = new PostDTO();


        dto.setIdx(Integer.parseInt(req.getParameter("hidden_idx")));
        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        boolean isUpdate = dao.updatePost(dto);
        if (isUpdate) {
            resp.sendRedirect("view.post?idx=" + dto.getIdx());
        }else {
            req.setAttribute("error", "게시글 수정 중 오류가 발생했습니다.");
            req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
        }
    }


    @Override
    public void deletePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idx = Integer.parseInt(req.getParameter("idx"));
        boolean isDelete = dao.deletePost(idx);
        if (isDelete) {
            resp.sendRedirect("board.post");
        }
    }

    @Override
    public void viewEditComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer board_idx = Integer.parseInt(req.getParameter("board_idx"));
        Integer comment_idx = Integer.parseInt(req.getParameter("comment_idx"));
        PostDTO onePost = dao.getOnePostByIdx(board_idx);
        List<CommentDTO> comments = dao.getAllCommentByBoard_idx(board_idx);
        req.setAttribute("onePost", onePost);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("WEB-INF/views/editComment.jsp").forward(req, resp);

    }

    @Override
    public void editCommentDone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDTO dto = new CommentDTO();
        dto.setIdx(Integer.parseInt(req.getParameter("comment_idx")));
        dto.setBoard_idx(Integer.parseInt(req.getParameter("board_idx")));
        dto.setContent(req.getParameter("comment"));

        boolean isCommentUpdate= dao.updateCommentByComment_idx(dto);
        if (isCommentUpdate) {
            resp.sendRedirect("view.post?idx=" + dto.getBoard_idx()); // ← 새로고침해도 중복 요청 없음
        } else {
            req.setAttribute("error", "댓글 수정 중 오류가 발생했습니다.");
            req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
        }
    }

    @Override
    public void deleteComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer comment_idx = Integer.parseInt(req.getParameter("comment_idx"));
        Integer board_idx = Integer.parseInt(req.getParameter("board_idx"));
        boolean isDelete = dao.deleteComment(comment_idx);
        if (isDelete) {
            resp.sendRedirect("view.post?idx=" + board_idx); // ← 새로고침해도 중복 요청 없음
        }
    }

    @Override
    public void registComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDTO dto = new CommentDTO();
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");
        dto.setUser_id(sessionDto.getUserid());
        dto.setBoard_idx(Integer.parseInt(req.getParameter("board_idx")));
        dto.setContent(req.getParameter("comment"));
        boolean success = dao.registComment(dto);
        if (success) {
            resp.sendRedirect("view.post?idx=" + dto.getBoard_idx());
        }else {
            req.setAttribute("error", "게시글 수정 중 오류가 발생했습니다.");
            req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
        }

    }
}
