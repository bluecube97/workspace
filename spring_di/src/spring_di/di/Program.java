package spring_di.di;

import spring_di.di.console.NormalConsole;
import spring_di.di.console.ScoreConsole;
import spring_di.di.inter.MakingScore;
import spring_di.di.inter.Score;
import spring_di.di.inter.SubjectList;

public class Program {

	public static void main(String[] args) {

		// interface
		SubjectList sl = new SubjectList();
		sl.setC(10);
		sl.setHtml(20);
		sl.setJava(30);
		sl.setJavascript(40);

		Score sr = new MakingScore(sl);
		// 파라미터 세팅

		// 클래스 별도로
		ScoreConsole sc = new NormalConsole(sr);

		sc.print();
	}

}