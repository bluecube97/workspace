package com.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.session.vo.sessionVO;
import com.user.dao.userDAO;
import com.user.vo.userVO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/com/user/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("id");
		String ppass = req.getParameter("pass");

		System.out.println("id : " + pid);
		System.out.println("pass : " + ppass);

		userVO uv = new userVO(pid, ppass);
		userDAO ud = new userDAO();
		uv = ud.getLoginCheck(uv);

		if (!uv.getUserID().equals("") || uv.getUserID() != null) {
			String userId = uv.getUserID();
			String userNm = uv.getUserNm();
			String userRole = uv.getUserRole();
			String userDept = uv.getUserDept();
			
			// 세션 선언
			HttpSession session = req.getSession();
			
			session.setAttribute("userId", userId);
			session.setAttribute("userNm", userNm);
			session.setAttribute("userRole", userRole);
			session.setAttribute("userDept", userDept);
			
			resp.sendRedirect("/board");
		} else {
			doGet(req, resp);
		}
	}
}
