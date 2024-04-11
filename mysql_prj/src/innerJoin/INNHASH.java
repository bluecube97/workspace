package innerJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class INNHASH {
	public List<HashMap<String, Object>> innerJoin() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT cu.USERID, cu.USERNM, cc.CODENM, cd.DEPTNM "
				   + "   FROM COM_USER cu, "
				   + "        COM_CODE cc, "
				   + "        COM_DEPT cd "
				   + "  WHERE cu.USERROLE = cc.CODECD "
				   + "    AND cu.DEPTNO = cd.DEPTNO ";
		
		List<HashMap<String, Object>> list = new ArrayList<>();
		
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> innMap = new HashMap<>();
				
				innMap.put("USERID", rs.getString("USERID"));
				innMap.put("USERNM", rs.getString("USERNM"));
				innMap.put("CODENM", rs.getString("CODENM"));
				innMap.put("DEPTNM", rs.getString("DEPTNM"));
				
				list.add(innMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
