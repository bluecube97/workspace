package com.board.detail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.boardDAO;
import com.board.vo.boardVO;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brdNo = req.getParameter("brdno");
		System.out.println("글번호: " + brdNo);
		
		boardDAO bd = new boardDAO();
		boardVO bv = bd.getBoardDetail(brdNo);
		
		req.setAttribute("detail", bv);
		req.getRequestDispatcher("/WEB-INF/com/board/detail.jsp").forward(req, resp);
	}
}
