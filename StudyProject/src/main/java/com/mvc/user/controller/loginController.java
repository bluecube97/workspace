package com.mvc.user.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.user.dao.userDAO;

@WebServlet("/user/login")
public class loginController extends HttpServlet {
	private userDAO ud = null;
	private static final int cookieExp = 60 * 60 * 24 * 7;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memoryId = getCookie("StudyProject_Cookie", req);
		
		req.setAttribute("id", memoryId);
		req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		ud = new userDAO();

		HashMap<String, Object> userMap = ud.getLoginCheck(id, password);

		// id, password 체크 및 사용자 정보 조회
		if (userMap == null) {
			String ment = "아이디 또는 비밀번호가 일치하지 않습니다.";
			doFailed(req, resp, ment);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userMap", userMap);

			if (remember != null) { // remember id 체크
				makeCookie("StudyProject_Cookie", id, resp); // 쿠키에 id 각인 서비스
				
			}
			resp.sendRedirect("/board/boardList");
		}

		
	}

	// 로그인 실패시
	private void doFailed(HttpServletRequest req, HttpServletResponse resp, String ment) {
		req.setAttribute("ment", ment);
		try {
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 쿠키 생성
	private void makeCookie(String cid, String pid, HttpServletResponse resp) {
		Cookie cookie = new Cookie(cid, pid);
		cookie.setPath("/");
		cookie.setMaxAge(cookieExp);
		resp.addCookie(cookie);
	}

	// 쿠키 확인
	private String getCookie(String cid, HttpServletRequest req) {
		String rid = "";
		if (req == null) { // 1. 사용자 요청 없이 그냥 로그인 화면만 띄우는 경우
			return rid;
		}

		Cookie[] cookies = req.getCookies(); // 사용자 쿠키 소유 여부 확인
		String pid = null;

		if (cookies == null) { // 사용자가 쿠키가 없으면
			return rid;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cid)) { // 쿠키 값 중에 cid와 동일한 것이 있으면
				rid = cookie.getValue();

				System.out.println("cookieName: " + cookie.getName());
				System.out.println("cookieValue: " + cookie.getValue());
				System.out.println("rid: " + rid);

				break;
			}
		}
		return rid;
	}
}
