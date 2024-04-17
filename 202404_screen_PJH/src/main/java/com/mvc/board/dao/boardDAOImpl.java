package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mvc.board.vo.boardRegeditVO;
import com.mvc.board.vo.boardSearchVO;
import com.reference.connection.JDBCUtill;
import com.reference.connection.connectionProvider;

public class boardDAOImpl implements boardDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public List<HashMap<String, Object>> getBoardList(boardSearchVO bv) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		int start_page = ((bv.getPage() - 1) * 10); // 시작 페이지 (3페이지에 있을 경우 3-1 * 10)

		String pageSql = "LIMIT " + start_page + " , " + 10;

		String sql = "SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, tb.BRDMEMO as brdmemo, "
				+ " tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate, tb.HIT as hit "
				+ "   FROM TBL_BOARD tb " + "	 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
				+ "  WHERE tb.BRDDELETEFLAG ='N' ";

		sql = sql + bv.getDynamicSql() + pageSql;

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + bv.getKeyword() + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				map.put("brdno", rs.getInt("brdno"));
				map.put("brdtitle", rs.getString("brdtitle"));
				map.put("brdmemo", rs.getString("brdmemo"));
				map.put("userno", rs.getInt("userno"));
				map.put("usernm", rs.getString("usernm"));
				map.put("brddate", rs.getDate("brddate"));
				map.put("hit", rs.getInt("hit"));

				list.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		return list;
	}

	@Override
	public int getBoardListCnt(boardSearchVO bv) {
		int cnt = 0;

		String sql = "SELECT count(*) as cnt " + " FROM TBL_BOARD tb "
				+ "	INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + " WHERE tb.BRDDELETEFLAG ='N' ";

		if (bv.getDynamicSql() != null) {
			sql += bv.getDynamicSql();
		}

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + bv.getKeyword() + "%");
			rs = psmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(rs);
			JDBCUtill.close(psmt);
			JDBCUtill.close(con);
		}

		return cnt;
	}

	@Override
	public List<HashMap<String, Object>> getTodaysList(int userNo) {
		List<HashMap<String, Object>> rlist = new ArrayList<HashMap<String, Object>>();

		String sql = "SELECT DISTINCT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, cu.USERNO as userno, cu.USERNM as usernm, cu.USERID as userid "
				+ "FROM TBL_BOARD tb "
				+ "INNER JOIN tb_checkboard tc ON tc.BRDNO = tb.BRDNO "
				+ "INNER JOIN COM_USER cu ON cu.USERNO = tc.USERNO "
				+ "WHERE tc.USERNO = ? "
				+ "  and date_format(tc.READDATE, '%Y%m%D') = date_format(now(), '%Y%m%D') "
				+ "GROUP BY tb.BRDNO, tb.BRDTITLE, cu.USERNO, cu.USERNM, cu.USERID "
				+ "ORDER BY MAX(tc.READDATE) desc limit 10";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				map.put("brdno", rs.getInt("brdno"));
				map.put("brdtitle", rs.getString("brdtitle"));
				map.put("userno", rs.getInt("userno"));
				map.put("usernm", rs.getString("usernm"));
				map.put("userid", rs.getString("userid"));

				rlist.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		return rlist;
	}

	@Override
	public void increaseHit(int brdNo) {
		String sql = "update tbl_board  set HIT = HIT + 1 " + " where BRDNO = ? ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, brdNo);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}

	}

	@Override
	public HashMap<String, Object> getBoardDetail(String brdNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		String sql = " select tb.USERNO as userno, cu.USERNM as usernm, tb.BRDTITLE as brdtitle, tb.BRDMEMO as brdmemo, tb.BRDDATE as brddate "
				+ " from tbl_board tb " + " inner join com_user cu on tb.USERNO = cu.USERNO " + " where tb.BRDNO = ? ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(brdNo));
			rs = psmt.executeQuery();

			if (rs.next()) {
				int userNo = rs.getInt("userno");
				String userNm = rs.getString("usernm");
				String brdTitle = rs.getString("brdtitle");
				String brdMemo = rs.getString("brdmemo");
				Date brdDate = rs.getDate("brddate");

				map.put("userno", userNo);
				map.put("usernm", userNm);
				map.put("brdtitle", brdTitle);
				map.put("brdmemo", brdMemo);
				map.put("brddate", brdDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}

		return map;
	}

	@Override
	public void regeditContents(boardRegeditVO bv) {
		String sql = " insert into TBL_BOARD (BGNO, BRDTITLE, USERNO, BRDMEMO, BRDDATE, LASTDATE, LASTUSERNO, BRDDELETEFLAG) "
				 + "	VALUES (3, ?, ?, ?, now(), now(), ?, 'N') ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, bv.getBrdTitle());
			psmt.setInt(2, bv.getUserNo());
			psmt.setString(3, bv.getBrdMemo());
			psmt.setInt(4, bv.getUserNo());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}

	}

	@Override
	public int getMyContentNo(boardRegeditVO bv, HttpServletResponse resp) {
		int brdNo = 0;

		String sql = " select tb.BRDNO as brdno "
				+ " from tbl_board tb "
				+ " where tb.USERNO = ? "
				+ "  and tb.BRDDELETEFLAG = 'N' "
				+ " order by tb.BRDDATE desc "
				+ " limit 1 ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, bv.getUserNo());
			rs = psmt.executeQuery();

			if (rs.next()) {
				brdNo = rs.getInt("brdno");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		return brdNo;
	}

	@Override
	public void updateContents(String brdTitle, String brdMemo, String brdNo) {
		String sql = " UPDATE tbl_board " + " set BRDTITLE = ?, BRDMEMO = ?, LASTDATE = now() " + " where BRDNO = ? ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, brdTitle);
			psmt.setString(2, brdMemo);
			psmt.setInt(3, Integer.parseInt(brdNo));

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}
		
	}

}
