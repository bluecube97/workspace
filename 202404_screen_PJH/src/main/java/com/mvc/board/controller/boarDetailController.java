package com.mvc.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.board.dao.boardDAO;
import com.mvc.board.dao.boardDAOImpl;
import com.mvc.user.dao.userDAO;
import com.mvc.user.dao.userDAOImpl;
import com.reference.config.XmlConfig;

@WebServlet("/board/boardetail")
public class boarDetailController extends HttpServlet {
	private static final int cookieExp = 60 * 60 * 24 * 2;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		userDAO ud = new userDAOImpl();
		if (session != null) {
			System.out.println("세션있음");
			req.setAttribute("userMap", session);
		}
		
		String page = req.getParameter("page");
		String field = req.getParameter("field");
		String keyword = req.getParameter("keyword");
		String brdNo = req.getParameter("brdno");

		boardDAO bd = new boardDAOImpl();
		// 쿠키 확인, 생성
		boolean readDetail = checkCookieBrdno(req, brdNo);

		if (!readDetail) {
			makeCookie(resp, brdNo);
			ud.insertReadList(session, brdNo);
			bd.increaseHit(Integer.parseInt(brdNo));
		}

		HashMap<String, Object> bmap = new HashMap<String, Object>();
		bmap = bd.getBoardDetail(brdNo);

		req.setAttribute("page", page);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("bmap", bmap);
		req.setAttribute("brdno", brdNo);
		req.getRequestDispatcher("/WEB-INF/view/board/boarDetail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}

	private void makeCookie(HttpServletResponse resp, String brdNo) {
		Cookie cookie = new Cookie("detail_" + brdNo, "true");
		cookie.setPath("/");
		resp.addCookie(cookie);
	}

	private boolean checkCookieBrdno(HttpServletRequest req, String brdNo) {
		Cookie[] cookies = req.getCookies();

		boolean b = false;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				b = cookie.getName().equals("detail_" + brdNo) && cookie.getValue().equals("true");
			}
		}
		return b;
	}

}
