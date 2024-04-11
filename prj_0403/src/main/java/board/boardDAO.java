package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class boardDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public List<HashMap<String, Object>> getBoardList(String skey, String addSql, String soption) {
		List<HashMap<String, Object>> hashList = new ArrayList<HashMap<String,Object>>();
		
		String sql = " SELECT tb.BRDNO as brdno, tb.BRDTITLE as brdtitle, "
				+ "	tb.USERNO as userno, cu.USERNM as usernm, tb.BRDDATE as brddate " + "   FROM TBL_BOARD tb "
				+ " INNER JOIN COM_USER cu ON cu.USERNO = tb.USERNO " + "  WHERE tb.BRDDELETEFLAG ='N' ";
		
		try {
			sql = sql + addSql;

			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);
			psmt = con.prepareStatement(sql);

			psmt.setString(1, "%" + skey + "%");
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> hash = new HashMap<String, Object>();
				
				int brdNo = rs.getInt("brdno");
				String brdTitle = rs.getString("brdTitle");
				int userNo = rs.getInt("userno");
				String userNm = rs.getString("usernm");
				Date brdDate = rs.getDate("brddate");
				
				hash.put("brdNo", brdNo);
				hash.put("brdTitle", brdTitle);
				hash.put("userNo", userNo);
				hash.put("userNm", userNm);
				hash.put("brdDate", brdDate);
				hash.put("skey", skey);
				hash.put("soption", soption);
				
				hashList.add(hash);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hashList;
	}

}
