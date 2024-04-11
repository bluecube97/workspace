package com.mvc.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.dao.boardDAO;
import com.mvc.connection.JDBCUtil;

@WebServlet("/board")
public class boardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boardDAO bd = new boardDAO();
		List<HashMap<String, Object>> boardList = bd.getBoardList();
		
		req.setAttribute("list", boardList);
		req.getRequestDispatcher("/WEB-INF/com/board/board.jsp").forward(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JDBCUtil.UFT(req, resp);
		
		
	}
}
