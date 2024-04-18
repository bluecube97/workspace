package spring_di.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_di.di.console.ScoreConsole;


public class Program {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring_di/di/settng.xml");
	
		ScoreConsole console = (ScoreConsole)context.getBean("scoreConsole");

		console.print();
	}
}
