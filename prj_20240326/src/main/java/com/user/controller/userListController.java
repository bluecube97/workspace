package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.config.XmlConfig;
//import com.reference.config.XmlConfig;
//import com.user.dao.userDAO;
import com.user.dao.userDAOImpl;
import com.user.vo.userVO;

@WebServlet("/userList")
public class userListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private userDAO ud = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String skey_ = req.getParameter("sk");
		String skey = "";
		String soption_ = req.getParameter("so");
		String soption = "userno";
		String page_ = req.getParameter("page");
		int page = 1;
		
		try {
			//String daoClass = XmlConfig.getXmlDAO("userDAO");
			//Class<?> findClass = Class.forName(daoClass);
			//ud = (userDAO) findClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (skey_ != null && !skey_.equals("")) {
			skey = skey_;
		}
		if (soption_ != null && !soption_.equals("")) {
			soption = soption_;
		}
		
		String addSql = "";
		
		if (soption.equals("userno")) {
			addSql = " where cu.USERNO like ? ";
		} else if (soption.equals("usernm")) {
			addSql = " where cu.USERNM like ? ";
		}
		
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		userDAOImpl ud = new userDAOImpl();
		int cnt = ud.getBoardCount(skey, addSql);
		List<userVO> list = ud.getUserList(skey, addSql, page);
		
		req.setAttribute("userList", list);
		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("/WEB-INF/com/user/userList.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);
	}
}
