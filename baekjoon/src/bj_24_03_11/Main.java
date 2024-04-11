package bj_24_03_11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int test_cnt = sc.nextInt();
		double[] test_score = new double[test_cnt];
		
		for(int i = 0; i < test_cnt; i++) {
			test_score[i] = sc.nextFloat();
		}
		
		double max = Arrays.stream(test_score).max().getAsDouble();
		
		for(int i = 0; i < test_cnt; i++) {
			test_score[i] /= max / 100;
		}
		
		double total = 0;
		
		for(int i = 0; i < test_cnt; i++) {
			total += test_score[i];
		}
		
		System.out.println(total / test_cnt);

	}

}
