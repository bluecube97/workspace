package com.mvc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mvc.connection.ConnectionProvider;
import com.mvc.connection.JDBCUtil;

public class UserDao {

	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public HashMap<String, Object> UserCheck(String pid, String ppw) {	
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			String sql = "  select cu.USERNO AS userno, cu.USERID AS userid, cu.USERNM AS usernm,  " 
					+ "		(CASE "
					+ "			 WHEN cu.USERROLE = 'A' " 
					+ "			 THEN  '관리자' "
					+ "			 WHEN cu.USERROLE = 'U' " 
					+ "			 THEN '사용자' " 
					+ "		END) AS USERROLE, "
					+ "		(CASE  " 
					+ "			 WHEN cu.DEPTNO =1 " 
					+ "			 THEN '사장실' "
					+ "			 WHEN cu.DEPTNO =2 " 
					+ "			 THEN '인사팀' " 
					+ "			 WHEN cu.DEPTNO =3 "
					+ "			 THEN '영업1팀' " 
					+ "			 WHEN cu.DEPTNO =4 " 
					+ "			 THEN '영업2팀' "
					+ "			 WHEN cu.DEPTNO =5 " 
					+ "			 THEN '개발팀' " 
					+ "			 WHEN cu.DEPTNO =6 "
					+ "			 THEN '자재팀' " 
					+ "		END) AS userdept ,"
					+ "		cu.USEREMAIL as useremail " 
					+ "  from COM_USER cu  "
					+ " WHERE cu.USERID = ?   " 
					+ "   and cu.USERPW = SHA2( ? ,256)  " 
					+ " LIMIT 1 ";
			
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, pid);
			psmt.setString(2, ppw);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				int userNo = rs.getInt("userno");
				String userId = rs.getString("userid");
				String userNm = rs.getString("usernm");
				String userDept = rs.getString("userdept");
				String userRole = rs.getString("USERROLE");
				String userEmail = rs.getString("usermail");
				
				map.put("userNo", userNo);
				map.put("userId", userId);
				map.put("userNm", userNm);
				map.put("userDept", userDept);
				map.put("userRole", userRole);
				map.put("userEmail", userEmail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		return map;
	}
}
