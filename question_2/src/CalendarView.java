import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class CalendarView extends JPanel {

    private final int DAYS_IN_ROW = 7;
    private final int DAYS_IN_COLUMN = 6;

    public CalendarView(int year, int month) {
        setLayout(new GridLayout(DAYS_IN_ROW, DAYS_IN_COLUMN + 1));

        add(new JLabel("Sunday", SwingConstants.CENTER));
        add(new JLabel("Monday", SwingConstants.CENTER));
        add(new JLabel("Tuesday", SwingConstants.CENTER));
        add(new JLabel("Wednesday", SwingConstants.CENTER));
        add(new JLabel("Thursday", SwingConstants.CENTER));
        add(new JLabel("Friday", SwingConstants.CENTER));
        add(new JLabel("Saturday", SwingConstants.CENTER));

        Map<Integer, DayData> monthMap = CalendarData.getMYData(year, month);

        ArrayList<DayData> monthData = new ArrayList<>(monthMap.size());



        int daysCount = 0;

        for (Integer day : monthMap.keySet()) {
            monthData.add(day - 1, monthMap.get(day));
        }

        // fill empty days
        for(int i = 0; i < monthMap.get(1).getDayOfWeek() - 1; i++) {
            add(new DayView());
            daysCount++;
        }

        for (DayData dd : monthData) {
            add(new DayView(dd));
            daysCount++;
        }

        // fill empty days
        for (; daysCount < DAYS_IN_COLUMN * DAYS_IN_ROW; daysCount++) {
            add(new DayView());
        }

        repaint();
    }
}
