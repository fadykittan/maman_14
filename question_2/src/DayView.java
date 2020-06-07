import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DayView extends JPanel {

    private JButton cmdShowEvent;

    public DayView(ArrayList<String> events) {
        cmdShowEvent = new JButton("Show Event");
        cmdShowEvent.addActionListener(new ShowEvent());
        add(cmdShowEvent);

        //todo temp code
        events.add("meet 1");
        events.add("meet 2");
        events.forEach(e -> add(new JLabel(e, SwingConstants.CENTER)));
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(0, 0, getWidth(), getHeight());
    }


    private class ShowEvent implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String st = "Welcome";
            JOptionPane.showMessageDialog(null, st, "event title", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
