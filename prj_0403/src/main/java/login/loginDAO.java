package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public int getLoginChk(loginVO lv) {
		String sql = " SELECT USERID, USERPW " + " from com_user ";

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();

			String chkId = lv.getUserId();
			String chkPw = lv.getUserPw();
			
			while (rs.next()) {
				String userId = rs.getString("USERID");
				String userPw = rs.getString("USERPW");
				
				if (userId.equals(chkId) && userPw.equals(chkPw)) {
					return 1;
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
