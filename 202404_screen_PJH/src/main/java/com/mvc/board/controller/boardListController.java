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
import com.mvc.board.dao.boardDAOImpl;
import com.mvc.board.vo.boardSearchVO;
import com.reference.config.XmlConfig;

@WebServlet("/board/boardList")
public class boardListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("111111111111");
		HttpSession session = req.getSession(false);
		boolean b = req.isRequestedSessionIdValid();
		System.out.println("b: " + b);

		String page_ = req.getParameter("page");
		String field_ = req.getParameter("field");
		String keyword_ = req.getParameter("keyword");

		int page = 1;
		String field = "title";
		String keyword = "";
		String dynamicSql = "";

		if (page_ != null && !page_.isEmpty()) {
			page = Integer.parseInt(page_);
		}

		if (field_ != null && !field_.isEmpty()) {
			field = field_;
		}

		if (keyword_ != null && !keyword_.isEmpty()) {
			keyword = keyword_;
		}

		if (field.equals("title")) {
			dynamicSql = " and tb.BRDTITLE like ? ";
		} else if (field.equals("user")) {
			dynamicSql = " and cu.USERNM like ? ";
		}

		boardSearchVO bv = new boardSearchVO(page, field, keyword, dynamicSql);

		boardDAO bd = new boardDAOImpl();

		int cnt = bd.getBoardListCnt(bv);

		List<HashMap<String, Object>> blist = bd.getBoardList(bv);

		// jsp로 Param전송
		req.setAttribute("page", page);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("session", session);
		req.setAttribute("blist", blist); // 글목록
		req.setAttribute("count", cnt); // 글갯수
		System.out.println("b: "  + b);
		if (b) {
			HashMap<String, Object> userMap = (HashMap<String, Object>) session.getAttribute("userMap");

			System.out.println("userMap : " + userMap);
			int userNo = (int) userMap.get("userno");
			System.out.println("userNo : " + userNo);
			System.out.println("page : " + page_);
			System.out.println("field : " + field_);
			System.out.println("keyword : " + keyword_);

			List<HashMap<String, Object>> rlist = bd.getTodaysList(userNo);
			System.out.println("rlist: " + rlist);
			req.setAttribute("rlist", rlist);
		}

		req.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}
}
