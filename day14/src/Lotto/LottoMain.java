package Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
//		입력: 경우의 수
//		출력: 경우의 수만큼 로또 번호 6개 + 보너스 1개 출력 (1 ~ 45)
//		ex) 40, 43, 21, 33, 12, 6, 보너스 39

		Scanner sc = new Scanner(System.in);

		int lotto_cnt = sc.nextInt();
		List<List<Integer>> lotto_list_list = new ArrayList<List<Integer>>();

		for (int i = 0; i < lotto_cnt; i++) {
			List<Integer> lotto_list = new ArrayList<Integer>();
			for (int j = 0; j < 7; j++) {
				Random rd = new Random();
				int lotto_num = rd.nextInt(45) + 1;

				for (int k = 0; k < lotto_list.size(); k++) {
					if (lotto_list.get(k) == lotto_num) {
						j--;
						lotto_list.remove(k);
						break;
					}
				}

				lotto_list.add(lotto_num);
			}
			lotto_list_list.add(lotto_list);
		}

		for (int i = 0; i < lotto_cnt; i++) {
			for (int j = 0; j < 7; j++) {
				if (j == 6) {
					System.out.print("보너스 ");
				}
				System.out.print(lotto_list_list.get(i).get(j));
				if (j < 6) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}

	}

}
