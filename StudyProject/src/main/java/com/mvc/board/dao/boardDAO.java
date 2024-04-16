package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mvc.board.vo.BoardSearchVo;
import com.mvc.board.vo.boardRegeditVO;
import com.reference.connection.JDBCUtill;
import com.reference.connection.connectionProvider;

public class boardDAO {

	private static boardDAO bd = new boardDAO();

	public static boardDAO bd() {
		return bd;
	}

	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 검색 조건에 따른 글 목록
	public List<HashMap<String, Object>> getBoardList(BoardSearchVo bv) {
		List<HashMap<String, Object>> blist = new ArrayList<HashMap<String, Object>>();

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

				blist.add(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		return blist;
	}

	// 글목록 갯수 pagging 처리 10개로 끊음
	public int getBoardListCount(BoardSearchVo bv) {
		int count = 0;

		String sql = "SELECT count(*) as cnt" + "   FROM TBL_BOARD tb "
				+ "	 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";

		if (bv.getDynamicSql() != null) {
			sql = sql + bv.getDynamicSql();
		}

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + bv.getKeyword() + "%");
			rs = psmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		return count;
	}

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

	// 마지막으로 저장된 나의 글 번호 조회
	public int getMyContentNo(boardRegeditVO bv, HttpServletResponse resp) {
		int brdNo = 0;

		String sql = " select tb.BRDNO as brdno " + " from tbl_board tb " + " where tb.USERNO = ? "
				+ "  and tb.BRDDELETEFLAG = 'N' " + " order by tb.BRDDATE desc " + " limit 1 ";

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

	public void deleteContents(String brdNo) {
		String sql = " delete from tbl_board " + " where BRDNO = ? ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(brdNo));

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}

	}

	public int getMyReadListChk(String brdNo, int userNo) {
		String sql = " select COUNT(*) "
				+ " FROM com_read_list "
				+ " WHERE BRDNO = ? "
				+ "  AND USERNO = ?";
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(brdNo));
			psmt.setInt(2, userNo);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}

		return 0;
	}

	public void updateMyReadList(String brdNo, int userNo) {
		String sql = " update com_read_list "
				+ " set READCNT = READCNT + 1, LASTREADATE = now() "
				+ " where BRDNO = ? "
				+ "  and USERNO = ?";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(brdNo));
			psmt.setInt(2, userNo);

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}
	}

	public void insertMyReadList(String brdNo, int userNo) {
		String sql = "insert into com_read_list (USERNO, BRDNO, READCNT, LASTREADATE) "
				+ "VALUES (?, ?, 1, now())";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userNo);
			psmt.setInt(2, Integer.parseInt(brdNo));

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}

	}

	public List<HashMap<String, Object>> getMyReadList(int userNo) {
		String sql = " select crl.BRDNO as brdno, tb.BRDTITLE as brdtitle, tb.BRDMEMO as brdmemo, crl.LASTREADATE as lastreadate "
				+ " from com_read_list crl "
				+ " inner join tbl_board tb "
				+ " where crl.USERNO = ? and crl.BRDNO = tb.BRDNO"
				+ " order by crl.LASTREADATE desc "
				+ " limit 5 ";
		
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				int brdNo = rs.getInt("brdno");
				String brdTitle = rs.getString("brdtitle");
				String brdMemo = rs.getString("brdmemo");
				Date lastReadDate = rs.getDate("lastreadate");
				
				map.put("brdno", brdNo);
				map.put("brdtitle", brdTitle);
				map.put("brdmemo", brdMemo);
				map.put("lastreadate", lastReadDate);
				map.put("userno", userNo);
				
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

	public void addReadCnt(String brdNo) {
		String sql = " update tbl_board "
				+ " set HIT = HIT + 1 "
				+ " where BRDNO = ? ";

		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(brdNo));

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
		}
		
	}
}
