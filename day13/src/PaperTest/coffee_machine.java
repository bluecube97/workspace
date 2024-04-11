package PaperTest;

import java.util.HashMap;
import java.util.Scanner;

public class coffee_machine {
	Scanner sc = new Scanner(System.in);

	public void first_view(coffee_admin cad, coffee_customer cct, coffee_customerVO cctVO) {
		boolean first_view_menu_flag = true;
		
		while (first_view_menu_flag) {
			System.out.println("1. 일반 사용	2. admin 모드 진입");
			int first_view_menu = sc.nextInt();

			switch (first_view_menu) {
			case 1:
				customer_view(cct, cctVO);
				first_view_menu_flag = false;
				break;
			case 2:
				admin_view(cad, cctVO);
				first_view_menu_flag = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public void customer_view(coffee_customer cct, coffee_customerVO cctVO) {
		HashMap<String, Object> orderMap = new HashMap<String, Object>();
		int result_price = 0;
		
		orderMap = new HashMap<String, Object>();
		orderMap = cct.sel_menu(cctVO, orderMap);
		orderMap = cct.sel_cnt(cctVO, orderMap);
		cctVO.orderList.add(orderMap);

		boolean customer_view_flag = true;

		while (customer_view_flag) {
			System.out.println("1. 추가 주문	2. 주문 수정	3. 주문 완료");
			int customer_view_menu = sc.nextInt();
			switch (customer_view_menu) {
			case 1:
				orderMap = new HashMap<String, Object>();
				orderMap = cct.sel_menu(cctVO, orderMap);
				orderMap = cct.sel_cnt(cctVO, orderMap);
				cctVO.orderList.add(orderMap);
				break;
			case 2:
				cct.del_order(cctVO);
				break;
			case 3:
				customer_view_flag = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}

		customer_view_flag = true;

		while (customer_view_flag) {
			System.out.println("할인카드가 있으십니까?");
			System.out.println("1. 있음	2. 없음");
			int discount_card = sc.nextInt();
			if (discount_card == 1 || discount_card == 2) {
				result_price = cct.coffee_price(cctVO, discount_card);
				customer_view_flag = false;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}

		cct.output_result(cctVO, result_price);
		cctVO.orderList.clear();
	}

	public void admin_view(coffee_admin cad, coffee_customerVO cctVO) {
		boolean admin_pw = true;
		boolean admin_view_flag = true;

		while (admin_view_flag) {
			admin_pw = cad.input_pw();
			if (admin_pw = true) {
				break;
			}
		}

		admin_view_flag = true;

		while (admin_view_flag) {
			System.out.println("1. 메뉴 추가	2. 메뉴 삭제	3. 가격 변경	4. 운영자 모드 종료");
			int admin_view_menu = sc.nextInt();
			switch (admin_view_menu) {
			case 1:
				cad.add_menu(cctVO);
				break;
			case 2:
				if (cctVO.menu.size() == 0) {
					System.out.println("삭제할 메뉴가 없습니다.");
				} else {
					cad.del_menu(cctVO);
				}
				break;
			case 3:
				cad.alt_price(cctVO);
				break;
			case 4:
				admin_view_flag = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

}
