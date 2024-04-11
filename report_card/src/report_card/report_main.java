package report_card;

public class report_main {
	public static void main(String[] args) {
		// 1. 성적표 만들기.
		// 2. C, JAVA, PYTHON, JS 성적을 입력하여 평균 점수를 구한다.
		// 3. 이름을 입력하고, 입력한 인원 수 만큼의 성적을 출력한다.
		// List 사용할 것, 예외처리 다 할것.
		report_controll rc = new report_controll();

		rc.controll_main(); // 프로그램 시작

	}

}
