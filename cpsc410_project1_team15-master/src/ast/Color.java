package ast;

public class Color extends Info {
    private String color;
    private String infoType = "color";

    public Color(String color){
        this.color = color;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public String getInfoType() {
        return infoType;
    }

    public String getColor() {
        return color;
    }
}
