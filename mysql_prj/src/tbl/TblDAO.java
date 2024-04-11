package tbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ConnectionProvider;

public class TblDAO {
	public List<TblVO> contentInfo(String keyword) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = " SELECT BRDNO, BRDTITLE , BRDMEMO "
		+ "  FROM TBL_BOARD " + " WHERE BRDTITLE LIKE  ? ";

		List<TblVO> list = new ArrayList<TblVO>();

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + keyword + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				int brdNo = rs.getInt("BRDNO");
				String brdTitle = rs.getString("BRDTITLE");
				String brdMemo = rs.getString("BRDMEMO");
				TblVO tv = new TblVO(brdNo, brdTitle, brdMemo);
				list.add(tv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
