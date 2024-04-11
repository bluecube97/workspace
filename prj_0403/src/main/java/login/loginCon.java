package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		loginVO lv = new loginVO();
		loginDAO ld = new loginDAO();

		lv.setUserId(id);
		lv.setUserPw(pw);

		if (ld.getLoginChk(lv) == 1) {
			System.out.println("로그인 성공");
			PrintWriter pwriter = resp.getWriter();
			pwriter.print(lv.getUserId());
			pwriter.flush();
		} else {
			System.out.println("로그인 실패");
			doGet(req, resp);
		}

	}
}
