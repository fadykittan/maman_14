import javax.swing.*;
import java.awt.*;

public class CalendarSide extends JPanel {


    public void paintComponent(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}
