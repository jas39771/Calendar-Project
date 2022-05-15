package ast;

public class Overlap extends Info {
    private String overlap;
    private String infoType = "overlap";

    public Overlap(String overlap){
        this.overlap = overlap;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public String getInfoType() {
        return infoType;
    }

    public String getOverlap() {
        return overlap;
    }
}
