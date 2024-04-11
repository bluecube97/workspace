package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.board.vo.BoardVO;
import com.connection.ConnectionProvider;
import com.connection.JDBCUtil;
import com.session.vo.SessionVO;

public class BoardDaoImpl implements BoardDao {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public List<BoardVO> getBoardList(String skey, String addSql, int page) {
		List<BoardVO> blist = new ArrayList<BoardVO>();

		int start_page = ((page - 1) * 10);
		String pageSql = " LIMIT " + start_page + ", 10";

		String sql = " SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
				+ "	tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate " + "   FROM TBL_BOARD tb "
				+ " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";
		try {
			sql = sql + addSql + pageSql;

			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

			rs = psmt.executeQuery();

			while (rs.next()) {
				int brdNo = rs.getInt(1);
				String brdTitle = rs.getString(2);
				int userNo = rs.getInt(3);
				String userNm = rs.getString(4);
				Date brdDate = rs.getDate(5);

				BoardVO bv = new BoardVO(brdNo, brdTitle, userNo, userNm, brdDate);

				blist.add(bv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		return blist;
	}

	public BoardVO getBoardDetail(String brdNo) {

		BoardVO bv = new BoardVO();
		int bno = Integer.parseInt(brdNo);

		String sql = " SELECT  cu.USERNM  AS usernm, tb.BRDTITLE AS brdtitle, tb.BRDDATE AS brddate, tb.BRDMEMO AS brdmemo "
				+ "     FROM TBL_BOARD tb  " + " 	INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO  "
				+ " 	WHERE tb.BRDNO = ?  " + " 	  AND tb.BRDDELETEFLAG = 'N' ";
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

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
		} finally {
			JDBCUtil.close(con);
			JDBCUtil.close(psmt);
			JDBCUtil.close(rs);
		}
		return bv;
	}

	public int getBoardCount(String skey, String addSql) {
		// TODO Auto-generated method stub
		int count = 0;

		String sql = "  SELECT COUNT(*) AS CNT" + "   FROM TBL_BOARD tb "
				+ "  INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";
		try {
			sql = sql + addSql;

			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

			rs = psmt.executeQuery();

			if (rs.next()) {
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