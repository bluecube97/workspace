package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SearchDAO sd = new SearchDAO();

		System.out.println("검색할 제목을 입력하세요.");
		String title_keyword = sc.next();
		System.out.println("검색할 저자를 입력하세요.");
		String name_keyword = sc.next();

		List<SearchVO> list = new ArrayList<SearchVO>();
		list = sd.contentInfo(title_keyword, name_keyword);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUserNm());
			System.out.println(list.get(i).getBrdTitle());
			System.out.println(list.get(i).getBrdMemo());
		}

	}

}
