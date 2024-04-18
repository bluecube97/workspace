package spring_di.di.calc;

public class ElementList {
    int num1;
    int num2;
    String op;

    public ElementList() {

    }

    public ElementList(int num1, int num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
