package com.mvc.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.board.dao.boardDAO;
import com.reference.config.XmlConfig;

@WebServlet("/board/boardMyReadList")
public class boardMyReadListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Session 체크
		HttpSession session = req.getSession();
		boolean b = req.isRequestedSessionIdValid();

		if (session == null || b == false) {
			resp.sendRedirect("/user/login");
		} else {
			HashMap<String, Object> userMap = (HashMap<String, Object>) session.getAttribute("userMap");
			int userNo = (int) userMap.get("userno");
			System.out.println("userNo: " + userNo);
			
			boardDAO bd = new boardDAO();
			List<HashMap<String, Object>> myReadList = bd.getMyReadList(userNo);

			
			
			req.setAttribute("mdlist", myReadList);
			req.getRequestDispatcher("/WEB-INF/view/board/boardMyReadList.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}
}
