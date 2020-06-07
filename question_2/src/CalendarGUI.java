import javax.swing.*;
import java.awt.*;

public class CalendarGUI extends JPanel {

    private JButton cmdAddEvent, cmdShowMonth;
    private int month = 1;
    private int year = 2020;
    private JTextField txtMonth, txtYear;
    private JLabel lblMonth, lblYear;
    private JTextField txtMonthDate, txtYearDate, txtDayDate, txtTitle, txtMessage;

    public CalendarGUI() {
        this.setLayout(new BorderLayout());

        // Top Part
        cmdShowMonth = new JButton("Show Month");
        cmdAddEvent = new JButton("Add Event");
        txtMonth = new JTextField(3);
        txtYear = new JTextField(5);
        lblMonth = new JLabel(" Month: " + month, SwingConstants.CENTER);
        lblYear = new JLabel(" Year: " + year, SwingConstants.CENTER);



        JPanel controls = new JPanel();
        controls.add(lblMonth);
        controls.add(lblYear);
        controls.add(cmdShowMonth);
        controls.add(new JLabel("Month: "));
        controls.add(txtMonth);
        controls.add(new JLabel("Year: "));
        controls.add(txtYear);
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
