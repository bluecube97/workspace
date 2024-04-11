package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.boardDAO;
import com.board.vo.boardVO;
import com.user.dao.userListDAO;
import com.user.vo.userListVO;

@WebServlet("/userlist")
public class UserListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ulskey_ = req.getParameter("ulsk");
		String ulsoption_ = req.getParameter("ulso");
		String page_ = req.getParameter("page");
		
		System.out.println("검색어: " + ulskey_);
		System.out.println("검색조건: " + ulsoption_);
		
		String ulskey = "";
		String ulsoption = "title";
		int page = 1;
		
		if (ulskey_ != null && !ulskey_.equals("")) {
			ulskey = ulskey_;
		}
		
		if (ulsoption_ != null && !ulsoption_.equals("")) {
			ulsoption = ulsoption_;
		}
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		String add_sql = " WHERE usernm like ? ";
		
		if (ulsoption.equals("usernm")) {
			add_sql = " WHERE usernm like ? ";
		} else if (ulsoption.equals("userrole")) {
			add_sql = " WHERE userrole like ? ";
		}
		
		userListDAO uld = new userListDAO();
		userListVO ulv = new userListVO();
		
		int ucount = uld.getUserCount(add_sql, ulskey);
		List<userListVO> ulist = uld.getUserList(ulv, ulskey, add_sql, page);

		req.setAttribute("userlist", ulist);
		req.setAttribute("ucount", ucount);
		req.getRequestDispatcher("/WEB-INF/com/user/userList.jsp").forward(req, resp);
	}
}
