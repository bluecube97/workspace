package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionProvider;
import com.connection.JDBCUtil;
import com.user.vo.UserVO;

public class UserDaoImpl implements UserDao {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public UserVO getLoginCheck(UserVO uv) {
		UserVO uvo = null;		
		
		String sql = "SELECT cu.USERNO as USERNO, cu.USERID as USERID, "
				+ "       cu.USERNM as USERNM,  "
				+ "       (CASE "
				+ "           WHEN cu.USERROLE = 'A' "
				+ "            THEN '관리자' "
				+ "           WHEN cu.USERROLE = 'U' "
				+ "            THEN '사용자' "
				+ "       END)AS USERROLE, "
				+ "       (CASE  "
				+ "            WHEN cu.DEPTNO = 1 "
				+ "             THEN '사장실' "
				+ "            WHEN cu.DEPTNO = 2 "
				+ "             THEN '인사팀' "
				+ "            WHEN cu.DEPTNO = 3 "
				+ "             THEN '영업1팀' "
				+ "            WHEN cu.DEPTNO = 4 "
				+ "             THEN '영업2팀' "
				+ "            WHEN cu.DEPTNO = 5 "
				+ "             THEN '개발팀' "
				+ "            WHEN cu.DEPTNO = 6 "
				+ "             THEN '자재팀' "
				+ "       END) as USERDEPT  "
				+ "  FROM COM_USER cu "
				+ " where cu.USERID = ?   "
				+ "   and cu.USERPW = ? "
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
				
				uvo = new UserVO(userNo,userId,userNm,userRole,userDept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		return uvo;
	}

	@Override
	public List<UserVO> getUserList(String skey, String addSql, int page) {
		List<UserVO>ulist = new ArrayList<UserVO>();

		String sql = " select cu.USERNO as userno, cu.USERNM as usernm, cu.USERID as userid "
				+ "  from COM_USER cu " ;

		try {
			int start_page=((page-1)*10);
			String pageSql = " LIMIT " + start_page +","+ 10;
			sql = sql+addSql+pageSql;
			
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, "%" + skey + "%");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int userNo = rs.getInt(1);
				String userNm = rs.getString(2);
				String userRole =rs.getString(3);
			
				UserVO uv = new UserVO(userNo, userNm,  userRole);
				ulist.add(uv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		return ulist;
	}
	@Override
	public int getBoardCount(String skey, String addSql) {
		int count = 0;
		String sql = " SELECT COUNT(*) AS CNT "
				+ "  from COM_USER cu " ;
		
		try {
			
			sql = sql+addSql;
			
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, "%" + skey + "%");
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		
		return count;
	}
}
