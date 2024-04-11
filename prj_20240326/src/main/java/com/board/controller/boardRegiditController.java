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
import com.reference.config.XmlConfig;
import com.user.vo.userVO;

@WebServlet("/regidit")
public class boardRegiditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String ment = (String) req.getAttribute("ment");
		System.out.println("ment: " + ment);
		
		req.setAttribute("userinfo", session);
		req.getRequestDispatcher("/WEB-INF/com/board/regidit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
		HttpSession session = req.getSession();

		userVO uv = (userVO) session.getAttribute("userinfo");
		int userNo = uv.getUserNo();

		String brdTitle = req.getParameter("title");
		String brdMemo = req.getParameter("content");

		boardDAO bd = new boardDAOImpl();
		
		int result = bd.boardRegidit(userNo, brdTitle, brdMemo);
		String ment = "";
		
		System.out.println("result: " + result);

		if (result != 0) {
			int brdNo = bd.getLastBoardNo(userNo);
			resp.sendRedirect("/detail?brdno=" + brdNo);
		} else if (result == 0) {
			ment = "저장에 실패했습니다.";
			req.setAttribute("ment", ment);
			doGet(req, resp);
		}

		System.out.println("제목: " + brdTitle);
		System.out.println("내용: " + brdMemo);
	}
}
