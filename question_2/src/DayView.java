import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DayView extends JPanel {

    private JButton cmdShowEvent;
    private ArrayList<Event> events;

    public DayView() {
        cmdShowEvent = new JButton("Show Event");
        cmdShowEvent.addActionListener(new ShowEvent());
        add(cmdShowEvent);

        this.addMouseListener(new MListener());

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


    private class MListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                JOptionPane.showMessageDialog(null, "B1", "Events List", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                JOptionPane.showMessageDialog(null, "B2", "Events List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
