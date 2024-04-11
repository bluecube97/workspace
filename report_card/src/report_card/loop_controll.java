package report_card;

public class loop_controll {
	private boolean program_loop = true; // 프로그램 루프
	private boolean input_loop = true; // 성적입력 루프

	public loop_controll() {

	}

	public loop_controll(boolean program_loop, boolean input_loop) {
		super();
		this.program_loop = program_loop;
		this.input_loop = input_loop;
	}

	public boolean isProgram_loop() {
		return program_loop;
	}

	public void setProgram_loop(boolean program_loop) {
		this.program_loop = program_loop;
	}

	public boolean isInput_loop() {
		return input_loop;
	}

	public void setInput_loop(boolean input_grade_loop) {
		this.input_loop = input_grade_loop;
	}

}
