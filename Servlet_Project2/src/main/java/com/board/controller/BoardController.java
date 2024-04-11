package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.boardDAO;
import com.board.session.vo.sessionVO;
import com.board.vo.boardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		boolean b = req.isRequestedSessionIdValid();

		if (session == null || b == false) {
			resp.sendRedirect("/login");
		} else {
			String userId = (String) req.getSession().getAttribute("userId");
			String userNm = (String) req.getSession().getAttribute("userNm");
			String userRole = req.getSession().getAttribute("userRole").toString();
			String userDept = req.getSession().getAttribute("userDept").toString();

			sessionVO sv = new sessionVO(userId, userNm, userRole, userDept);
			
			System.out.println(userId + userNm + userRole + userDept);

			String skey_ = req.getParameter("sk");
			String soption_ = req.getParameter("so");
			String page_ = req.getParameter("page");

			System.out.println("검색어: " + skey_);
			System.out.println("검색조건: " + soption_);

			String skey = "";
			String soption = "title";
			int page = 1;

			if (skey_ != null && !skey_.equals("")) {
				skey = skey_;
			}

			if (soption_ != null && !soption_.equals("")) {
				soption = soption_;
			}

			if (page_ != null && !page_.equals("")) {
				page = Integer.parseInt(page_);
			}

			String add_sql = "";

			if (soption.equals("title")) {
				add_sql = " AND tb.brdtitle like ? ";
			} else if (soption.equals("writernm")) {
				add_sql = " AND cu.usernm like ? ";
			}

			boardDAO bd = new boardDAO();

			int count = bd.getBoardCount(add_sql, skey); // 글 목록 카운트
			List<boardVO> blist = bd.getBoardList(skey, add_sql, page); // 글 목록

			req.setAttribute("sv", sv);
			req.setAttribute("board", blist);
			req.setAttribute("count", count);
			req.getRequestDispatcher("/WEB-INF/com/board/board.jsp").forward(req, resp);
		}
	}
}
