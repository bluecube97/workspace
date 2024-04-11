package game2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sql_game_char_weapon {
	public void insertCharWeaponData(HashMap<String, Object> insertCharWeaponMap) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = " INSERT INTO JH_GAME_WEAPON (WEAPONNM, WEAPONDICE, WEAPONSPD, REQJOB) "
				   + "                     values (?, ?, ?, ?) ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, insertCharWeaponMap.get("weaponNm").toString());
			psmt.setString(2, insertCharWeaponMap.get("weaponDice").toString());
			psmt.setString(3, insertCharWeaponMap.get("weaponSpd").toString());
			psmt.setString(4, insertCharWeaponMap.get("reqJob").toString());
			
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public List<HashMap<String, Object>> extCharWeaponData() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> extCharWeaponList = new ArrayList<>();

		String sql = " SELECT WEAPONNM, WEAPONDICE, WEAPONSPD, REQJOB "
				   + "   FROM JH_GAME_WEAPON ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				HashMap<String, Object> extCharWeaponMap = new HashMap<>();

				extCharWeaponMap.put("weaponNm", rs.getString("WEAPONNM"));
				extCharWeaponMap.put("weaponDice", rs.getString("WEAPONDICE"));
				extCharWeaponMap.put("weaponSpd", rs.getString("WEAPONSPD"));
				extCharWeaponMap.put("reqJob", rs.getString("REQJOB"));
				       
				extCharWeaponList.add(extCharWeaponMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return extCharWeaponList;
	}
}
