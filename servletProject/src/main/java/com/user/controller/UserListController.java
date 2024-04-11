package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.XmlConfig;
import com.user.dao.UserDao;
import com.user.dao.UserDaoImpl;
import com.user.vo.UserVO;

@WebServlet("/userList")
public class UserListController extends HttpServlet {
	private UserDao ud = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String skey_ = req.getParameter("sk");
		String skey = "";
		String soption_ = req.getParameter("so");
		String soption = "userno";
		String page_ = req.getParameter("page");
		int page = 1;

		try {
			String daoClass = XmlConfig.getXmlDao("UserDao");
			Class<?> findClass = Class.forName(daoClass);
			ud = (UserDao) findClass.getDeclaredConstructor().newInstance();

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
			addSql = "  where cu.USERNO like ?  ";
		} else if (soption.equals("usernm")) {
			addSql = "  where cu.USERNM like ?  ";
		}
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		UserDaoImpl ud = new UserDaoImpl();
		int count = ud.getBoardCount(skey, addSql);
		List<UserVO> ulist = ud.getUserList(skey, addSql, page);

		req.setAttribute("userList", ulist);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/WEB-INF/com/user/userList.jsp").forward(req, resp);

	}
}
