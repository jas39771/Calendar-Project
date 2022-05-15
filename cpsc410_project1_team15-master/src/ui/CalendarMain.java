package ui;

import ast.CalendarEvaluator;
import ast.CalendarEvent;
import ast.CalendarParser;
import ast.Program;
import libs.CalendarTokenizer;
import libs.Tokenizer;
import gui.Calendar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalendarMain {
    public static void main(String[] args) {
        List<String> fixedLiterals = Arrays.asList("Event:", "{", "}", "Name:", "Type:", "Place:", "Date:", "Start time:", "End time:", "Color:", "Overlap:", "Priority:", "\\n");
        Tokenizer tokenizer = CalendarTokenizer.createCalendarTokenizer("input.tvar",fixedLiterals);
        System.out.println("Done tokenizing");

        CalendarParser p = CalendarParser.getParser(tokenizer);
        Program program = p.parseProgram();
        System.out.println("Done parsing");

        CalendarEvaluator e = new CalendarEvaluator("output.txt");

        program.accept(e);
        List<CalendarEvent> tempEvents = program.getFinalEvents();
        CalendarEvent[] events = tempEvents.toArray(new CalendarEvent[0]);
        System.out.println(events);
        Calendar calendar = new Calendar(2020, 10);
        calendar.makeCalendar();
    }
}
