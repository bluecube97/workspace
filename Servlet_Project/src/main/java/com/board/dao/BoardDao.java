package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.board.vo.BoardVO;
import com.connection.ConnectionProvider;
import com.connection.JdbcUtil;

public class BoardDao {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public List<BoardVO> getBoardList(String addSql, String skey, int page) {
		List<BoardVO> blist = new ArrayList<BoardVO>();

		try {
			int start_page = ((page - 1) * 10);

			String pageSql = "LIMIT " + start_page + " , " + 10;

			String sql = " SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
					+ " 					tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate "
					+ "		 FROM TBL_BOARD tb " + "		 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO"
					+ "		WHERE tb.BRDDELETEFLAG ='N'";

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
		}
		return blist;
	}

	public BoardVO getBoardDetail(String brdNo) {

		BoardVO bv = new BoardVO();
		try {
			String sql = "SELECT cu.USERNM as usernm, tb.BRDTITLE as brdtitle, tb.BRDDATE as brddate, tb.BRDMEMO as brdmemo "
					+ "  FROM TBL_BOARD tb " + " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
					+ " WHERE tb.BRDNO = ?  " + "   AND tb.BRDDELETEFLAG ='N' ";

			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
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

	public int getBoardCount(String addSql, String skey) {
		int count = 0;

		try {
			String sql = " SELECT COUNT(*) AS CNT " + "		 FROM TBL_BOARD tb "
					+ "		 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO" + "		WHERE tb.BRDDELETEFLAG ='N'";

			sql = sql + addSql;

			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

			rs = psmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("CNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<HashMap<String, Object>> getReplyList(String brdNo) {
		List<HashMap<String, Object>> rlist = new ArrayList<HashMap<String, Object>>();
		try {

			String sql = " select tr.REPLYNO as replyno, tr.PREPLYNO as preplyno, tr.REPLYNOTE as replynote,"
					+ " 		tr.BRDDATE as brddate " + "   from TBL_REPLY tr " + "  where tr.BRDNO = ? "
					+ "    and tr.DELFLAG = 'N' " + "    order by REPLYNO asc ";

			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			int brdno = Integer.parseInt(brdNo);
			psmt.setInt(1, brdno);

			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("replyno", rs.getInt("replyno"));
				map.put("preplyno", rs.getInt("preplyno"));
				map.put("replynote", rs.getString("replynote"));
				map.put("brddate", rs.getDate("brddate"));
				rlist.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rlist;
	}

	public int insertReply(HashMap<String, Object> map) {
		int result = 0;

		String sql = " INSERT INTO tbl_reply (BRDNO, REPLYNOTE, USERNO, BRDDATE, LASTDATE) "
				+ " VALUES (?, ?, (SELECT cu.userno " + "                   FROM com_user cu "
				+ "                   WHERE cu.USERID = ? " + "                   LIMIT 1), now(), now()) ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			String brdNo_ = (String) map.get("brdNo");
			int brdNo = Integer.parseInt(brdNo_);
			String replyment = (String) map.get("replyment");
			String userId = (String) map.get("userId");

			psmt.setInt(1, brdNo);
			psmt.setString(2, replyment);
			psmt.setString(3, userId);

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
			JdbcUtil.close(rs);
			JdbcUtil.close(psmt);
		}
		return result;
	}
}
