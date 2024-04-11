package signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class signUpCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String id = req.getParameter("id");

		idChk(id, req, resp);

		boolean canSignUp = Boolean.parseBoolean(req.getParameter("canSignUp"));
		System.out.println("cansup" + canSignUp);
		if (canSignUp) {
			id = req.getParameter("id");
			String name = req.getParameter("name");
			String gender = req.getParameter("gender");
			String pw = req.getParameter("pw");
			String email = req.getParameter("email");
			
			System.out.println("post-" + id + "-" + name + "-" + gender + "-" + pw + "-" + email);
			SignUp(id, name, gender, pw, email);
			doGet(req, resp);
		}

	}

	private void idChk(String id, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		signupDAO sd = new signupDAO();
		int result = sd.IdCheck(id);

		PrintWriter pw = resp.getWriter();
		pw.print(result);
		pw.flush();
	}

	private void SignUp(String id, String name, String gender, String pw, String email) {
		signupDAO sd = new signupDAO();
		System.out.println("method-" + id + "-" + name + "-" + gender + "-" + pw + "-" + email);
		sd.SignUp(id, name, gender, pw, email);
	}
}
