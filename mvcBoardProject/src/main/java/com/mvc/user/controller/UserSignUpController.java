package com.mvc.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.user.dao.*;

@WebServlet("/user/signup")
public class UserSignUpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/com/user/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		UserDao ud = new UserDao();
		
		int result = 0;
		
		String pid = req.getParameter("id");
		String ppw = req.getParameter("pw");
		
		HashMap<String, Object>map =  ud.UserCheck(pid, ppw);
		//map 에 사용자 정보가 있다면
		if(map.containsKey("useNo") && map!= null) {
			//세션에 사용자 정보 추가
			HttpSession session = req.getSession();
			session.setAttribute("useNo", map.get("useNo"));
			session.setAttribute("userId", map.get("userId"));
			session.setAttribute("userNm", map.get("userNm"));
			session.setAttribute("userRole", map.get("userRole"));
			session.setAttribute("userDept", map.get("userDept"));
			
			//js 에 반환될 데이터 변경
			result = 1;
		}
		
		//js 에 result 값 반환
		PrintWriter pwr = resp.getWriter();
		pwr.print(result);
		pwr.flush();
	}
}
