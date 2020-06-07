import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CalendarView extends JPanel {

    private final int DAYS_IN_ROW = 7;
    private final int DAYS_IN_COLUMN = 6;

    public CalendarView() {
        setLayout(new GridLayout(DAYS_IN_ROW, DAYS_IN_COLUMN + 1));

        add(new JLabel("Sunday", SwingConstants.CENTER));
        add(new JLabel("Monday", SwingConstants.CENTER));
        add(new JLabel("Tuesday", SwingConstants.CENTER));
        add(new JLabel("Wednesday", SwingConstants.CENTER));
        add(new JLabel("Thursday", SwingConstants.CENTER));
        add(new JLabel("Friday", SwingConstants.CENTER));
        add(new JLabel("Saturday", SwingConstants.CENTER));

        for (int i = 1; i <= DAYS_IN_COLUMN * DAYS_IN_ROW; i++) {
            add(new DayView(new ArrayList<>()));
        }
    }
}
