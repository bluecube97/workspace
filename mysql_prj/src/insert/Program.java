package insert;

import java.util.HashMap;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		insertExm ie = new insertExm();
		//List<HashMap<String, Object>> insertList = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> insertMap = new HashMap<>();

		System.out.println("Insert ID");
		insertMap.put("userId", sc.next());
		System.out.println("Insert PW");
		insertMap.put("userNm", sc.next());
		System.out.println("Insert Name");
		insertMap.put("userPw", sc.next());
		 
		//insertList.add(insertMap);
		ie.insertInfo(insertMap);

	}

}
