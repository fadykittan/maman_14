import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DayView extends JPanel {

    private JButton cmdShowEvent;
    private ArrayList<Event> events;

    public DayView(ArrayList<Event> events) {
        cmdShowEvent = new JButton("Show Event");
        cmdShowEvent.addActionListener(new ShowEvent());
        add(cmdShowEvent);

        this.events = events;

        this.events.forEach(e -> add(new JLabel(e.getTitle(), SwingConstants.CENTER)));
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(0, 0, getWidth(), getHeight());
    }


    private class ShowEvent implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            String txt = "";

            for(Event e : events){
                txt += e.getTitle() + ":\n";
                txt += e.getText() + "\n";
            }

            JOptionPane.showMessageDialog(null, txt, "Events List", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
