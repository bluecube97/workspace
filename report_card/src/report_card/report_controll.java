package report_card;

import java.util.List;

public class report_controll {
	report_input ri = new report_input();
	report_print ro = new report_print();
	report_grade rg = new report_grade();
	report_user ru = new report_user();
	report_list rl = new report_list();
	report_key rk = new report_key();
	loop_controll lc = new loop_controll();

	public void controll_main() {

		while (lc.isProgram_loop()) {
			while (lc.isInput_loop()) {
				ri.input_grade(rk, lc, rg, rl); // 성적 입력
				if (lc.isInput_loop() == false) {
					break;
				}
				ri.input_name(ru, rl); // 이름 입력
			}
			ro.report_output(rl);
			break;
		}
	}
}
