package ast;

import gui.Calendar;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarEvaluator implements CalendarVisitor<Integer> {
    private PrintWriter writer; // nothing stops a visitor from having other features

    public CalendarEvaluator(String outFilename) {

    }

    private final Map<String, Integer> environment = new HashMap<>();
    private final Map<Integer, Integer> memory = new HashMap<>();
    private Integer memoryLocation = 0;

    public final Map<String, Map> types = new HashMap<>();
    public final List<CalendarEvent> eventsList = new ArrayList<CalendarEvent>();

    public Map<String, Integer> getEnvironment() {
        return environment;
    }
    public Map<Integer, Integer> getMemory() {
        return memory;
    }

    private Integer getNewLocation() {
        Integer currLocation = memoryLocation;
        memoryLocation++;
        return currLocation;
    }

    @Override
    public Integer visit(Program p) {
        for (Statement s : p.getStatements()) {
            s.accept(this);
        }
        p.setFinalEvents(eventsList);
        return null;
    }

    @Override
    public Integer visit(Color c) {
        return null;
    }

    @Override
    public Integer visit(Event e) {
        String name = e.getName();
        String date = e.getDate();
        String start_time = e.getStart_time();
        String end_time = e.getEnd_time();
        String type = e.getType();
        if (type.equals("")) {
            type = name;
        }
        CalendarEvent event = new CalendarEvent(name, type, date, start_time, end_time);
        if (types.containsKey(type)) {
            Map<String, String> savedInfo = types.get(type);
            event = setCalendarValues(event, savedInfo);
        }
        List<Info> infoList = e.getAdditionalinfo();
        Map<String, String> additionalInfo = new HashMap<>();
        for (Info i : infoList) {
            String infoValue = evaluateInfo(i);
            additionalInfo.put(i.getInfoType(), infoValue);
        }
        event = setCalendarValues(event, additionalInfo);
        eventsList.add(event);
        return null;
    }

    @Override
    public Integer visit(Info i) {
        return null;
    }

    @Override
    public Integer visit(Name n) {
        return null;
    }

    @Override
    public Integer visit(Overlap o) {
        return null;
    }

    @Override
    public Integer visit(Place p) {
        return null;
    }

    @Override
    public Integer visit(Priority p) {
        return null;
    }

    @Override
    public Integer visit(Reoccurring r) {
        return null;
    }

    @Override
    public Integer visit(Time t) {
        return null;
    }

    private CalendarEvent setCalendarValues(CalendarEvent event, Map<String, String> savedInfo) {
        for (String s : savedInfo.keySet()) {
            boolean stringToBool = false;
            switch (s) {
                case "place":
                    event.setPlace(savedInfo.get(s));
                    break;
                case "overlap":
                    if (savedInfo.get(s).equals("Yes")){
                        stringToBool = true;
                    }
                    event.setOverlap(stringToBool);
                    break;
                case "color":
                    event.setColor(savedInfo.get(s));
                    break;
                case "priority":
                    if (savedInfo.get(s).equals("Important")){
                        stringToBool = true;
                    }
                    event.setPriority(stringToBool);
                    break;
                case "reoccuring":
                    if (savedInfo.get(s).equals("Yes")){
                        stringToBool = true;
                    }
                    event.setReoccurring(stringToBool);
                    break;
            }
        }
        return event;
    }

    public Integer visit(UserDef u) {
        String name = u.getName();
        List<Info> infoList = u.getInfo();
        Map<String, String> savedInfo = new HashMap<>();
        for (Info i : infoList) {
            String infoValue = evaluateInfo(i);
            savedInfo.put(i.getInfoType(), infoValue);
        }
        types.put(name, savedInfo);
        return null;
    }

    @Override
    public Integer visit(Date d) {
        return null;
    }

    private String evaluateInfo(Info i) {
        String infoType = i.getInfoType();
        String value = "";
        switch (i.getInfoType()) {
            case "place":
                value = ((Place) i).getPlace();
                break;
            case "overlap":
                value = ((Overlap) i).getOverlap();
                break;
            case "color":
                value = ((Color) i).getColor();
                break;
            case "priority":
                value = ((Priority) i).getPriority();
                break;
            case "reoccuring":
                value = ((Reoccurring) i).getReoccurring();
                break;
        }
        return value;
    }
}
