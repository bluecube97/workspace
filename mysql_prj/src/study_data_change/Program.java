package study_data_change;

import java.util.HashMap;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		SDCHASH sd = new SDCHASH();

		List<HashMap<String, Object>> list = sd.changeInfo();

		for (HashMap<String, Object> uv : list) {
			System.out.println("id: " + (int) uv.get("id"));
			System.out.println("journal: " + uv.get("journal_nm").toString());
			System.out.println("issn: " + uv.get("issn").toString());
			System.out.println("eissn: " + uv.get("eissn").toString());
			System.out.println("factor: " + uv.get("factor").toString());
		}

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> uv = list.get(i);

			System.out.println("id: " + (int) uv.get("id"));
		}
	}
}
