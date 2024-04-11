package ScoreList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int menu;
		boolean keepLoop = true;

		List<SubjectScore> list = new ArrayList<SubjectScore>();

		while (keepLoop) {
			menu = message();

			switch (menu) {
			case 1:
				subjectInput(list);

				break;
			case 2:
				subjectPrint(list);
				break;
			case 3:

				System.out.println("Bye~~");

				keepLoop = false;
				break;

			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}
	}

	private static int message() {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌───────────────────────────┐");
		System.out.println("│           메인 메뉴         │");
		System.out.println("└───────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = scan.nextInt();

		return menu;

	}

	private static void subjectPrint(List<SubjectScore> list) {

		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적 출력         │");
		System.out.println("└───────────────────────────┘");
		System.out.println();
		int size = list.size();

		for (int i = 0; i < size; i++) {
			SubjectScore s1 = list.get(i); // ArrayList list 배열의 i번째 값(SubjectScore 형)을 가져옴.
			int kor = s1.kor;
			int eng = s1.eng;
			int math = s1.math;
			int total = kor + eng + math;
			float avg = total / 3.0f;
			System.out.printf("국어 %d : %3d\n", (i + 1), kor);
			System.out.printf("영어 %d : %3d\n", (i + 1), eng);
			System.out.printf("수학 %d : %3d\n", (i + 1), math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("─────────────────────────────");
		}
	}

	private static void subjectInput(List<SubjectScore> list) {
		Scanner scan = new Scanner(System.in);

		System.out.println("┌───────────────────────────┐");
		System.out.println("│           성적 입력         │");
		System.out.println("└───────────────────────────┘");
		System.out.println();

		int kor = 0;
		int math = 0;
		int eng = 0;

		do {
			System.out.printf("국어 : ");
			kor = scan.nextInt();

			if (kor < 0 || 100 < kor)
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (kor < 0 || 100 < kor);

		System.out.println("─────────────────────────────");
		do {
			System.out.printf("영어 : ");
			eng = scan.nextInt();

			if (eng < 0 || 100 < eng)
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (eng < 0 || 100 < eng);

		System.out.println("─────────────────────────────");
		do {
			System.out.printf("수학 : ");
			math = scan.nextInt();

			if (math < 0 || 100 < math)
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");

		} while (math < 0 || 100 < math);

		System.out.println("─────────────────────────────");

		SubjectScore s1 = new SubjectScore(kor, eng, math);
		list.add(s1);
	}
}