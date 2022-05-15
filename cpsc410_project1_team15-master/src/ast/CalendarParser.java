package ast;

import libs.Tokenizer;
import java.util.*;
import java.util.regex.Pattern;

public class CalendarParser {
    private static final String NAME = "[^{}|\\n]+";
    private static final String DATE = "[A-Za-z]+ [0-9]+";
    private static final String TIME = "(2[0-3]|[01]?[0-9]):[0-5][0-9]";
    private static final String COLOR = "(Red|Blue|Green|Yellow)";
    private static final String OVERLAP = "(Yes|No)";
    private static final String PRIORITY = "(Important|Not Important)";
    private static final Map<String, Integer> daysInMonth = createMonths();
    private static Map<String, Integer> createMonths() {
        Map<String, Integer> months = new HashMap<>();
        months.put("Jan", 31);
        months.put("Feb", 29);
        months.put("Mar", 31);
        months.put("Apr", 30);
        months.put("May", 31);
        months.put("Jun", 30);
        months.put("Jul", 31);
        months.put("Aug", 31);
        months.put("Sept", 30);
        months.put("Oct", 31);
        months.put("Nov", 30);
        months.put("Dec", 31);
        return Collections.unmodifiableMap(months);
    }

    private final Tokenizer tokenizer;


    public CalendarParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public static CalendarParser getParser(Tokenizer tokenizer) {
        return new CalendarParser(tokenizer);
    }

    public Program parseProgram() {
        List<Statement> statements = new ArrayList<>();
        while (tokenizer.moreTokens()) {
            statements.add(parseStatement());
        }
        return new Program(statements);
    }

    private Statement parseStatement(){
        if (tokenizer.checkToken("Event:")) {
            return parseEvent();
        }
        if (tokenizer.checkToken("Type:")) {
            return parseUserDef();
        }
        else {
            throw new RuntimeException("Error");
        }
    }

    private UserDef parseUserDef() {
        tokenizer.getAndCheck("Type:");
        tokenizer.getAndCheck("\\{");
        tokenizer.getAndCheck("Name:");
        String name = tokenizer.getAndCheck(NAME);
        List<Info> additionalInfo = new ArrayList<>();
        if (!tokenizer.checkToken("\\}")){
            additionalInfo = parseInfo();
        }
        tokenizer.getAndCheck("\\}");
        return new UserDef(name, additionalInfo);
    }

    private Event parseEvent() {
        tokenizer.getAndCheck("Event:");
        tokenizer.getAndCheck("\\{");
        tokenizer.getAndCheck("Name:");
        String name = tokenizer.getAndCheck(NAME);
        String type = "";
        if (tokenizer.checkToken("Type:")){
            tokenizer.getAndCheck("Type:");
            type = tokenizer.getAndCheck(NAME);
        }
        tokenizer.getAndCheck("Date:");
        String date = tokenizer.getAndCheck(DATE);
        if (!checkDate(date)){
            throw new RuntimeException("Invalid date " + date);
        }
        tokenizer.getAndCheck("Start time:");
        String start_time = tokenizer.getAndCheck(TIME);
        tokenizer.getAndCheck("End time:");
        String end_time = tokenizer.getAndCheck(TIME);
        List<Info> additionalInfo = new ArrayList<>();
        if (!tokenizer.checkToken("\\}")){
            additionalInfo = parseInfo();
        }
        tokenizer.getAndCheck("\\}");
        return new Event(name, type, date, start_time, end_time, additionalInfo);
    }

    private List<Info> parseInfo() {
        List<Info> info = new ArrayList<>();
        while (!tokenizer.checkToken("\\}")) {
            if (tokenizer.checkToken("Place:")){
                tokenizer.getAndCheck("Place:");
                String place = tokenizer.getAndCheck(NAME);
                info.add(new Place(place));
            }
            else {
                if (tokenizer.checkToken("Color:")){
                    tokenizer.getAndCheck("Color:");
                    String color = tokenizer.getAndCheck(COLOR);
                    info.add(new Color(color));
                }
                else {
                    if (tokenizer.checkToken("Priority:")){
                        tokenizer.getAndCheck("Priority:");
                        String priority = tokenizer.getAndCheck(PRIORITY);
                        info.add(new Priority(priority));
                    }
                    else {
                        if (tokenizer.checkToken("Overlap:")){
                            tokenizer.getAndCheck("Overlap:");
                            String overlap = tokenizer.getAndCheck(OVERLAP);
                            info.add(new Overlap(overlap));
                        }
                        else {
                            throw new RuntimeException("Unknown expression:" + tokenizer.getNext());
                        }
                    }
                }
            }
        }
        return info;
    }

    private static boolean checkDate(String s) {
        if (Pattern.matches("[A-Za-z]+ [0-9]+", s)) {
            String[] temp = s.split(" ");
            if (daysInMonth.containsKey(temp[0])) {
                if (Integer.parseInt(temp[1]) <= daysInMonth.get(temp[0])) {
                    return true;
                } else {
                    throw new RuntimeException("Invalid Date "+ s );
                }
            } else {
                throw new RuntimeException("Invalid Date "+ s );
            }
        }
        else
            throw new RuntimeException("Invalid Date " + s );
    }
}
