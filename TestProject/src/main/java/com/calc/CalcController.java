package com.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reference.config.XmlConfig;

import java.io.IOException;

@WebServlet("/calc")
public class CalcController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/com/calc/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		XmlConfig.UTFUCK(req, resp);

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String num3 = req.getParameter("num3");
        String num4 = req.getParameter("num4");
        String num5 = req.getParameter("num5");
        String num6 = req.getParameter("num6");
        String num7 = req.getParameter("num7");
        String num8 = req.getParameter("num8");
        String num9 = req.getParameter("num9");
        String Erase = req.getParameter("Erase");
        String num0 = req.getParameter("num0");
        String Enter = req.getParameter("Enter");
        String output = req.getParameter("outputText");

    }
}
