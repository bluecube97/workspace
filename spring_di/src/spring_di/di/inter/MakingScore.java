package spring_di.di.inter;

public class MakingScore implements Score {

    private SubjectList sl;

    public MakingScore(SubjectList sl) {
        this.sl = sl;
    }

    @Override
    public int sum() {
        return sl.getHtml() + sl.getJava() + sl.getJavascript() + sl.getC();
    }

    @Override
    public float avg() {
        return sum()/4.0f;
    }

    public int subjectScore() {

        return sl.getJava();
    }
}