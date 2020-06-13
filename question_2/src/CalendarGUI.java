import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarGUI extends JPanel {

    private JButton cmdShowMonth;
    private int month = 1;
    private int year = 2020;
    private JTextField txtMonth, txtYear;
    private JLabel lblMonth, lblYear;
    private BorderLayout myLayout;
//    private JTextField txtMonthDate, txtYearDate, txtDayDate, txtTitle, txtMessage;

    public CalendarGUI() {
        this.myLayout = new BorderLayout();
        this.setLayout(this.myLayout);

        // Top Part
        cmdShowMonth = new JButton("Show Month");
        cmdShowMonth.addActionListener(new BListener());
//        cmdAddEvent = new JButton("Add Event");
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
//        controls.add(cmdAddEvent);
        add(controls, BorderLayout.NORTH);


        // Side Part
        add(new CalendarSide(), BorderLayout.WEST);
        add(new CalendarSide(), BorderLayout.EAST);

        // add show event section
        add(new EventsView(), BorderLayout.SOUTH);

        // add month view
        CalendarView cv = new CalendarView(year, month);
        add(cv, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, "To set new event, right click on the date\n" +
                "To show events list left click on the date.\n\n " +
                "Enjoy using :) ", "How to Use", JOptionPane.INFORMATION_MESSAGE);

    }

    public void paintComponent(Graphics g) {
//        this.remove(this.myLayout.getLayoutComponent(BorderLayout.CENTER));
//        add(new CalendarView(year, month));
        super.paintComponent(g);
    }

    private void setLabelText() {
        lblMonth.setText(" Month: " + month);
        lblYear.setText(" Year: " + year);
    }

    private class BListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String year = CalendarGUI.this.txtYear.getText();
            String month = CalendarGUI.this.txtMonth.getText();

            if (year == null || year.isEmpty() || month == null || month.isEmpty()) {
                return;
            }

            int y;
            int m;

            try {
                y = Integer.parseInt(year);
                m = Integer.parseInt(month);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid month and year", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

//            CalendarGUI.this.changeCalendarView(y, m);
            CalendarGUI.this.year = y;
            CalendarGUI.this.month = m;
            CalendarGUI.this.setLabelText();
            CalendarGUI.this.remove(CalendarGUI.this.myLayout.getLayoutComponent(BorderLayout.CENTER));
            CalendarGUI.this.add(new CalendarView(y, m), BorderLayout.CENTER);
            CalendarGUI.this.revalidate();
            repaint();

        }
    }



}