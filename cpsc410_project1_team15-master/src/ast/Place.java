package ast;

public class Place extends Info {
    private String place;
    private String infoType = "place";

    public Place(String place){
        this.place = place;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public String getPlace() {
        return place;
    }

    public String getInfoType() {
        return infoType;
    }
}
