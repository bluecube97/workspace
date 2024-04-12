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
import com.mvc.board.vo.BoardSearchVo;

@WebServlet("/board/boardList")
public class boardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Session 체크
		HttpSession session = req.getSession();
		boolean b = req.isRequestedSessionIdValid();

		if (session == null || b == false) {
			resp.sendRedirect("/user/login");
		} else {

			// Parameter 체크 jsp -> controller
			String page_ = req.getParameter("page");
			String field_ = req.getParameter("field");
			String keyword_ = req.getParameter("keyword");

			// 형변환 및 Validation 추가
			int page = 1;
			String field = "title";
			String keyword = "";
			String dynamicSql = "";

			if (page_ != null && !page_.equals("")) {
				page = Integer.parseInt(page_);
			}

			if (field_ != null && !field_.equals("")) {
				field = field_;
			}

			if (keyword_ != null && !keyword_.equals("")) {
				keyword = keyword_;
			}

			// 검색 조건에 따른 sql구문 변경 -> dynamicSql을 세팅해줌.
			if (field.equals("title")) {
				dynamicSql = " and tb.BRDTITLE like ? ";
			} else if (field.equals("user")) {
				dynamicSql = " and cu.USERNM like ? ";
			}

			/*  */
			BoardSearchVo bv = new BoardSearchVo(page, field, keyword, dynamicSql);

			// 검색조건에 따른 글 갯수
			int count = boardDAO.bd().getBoardListCount(bv);

			// 검색조건에 따른 글 목록
			List<HashMap<String, Object>> blist = boardDAO.bd().getBoardList(bv);

			// jsp로 Param전송
			req.setAttribute("session", session);
			req.setAttribute("blist", blist); // 글목록
			req.setAttribute("count", count); // 글갯수
			req.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
