package gui;

import javax.swing.*;
import java.awt.*;

public class Event extends JButton {
    private String title;
    private String time;
    private Color colour;

    public Event(String title, String time, Color colour) {
        this.title = title;
        this.time = time;
        this.colour = colour;
        setText("<html>" + title + "<br>" + time + "</html>");
        setBackground(colour);
    }







}
