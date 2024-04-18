package spring_di.di.console;

import org.springframework.core.env.SystemEnvironmentPropertySource;
import spring_di.di.inter.Score;

public class NomalConsole implements ScoreConsole {

	private Score sr;
	
	public NomalConsole() {
	}
	
	public NomalConsole(Score sr) {
		this.sr = sr;
	}
	
	@Override
	public void print() {
		System.out.println("총점은 : " + sr.sum());
		System.out.println("평균은 : " + sr.avg());
		System.out.println("java : " + sr.subjectScore());
	}
	
	public void setScore(Score sr) {
		this.sr = sr;
	}
}
