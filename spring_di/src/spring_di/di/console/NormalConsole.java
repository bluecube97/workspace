package spring_di.di.console;

import spring_di.di.inter.Score;

public class NormalConsole implements ScoreConsole {

	private final Score sr;

	public NormalConsole(Score sr) {
		this.sr = sr;
	}

	@Override
	public void print() {
		System.out.println("총점 : " + sr.sum());
		System.out.println("평균 : " + sr.avg());
	}

}
