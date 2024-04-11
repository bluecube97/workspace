package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class baekjoon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int card_cnt = 0;
		int max = 0;

		card_cnt = sc.nextInt();
		max = sc.nextInt();

		int[] arr = new int[card_cnt];
		int[] result = { 0 };
		result = new int[2];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		Loop1: for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					result[0] = arr[i] + arr[j] + arr[k];
					if (result[0] < max) {
						if (result[1] < result[0]) {
							result[1] = result[0];
						}
					} else if (result[0] == max) {
						System.out.println(max);
						break Loop1;
					} else {
						System.out.println(result[1]);
						break Loop1;
					}
				}
			}
		}
	}
}
