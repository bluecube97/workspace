package PaperTest;

import java.util.HashMap;
import java.util.Scanner;

public class coffee_customer {
	Scanner sc = new Scanner(System.in);

	public void cat_menu(coffee_customerVO cctVO) {
		System.out.println("*****************");
		for (int i = 0; i < cctVO.getMenu().size(); i++) {
			String menu = cctVO.getMenu().get(i);
			int price = cctVO.getPrice().get(i);

			System.out.println((i + 1) + ". " + menu + "	" + price + "원");
			System.out.println("*****************");
		}

	}

	public void cat_orderList(coffee_customerVO cctVO) {
		for (int i = 0; i < cctVO.orderList.size(); i++) {
			int menu = (int) cctVO.orderList.get(i).get("menu");
			String menu_ = cctVO.menu.get(menu - 1);
			int cnt = (int) cctVO.orderList.get(i).get("cnt");
			System.out.println((i + 1) + ". " + menu_ + "	" + cnt + " 잔");
		}
	}

	public HashMap<String, Object> sel_menu(coffee_customerVO cctVO, HashMap<String, Object> orderMap) {
		cat_menu(cctVO);
		System.out.println("메뉴 번호를 선택해주세요.");
		int menu = sc.nextInt();
		orderMap.put("menu", menu);

		return orderMap;
	}

	public HashMap<String, Object> sel_cnt(coffee_customerVO cctVO, HashMap<String, Object> orderMap) {
		System.out.println("수량을 선택해주세요.");
		int cnt = sc.nextInt();
		orderMap.put("cnt", cnt);

		return orderMap;
	}

	public void del_order(coffee_customerVO cctVO) {
		cat_orderList(cctVO);
		System.out.println("수정할 주문 번호를 입력해주세요.");
		int cnt = sc.nextInt();
		cctVO.orderList.remove(cnt - 1);
	}

	public int coffee_price(coffee_customerVO cctVO, int discount_card) {
		int result_price = 0;

		for (int i = 0; i < cctVO.orderList.size(); i++) {
			int cnt = (int) cctVO.orderList.get(i).get("cnt");
			int menu = (int) cctVO.orderList.get(i).get("menu");
			int price = cctVO.price.get(menu - 1);

			result_price += cnt * price;
		}

		if (discount_card == 1) {
			System.out.println("10% 할인받으셨습니다.");
			return result_price = result_price * 90 / 100;
		} else {
			return result_price;
		}
	}

	public void output_result(coffee_customerVO cctVO, int result_price) {
		cat_orderList(cctVO);
		System.out.println("총 금액은 " + result_price + "원 입니다.");
	}

}
