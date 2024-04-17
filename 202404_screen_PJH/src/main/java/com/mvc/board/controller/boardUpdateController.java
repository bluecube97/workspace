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
import com.mvc.board.dao.boardDAOImpl;
import com.reference.config.XmlConfig;

@WebServlet("/board/update")
public class boardUpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		boardDAO bd = new boardDAOImpl();
		String brdNo = req.getParameter("brdno");
		if (flag.equals("u")) {
			HashMap<String, Object> bmap = bd.getBoardDetail(brdNo);
			req.setAttribute("bmap", bmap);

			req.getRequestDispatcher("/WEB-INF/view/board/boardUpdate.jsp").forward(req, resp);
		} else if(flag.equals("d")){
			// bd.deleteContents(brdNo);
			
			// req.getRequestDispatcher("/").forward(req, resp);
			// req.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(req, resp);
			resp.sendRedirect("/board/boardList");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

		// 세션 체크
		HttpSession session = req.getSession(false);
		// 세션이 존재하면
		if (session != null) {
			// parameter JSP TO Controller
			String brdTitle = req.getParameter("brdtitle");
			String brdMemo = req.getParameter("brdmemo");
			String brdNo = req.getParameter("brdno");
			
			boardDAO bd = new boardDAOImpl();
			bd.updateContents(brdTitle, brdMemo, brdNo);
			// 수정한 글 번호 조회 및 글 자세히보기로 리다이렉트
			resp.sendRedirect("/board/boardetail?brdno=" + brdNo);
		} else { // session에 문제가 있거나, 부정한 접근이 감지되면
			resp.sendRedirect("/");
		}
	}
}
