package ast;

public abstract class CalendarNode {
    public abstract <T> T accept(CalendarVisitor<T> calendarVisitor);
}
