package innerJoin;

import java.util.HashMap;
import java.util.List;

public class Program1 {

	public static void main(String[] args) {
		INNHASH in = new INNHASH();
		
		List<HashMap<String, Object>> list = in.innerJoin();
		
		for(int i = 0; i < list.size(); i++) {
			String userId = list.get(i).get("USERID").toString();
			String userNm = list.get(i).get("USERNM").toString();
			String codeNm = list.get(i).get("CODENM").toString();
			String deptNm = list.get(i).get("DEPTNM").toString();
			
			System.out.println("***********************");
			System.out.println("userId: " + userId);
			System.out.println("userNm: " + userNm);
			System.out.println("codeNm: " + codeNm);
			System.out.println("deptNm: " + deptNm);
			
		}
		System.out.println("***********************");
	}

}
