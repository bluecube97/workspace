package study_data_change;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SDCHASH {
	public List<HashMap<String, Object>> changeInfo(){
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT id , journal_nm , issn , eissn , factor "
				   + "	 FROM journal_impact_temp ";
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> sdcMap = new HashMap<>();
				
				sdcMap.put("id", rs.getInt("id"));
				sdcMap.put("journal_nm", rs.getString("journal_nm"));
				// sdcMap.put("issn", rs.getString("issn"));
				sdcMap.put("issn", "");
				if(rs.getString("eissn").equals("")) {
					sdcMap.put("eissn", rs.getString("issn"));
				}
				//sdcMap.put("eissn", rs.getString("eissn"));
				sdcMap.put("factor", Float.valueOf(rs.getString("factor")) / 100);
				
				list.add(sdcMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
