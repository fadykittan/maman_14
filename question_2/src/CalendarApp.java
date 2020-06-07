import javax.swing.*;

public class CalendarApp {


    public static void main(String[] args) {


        JFrame frame = new JFrame("Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        CalendarGUI gui = new CalendarGUI();
        frame.add(gui);
        frame.setVisible(true);

    }



}
