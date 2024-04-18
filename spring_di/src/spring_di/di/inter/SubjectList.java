package spring_di.di.inter;

public class SubjectList {
	private int java;
	private int c;
	private int javascript;
	private int html;
	
	public SubjectList() {
	}
	
	public SubjectList(int java, int c, int javascript, int html) {
		this.java = java;
		this.c = c;
		this.javascript = javascript;
		this.html = html;
	}
	
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getJavascript() {
		return javascript;
	}
	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
}
