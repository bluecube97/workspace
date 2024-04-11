package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.config.XmlConfig;
import com.user.dao.userDAO;
import com.user.dao.userDAOImpl;

@WebServlet("/signup")
public class userSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ment = (String) req.getAttribute("ment");

		if (ment != null && !ment.isBlank()) {
			req.setAttribute("ment", ment);
		}

		req.getRequestDispatcher("/WEB-INF/com/user/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

		String id = req.getParameter("id");

		idChk(id, req, resp);
	}


	private void idChk(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDAO ud = new userDAOImpl();
		int result = ud.IdCheck(id);
		
		PrintWriter pw = resp.getWriter();
		pw.print(result);
		pw.flush();
	}
}
