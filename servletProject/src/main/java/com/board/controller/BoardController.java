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
import com.board.dao.BoardDaoImpl;
import com.board.vo.BoardVO;
import com.session.vo.SessionVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		boolean b = req.isRequestedSessionIdValid();
		
		if(session == null || b == false) {
			resp.sendRedirect("/login");
		}else {
			String userId = (String) session.getAttribute("userId");
			String userNm = (String) session.getAttribute("userNm");
			String userRole = (String) session.getAttribute("userRole");
			String userDept = (String) session.getAttribute("userDept");
			
			SessionVO sv = new SessionVO(userId, userNm, userRole, userDept);

			System.out.println(b);
			System.out.println("userID : " + userId + " userNm : " + userNm + " userRole : " + userRole);
			
			String skey_ = req.getParameter("sk");
			String skey = "";
			String soption_ = req.getParameter("so");
			String soption ="title";
			String page_ = req.getParameter("page");
			int page =1;
			
			if(skey_!=null && !skey_.equals("")) {
				skey = skey_;	
			}
			
			if(soption_!=null && !soption_.equals("")) {
				soption = soption_;	
			}
			
			String addSql = "";
			if(soption.equals("title")) {
				addSql = " AND tb.BRDTITLE like ? ";
			}else if (soption.equals("writernm")) {
				addSql = " AND cu.USERNM like ? ";
			}
			if(page_!=null && !page_.equals("")) {
				page = Integer.parseInt(page_); 
			}
			
			BoardDao bd = new BoardDaoImpl();
			
			int count = bd.getBoardCount(skey,addSql);//글 목록 갯수
			List<BoardVO>blist = bd.getBoardList(skey,addSql, page);//글 목록
			
			req.setAttribute("sv", sv);
			req.setAttribute("board", blist);
			req.setAttribute("count", count);
			req.getRequestDispatcher("/WEB-INF/com/board/board.jsp").forward(req, resp);
		}
	}
}
