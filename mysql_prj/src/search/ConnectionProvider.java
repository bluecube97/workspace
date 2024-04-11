package search;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://192.168.0.78:3306/project9?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "studyuser";
			String pass = "1111";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}