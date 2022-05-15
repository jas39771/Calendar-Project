package ast;

import java.util.List;

public interface CalendarVisitor<T> {
    T visit(Program p);
    T visit(Color c);
    T visit(Event e);
    T visit(Info i);
    T visit(Name n);
    T visit(Overlap o);
    T visit(Place p);
    T visit(Priority p);
    T visit(Reoccurring r);
    T visit(Time t);
    T visit(UserDef u);
    T visit(Date d);
}
