package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mvc.board.vo.BoardSearchVo;
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

		int start_page = ((bv.getPage()-1)*10); // 시작 페이지 (3페이지에 있을 경우 3-1 * 10)
		
        String pageSql="LIMIT " + start_page + " , " + 10;
        
        String sql = "SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
				+ " tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate, tb.HIT as hit "
				+ "   FROM TBL_BOARD tb "
				+ "	 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
				+ "  WHERE tb.BRDDELETEFLAG ='N' ";
        
        sql = sql + bv.getDynamicSql() + pageSql;
        
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + bv.getKeyword() + "%");
			rs = psmt.executeQuery();
			System.out.println("List의 sql = " + sql);
			
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();

				map.put("brdno", rs.getInt("brdno"));
				map.put("brdtitle", rs.getString("brdtitle"));
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
		
		String sql = "SELECT count(*) as cnt"
				+ "   FROM TBL_BOARD tb " + "	 INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO "
				+ "  WHERE tb.BRDDELETEFLAG ='N' ";
		
		if (bv.getDynamicSql() != null) {
			sql = sql + bv.getDynamicSql();
		}
		
		try {
			con = connectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + bv.getKeyword() + "%");
			System.out.println("ListCount의 sql = " + sql);
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
}
