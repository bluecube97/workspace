package com.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dao.userDAO;
import com.user.dao.userDAOImpl;

@WebServlet("/joblist")
public class UserJobListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDAO ud = new userDAOImpl();
		
		System.out.println("나 등장");
		
		List<HashMap<String, Object>> result = ud.getJobList();
		
		System.out.println("result: " + result);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		ObjectMapper map = new ObjectMapper();
		map.writeValue(resp.getWriter(), result);

	}
}
