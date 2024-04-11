package com.board.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/board")
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		boolean b = req.isRequestedSessionIdValid();
		
		if(session==null || b == false) {
			resp.sendRedirect("/login");
		}else {
			String userId = (String)session.getAttribute("userId");
			String userNm = session.getAttribute("userNm").toString();
			String userRole = session.getAttribute("userRole").toString();
			String userDept = session.getAttribute("userDept").toString();
			
			SessionVO sv = new SessionVO(userId, userNm, userRole, userDept);
			
			System.out.println("userID : " + userId);
			System.out.println("userNm : " + userNm);
			System.out.println("userRole : " + userRole);
			
		String skey_ = req.getParameter("sk");
		String soption_ = req.getParameter("so");
		String page_ = req.getParameter("page");
		
		System.out.println("검색어: " + skey_);
		System.out.println("검색조건: " + soption_);
		
		String skey = "";
		String soption = "title";
		int page = 1;
		
		if(soption_!=null && !soption_.equals("")){
			soption = soption_;
		}
		
		if(skey_!=null && !skey_.equals("")){
			skey = skey_;
		}
		
		if(page_!=null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		String addSql = "";
		
		if(soption.equals("title")) {
			addSql = " AND tb.BRDTITLE  like  ? ";
		}else if (soption.equals("writernm")) {
			addSql = " AND cu.USERNM  like  ? ";
		}

		BoardDao bd = new BoardDao();
		
		int count  = bd.getBoardCount(addSql, skey);  //글 목록 갯수
		List<BoardVO>blist = bd.getBoardList(addSql, skey, page); //글목록

		req.setAttribute("sv", sv);
		req.setAttribute("board", blist);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/WEB-INF/com/board/board.jsp").forward(req, resp);
		}
	}
}
