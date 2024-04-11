package game2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sql_game_mob {
	public void insertMobData(HashMap<String, Object> insertMobMap) {
		Connection con = null;
		PreparedStatement psmt = null;

		String sql = " INSERT INTO JH_GAME_MOB (MNM, MHP, MWEAPON, MWEAPONNM, MWEAPONDICE, MATTK, MSTR, MDEX, MINT, MLV, MEXP, MENCOUNTER, MKIND) "
				   + "                  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);

			psmt.setString(1, insertMobMap.get("mNm").toString());
			psmt.setString(2, insertMobMap.get("mHp").toString());
			psmt.setString(3, insertMobMap.get("mWeapon").toString());
			psmt.setString(4, insertMobMap.get("mWeaponNm").toString());
			psmt.setString(5, insertMobMap.get("mWeaponDice").toString());
			psmt.setString(6, insertMobMap.get("mAttk").toString());
			psmt.setString(7, insertMobMap.get("mStr").toString());
			psmt.setString(8, insertMobMap.get("mDex").toString());
			psmt.setString(9, insertMobMap.get("mInt").toString());
			psmt.setString(10, insertMobMap.get("mLv").toString());
			psmt.setString(11, insertMobMap.get("mExp").toString());
			psmt.setString(12, insertMobMap.get("mEncounter").toString());
			psmt.setString(13, insertMobMap.get("mKind").toString());
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public List<HashMap<String, Object>> extMobData() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> extMobList = new ArrayList<>();

		String sql = " SELECT MNM, MHP, MWEAPON, MWEAPONNM, MWEAPONDICE, MATTK, MSTR, MDEX, MINT, MLV, MEXP, MENCOUNTER, MKIND "
				   + "	 FROM JH_GAME_MOB ";

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				HashMap<String, Object> extMobMap = new HashMap<>();

				extMobMap.put("mNm", rs.getString("MNM"));
				extMobMap.put("mHp", rs.getString("MHP"));
				extMobMap.put("mWeapon", rs.getString("MWEAPON"));
				extMobMap.put("mWeaponNm", rs.getString("MWEAPONNM"));
				extMobMap.put("mWeaponDice", rs.getString("MWEAPONDICE"));
				extMobMap.put("mAttk", rs.getString("MATTK"));
				extMobMap.put("mStr", rs.getString("MSTR"));
				extMobMap.put("mDex", rs.getString("MDEX"));
				extMobMap.put("mInt", rs.getString("MINT"));
				extMobMap.put("mLv", rs.getString("MLV"));
				extMobMap.put("mExp", rs.getString("MEXP"));
				extMobMap.put("mEncounter", rs.getString("MENCOUNTER"));
				extMobMap.put("mKind", rs.getString("MKIND"));
				
				extMobList.add(extMobMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return extMobList;
	}
}
