package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ConnectionProvider;

public class SearchDAO {
	public List<SearchVO> contentInfo(String title_keyword, String name_keyword) {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = " SELECT tb.BRDNO, tb.BRDTITLE, tb.BRDMEMO, cu.USERNM "
                + "      FROM TBL_BOARD tb, "
                + "           COM_USER cu "
                + "     WHERE tb.BRDTITLE LIKE ? "
                + "       AND cu.USERNM LIKE ? "
                + "       AND cu.USERNO = tb.USERNO ";

		List<SearchVO> list = new ArrayList<SearchVO>();

		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, "%" + title_keyword + "%");
			psmt.setString(2, "%" + name_keyword + "%");
			rs = psmt.executeQuery();

			while (rs.next()) {
				String brdTitle = rs.getString("BRDTITLE");
				String brdMemo = rs.getString("BRDMEMO");
				String userNm = rs.getString("USERNM");
				SearchVO sv = new SearchVO(brdTitle, brdMemo, userNm);
				list.add(sv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
