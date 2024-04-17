package com.mvc.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.reference.connection.JDBCUtill;
import com.reference.connection.connectionProvider;

public class userDAOImpl implements userDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public void insertReadList(HttpSession session, String brdNo) {
		String sql = "insert into tb_checkboard (USERNO, BRDNO) "
				+ " values (?, ?) ";

		HashMap<String, Object> map = (HashMap<String, Object>) session.getAttribute("userMap");
		int userNo = (int) map.get("userno");
		int brdNo_ = Integer.parseInt(brdNo);
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, userNo);
			psmt.setInt(2, brdNo_);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
	}

	@Override
	public HashMap<String, Object> getLoginCheck(String id, String password) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();

		String sql = " SELECT cu.USERNO as userno, cu.USERID as userid, "
				+ "	cu.USERNM as usernm, "
				+ " (CASE "
				+ " WHEN cu.USERROLE = 'A' "
				+ "	THEN '관리자' "
				+ " WHEN cu.USERROLE = 'U' "
				+ "	THEN '사용자' "
				+ " END)AS userrole, "
				+ " (CASE "
				+ " WHEN cu.DEPTNO = 1 "
				+ " THEN '사장실' "
				+ " WHEN cu.DEPTNO = 2 "
				+ " THEN '인사팀' "
				+ " WHEN cu.DEPTNO = 3 "
				+ " THEN '영업1팀' "
				+ " WHEN cu.DEPTNO = 4 "
				+ " THEN '영업2팀' "
				+ " WHEN cu.DEPTNO = 5 "
				+ " THEN '개발팀' " + " WHEN cu.DEPTNO = 6 "
				+ " THEN '자재팀' "
				+ " END) as userdept, "
				+ " cu.USEREMAIL as useremail "
				+ " FROM COM_USER cu "
				+ " where cu.USERID = ? "
				+ " and cu.USERPW = sha2(?, 256) "
				+ " LIMIT 1 ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, password);

			rs = psmt.executeQuery();

			if (rs.next()) {
				int userNo = rs.getInt("userno");
				String userId = rs.getString("userid");
				String userNm = rs.getString("usernm");
				String userRole = rs.getString("userrole");
				String userDept = rs.getString("userdept");
				String userEmail = rs.getString("useremail");

				userMap.put("userno", userNo);
				userMap.put("userid", userId);
				userMap.put("usernm", userNm);
				userMap.put("userrole", userRole);
				userMap.put("userdept", userDept);
				userMap.put("useremail", userEmail);
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}

		return userMap;
	}

}
