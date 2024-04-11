package signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class signupDAO {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public int IdCheck(String id) {
		int result = 0;
		String sql = " SELECT count(USERID) as cnt " + " FROM com_user " + " WHERE USERID = ? ";

		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbid = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, dbid, pass);
			psmt = con.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void SignUp(String id, String name, String gender, String pw, String email) {
		String sql = " INSERT INTO com_user (USERID, USERNM, USERGENDER, USERPW, USEREMAIL) "
				+ " VALUES (?, ?, ?, SHA2(?, 256), ?) ";
		System.out.println("dao-" + id + "-" + name + "-" + gender + "-" + pw + "-" + email);
		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String dbid = "root";
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, dbid, pass);
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setString(3, gender);
			psmt.setString(4, pw);
			psmt.setString(5, email);
			
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
