package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.config.XmlConfig;

import java.io.IOException;

@WebServlet("/jstest")
public class JsTestController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/com/test/jstest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

		String val1 = req.getParameter("val1");
		System.out.println("val1: " + val1);
	}
}
