package ast;

import java.util.List;

public class Event extends Statement {
    private String name;
    private String type;
    private String date;
    private String start_time;
    private String end_time;
    private List<Info> additionalinfo;

    public Event(String name, String type, String date, String start_time, String end_time, List<Info> additionalinfo){
        this.name = name;
        this.type = type;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.additionalinfo = additionalinfo;
    }

    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public List<Info> getAdditionalinfo() {
        return additionalinfo;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
