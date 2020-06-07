import javax.swing.*;
import java.awt.*;

public class CalendarGUI extends JPanel {

    private JButton cmdAddEvent, cmdShowMonth;

    public CalendarGUI() {
        this.setLayout(new BorderLayout());

        // Top Part
        cmdAddEvent = new JButton("Add Event");
        cmdShowMonth = new JButton("Show Month");

        JPanel controls = new JPanel();
        controls.add(cmdShowMonth);
        controls.add(cmdAddEvent);
        add(controls, BorderLayout.NORTH);


        // Side Part
        add(new CalendarSide(), BorderLayout.WEST);
        add(new CalendarSide(), BorderLayout.EAST);

        // add show event section
        add(new EventsView(), BorderLayout.SOUTH);

        // add month view
        CalendarView cv = new CalendarView();
        add(cv, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g) {

        g.fillOval(10, 10, 10, 10);
    }

}
