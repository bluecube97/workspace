package spring_di.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_di.di.calc.Calc;
import spring_di.di.console.ScoreConsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Program {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_di/di/settng.xml");

        // 두 개 같은거임
        //ScoreConsole console = (ScoreConsole) context.getBean("scoreConsole");
        //ScoreConsole console = (ScoreConsole) context.getBean(ScoreConsole.class);

        //console.print();

        Calc calc = (Calc) context.getBean("calc");

        calc.calculate();

    }
}
