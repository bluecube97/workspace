package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reference.config.XmlConfig;
import com.user.dao.userDAO;
import com.user.vo.userVO;

@WebServlet("/login")
public class userLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO ud = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/com/user/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		userVO uv = new userVO(id, pw);

		try {
			String daoClass = XmlConfig.getXmlDAO("userDAO");
			Class<?> findClass = Class.forName(daoClass);
			ud = (userDAO) findClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		uv = ud.getLoginCheck(uv);

		if (!uv.getUserId().equals("") || uv.getUserId() != null) {
			int userNo = uv.getUserNo();
			String userId = uv.getUserId();
			String userNm = uv.getUserNm();
			String userDept = uv.getUserDept();
			String userRole = uv.getUserRole();
			String userEmail = uv.getUserEmail();

			// 세션 선언
			HttpSession session = req.getSession();
			session.setAttribute("userinfo", uv);

			session.setAttribute("userno", userNo);
			session.setAttribute("userid", userId);
			session.setAttribute("usernm", userNm);
			session.setAttribute("userdept", userDept);
			session.setAttribute("userrole", userRole);
			session.setAttribute("useremail", userEmail);

			resp.sendRedirect("/board");
		} else {
			doGet(req, resp);
		}
	}
}
