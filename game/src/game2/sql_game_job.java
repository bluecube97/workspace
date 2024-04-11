package game2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sql_game_job {
	public void insertJobData(HashMap<String, Object> insertJobMap) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = " INSERT INTO JH_GAME_JOB (JOBNM, HP, STR, DEX, `INT`, LUK) "
				   + "                  values (?, ?, ?, ?, ?, ?) ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, insertJobMap.get("jobNm").toString());
			psmt.setString(2, insertJobMap.get("hp").toString());
			psmt.setString(3, insertJobMap.get("str").toString());
			psmt.setString(4, insertJobMap.get("dex").toString());
			psmt.setString(5, insertJobMap.get("int").toString());
			psmt.setString(6, insertJobMap.get("luk").toString());
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public List<HashMap<String, Object>> extJobData() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> extJobList = new ArrayList<>();

		String sql = " SELECT seq, JOBNM, HP, STR, DEX, `INT`, LUK "
				   + "	 FROM JH_GAME_JOB ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				HashMap<String, Object> extJobMap = new HashMap<>();

				extJobMap.put("seq", rs.getString("seq"));
				extJobMap.put("jobNm", rs.getString("JOBNM"));
				extJobMap.put("hp", rs.getString("HP"));
				extJobMap.put("str", rs.getString("STR"));
				extJobMap.put("dex", rs.getString("DEX"));
				extJobMap.put("int", rs.getString("INT"));
				extJobMap.put("luk", rs.getString("LUK"));
				   
				extJobList.add(extJobMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return extJobList;
	}
}
