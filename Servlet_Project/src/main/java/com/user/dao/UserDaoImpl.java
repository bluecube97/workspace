package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionProvider;
import com.connection.JdbcUtil;
import com.user.vo.UserVO;


public class UserDaoImpl implements UserDao {

	@Override
	public UserVO getLoginCheck(UserVO uv) {
		UserVO uvo = null;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cu.USERNO as USERNO, cu.USERID as USERID, "
				+ "	   cu.USERNM as USERNM,  "
				+ "	   (CASE "
				+ "	   	WHEN cu.USERROLE = 'A' "
				+ "	   	 THEN '관리자'"
				+ "	   	WHEN cu.USERROLE = 'U' "
				+ "	   	 THEN '사용자' "
				+ "	   END)AS USERROLE, "
				+ "	   (CASE "
				+ "	   	 WHEN cu.DEPTNO = 1 "
				+ "	   	  THEN '사장실' "
				+ "	   	 WHEN cu.DEPTNO = 2 "
				+ "	   	  THEN '인사팀'"
				+ "	   	 WHEN cu.DEPTNO = 3 "
				+ "	   	  THEN '영업1팀' "
				+ "	   	 WHEN cu.DEPTNO = 4 "
				+ "	   	  THEN '영업2팀' "
				+ "	   	 WHEN cu.DEPTNO = 5 "
				+ "	   	  THEN '개발팀' "
				+ "	   	 WHEN cu.DEPTNO = 6 "
				+ "	   	  THEN '자재팀' "
				+ "	   END) as USERDEPT "
				+ "  FROM COM_USER cu "
				+ " WHERE cu.USERID = ? "
				+ "   AND cu.USERPW = ? "
				+ " LIMIT 1 ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			String pid = uv.getUserId();
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
				
				uvo = new UserVO(userNo, userId, userNm, userRole, userDept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
			JdbcUtil.close(psmt);
			JdbcUtil.close(rs);
		}
		return uvo;
	}
	
	public List<UserVO> getUserList(String nmkey, int page) {
		List<UserVO> ulist = new ArrayList<UserVO>();
		
		UserVO uvo = null;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		int start_page = ((page - 1) * 10);
		String pagesql = "LIMIT " + start_page + "," + 10;
		String sql = " select cu.USERNO as userno, cu.USERNM as usernm, cu.USERROLE as userrole "
					+ "  from COM_USER cu "
					+ " where cu.DELETEFLAG = 'N' "
					+ "  and cu.USERNM like ? ";

		sql = sql + pagesql;

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + nmkey + "%");

			rs = psmt.executeQuery();
			while (rs.next()) {
				int userNo = rs.getInt("userno"); // rs.getInt(1); 가능
				String userNm = rs.getString("usernm"); // rs.getString(2);
				String userRole = rs.getString("userrole");

				UserVO bv = new UserVO(userNo, userNm, userRole);

				ulist.add(bv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
			JdbcUtil.close(psmt);
			JdbcUtil.close(rs);
		}
		return ulist;
	}

	public int getUserCount(String nmkey) {
		int count = 0;
		
		UserVO uvo = null;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = " select  COUNT(*) AS CNT "
					+ "  from COM_USER cu "
					+ " where cu.DELETEFLAG = 'N' "
					+ "  and cu.USERNM like ? ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + nmkey + "%");

			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
			JdbcUtil.close(psmt);
			JdbcUtil.close(rs);
		}
		return count;
	}
}
