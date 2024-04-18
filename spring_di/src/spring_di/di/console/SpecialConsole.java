package spring_di.di.console;

import spring_di.di.inter.Score;

public class SpecialConsole implements ScoreConsole {

	private Score sr;
	
	public SpecialConsole() {
	}
	
	public SpecialConsole(Score sr) {
		this.sr = sr;
	}
	
	@Override
	public void print() {
		System.out.println("************************");
		System.out.println("총점은 : " + sr.sum());
		System.out.println("************************");
		System.out.println("평균은 : " + sr.avg());
		System.out.println("************************");
	}
	
	public void setScore(Score sr) {
		this.sr = sr;
	}
}
