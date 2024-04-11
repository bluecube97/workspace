package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class char_hashmap {
	public void insertCharData(List<HashMap<String, Object>> insertCharList) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = " INSERT PNAME, PJOB, PHP, PWEAPON, WEAPONNAME, WEAPONDICE, PSTR, PDEX, PINT, PATTK, PLV "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			HashMap<String, Object> insertCharMap = insertCharList.get(0);
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, insertCharMap.get("pName").toString());
			psmt.setString(2, insertCharMap.get("pJob").toString());
			psmt.setString(3, insertCharMap.get("pHp").toString());
			psmt.setString(4, insertCharMap.get("pWeapon").toString());
			psmt.setString(5, insertCharMap.get("weaponName").toString());
			psmt.setString(6, insertCharMap.get("weaponDice").toString());
			psmt.setString(7, insertCharMap.get("pStr").toString());
			psmt.setString(8, insertCharMap.get("pDex").toString());
			psmt.setString(9, insertCharMap.get("pInt").toString());
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

		String sql = " SELECT PNAME, PJOB, PHP, PWEAPON, WEAPONNAME, WEAPONDICE, PSTR, PDEX, PINT, PATTK, PLV "
				+ "	 FROM JH_GAME_CHAR ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				HashMap<String, Object> extCharMap = new HashMap<>();

				extCharMap.put("pName", rs.getString("PNAME"));
				extCharMap.put("pJob", rs.getString("PJOB"));
				extCharMap.put("pHp", rs.getString("PHP"));
				extCharMap.put("pWeapon", rs.getString("PWEAPON"));
				extCharMap.put("weaponName", rs.getString("WEAPONNAME"));
				extCharMap.put("weaponDice", rs.getString("WEAPONDICE"));
				extCharMap.put("pStr", rs.getString("PSTR"));
				extCharMap.put("pDex", rs.getString("PDEX"));
				extCharMap.put("pInt", rs.getString("PINT"));
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
