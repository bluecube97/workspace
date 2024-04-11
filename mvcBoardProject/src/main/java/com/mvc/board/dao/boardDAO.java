package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mvc.connection.ConnectionProvider;
import com.mvc.connection.JDBCUtil;

public class boardDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public List<HashMap<String, Object>> getBoardList() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String sql = " SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
				+ "	tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate " + "   FROM TBL_BOARD tb "
				+ " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				int brdNo = rs.getInt("brdno");
				String brdTitle = rs.getString("brdTitle");
				int userNo = rs.getInt("userno");
				String userNm = rs.getString("usernm");
				Date brdDate = rs.getDate("brddate");

				map.put("brdNo", brdNo);
				map.put("brdTitle", brdTitle);
				map.put("userNo", userNo);
				map.put("userNm", userNm);
				map.put("brdDate", brdDate);

				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(rs);
			JDBCUtil.close(psmt);
		}

		return list;
	}

	public HashMap<String, Object> getBoardDetail(String brdNo_) {
		int brdNo = Integer.parseInt(brdNo_);
		HashMap<String, Object> map = new HashMap<String, Object>();

		String sql = " SELECT cu.USERNO AS userno, cu.USERNM AS usernm, tb.BRDTITLE AS brdtitle, tb.BRDDATE AS brddate, tb.BRDMEMO AS brdmemo "
				+ " FROM TBL_BOARD tb  " + " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + " WHERE tb.BRDNO = ?  "
				+ " AND tb.BRDDELETEFLAG = 'N' ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, brdNo);

			rs = psmt.executeQuery();

			if (rs.next()) {
				map.put("userno", rs.getInt("userno"));
				map.put("usernm", rs.getString("usernm"));
				map.put("brdtitle", rs.getString("brdtitle"));
				map.put("brddate", rs.getDate("brddate"));
				map.put("brdmemo", rs.getString("brdmemo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}

		return map;

	}

	public List<HashMap<String, Object>> getCommentList(String brdNo_) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		String sql = " SELECT COMMENTTITLE as commenttitle, COMMENTMEMO as commentmemo, USERNO as userno, COMMENTDATE as commentdate "
				+ " FROM tbl_board_comment "
				+ " WHERE BRDNO = ? ";

		int brdNo = Integer.parseInt(brdNo_);
		
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, brdNo);

			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("commenttitle", rs.getString("commenttitle"));
				map.put("commentmemo", rs.getString("commentmemo"));
				map.put("userno", rs.getInt("userno"));
				map.put("commentdate", rs.getDate("commentdate"));
				
				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(rs);
			JDBCUtil.close(psmt);
		}

		return list;
	}

//	public List<HashMap<String, Object>> getReplyList(String brdNo) {
//		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//
//		String sql = "";
//
//		try {
//			con = ConnectionProvider.getConnection();
//			psmt = con.prepareStatement(sql);
//
//			rs = psmt.executeQuery();
//
//			while (rs.next()) {
//				HashMap<String, Object> map = new HashMap<String, Object>();
//
//				list.add(map);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(con);
//			JDBCUtil.close(rs);
//			JDBCUtil.close(psmt);
//		}
//
//		return list;
//	}

}
