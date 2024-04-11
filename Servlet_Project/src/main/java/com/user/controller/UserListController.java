package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.XmlConfig;
import com.user.dao.UserADD;
import com.user.dao.UserDao;
import com.user.vo.UserVO;

@WebServlet("/userList")
public class UserListController extends HttpServlet {
	private UserDao ud = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nmkey = "";
		String nmkey_ = req.getParameter("nmk");
		String page_ = req.getParameter("page");
		int page = 1;

		if (nmkey_ != null && !nmkey_.equals("")) {
			nmkey = nmkey_;
		}
		if (page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}

		try {
			String DAOClass = XmlConfig.getXmlDao("UserDao");

			Class<?> findClass = Class.forName(DAOClass);

			ud = (UserDao) findClass.getDeclaredConstructor().newInstance();
			// ud = new com.user.dao.UserDAOImpl(); 윗줄과 같음
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = ud.getUserCount(nmkey);
		List<UserVO> ulist = ud.getUserList(nmkey, page);

		// UserDAO ud = new UserDAOImpl();
		// int count = ud.getUserCount(nmkey);
			// int count = UserADD.getInstance().getUserDAO().getUserCount(nmkey_);
		// List<UserVO> ulist = ud.getUserList(nmkey, page);
			// List<UserVO> ulist = UserADD.getInstance().getUserDAO().getUserList(nmkey_, page);

		req.setAttribute("userList", ulist);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/WEB-INF/com/user/userList.jsp").forward(req, resp);
	}
}
