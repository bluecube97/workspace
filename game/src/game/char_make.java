package game;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class char_make {
	Scanner sc = new Scanner(System.in);

	public HashMap<String, Object> input_name(HashMap<String, Object> insertCharMap, char_hashmap ch) {
		System.out.println("당신의 이름을 입력하세요.");
		insertCharMap.put("pName", sc.next());
		
		System.out.println(insertCharMap.get("pName"));
		
		return insertCharMap;
	}

	public void select_job(List<HashMap<String, Object>> insertCharList, char_hashmap ch) {
		List<HashMap<String, Object>> extCharList = ch.extCharData();
		HashMap<String, Object> extCharMap = extCharList.get(0);
		HashMap<String, Object> insertCharMap = new HashMap<>();
		System.out.println("---------------------------------------------");
		System.out.println(extCharMap.get("pName") + " 님 직업을 선택해주세요."); // char_stat에 저장된 p_name 값 호출
		System.out.println("1. 전사		2. 마법사		3. 사냥꾼");
		int job = sc.nextInt();
		//ct.setP_job(job);
	}
}
