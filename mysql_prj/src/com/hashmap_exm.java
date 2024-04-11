package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hashmap_exm {
	public List<HashMap<String, Object>> userInfo() {
		Connection con = null;
		PreparedStatement psmt = null; 
		ResultSet rs = null;

		String sql = " SELECT USERNO, USERID, USERNM "
		+ "	FROM COM_USER ";

		List<HashMap<String, Object>> list = new ArrayList<>();

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				HashMap<String, Object> userMap = new HashMap<>();
				
				userMap.put("userNo", rs.getInt("USERNO"));
				userMap.put("userId", rs.getString("USERID"));
				userMap.put("userName", rs.getString("USERNM"));
				list.add(userMap);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
}
