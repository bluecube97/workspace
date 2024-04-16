package com.mvc.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.board.dao.boardDAO;
import com.reference.config.XmlConfig;

@WebServlet("/board/boardetail")
public class boarDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {
			System.out.println("세션있음");
			req.setAttribute("userMap", session);
		}

		String page = req.getParameter("page");
		String field = req.getParameter("field");
		String keyword = req.getParameter("keyword");
		String brdNo = req.getParameter("brdno");

		HashMap<String, Object> userMap = (HashMap<String, Object>) session.getAttribute("userMap");
		int userNo = (int) userMap.get("userno");

		boardDAO bd = new boardDAO();
		HashMap<String, Object> bmap = new HashMap<String, Object>();
		bmap = bd.getBoardDetail(brdNo);

		int readListChk = bd.getMyReadListChk(brdNo, userNo);
		System.out.println("readListChk: " + readListChk);

		if (readListChk > 0) {
			bd.updateMyReadList(brdNo, userNo);
		} else {
			bd.insertMyReadList(brdNo, userNo);
			bd.addReadCnt(brdNo);
		}
		
		String myListFlag = req.getParameter("mylistflag");

		req.setAttribute("mylistflag", myListFlag);
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
}
