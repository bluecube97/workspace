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
import com.mvc.board.vo.boardRegeditVO;
import com.reference.config.XmlConfig;

@WebServlet("/board/regedit")
public class boardRegeditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/board/boardRegedit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

		// 세션 체크
		HttpSession session = req.getSession(false);
		// 세션이 존재하면
		if (session != null) {
			HashMap<String, Object> map = (HashMap<String, Object>) session.getAttribute("userMap");

			// 세션 상의 사용자 정보
			// String userNm = (String) map.get("usernm");
			int userNo = (int) map.get("userno");
			// String userRole = (String) map.get("userrole");

			// parameter JSP TO Controller
			String brdTitle = req.getParameter("brdtitle");
			String brdMemo = req.getParameter("brdmemo");

			boardDAO bd = new boardDAO();
			boardRegeditVO bv = new boardRegeditVO(userNo, brdTitle, brdMemo);
			bd.regeditContents(bv);

			// 저장된 글 번호 조회
			int brdNo = bd.getMyContentNo(bv, resp);

			resp.sendRedirect("/board/boardetail?brdno=" + brdNo);
		} else { // session에 문제가 있거나, 부정한 접근이 감지되면
			resp.sendRedirect("/");
		}

	}
}
