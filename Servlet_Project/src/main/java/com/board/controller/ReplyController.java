package com.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDao bd = new BoardDao();
		
		int brdno = 2;
		
		//List<HashMap<String, Object>>rlist = bd.getReplyList(brdno);
		
		//req.setAttribute("rlist", rlist);
		
		req.getRequestDispatcher("/WEB-INF/com/board/reply.jsp").forward(req, resp);
	}
}
