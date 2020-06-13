import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DayView extends JPanel {

    private DayData dayData;
    private boolean isEmptyday;
    private JLabel text;

    public DayView(DayData dayData) {
        this.dayData = dayData;
        isEmptyday = false;

        add(new JLabel(dayData.getDay() + "-" + dayData.getMonth() + "-" + dayData.getYear(), SwingConstants.CENTER));
        addMouseListener(new MListener());

        text = new JLabel();
        add(text);
        setDayText();

        repaint();

//        this.addMouseListener(new MListener());

//        this.events.forEach(e -> add(new JLabel(e.getTitle(), SwingConstants.CENTER)));
    }

    public DayView() {
        isEmptyday = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(0, 0, getWidth(), getHeight());
    }


    private void setDayText() {

        if(isEmptyday || dayData.getEventsData() == null || dayData.getEventsData().isEmpty()) {
            return;
        }

        String s = "Events: ";
        for(Event e : dayData.getEventsData()) {
            s = s + e.getTitle();
            s = s + "\n";
        }

        text.setText(s);
    }



//    private class ShowEvent implements ActionListener {
//
//        public void actionPerformed(ActionEvent a) {
//            String txt = "";
//
//            for(Event e : events){
//                txt += e.getTitle() + ":\n";
//                txt += e.getText() + "\n";
//            }
//
//            JOptionPane.showMessageDialog(null, txt, "Events List", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//    }


    private class MListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            if(DayView.this.isEmptyday) {
                return;
            }

            if (e.getButton() == MouseEvent.BUTTON1) {
                if(!DayView.this.isEmptyday) {
                    String txt = "";

                    for (Event event : DayView.this.dayData.getEventsData()) {
                        txt += event.getTitle() + ":\n";
                        txt += event.getText() + "\n";
                    }

                    if(DayView.this.dayData.getEventsData().isEmpty()){
                        txt = "No Events for today.";
                    }

                    JOptionPane.showMessageDialog(null, txt, "Events List", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (e.getButton() == MouseEvent.BUTTON3) {

                String title = JOptionPane.showInputDialog(null, "Please enter event title: ");
                String txt = JOptionPane.showInputDialog(null, "Please enter event details: ");

                ArrayList<Event> events = CalendarData.saveEvent(title, txt, DayView.this.dayData.getYear(), DayView.this.dayData.getMonth(), DayView.this.dayData.getDay());
                DayView.this.dayData.setEventsData(events);
                DayView.this.setDayText();
                DayView.this.revalidate();
                repaint();
            }
        }
    }

}
