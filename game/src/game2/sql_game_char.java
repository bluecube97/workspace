package game2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sql_game_char {
	public void insertCharData(HashMap<String, Object> insertCharMap) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = " INSERT INTO JH_GAME_CHAR (PNM, PJOB, PHP, PWEAPON, WEAPONNM, WEAPONDICE, PSTR, PDEX, PINT, PLUK, PATTK, PLV) "
				   + "                   values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, insertCharMap.get("pNm").toString());
			psmt.setString(2, insertCharMap.get("pJob").toString());
			psmt.setString(3, insertCharMap.get("pHp").toString());
			psmt.setString(4, insertCharMap.get("pWeapon").toString());
			psmt.setString(5, insertCharMap.get("weaponNm").toString());
			psmt.setString(6, insertCharMap.get("weaponDice").toString());
			psmt.setString(7, insertCharMap.get("pStr").toString());
			psmt.setString(8, insertCharMap.get("pDex").toString());
			psmt.setString(9, insertCharMap.get("pInt").toString());
			psmt.setString(9, insertCharMap.get("pLuk").toString());
			psmt.setString(10, insertCharMap.get("pAttk").toString());
			psmt.setString(11, insertCharMap.get("pLv").toString());
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public List<HashMap<String, Object>> extCharData() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> extCharList = new ArrayList<>();

		String sql = " SELECT PNM, PJOB, PHP, PWEAPON, WEAPONNM, WEAPONDICE, PSTR, PDEX, PINT, PLUK, PATTK, PLV "
				+ "	 FROM JH_GAME_CHAR ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				HashMap<String, Object> extCharMap = new HashMap<>();

				extCharMap.put("pNm", rs.getString("PNM"));
				extCharMap.put("pJob", rs.getString("PJOB"));
				extCharMap.put("pHp", rs.getString("PHP"));
				extCharMap.put("pWeapon", rs.getString("PWEAPON"));
				extCharMap.put("weaponNm", rs.getString("WEAPONNM"));
				extCharMap.put("weaponDice", rs.getString("WEAPONDICE"));
				extCharMap.put("pStr", rs.getString("PSTR"));
				extCharMap.put("pDex", rs.getString("PDEX"));
				extCharMap.put("pInt", rs.getString("PINT"));
				extCharMap.put("pLuk", rs.getString("PLUK"));
				extCharMap.put("pAttk", rs.getString("PATTK"));
				extCharMap.put("pLv", rs.getString("PLV"));
				
				extCharList.add(extCharMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return extCharList;
	}

}
