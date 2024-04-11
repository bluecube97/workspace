package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.vo.userVO;

public class userDAO {

	public userVO getLoginCheck(userVO uv) {
		userVO uvo = null;
		try {
			String url = "jdbc:mysql://192.168.0.78:3306/testDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "studyuser";
			String pass = "1111";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			
			ResultSet rs = null;

			String sql = " SELECT cu.USERNO AS USERNO, "
					   + "        cu.USERID AS USERID, "
					   + "        cu.USERNM AS USERNM, "
					   + " (CASE "
					   + "     WHEN cu.USERROLE = 'A' "
					   + "         THEN '관리자' "
					   + "     WHEN cu.USERROLE = 'U' "
					   + "         THEN '사용자' "
					   + " END) AS USERROLE, "
					   + " (CASE "
					   + "     WHEN cu.DEPTNO = 1 "
					   + "         THEN '사장실' "
					   + "     WHEN cu.DEPTNO = 2 "
					   + "         THEN '인사팀' "
					   + "     WHEN cu.DEPTNO = 3 "
					   + "         THEN '영업1팀' "
					   + "     WHEN cu.DEPTNO = 4 "
					   + "         THEN '영업2팀' "
					   + "     WHEN cu.DEPTNO = 5 "
					   + "         THEN '개발팀' "
					   + "     WHEN cu.DEPTNO = 6 "
					   + "         THEN '자재팀' "
					   + " END)  AS USERDEPT "
					   + " FROM COM_USER cu "
					   + " where cu.USERID = ?  and cu.USERPW = ? "
					   + " LIMIT 1 ";
			
			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement  psmt = con.prepareStatement(sql);
			
			String pid = uv.getUserID();
			String ppass = uv.getUserPass();
			
			psmt.setString(1, pid);
			psmt.setString(2, ppass);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				int userNo = rs.getInt("USERNO");
				String userId = rs.getString("USERID");
				String userNm = rs.getString("USERNM");
				String userRole = rs.getString("USERROLE");
				String userDept = rs.getString("USERDEPT");
				
				uvo = new userVO(userNo, userId, userNm, userRole, userDept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uvo;
	}
}
