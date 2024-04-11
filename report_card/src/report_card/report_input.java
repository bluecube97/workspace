package report_card;

import java.util.Scanner;

public class report_input {
	Scanner sc = new Scanner(System.in);
	int key_cnt = 0;

	public void input_grade(report_key rk, loop_controll lc, report_grade rg, report_list rl) {
		while (true) {
			rg = new report_grade();
			// 안내 멘트
			System.out.println("숫자만 입력해주세요.");
			System.out.println("C JAVA PYTHON JavaScript 순으로 입력하세요.");
			System.out.println("그만 입력하시려면 stop을 입력하세요.");
			// report_grade 객체의 각 성적변수에 성적 입력
			// 첫 입력이 stop이면 반복 종료(report_controll 15line)
			String isStop = sc.next();
			if (isStop.equals("stop")) {
				lc.setInput_loop(false);
				break;
			} else {
				int a = Integer.valueOf(isStop);
				rg.setC(a);
			}
			rg.setJava(sc.nextInt());
			rg.setPy(sc.nextInt());
			rg.setJs(sc.nextInt());
			// 성적이 0점 미만이거나, 100점 초과일 경우 예외처리
			if (!(rg.getC() >= 0 && rg.getC() <= 100)) {
				System.out.println("잘못 입력하셨습니다.");
			} else if (!(rg.getJava() >= 0 && rg.getJava() <= 100)) {
				System.out.println("잘못 입력하셨습니다.");
			} else if (!(rg.getPy() >= 0 && rg.getPy() <= 100)) {
				System.out.println("잘못 입력하셨습니다.");
			} else if (!(rg.getJs() >= 0 && rg.getJs() <= 100)) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				// 점수 평균 계산
				rg.setAver(((float) rg.getC() + (float) rg.getJava() + (float) rg.getPy() + (float) rg.getJs()) / 4);
				// report_key 객체의 key_controll 값 1 증가
				// report_grade 객체의 grade_key 변수에
				// report_controll 객체의 key_controll 값 입력
				key_cnt++;
				rk.setKey_controll(key_cnt);
				rg.setGrade_key(rk.getKey_controll());
				// report_list 객체의 grade_List 에
				// report_grade 객체를 add함 (C, Java, Python, JavaScript, grade_key)
				rl.grade_List.add(rg);
				break;
			}
		}
	}

	public void input_name(report_user ru, report_list rl) {
		ru = new report_user();
		System.out.println("이름을 입력해주세요.");
		ru.setName(sc.next());
		ru.setUser_key(key_cnt);
		rl.user_List.add(ru);
	}
}
