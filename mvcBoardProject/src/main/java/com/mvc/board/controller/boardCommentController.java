package com.mvc.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.dao.boardDAO;
import com.mvc.connection.JDBCUtil;

@WebServlet("/comment")
public class boardCommentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boardDAO bd = new boardDAO();

		String brdNo = req.getParameter("brdno");
		System.out.println("brdNo: " + brdNo);
		List<HashMap<String, Object>> commentList = bd.getCommentList(brdNo);
		System.out.println("commentList: " + commentList);
		
		req.getRequestDispatcher("/WEB-INF/com/board/boardComment.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCUtil.UFT(req, resp);
	}
}
