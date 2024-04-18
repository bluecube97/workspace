package spring_di.di.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculate implements Calc{
    Scanner sc = new Scanner(System.in);

    private ElementList el;

    public Calculate(ElementList el) {
        this.el = el;
    }

    @Override
    public void calculate()  {
        inputVal();
        outputPhase(calPhase());
    }

    private void outputPhase(int i) {
        System.out.println("결과 값은 : " + i);
    }

    private void inputVal() {
        System.out.println("두 수를 입력해주세요.");
        el.setNum1(sc.nextInt());
        el.setNum2(sc.nextInt());

        System.out.println("연산자를 입력해주세요.");
        el.setOp(sc.nextLine());
    }

    private int calPhase() {
        boolean ca = true;
        int result = 0;

        while (ca) {
            switch (el.getOp()) {
                case "+":
                    ca = false;
                    result = sum(el.getNum1(), el.getNum2());
                    break;
                case "-":
                    ca = false;
                    result = minus(el.getNum1(), el.getNum2());
                    break;
                case "*":
                    ca = false;
                    result = multiply(el.getNum1(), el.getNum2());
                    break;
                case "/":
                    ca = false;
                    result = divide(el.getNum1(), el.getNum2());
                    break;
                default:
                    System.out.println("연산자를 잘못 입력하셨습니다.");
                    break;
            }
        }
        return result;
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }

}
