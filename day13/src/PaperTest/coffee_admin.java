package PaperTest;

import java.util.Scanner;

public class coffee_admin {
	Scanner sc = new Scanner(System.in);

	public boolean input_pw() {
		// 비번맞으면 false, 틀리면 true
		String pw = sc.next();
		if (pw.equals("!Q@W#E$R")) {
			return false;
		} else {
			return true;
		}
	}

	public void add_menu(coffee_customerVO cctVO) {
		System.out.println("추가할 메뉴 이름을 입력하세요.");
		String menu = sc.next();
		cctVO.menu.add(menu);

		System.out.println("메뉴의 가격을 입력하세요.");
		int price = sc.nextInt();
		cctVO.price.add(price);
	}

	public void cat_menu(coffee_customerVO cctVO) {
		System.out.println("*****************");
		for (int i = 0; i < cctVO.getMenu().size(); i++) {
			String menu = cctVO.getMenu().get(i);
			int price = cctVO.getPrice().get(i);

			System.out.println((i + 1) + ". " + menu + "	" + price + "원");
			System.out.println("*****************");
		}
	}

	public void del_menu(coffee_customerVO cctVO) {
		System.out.println("삭제할 메뉴 번호를 입력하세요.");
		cat_menu(cctVO);

		int del_idx = sc.nextInt();
		if (del_idx > cctVO.menu.size() || del_idx < 0) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			cctVO.menu.remove(del_idx - 1);
			cctVO.price.remove(del_idx - 1);
		}
	}

	public void alt_price(coffee_customerVO cctVO) {
		System.out.println("가격을 변경할 메뉴 번호를 입력하세요.");
		cat_menu(cctVO);
		
		int alt_idx = sc.nextInt();
		if (alt_idx > cctVO.menu.size() || alt_idx < 0) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			System.out.println("얼마로 변경하시겠습니까?");
			int alt_price = sc.nextInt();
			cctVO.price.set(alt_idx - 1, alt_price);
		}
	}

}
