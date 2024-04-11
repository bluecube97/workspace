package com.mvc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/dbstudy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";;
			String pass = "1234";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
