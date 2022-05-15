package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Calendar implements ComponentListener {
    private int year, month;
    private JFrame mainFrame;
    private JTable table;
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
    "September", "October", "November", "December"};
    private String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private DefaultTableModel tbm;
    private JScrollPane scrollPane;
    // what the calendar takes in will be changed later once we know what data format the back-end is giving us.
    public Calendar(int year, int month) {
        this.year = year;
        this.month = month;
    }


    // makes the frame and other containers of the calendar.
    public void makeCalendar() {
        mainFrame = new JFrame("Calendar");
        mainFrame.setLayout(null);
        mainFrame.setSize(700,700);
        Container pane = mainFrame.getContentPane();
        pane.setLayout(null);

        tbm = new DefaultTableModel();
        table = new JTable(tbm);
        scrollPane = new JScrollPane(table);
        pane.add(scrollPane);
        scrollPane.setBounds(0, 0, mainFrame.getWidth() - 30, mainFrame.getHeight() - 30);



        setUpTable(mainFrame.getHeight());

        // just trying something with jbutton and table cell
        Event testing = new Event("Test 123", "4:30 - 19:00", Color.CYAN);
        if (tbm.getValueAt(4,5) != null) {

        }


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.addComponentListener(this);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }

    // populates and sets up the table
    private void setUpTable(int height) {
        for (int i = 0; i < 7; i++) {
            tbm.addColumn(days[i]);
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(height / 7);
        tbm.setColumnCount(7);
        tbm.setRowCount(6);
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                tbm.setValueAt(null, i, j);
            }
        }



        // using the GregorianCalendar
        GregorianCalendar gCal = new GregorianCalendar(this.year, this.month, 1);
        TimeZone timezone = TimeZone.getTimeZone("PST");
        gCal.setTimeZone(timezone);
        int daysInMonth = gCal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int firstDayOfMonth = gCal.getActualMaximum(GregorianCalendar.DAY_OF_WEEK);
        for (int i = 1; i < daysInMonth + 1; i++) {
            int row = (i + firstDayOfMonth - 2) / 7;
            int column = (i + firstDayOfMonth - 2)%7;
            tbm.setValueAt(i, row, column);
        }
        table.setDefaultRenderer(table.getColumnClass(0), new tblCalendarRenderer());
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowSelected = table.rowAtPoint(e.getPoint());
                int columnSelected = table.columnAtPoint(e.getPoint());
                if (rowSelected >= 0 && columnSelected >= 0) {
                    System.out.println(table.getValueAt(rowSelected, columnSelected));
                }
            }
        });
    }


    // custom renderer for weekend columns.
    static class tblCalendarRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6) { // for the weekend
                setBackground(new Color(227, 227, 227));
            }
            else { // for the week
                setBackground(new Color(255, 255, 255));
            }
            return this;
        }
    }

    // method used to dynamically resize components when frame is resized.
    @Override
    public void componentResized(ComponentEvent e) {
        table.setRowHeight(mainFrame.getHeight() / 7);
        scrollPane.setBounds(10, 20, mainFrame.getWidth() - 30, mainFrame.getHeight() - 30);

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
