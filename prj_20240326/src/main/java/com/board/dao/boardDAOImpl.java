package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.board.vo.boardVO;
import com.reference.connection.JDBCUtill;
import com.reference.connection.connectionProvider;
import com.user.vo.userVO;

public class boardDAOImpl implements boardDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public List<boardVO> getBoardList(String skey, String addSql, int page) {
		List<boardVO> list = new ArrayList<>();

		int start_page = ((page - 1) * 10);
		String pageSql = " LIMIT " + start_page + ", 10";

		String sql = " SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
				+ "	tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate " + "   FROM TBL_BOARD tb "
				+ " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";
		try {
			sql = sql + addSql + pageSql;

			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

			rs = psmt.executeQuery();

			while (rs.next()) {
				int brdNo = rs.getInt("brdno");
				String brdTitle = rs.getString("brdTitle");
				int userNo = rs.getInt("userno");
				String userNm = rs.getString("usernm");
				Date brdDate = rs.getDate("brddate");

				boardVO bv = new boardVO(brdNo, brdTitle, userNo, userNm, brdDate);

				list.add(bv);
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
	public int boardRegidit(int userNo, String brdTitle, String brdMemo) {
		String sql = " insert into TBL_BOARD (BGNO, BRDTITLE, USERNO, BRDMEMO, BRDDATE, LASTDATE, LASTUSERNO, BRDDELETEFLAG) "
				   + " VALUES (3, ?, ?, ?, now(), now(), ?, 'N') ";
		int result = 0;

		System.out.println("no: " + userNo);
		System.out.println("title: " + brdTitle);
		System.out.println("memo: " + brdMemo);
		
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			// rs = psmt.executeQuery();
			
			psmt.setString(1, brdTitle);
			psmt.setInt(2, userNo);
			psmt.setString(3, brdMemo);
			psmt.setInt(4, userNo);
			
			
			// 실행 결과 (insert row 갯수)를 반환한다.
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		
		return result;
	}

	@Override
	public boardVO getBoardDetail(String brdNo) {
		boardVO bv = new boardVO();
		int bno = Integer.parseInt(brdNo);
		
		String sql = " SELECT cu.USERNO AS userno, cu.USERNM AS usernm, tb.BRDTITLE AS brdtitle, tb.BRDDATE AS brddate, tb.BRDMEMO AS brdmemo "
				   + " FROM TBL_BOARD tb  "
				   + " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
				   + " WHERE tb.BRDNO = ?  "
				   + " AND tb.BRDDELETEFLAG = 'N' ";
		
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, bno);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				bv.setUserNo(rs.getInt("userno"));
				bv.setUserNm(rs.getString("usernm"));
				bv.setBrdTitle(rs.getString("brdtitle"));
				bv.setBrdDate(rs.getDate("brddate"));
				bv.setBrdMemo(rs.getString("brdmemo"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		
		return bv;
	}

	@Override
	public int getBoardCount(String skey, String addSql) {
		int cnt = 0;
		
		String sql = " SELECT COUNT(*) AS CNT "
		           + " FROM TBL_BOARD tb "
				   + " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
		           + " WHERE tb.BRDDELETEFLAG ='N' ";
		
		try {
			sql += addSql;
			
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");

			rs = psmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		
		return cnt;
	}

	@Override
	public int getLastBoardNo(int userNo) {
		String sql = " SELECT max(tb.BRDNO) as brdno "
				   + " FROM tbl_board tb "
				   + " WHERE tb.USERNO = ? ";
		
		// 반환값 초기화
		int brdNo = 0;
		
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setInt(1, userNo);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				brdNo = rs.getInt(1);
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
	public int boardUpdate(userVO uv, String brdTitle, String brdMemo, int brdNo) {
		String sql = " UPDATE tbl_board "
				   + " SET BRDTITLE   = ?, "
			   	   + "     BRDMEMO    = ?, "
				   + "     LASTUSERNO = ?, "
				   + "     LASTDATE   = NOW() "
				   + " WHERE BRDNO = ? ";
		int result = 0;
		
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, brdTitle);
			psmt.setString(2, brdMemo);
			psmt.setInt(3, uv.getUserNo());
			psmt.setInt(4, brdNo);
			
			// 실행 결과 (insert row 갯수)를 반환한다.
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(con);
			JDBCUtill.close(psmt);
			JDBCUtill.close(rs);
		}
		
		return result;
	}

	@Override
	public void boardDelete(int brdNo) {
		String sql = " UPDATE TBL_BOARD SET BRDDELETEFLAG='Y' "
				   + " WHERE BRDNO = ? ";
		
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
			JDBCUtill.close(rs);
		}
	}

}