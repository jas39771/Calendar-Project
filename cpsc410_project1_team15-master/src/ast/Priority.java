package ast;

public class Priority extends Info {
    private String priority;
    private String infoType = "priority";

    public Priority(String priority){
        this.priority = priority;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public String getPriority() {
        return priority;
    }

    public String getInfoType() {
        return infoType;
    }
}
