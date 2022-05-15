package ast;

import java.util.List;

public class UserDef extends Statement {
    private String name;
    private List<Info> info;

    public UserDef(String name, List<Info> info){
        this.name = name;
        this.info = info;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public String getName() {
        return name;
    }

    public List<Info> getInfo() {
        return info;
    }
}
