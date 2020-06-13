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
    private JLabel lblDate;

    public DayView(DayData dayData) {
        this.dayData = dayData;
        this.addMouseListener(new MListener());
        this.lblDate = new JLabel();

        //add(new JLabel(dayData.getDay() + "-" + dayData.getMonth() + "-" + dayData.getYear(), SwingConstants.CENTER));
        this.isEmptyday = false;

//        this.dayData.getEventsData().forEach(e -> add(new JLabel(e.getTitle(), SwingConstants.CENTER)));
    }

    public DayView() {
        this.addMouseListener(new MListener());
        this.lblDate = new JLabel();
        this.isEmptyday = true;
    }

    public void setDayView(DayData dayData, boolean isEmptyday) {
        this.dayData = dayData;
        this.isEmptyday = isEmptyday;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawRect(0, 0, getWidth(), getHeight());
        if (!isEmptyday) {
            this.lblDate.setText(dayData.getDay() + "-" + dayData.getMonth() + "-" + dayData.getYear());
        }
    }


    private class MListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {

            if(DayView.this.isEmptyday) {
                return;
            }

            if (e.getButton() == MouseEvent.BUTTON1) {
                String txt = "";

                for(Event event : DayView.this.dayData.getEventsData()){
                    txt += event.getTitle() + ":\n";
                    txt += event.getText() + "\n";
                }

                JOptionPane.showMessageDialog(null, txt, "Events List", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getButton() == MouseEvent.BUTTON3) {

                String title = JOptionPane.showInputDialog("Please enter event title: ");
                String txt = JOptionPane.showInputDialog("Please enter event details: ");

                CalendarData.saveEvent(title, txt, DayView.this.dayData.getYear(), DayView.this.dayData.getMonth(), DayView.this.dayData.getDay());

                repaint();
            }
        }
    }

}
