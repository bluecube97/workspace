package com;

import java.util.HashMap;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		hashmap_exm ud = new hashmap_exm();

		List<HashMap<String, Object>> list = ud.userInfo();

		System.out.println("|---------------------------------------------------|");
		for (HashMap<String, Object> uv : list) {
			int userNo = (int) uv.get("userNo");
			String userId = uv.get("userId").toString();
			String userNm = uv.get("userName").toString();
			
			System.out.println("|사용자 번호 | " + userNo + " | 사용자 ID | " + userId + " | 사용자명 | " + userNm + " |");
			System.out.println("|---------------------------------------------------|");
		}

	}

}
