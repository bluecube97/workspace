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
import com.board.dao.boardDAOImpl;
import com.board.vo.boardVO;
import com.reference.config.XmlConfig;
import com.session.vo.sessionVO;

@WebServlet("/board")
public class boardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean b = req.isRequestedSessionIdValid();

		if (session == null || b == false) {
			resp.sendRedirect("/login");
		} else {
			String userId = (String) session.getAttribute("userid");
			String userNm = (String) session.getAttribute("usernm");
			String userRole = (String) session.getAttribute("userrole");
			String userDept = (String) session.getAttribute("userdept");

			sessionVO sv = new sessionVO(userId, userNm, userRole, userDept);

			String skey_ = req.getParameter("sk");
			String skey = "";
			String soption_ = req.getParameter("so");
			String soption = "title";
			String page_ = req.getParameter("page");
			int page = 1;

			if (skey_ != null && !skey_.equals("")) {
				skey = skey_;
			}

			if (soption_ != null && !soption_.equals("")) {
				soption = soption_;
			}

			String addSql = "";

			if (soption.equals("title")) {
				addSql = " AND tb.BRDTITLE like ? ";
			} else if (soption.equals("writernm")) {
				addSql = " AND cu.USERNM like ? ";
			}

			if (page_ != null && !page_.equals("")) {
				page = Integer.parseInt(page_);
			}
			// dao 연결
			boardDAO bd = new boardDAOImpl();
			// 결과값 반환
			int cnt = bd.getBoardCount(skey, addSql);
			List<boardVO> list = bd.getBoardList(skey, addSql, page);

			// jsp로 결과값 보냄
			req.setAttribute("list", list);
			req.setAttribute("sv", sv);
			req.setAttribute("cnt", cnt);
			req.getRequestDispatcher("/WEB-INF/com/board/board.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}
}
