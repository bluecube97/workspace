package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/board")
public class boardCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/board.jsp").forward(req, resp);
		
//		
//		pwriter.print(list);
//		pwriter.flush();
	}
	
	private String chKey(String skey_, String skey) {
		if (skey_ != null && !skey_.equals("")) {
			skey = skey_;
		}
		
		return skey;
	}
	
	private String chkOption(String soption_, String soption) {
		if (soption_ != null && !soption_.equals("")) {
			soption = soption_;
		}
		
		return soption;
	}
	
	private String addSqlMet(String soption) {
		String addSql = "";
		if (soption.equals("title")) {
			addSql = " AND tb.BRDTITLE like ? ";
		} else if (soption.equals("writernm")) {
			addSql = " AND cu.USERNM like ? ";
		}
		
		return addSql;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String skey_ = req.getParameter("sk");
		String skey = "";
		String soption_ = req.getParameter("so");
		String soption = "title";
		
		skey = chKey(skey_, skey);
		soption = chkOption(soption_, soption);
		
		String addSql = addSqlMet(soption);

		boardDAO bd = new boardDAO();
		List<HashMap<String, Object>> list = bd.getBoardList(skey, addSql, soption);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getWriter(), list);
		
		//PrintWriter pwriter = resp.getWriter();
	}
}
