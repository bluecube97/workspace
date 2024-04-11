package com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.vo.BoardVO;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brdNo = req.getParameter("brdno");

		BoardDao bd = new BoardDaoImpl();
		BoardVO bv = bd.getBoardDetail(brdNo);

		req.setAttribute("detail", bv);
		req.getRequestDispatcher("/WEB-INF/com/board/ditail.jsp").forward(req, resp);

	}

}
