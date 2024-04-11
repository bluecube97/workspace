package beskin31;

import java.util.Scanner;

public class baskin31_main {

	public static void main(String[] args) {
//		1. 베스킨라빈스 만들기
//		2. 사이즈 정하기
//		3. 아이스크림 고르기
//		4. 계산하기 
//		5. 영수증 출력하기

		Scanner sc = new Scanner(System.in);

		System.out.println("************************");
		System.out.println("*베스킨라빈스 31 입니다.*");
		System.out.println("************************");

		boolean order_run = true;

		String cup_size[] = { "하프갤런", "패밀리", "쿼터", "파인트" };
		String icecream_taste[] = { "베리베리스트로베리", "아몬드봉봉", "슈팅스타", "아빠는딸바붕", "엄마는 외계인", "민트초코", "그린티" };

		int product_price[] = { 30000, 20000, 15000, 9800 }; // 사이즈별 금액
		int chose_cnt[] = { 6, 5, 4, 3 }; // 선택할 수 있는 맛 갯수
		String chose_taste[] = new String[6]; // 선택한 맛이 입력될 배열
		int order_price = 0; // 계산 결과

		while (order_run) {
			System.out.println("사이즈를 선택해주세요. .");
			System.out.println("*********************");
			for (int i = 0; i < cup_size.length; i++) {
				System.out.println((i + 1) + "." + cup_size[i]);
			}
			System.out.println("*********************");
			String chose_order = sc.nextLine();

			boolean taste_seq = true;

			int taste_cnt = 0;
			while (taste_seq) {
				System.out.println("*********************");
				for (int i = 0; i < chose_taste.length; i++) {
					System.out.println((i + 1) + "." + icecream_taste[i]);
				}
				System.out.println("*********************");

				System.out.println((taste_cnt + 1) + " 번째 맛을 선택하세요.");
				chose_taste[taste_cnt] = sc.nextLine();
				String message = icecream_taste[Integer.parseInt(chose_taste[taste_cnt]) - 1];
				System.out.println(message + " 이(가) 선택되었습니다.");

				System.out.println("컵크기: " + (7 - Integer.valueOf(chose_order)));
				System.out.println("선택하신 맛: " + (Integer.valueOf(taste_cnt) + 1));
				taste_cnt++;
				if (chose_order.equals("4") && taste_cnt == 3) {
					taste_seq = false;
					order_price = product_price[3];
				} else if (chose_order.equals("3") && taste_cnt == 4) {
					taste_seq = false;
					order_price = product_price[2];
				} else if (chose_order.equals("2") && taste_cnt == 5) {
					taste_seq = false;
					order_price = product_price[1];
				} else if (chose_order.equals("1") && taste_cnt == 6) {
					taste_seq = false;
					order_price = product_price[0];
				}
			}
			System.out.println("주문이 완료되었습니다.");
			System.out.println("*********************");
			System.out.println("선택하신 맛은");
			for (int i = 0; i < 7 - Integer.valueOf(chose_order); i++) {
				if (chose_taste[i].equals("1")) {
					System.out.println(icecream_taste[0] + " ");
				} else if (chose_taste[i].equals("2")) {
					System.out.println(icecream_taste[1] + " ");
				} else if (chose_taste[i].equals("3")) {
					System.out.println(icecream_taste[2] + " ");
				} else if (chose_taste[i].equals("4")) {
					System.out.println(icecream_taste[3] + " ");
				} else if (chose_taste[i].equals("5")) {
					System.out.println(icecream_taste[4] + " ");
				} else if (chose_taste[i].equals("6")) {
					System.out.println(icecream_taste[5] + " ");
				}
			}
			System.out.println("입니다.");
			System.out.println("*********************");

			System.out.println(" 주문하신 제품의 금액은 :" + order_price + " 원 입니다.");
			order_run = false;
		}
	}
}
