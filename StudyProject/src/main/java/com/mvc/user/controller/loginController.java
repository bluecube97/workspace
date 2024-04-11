package com.mvc.user.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.user.dao.userDAO;

@WebServlet("/user/login")
public class loginController extends HttpServlet {
	private userDAO ud = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		ud = new userDAO();

		HashMap<String, Object> userMap = ud.getLoginCheck(id, password);

		if (userMap == null) {
			resp.sendRedirect("/user/login");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userMap", userMap);
			resp.sendRedirect("/board/boardList");
		}
	}
}
