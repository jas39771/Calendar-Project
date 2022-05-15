package ast;

import java.util.List;

public class Program extends CalendarNode {
    private List<Statement> statements;
    private List<CalendarEvent> finalEvents;

    public Program (List<Statement> statements){
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }
    public <T> T accept(CalendarVisitor<T> v) {
        return v.visit(this);
    }

    public void setFinalEvents(List<CalendarEvent> finalEvents) {
        this.finalEvents = finalEvents;
    }

    public List<CalendarEvent> getFinalEvents() {
        return finalEvents;
    }
}
