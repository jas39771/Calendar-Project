package ast;

import java.util.List;

public class CalendarEvent {
    private String name;
    private String type;
    private String date;
    private String start_time;
    private String end_time;
    private boolean overlap = false;
    private boolean priority = false;
    private boolean reoccurring = false;
    private String place = "Undefined Location";
    private String color = "Red";

    public CalendarEvent(String name, String type, String date, String start_time,
                         String end_time){
        this.name = name;
        this.type = type;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        return;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public void setReoccurring(boolean reoccurring) {
        this.reoccurring = reoccurring;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public boolean isPriority() {
        return priority;
    }

    public boolean isReoccurring() {
        return reoccurring;
    }

    public String getPlace() {
        return place;
    }

    public String getColor() {
        return color;
    }
}
