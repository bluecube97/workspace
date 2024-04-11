package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.board.vo.boardVO;

public class boardDAO {
	public List<boardVO> getBoardList(String skey, String add_sql, int page) {
		List<boardVO> list = new ArrayList<boardVO>();

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			ResultSet rs = null;
			
			int start_page = (page - 1) * 10;

			String sql = " SELECT tb.BRDNO AS brdno, tb.BRDTITLE AS brdtitle, tb.USERNO AS userno, cu.USERNM AS usernm, tb.BRDDATE AS brddate "
					+ " FROM tbl_board tb "
					+ "         INNER JOIN com_user cu ON tb.USERNO = cu.USERNO "
					+ " WHERE tb.BRDDELETEFLAG = 'N' ";

			sql += add_sql;
			sql += " LIMIT " + start_page + ", " + 10;
			
			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int brdNo = rs.getInt(1);
				String brdTitle = rs.getString(2);
				int userNo = rs.getInt(3);
				String userNm = rs.getString(4);
				Date brdDate = rs.getDate(5);

				boardVO bv = new boardVO(brdNo, brdTitle, userNo, userNm, brdDate);

				list.add(bv);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boardVO getBoardDetail(String brdNo) {
		boardVO bv = new boardVO();

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			ResultSet rs = null;

			String sql = " SELECT cu.USERNM AS usernm, tb.BRDTITLE AS brdtitle, tb.BRDDATE AS brddate, tb.BRDMEMO AS brdmemo "
					+ " FROM tbl_board tb " + " INNER JOIN com_user cu ON cu.USERNO = tb.USERNO " + " AND tb.BRDNO = ? "
					+ " WHERE tb.BRDDELETEFLAG = 'N'";

			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement psmt = con.prepareStatement(sql);

			int bno = Integer.parseInt(brdNo);
			psmt.setInt(1, bno);

			rs = psmt.executeQuery();

			if (rs.next()) {
				bv.setUserNm(rs.getString("usernm"));
				bv.setBrdTitle(rs.getString("brdtitle"));
				bv.setBrdDate(rs.getDate("brddate"));
				bv.setBrdMemo(rs.getString("brdmemo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bv;
	}

	public int getBoardCount(String add_sql, String skey) {
		int count = 0;

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);

			ResultSet rs = null;

			String sql = " SELECT count(*)as cnt "
					+ " FROM tbl_board tb "
					+ "         INNER JOIN com_user cu ON cu.USERNO = tb.USERNO "
					+ " WHERE tb.BRDDELETEFLAG = 'N' ";

			sql += add_sql;
			
			Connection con = DriverManager.getConnection(url, id, pass);
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

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
