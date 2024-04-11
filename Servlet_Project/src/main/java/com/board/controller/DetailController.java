package com.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDao;
import com.board.vo.BoardVO;
import com.session.vo.SessionVO;

@WebServlet("/detail")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		boolean b = req.isRequestedSessionIdValid();

		if (session == null || b == false) {
			resp.sendRedirect("/login");
		} else {
			String userId = (String) session.getAttribute("userId");
			String userNm = session.getAttribute("userNm").toString();
			String userRole = session.getAttribute("userRole").toString();
			String userDept = session.getAttribute("userDept").toString();

			SessionVO sv = new SessionVO(userId, userNm, userRole, userDept);

			String brdNo = req.getParameter("brdno");
			System.out.println("글번호 :" + brdNo);

			BoardDao bd = new BoardDao();
			BoardVO bv = bd.getBoardDetail(brdNo);

			List<HashMap<String, Object>> rlist = bd.getReplyList(brdNo);

			req.setAttribute("userId", userId);
			req.setAttribute("rlist", rlist); // 댓글
			req.setAttribute("detail", bv); // 글 상세정보d
			req.setAttribute("brdNo", brdNo);

			req.getRequestDispatcher("/WEB-INF/com/board/detail.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String userId = req.getParameter("userId");
		String replyment = req.getParameter("replyment");
		String brdNo = req.getParameter("brdNo");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("replyment", replyment);
		map.put("brdNo", brdNo);
		
		BoardDao bd = new BoardDao();
		int result = bd.insertReply(map);
		
		resp.sendRedirect("/detail?brdno=" + brdNo);
	}
}
