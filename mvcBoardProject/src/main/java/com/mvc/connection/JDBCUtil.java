package com.mvc.connection;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCUtil {

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement psmt) {
		if (psmt != null) {
			try {
				psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void UFT(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html; charset=UTF-8");
	}

}
