package tbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TblDAO td = new TblDAO();

		System.out.println("검색할 키워드를 입력하세요.");
		String keyword = sc.next();

		List<TblVO> list = new ArrayList<TblVO>();
		list = td.contentInfo(keyword);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getBrdNo());
			System.out.println(list.get(i).getBrdTitle());
			System.out.println(list.get(i).getBrdMemo());
		}

	}

}
