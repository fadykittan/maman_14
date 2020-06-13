import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalendarGUI extends JPanel {

    private JButton cmdShowMonth;
    private int month = 1;
    private int year = 2020;
    private JTextField txtMonth, txtYear;
    private JLabel lblMonth, lblYear;
    private CalendarView cv;

    private BorderLayout layout;

    public CalendarGUI() {
        this.layout = new BorderLayout();
        this.setLayout(layout);

        // Top Part
        cmdShowMonth = new JButton("Show Month");
        txtMonth = new JTextField(3);
        txtYear = new JTextField(5);
        lblMonth = new JLabel(" Month: " + month, SwingConstants.CENTER);
        lblYear = new JLabel(" Year: " + year, SwingConstants.CENTER);

        cmdShowMonth.addActionListener(new BListener());

        JPanel controls = new JPanel();
        controls.add(lblMonth);
        controls.add(lblYear);
        controls.add(cmdShowMonth);
        controls.add(new JLabel("Month: "));
        controls.add(txtMonth);
        controls.add(new JLabel("Year: "));
        controls.add(txtYear);
        add(controls, BorderLayout.NORTH);


        // Side Part
        add(new CalendarSide(), BorderLayout.WEST);
        add(new CalendarSide(), BorderLayout.EAST);

        // add show event section
        add(new EventsView(), BorderLayout.SOUTH);

        // add month view
        this.cv = new CalendarView(year, month);
        add(cv, BorderLayout.CENTER);

        repaint();

    }

//    private void changeCalendarView(int year, int month) {
//        this.remove(this.layout.getLayoutComponent(BorderLayout.CENTER));
//        this.cv = new CalendarView(year, month);
//        add(this.cv, BorderLayout.CENTER);
//        repaint();
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        this.remove(this.layout.getLayoutComponent(BorderLayout.CENTER));
//        this.cv = new CalendarView(year, month);

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
            repaint();

        }
    }



}
