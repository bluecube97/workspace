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
import com.user.vo.userVO;

@WebServlet("/update")
public class boardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			req.setAttribute("userinfo", session);
		}

		boardDAO bd = new boardDAOImpl();
		String brdNo = req.getParameter("brdno");
		boardVO bv = bd.getBoardDetail(brdNo);
		String flag = req.getParameter("flag");
		int brdNo_ = Integer.parseInt(brdNo);

		System.out.println("flag: " + flag);

		if (flag.equals("d")) {
			bd.boardDelete(brdNo_);
			resp.sendRedirect("/board");
		} else {
			req.setAttribute("brdno", brdNo);
			req.setAttribute("detail", bv);
			req.getRequestDispatcher("/WEB-INF/com/board/update.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
		HttpSession session = req.getSession();

		userVO uv = (userVO) session.getAttribute("userinfo");
		String brdTitle = req.getParameter("title");
		String brdMemo = req.getParameter("content");
		String brdNo_ = req.getParameter("brdno");
		String flag = req.getParameter("flag");
		System.out.println("flag1: " + flag);
		int brdNo = 0;
		int result = 0;
		String ment = "";

		if (brdNo_ != null && !brdNo_.equals("")) {
			brdNo = Integer.parseInt(brdNo_);
		}

		boardDAO bd = new boardDAOImpl();

		System.out.println("flag2: " + flag);

		result = bd.boardUpdate(uv, brdTitle, brdMemo, brdNo);
		resp.sendRedirect("/detail?brdno=" + brdNo);

		if (result == 0) {
			ment = "저장에 실패했습니다.";
			req.setAttribute("ment", ment);
			doGet(req, resp);
		}

	}
}
