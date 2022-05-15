package ast;

public class Info extends Rule {

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    @Override
    public String getInfoType() {
        return null;
    }
}
