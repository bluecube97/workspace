package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.boardDAO;
import com.board.dao.boardDAOImpl;
import com.board.vo.boardVO;
import com.reference.config.XmlConfig;

@WebServlet("/detail")
public class boardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			req.setAttribute("userinfo", session);
		}
		
		String brdNo = req.getParameter("brdno");
		
		boardDAO bd = new boardDAOImpl();
		boardVO bv = bd.getBoardDetail(brdNo);

		req.setAttribute("brdno", brdNo);
		req.setAttribute("detail", bv);
		req.getRequestDispatcher("/WEB-INF/com/board/detail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}
}
