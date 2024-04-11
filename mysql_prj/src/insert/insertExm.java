package insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

public class insertExm {
	public void insertInfo(HashMap<String, Object> insertMap) {
		Connection con = null;
		PreparedStatement psmt = null; 

		String sql = " INSERT INTO com_user (USERID, USERNM, USERPW) "
				   + "      values (?, ?, ?) ";

		try {
			//HashMap<String, Object> insertMap = insertList;
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, insertMap.get("userId").toString());
			psmt.setString(2, insertMap.get("userNm").toString());
			psmt.setString(3, insertMap.get("userPw").toString());
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		
	}

}
