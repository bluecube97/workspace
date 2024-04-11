package report_card;

public class report_grade {
	private int c; // C 점수
	private int java; // JAVA 점수
	private int py; // PYTHON 점수
	private int js; // JavaScript 점수
	private float aver; // 점수평균
	private int grade_key; // 성적 리스트 키밸류

	public report_grade() {

	}

	public report_grade(int c, int java, int py, int js, float aver, int grade_key) {
		super();
		this.c = c;
		this.java = java;
		this.py = py;
		this.js = js;
		this.aver = aver;
		this.grade_key = grade_key;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getPy() {
		return py;
	}

	public void setPy(int py) {
		this.py = py;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public float getAver() {
		return aver;
	}

	public void setAver(float aver) {
		this.aver = aver;
	}

	public int getGrade_key() {
		return grade_key;
	}

	public void setGrade_key(int grade_key) {
		this.grade_key = grade_key;
	}

}
