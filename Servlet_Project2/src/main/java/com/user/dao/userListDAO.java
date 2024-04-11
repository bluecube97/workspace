package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.vo.userListVO;
import com.user.vo.userVO;

public class userListDAO {

	public List<userListVO> getUserList(userListVO ulv, String ulskey, String add_sql, int upage) {
		List<userListVO> list = new ArrayList<userListVO>();
		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			ResultSet rs = null;
			
			int start_page = (upage - 1) * 10;

			String sql = " SELECT userno, usernm, userrole "
			+ " FROM com_user ";

			sql += add_sql;
			sql += " LIMIT " + start_page + ", " + 10;

			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement psmt = con.prepareStatement(sql);

			if (!ulskey.equals("")) {
				psmt.setString(1, "%" + ulskey + "%");
			} else if (!ulskey.equals(null)) {
				psmt.setString(1, "%" + ulskey + "%");
			} else {
				psmt.setString(1, "%%");
			}

			rs = psmt.executeQuery();
			while (rs.next()) {
				ulv = new userListVO();
				ulv.setUserNo(rs.getInt("userno"));
				ulv.setUserNm(rs.getString("usernm"));
				ulv.setUserRole(rs.getString("userrole"));

				list.add(ulv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getUserCount(String add_sql, String ulskey) {
		int count = 0;

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			ResultSet rs = null;

			String sql = " SELECT count(*)as cnt "
					+ " FROM com_user ";

			sql += add_sql;
			
			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + ulskey + "%");

			rs = psmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
